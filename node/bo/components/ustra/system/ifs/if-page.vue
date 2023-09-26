<template>
  <UBox direction="col">
    <!-- search bar -->
    <UItem baseSize="100">
      <UButtonBar>
        <UFieldSet>
          <UFieldRow>
            <UField v-if="tabType === 'IN'" label="시스템 코드" totalWidth="400">
              <UCodeComboBox grpCd="SYS_CD" v-model="searchActions.criteria.sysCd" />
            </UField>
            <UField v-else label="채널 코드" totalWidth="400">
              <UCodeComboBox grpCd="CHNL_CD" v-model="searchActions.criteria.chnlOutCd" />
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField v-if="tabType === 'IN'" label="채널 코드" totalWidth="400">
              <UCodeComboBox grpCd="CHNL_CD" v-model="searchActions.criteria.chnlCd" displayNullText="전체" />
            </UField>
            <UField label="I/F 아이디" totalWidth="400">
              <WjInputMask v-model="searchActions.criteria.ifId" />
            </UField>
            <UField label="I/F 버젼" totalWidth="400">
              <WjInputMask v-model="searchActions.criteria.ifVer" />
            </UField>
            <UField label="사용여부" totalWidth="400">
              <WjComboBox
                v-model="searchActions.criteria.useYn"
                :itemsSource="ynList"
                displayMemberPath="name"
                selectedValuePath="code"
                :width="300"
              />
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="I/F 명" totalWidth="400">
              <WjInputMask v-model="searchActions.criteria.ifNm" />
            </UField>
            <UField label="url" totalWidth="400">
              <WjInputMask v-model="searchActions.criteria.url" />
            </UField>
            <UButtonBox right top>
              <UButton text="신규" :width="80" @click="formActions.newIfs" />
              <UButton text="검색" :width="80" @click="search" />
            </UButtonBox>
          </UFieldRow>
        </UFieldSet>
      </UButtonBar>
    </UItem>
    <UItem ratio="1">
      <UBox direction="row">
        <UItem ratio="1" :disabled="listDisabled">
          <IfsList :ref="e => (listComponent = e as InstanceType<typeof IfsList>)" @select="rowSelected"></IfsList>
        </UItem>
        <UItem ratio="1" :disabled="formDisabled">
          <IfsForm
            :ref="e => (formComponent = e as InstanceType<typeof IfsForm>)"
            :tabType="tabType"
            @saved="onSaved"
            @show-hist="shownHist"
          ></IfsForm>
        </UItem>
        <!-- <UItem ratio="1">
          <IfsHist :ref="e => (histComponent = e as InstanceType<typeof IfsHist>)" />
        </UItem> -->
      </UBox>
    </UItem>
  </UBox>
</template>

<script setup lang="ts">
import { reactive, ref, nextTick, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import { WjComboBox, UBox, UItem, WjInputMask, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { IfsCriteria, Ifs } from '#ustra/nuxt/management'
import IfsList from './ifs-list.vue'
import IfsForm from './ifs-form.vue'
import IfsHist from '../ifs-hist/index.vue'

const props = defineProps({
  tabType: String,
})

const formComponent = ref<InstanceType<typeof IfsForm>>(null)
const listComponent = ref<InstanceType<typeof IfsList>>(null)
const histComponent = ref<InstanceType<typeof IfsHist>>(null)

const showPopup = ref(false)
const listDisabled = ref(true)
const formDisabled = ref(true)

async function onConditionChanged(searchCond) {
  searchActions.criteria = searchCond
  await nextTick()
  if (searchCond) {
    listActions.search()
    formActions.newIfs()
    listDisabled.value = false
    formDisabled.value = true
  } else {
    listDisabled.value = true
    formDisabled.value = true
  }
}

function search() {
  formDisabled.value = true
  formComponent.value.init(searchActions.criteria, false)
  listComponent.value.loadData(searchActions.criteria)
  listDisabled.value = false
  listComponent.value.clearSelection()
}

function rowSelected(ifs: Ifs) {
  formDisabled.value = false
  formComponent.value.updateForm(ifs)
}

function onSaved() {
  formDisabled.value = true
  formComponent.value.init(searchActions.criteria, false)
  listComponent.value.loadData(searchActions.criteria)
}

function shownHist(ifId: string) {
  showPopup.value = true
  const histSearch = {
    ifId: ifId,
    searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -120), 'yyyyMMdd'),
    searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
    succYn: '',
  }

  // TODO
  // histComponent.value.search(histSearch)
}

// 검색 관련 기능
const searchActions = (() => {
  const criteria: IfsCriteria = reactive({
    chnlCd: null,
    sysCd: null,
    chnlInCd: null,
    chnlOutCd: null,
    ifId: null,
    ifVer: null,
    useYn: '',
    ifNm: null,
    url: null,
    ifDirCd: props.tabType,
  })

  return { criteria }
})()

const listActions = (() => {
  async function search() {
    listComponent.value.loadData(searchActions.criteria)
  }
  return { search }
})()

const formActions = (() => {
  async function newIfs() {
    formDisabled.value = false
    formComponent.value.init(searchActions.criteria)
    // TODO grid clear selection
    //listComponent.value.clearSelection()
  }
  return { newIfs }
})()

const ynList = reactive([
  { code: '', name: '전체' },
  { code: 'Y', name: '사용' },
  { code: 'N', name: '미사용' },
])

watch(
  () => searchActions.criteria.sysCd,
  (newValue, oldValue) => {
    onConditionChanged(searchActions.criteria)
  },
)
</script>

<style scoped></style>
