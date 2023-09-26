<template>
  <UBox direction="col" style="padding: 5px">
    <UItem :ratio="1">
      <UValidationGroup ref="validationGroup">
        <UFieldSet>
          <UFieldRow>
            <UField label="tabType">
              <div>{{ tabType }}</div>
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField required label="I/F 아이디">
              <WjInputMask ref="idInput" v-model="inputData.ifId" :isRequired="true" :read-only="mode === 'update'" />
            </UField>

            <UField required label="I/F 버전">
              <WjInputMask v-model="inputData.ifVer" :isRequired="true" />
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField required label="I/F 명">
              <WjInputMask v-model="inputData.ifNm" :isRequired="true" />
            </UField>
          </UFieldRow>

          <UFieldRow v-show="tabType === 'OUT'">
            <UField required label="시스템코드">
              <UCodeComboBox grpCd="SYS_CD" v-model="inputData.sysCd" displayNullText="선택" />
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField required label="I/F 방식">
              <UCodeComboBox grpCd="IF_TY_CD" v-model="inputData.ifTyCd" displayNullText="선택" />
              <!-- <WjComboBox :itemsSource="ynList" displayMemberPath="name" selectedValuePath="code" :width="300" /> -->
            </UField>
            <UField required label="I/F 로깅유형">
              <UCodeComboBox grpCd="IF_LOG_TY_CD" v-model="inputData.ifLogTyCd" />
              <!-- <WjComboBox :itemsSource="ynList" displayMemberPath="name" selectedValuePath="code" :width="300" /> -->
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField label="HTTP 메소드">
              <UCodeComboBox
                grpCd="HTTP_METH_CD"
                v-model="inputData.httpMethCd"
                displayNullText="선택"
                :isRequired="false"
                :validation="{
                  rules: [
                    {
                      type: 'custom',
                      handler: saveActions.validate,
                    },
                  ],
                }"
              />
            </UField>
            <UField label="URL">
              <WjInputMask v-model="inputData.url" :isRequired="false" />
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField label="사용여부">
              <URadioGroupBox
                v-model="inputData.useYn"
                :itemsSource="[
                  { value: 'Y', text: '사용' },
                  { value: 'N', text: '미사용' },
                ]"
              />
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="아이피 제한">
              <URadioGroupBox
                v-model="inputData.ipLmtYn"
                :itemsSource="[
                  { value: 'Y', text: '사용' },
                  { value: 'N', text: '미사용' },
                ]"
              />
            </UField>
          </UFieldRow>

          <UFieldRow v-if="inputData.ipLmtYn === 'Y'">
            <UField label="아이피 목록">
              <!--TODO -->
              <!-- <ifs-ip-list-form ref="ip" v-model="inputData.ipList" /> -->
              <UIpAddressListBox v-model="inputData.ipInputList" :isRequired="true" />
            </UField>
          </UFieldRow>

          <UFieldRow v-if="tabType === 'IN'">
            <UField label="채널 제한">
              <URadioGroupBox
                v-model="inputData.chnlLmtYn"
                :itemsSource="[
                  { value: 'Y', text: '사용' },
                  { value: 'N', text: '미사용' },
                ]"
              />
            </UField>
          </UFieldRow>

          <UFieldRow v-if="tabType === 'IN' && inputData.chnlLmtYn === 'Y'">
            <UField label="채널 유형">
              <UCodeMultiComboBox grpCd="CHNL_CD" v-model="inputData.chnlCd" />
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField label="인증 필요">
              <URadioGroupBox
                v-model="inputData.certNecYn"
                :itemsSource="[
                  { value: 'Y', text: '사용' },
                  { value: 'N', text: '미사용' },
                ]"
              />
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UButtonBar class="mt-2">
              <UButtonBox right>
                <UButton icon="mdi-folder-plus" @click="() => ifsKey.addRow()"></UButton>
                <UButton icon="mdi-folder-minus" :disabled="ifsKey.disabledRemoveButton.value" @click="() => ifsKey.removeRow()"></UButton>
              </UButtonBox>
            </UButtonBar>
          </UFieldRow>
          <UFieldRow>
            <WjFlexGrid
              style="height: 150px"
              :itemsSource="ifsKey.collectionView.value"
              :initialized="e => (ifsKey.grid.value = e)"
              :allowDelete="true"
            >
              <WjFlexGridColumn header="인터페이스키" binding="ifKey" :isRequired="true" :width="200" />
              <WjFlexGridColumn header="인터페이스값" binding="ifVal" :isRequired="true" :width="200" />
              <WjFlexGridColumn header="비고" binding="rmk" width="*"> </WjFlexGridColumn>
            </WjFlexGrid>
          </UFieldRow>

          <UFieldRow>
            <UField label="비고">
              <UTextBox v-model="inputData.rmk" type="textarea"></UTextBox>
            </UField>
          </UFieldRow>

          <!--TODO 입력정보 -->
          <!-- <UFieldRow v-show="mode === 'update'">
            <UField label="입력정보" :full-width="true">
              <u-system-info-box :model="inputData" />
            </UField>
          </UFieldRow> -->

          <!--TODO 수정정보 -->
          <!-- <UFieldRow v-show="mode === 'update'">
            <UField label="수정정보" :full-width="true">
              <u-system-info-box :model="inputData" :update="true" />
            </UField>
          </UFieldRow> -->
        </UFieldSet>
      </UValidationGroup>
    </UItem>
    <UItem>
      <UButtonBox right top>
        <!-- <UButton text="이력보기" icon="search" type="success" class="left" @click="showHist" /> -->
        <UButton text="저장" type="primary" :width="80" @click="() => saveActions.saveForm()" />
        <UButton v-if="!isNew" text="삭제" :width="80" :disabled="mode === 'new'" @click="() => deleteForm()" />
      </UButtonBox>
    </UItem>
  </UBox>
</template>

<script setup lang="ts">
import { isRef, reactive, defineExpose, ref, useOnError, defineEmits, nextTick, defineProps, computed, useDeepMerge, shallowRef } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  UTextBox,
  UValidationGroup,
  UCheckGroupBox,
  WjInputMask,
  WjInputNumber,
  WjMultiSelect,
  WjMultiSelectListBox,
  UIpAddressListBox,
  WjFlexGrid,
  WjFlexGridColumn,
  WjFlexGridCellTemplate,
  WjTabPanel,
  WjTab,
} from '#ustra/nuxt-wijmo/components'
import { FormMode } from '#ustra/core/data/models/base'
import IfsKeyForm from './ifs-key-form.vue'
import { IfsCriteria, Ifs } from '#ustra/nuxt/management'
import { UCodeMultiComboBox } from '#ustra/nuxt-wijmo/management/components'
import { useUstraInterfaceService } from '#ustra/nuxt/management/services/interface'
import { useCollectionView, isValidCollectionView } from '#ustra/nuxt-wijmo/composables/grid'
import { FlexGrid } from '@grapecity/wijmo.grid'
import { watchValidationData } from '#ustra/nuxt-wijmo/composables/validation'
import { ComboBox, ClickAction } from '@grapecity/wijmo.input'

const infService = useUstraInterfaceService()

const props = defineProps({
  tabType: String,
})

const isNew = ref(null)
const mode = ref('new')
const idInput = ref(null)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

const inputData: Ifs = reactive({
  ifId: null,
  ifVer: null,
  sysCd: null,
  ifNm: null,
  useYn: 'Y',
  rmk: null,
  ipLmtYn: 'N',
  ipList: null,
  url: null,
  httpMethCd: null,
  authCtrlYn: 'N',
  ifTyCd: null,
  ifLogTyCd: 'AL',
  ifDirCd: null,
  chnlLmtYn: 'N',
  certNecYn: 'N',
  chnlCd: [],
  keys: [],
  ipInputList: computed({
    get() {
      if (!inputData.ipList) {
        return []
      }

      return (inputData.ipList || '').split(',')
    },
    set(v: string[]) {
      inputData.ipList = v.join(',')
    },
  }),
})

async function init(criteria: IfsCriteria, focus: boolean = true) {
  // if (this.fieldSet) {
  //   await this.fieldSet.reset()
  // }

  await nextTick()

  inputData.ifId = null
  inputData.ifVer = null
  inputData.sysCd = criteria.sysCd ? criteria.sysCd : null
  inputData.ifNm = null
  inputData.useYn = 'Y'
  inputData.rmk = null
  inputData.ipLmtYn = 'N'
  inputData.ipList = null
  inputData.url = null
  inputData.httpMethCd = null
  inputData.authCtrlYn = 'N'
  inputData.ifTyCd = null
  inputData.ifLogTyCd = 'AL'
  inputData.ifDirCd = null
  inputData.chnlLmtYn = 'N'
  inputData.certNecYn = 'N'
  inputData.chnlCd = criteria.chnlCd ? [criteria.chnlCd] : []
  inputData.keys = []

  mode.value = 'new'
  validationGroup.value.init()

  if (focus) {
    // TODO focus 처리
    // nextTick(() => idInput.instance.focus())
  }
}

async function updateForm(ifs: Ifs) {
  mode.value = 'update'
  const ifsInfo = await infService.getInterface(ifs.ifId, ifs.ifVer)
  useDeepMerge(inputData, ifsInfo)
  // inputData.value = ifsInfo
  if (props.tabType === 'IN') {
    const valueMap = ifsInfo.channels.map(function (item) {
      return item.chnlCd
    })
    inputData.chnlCd = valueMap
  }
}

const saveActions = (() => {
  // const realInputData = $ustra.utils.core.deepMerge({}, inputData)

  //TODO validation
  // const validateResult = await fieldSet.validate()
  // if (!validateResult || !validateResult.isValid) {
  //   alert('입력 값을 확인해주세요.')
  //   return
  // }

  let validMessage: string = '잘못된 입력 값입니다.'

  function validate() {
    if (inputData.ifTyCd === 'SP' && inputData.httpMethCd !== 'POST') {
      return 'SOAP방식일 경우 POST만 선택 가능합니다.'
    } else if (inputData.ifTyCd === 'DB' && inputData.httpMethCd) {
      return 'DB방식일 경우 선택 불가합니다.'
    } else if (inputData.ifTyCd === 'MB' && inputData.httpMethCd) {
      return '모바일 브릿지 방식일 경우 선택 불가합니다.'
    } else if (
      inputData.ifTyCd === 'SC_LK' &&
      (inputData.httpMethCd === 'DELETE' || inputData.httpMethCd === 'PATCH' || inputData.httpMethCd === 'PUT')
    ) {
      return '화면연동 방식일 경우 GET, POST만 선택 가능합니다.'
    }
    return true
  }

  async function saveForm() {
    //const chnlCds = inputData.chnlCd.map(data => data.code)
    //inputData.chnlCd = chnlCds

    // if (!validate) {
    //   alert('입력 값을 확인해주세요.')
    //   return
    // }

    const result = await validationGroup.value.validate()
    if (!result.isValid) {
      return
    }

    inputData.ifDirCd = props.tabType

    if (mode.value === 'new') {
      await infService.addInterface(inputData)
    } else {
      await infService.editInterface(inputData)
    }

    emits('saved')
  }
  return { saveForm, validate }
})()

async function deleteForm() {
  //const realInputData = this.$ustra.utils.core.deepMerge({}, this.inputData)

  if (await confirm('삭제하시겠습니까?')) {
    await infService.removeInterface(inputData.ifId, inputData.ifVer)
    emits('saved')
  }
}

// 기능 목록
const ifsKey = {
  collectionView: computed(() => {
    const collectionView = useCollectionView(inputData.keys, {
      getError: function (item, property, parsing) {
        if (['ifKey', 'ifVal'].includes(property) && !item[property]) {
          return '필수 입력입니다.'
        }

        if (property === 'ifKey') {
          for (const row of ifsKey.collectionView.value.items) {
            if (row !== item && item.ifKey === row.ifKey) {
              return '동일한 인터페이스키가 존재합니다.'
            }
          }
        }

        return null
      },
    })

    collectionView.currentChanged.addHandler((s, e) => {
      const currentItem = ifsKey.collectionView.value.currentItem
      ifsKey.disabledRemoveButton.value = !currentItem
    })

    collectionView.collectionChanged.addHandler((s, e) => {
      collectionView.onCurrentChanged({})
    })

    return collectionView
  }),

  grid: ref<FlexGrid>(),

  /**
   * row 추가
   */
  addRow: async function () {
    ifsKey.collectionView.value.addNew({
      ifKey: null,
      ifVal: null,
      rmk: null,
      ifId: null,
      ifVer: null,
    })
    await nextTick()
    ifsKey.grid.value.startEditing(true, ifsKey.collectionView.value.itemCount - 1, 0, true)
  },

  // row 제거
  removeRow: function () {
    ifsKey.collectionView.value.remove(ifsKey.collectionView.value.currentItem)
  },

  // 삭제 버튼 비활성화 여부
  disabledRemoveButton: ref(true),
}

function showHist() {
  emits('showHist', inputData.ifId)
}

const emits = defineEmits<{
  (e: 'showHist', ifId: string): void
  (e: 'saved'): void
}>()

defineExpose({
  init,
  updateForm,
})
</script>

<style scoped></style>
