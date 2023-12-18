<template>
  <UPopup v-model="modelValue" :title="props.title" :width="800" :height="600" @shown="clear">
    <UBox direction="col">
      <UItem>
        <UButtonBar>
          <UFieldSet>
            <UFieldRow :ratio="props.usrSttCd ? [1, 1] : [1, 1, 1]">
              <UField label="사용자 명/아이디" direction="col">
                <WjInputMask ref="keywordInput" :initialized="e => e.focus()" @keydown.enter="search" v-model="inputData.usrId"></WjInputMask>
              </UField>
              <UField label="상태" direction="col" v-if="!props.usrSttCd">
                <UCodeComboBox grpCd="USR_STT_CD" v-model="inputData.usrSttCd" displayNullText="전체" />
              </UField>
              <UField blank>
                <UButtonBox> <UButton text="검색" type="primary" @click="search" /> </UButtonBox>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UButtonBar>
      </UItem>
      <UItem :ratio="1" scrollType="hidden">
        <WjFlexGrid style="height: 100%" :itemsSource="users" :initialized="grid.initialize">
          <WjFlexGridColumn binding="usrId" header="아이디" width="*" />
          <WjFlexGridColumn binding="usrNm" header="이름" width="*" />
          <WjFlexGridColumn header="회사명" binding="orgCd" :cellTemplate="ctx => useUstraCodeValue('ORG_CD', ctx.value)" width="*" />
          <WjFlexGridColumn header="부서명" binding="deptCd" :cellTemplate="ctx => useUstraUserDeptName(ctx.item)" width="*" />
          <WjFlexGridColumn
            header="상태"
            binding="usrSttCd"
            :cellTemplate="ctx => useUstraCodeValue('USR_STT_CD', ctx.value)"
            align="center"
            width="*"
          />
          <WjFlexGridColumn
            header="사용기간"
            binding="usrSttCd"
            :cellTemplate="
              ({ item }) => {
                if (!item.useSrtDt && !item.useEndDt) {
                  return null
                } else {
                  return `${$ustra.utils.formatting.date(item.useSrtDt)} ~ ${$ustra.utils.formatting.date(item.useEndDt)}`
                }
              }
            "
            width="2*"
          />
        </WjFlexGrid>
      </UItem>
    </UBox>
    <template #buttons>
      <UButton
        text="적용"
        type="primary"
        :disabled="!isEnableApplyButton"
        @click="() => {

            if (props.multiple) {
              emits('selected', useDeepMerge([] as any, toRaw(grid.checkSelection.rowsData.value)))
            } else {
              getUserData((grid.selectionData.value as User).usrId).then(user => emits('selected', user))
            }
            modelValue = false
          }
        "
      />
    </template>
  </UPopup>
</template>
<script lang="ts" setup>
import { defineProps, withDefaults, reactive, ref, toRaw, watchEffect, useDeepMerge, defineExpose, watch, defineOptions } from '#ustra/nuxt'
import {
  UPopup,
  WjFlexGrid,
  WjFlexGridColumn,
  UBox,
  UItem,
  UButtonBar,
  UFieldSet,
  UField,
  UFieldRow,
  WjInputMask,
  UButton,
} from '#ustra/nuxt-wijmo/components'
// import { User, UserCriteria, UsrSttCd, useUstraCodeValue, useUstraUserDeptName, useUstraUserService } from '#ustra/nuxt/management'
import { useUstraCodeValue, useUstraUserDeptName } from '#ustra/nuxt/management'
import { User, UserCriteria } from '~/models/user'
import { UsrSttCd } from '~/models/common-code'
import { useUstraUserService } from '~/services/user'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { useVModel } from '@vueuse/core'

defineOptions({
  name: 'UserPopup',
})

const userService = useUstraUserService()
const props = withDefaults(
  defineProps<{
    /**
     * 팝업 오픈 여부
     */
    modelValue: boolean
    /**
     * 팝업 제목
     * @default '사용자 조회'
     */
    title?: string

    /**
     * 멀티 선택 여부
     * @default false
     */
    multiple?: boolean

    /**
     * 조회 사용자 유형
     */
    useDvCds?: string[]

    /**
     * 사용자 상태 코드
     */
    usrSttCd?: UsrSttCd
  }>(),
  { title: '사용자 조회', multiple: false, useDvCds: null, usrSttCd: null },
)

const emits = defineEmits<{
  (e: 'selected', item: User | User[]): void
  (e: 'update:modelValue', v: boolean): void
}>()
const modelValue = useVModel(props, 'modelValue')

const grid = useWijmoFlexGrid<User>({
  async onCellDblClick(col, row, data) {
    if (props.multiple) {
      return
    }

    if (data) {
      emits('selected', await getUserData(data.usrId))
      modelValue.value = false
    }
  },
  selection: {
    mode: props.multiple ? 'Check' : wijmoGrid.SelectionMode.Row,
  },
})

const users = ref<User[]>()
const inputData: UserCriteria = reactive({
  usrId: null,
  usrSttCd: null,
})

watch(
  () => props.usrSttCd,
  v => {
    if (inputData.usrSttCd !== v) {
      inputData.usrSttCd = v
    }
  },
  {
    immediate: true,
  },
)

async function search() {
  inputData.useDvCds = !props.useDvCds || props.useDvCds.length < 1 ? null : props.useDvCds
  users.value = (await userService.getUsers(inputData)).map(u => $ustra.utils.model.removeSystemField(u))
}

function clear() {
  inputData.usrId = null
  inputData.usrSttCd = props.usrSttCd
  users.value = []
}

const isEnableApplyButton = ref(false)
watchEffect(() => {
  isEnableApplyButton.value = !props.multiple ? !!grid.selectionData.value : grid.selectionData.value && grid.checkSelection.rows.value.length > 0
})

async function getUserData(usrId: string) {
  return await userService.getUser(usrId)
}

/**
 * input keyword and search
 * @param keyword
 */
async function inputAndSearch(keyword: string) {
  inputData.usrId = keyword

  if (keyword) {
    await search()

    // if (users.value.length === 1) {
    //   emits('selected', await getUserData(grid.rawControl.selectedRows[0].dataItem.usrId))
    //   modelValue.value = false
    // }
  }
}

defineExpose({ inputAndSearch })
</script>
