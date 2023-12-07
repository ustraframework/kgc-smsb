<template>
  <WjTabPanel class="menu-tab-panel">
    <UBox class="table-title-wrap mt-2">
      <UButtonBox class="table-buttons">
        <UButton v-if="!isNew" text="삭제" :width="80" @click="() => remove()" />
        <UButton text="저장" type="is-filled" :width="80" @click="() => save()" />
      </UButtonBox>
    </UBox>
    <WjTab>
      <a>메뉴 정보</a>
      <UBox direction="col" style="padding-top: 8px">
        <UItem :ratio="1">
          <UValidationGroup ref="validationGroup">
            <UFieldSet>
              <UFieldRow>
                <UField label="상위 메뉴 명">
                  <div>{{ inputData.uprMnuId ? inputData.uprMnuPathText : '없음.' }}</div>
                </UField>
              </UFieldRow>

              <UFieldRow v-if="!isNew">
                <UField label="메뉴 아이디">{{ inputData.mnuId }}</UField>
              </UFieldRow>

              <UFieldRow>
                <UField label="프로그램 아이디"
                  ><WjInputMask v-model="inputData.proIdVal" :isRequired="false" :initialized="e => (programIdInput = e)"
                /></UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="메뉴 명"><WjInputMask v-model="inputData.mnuNm" /></UField>
              </UFieldRow>

              <UFieldRow>
                <UField label="메뉴 설명"><UTextBox v-model="inputData.mnuDesc" type="textarea"></UTextBox></UField>
              </UFieldRow>

              <UFieldRow>
                <UField label="URL"><WjInputMask v-model="inputData.mnuUrl" :isRequired="false" /></UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="순번"><WjInputNumber v-model="inputData.mnuSrtNo" /></UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="노출 디바이스">
                  <UCodeComboBox grpCd="MNU_DVC_SCOP_CD" v-model="inputData.mnuDvcScopCd" :isRequired="true" />
                </UField>
              </UFieldRow>

              <UFieldRow>
                <UField required label="권한 유형">
                  <UCodeComboBox grpCd="MNU_TY_CD" v-model="inputData.mnuTyCd" :isRequired="true" />
                </UField>
                <UField required label="권한 범위">
                  <UCodeComboBox grpCd="AUTH_SCOP_CD" v-model="inputData.authScopCd" :isRequired="true" />
                </UField>
              </UFieldRow>

              <UFieldRow v-if="inputData.mnuTyCd === '02'">
                <UButtonBar class="mt-2">
                  <UButtonBox right>
                    <UButton icon="mdi-folder-plus" @click="() => functions.addRow()"></UButton>
                    <UButton icon="mdi-folder-minus" :disabled="functions.disabledRemoveButton.value" @click="() => functions.removeRow()"></UButton>
                  </UButtonBox>
                </UButtonBar>
              </UFieldRow>
              <UFieldRow v-if="inputData.mnuTyCd === '02'">
                <WjFlexGrid
                  style="height: 200px"
                  :itemsSource="functions.collectionView.value"
                  :initialized="e => (functions.grid.value = e)"
                  :allowDelete="true"
                >
                  <WjFlexGridColumn header="아이디" binding="fncId" :isRequired="true" :width="100" />
                  <WjFlexGridColumn header="기능명" binding="fncNm" :isRequired="true" width="*" />
                  <WjFlexGridColumn header="개인정보여부" binding="prvViewYn" :cellTemplate="ctx => (ctx.value === 'Y' ? 'O' : 'X')" align="center">
                    <wj-flex-grid-cell-template cellType="CellEdit" v-slot="cell">
                      <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '' }]" v-model="cell.value"> </UCheckGroupBox>
                    </wj-flex-grid-cell-template>
                  </WjFlexGridColumn>
                </WjFlexGrid>
              </UFieldRow>

              <UFieldRow>
                <UField blank>
                  <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '사용' }]" v-model="inputData.useYn"> </UCheckGroupBox>
                  <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '노출' }]" v-model="inputData.dpYn"> </UCheckGroupBox>
                  <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '아이피 제한' }]" v-model="inputData.ipLmtYn">
                  </UCheckGroupBox>
                </UField>
              </UFieldRow>

              <UFieldRow v-if="inputData.ipLmtYn === 'Y'">
                <UField required label="아이피 제한"><UIpAddressListBox v-model="inputData.ipInputList" :isRequired="true" /></UField>
              </UFieldRow>
            </UFieldSet>
          </UValidationGroup>
        </UItem>
      </UBox>
    </WjTab>
    <WjTab :isDisabled="isNew">
      <a>권한 정보</a>
      <Authority :menuData="inputData" />
    </WjTab>
  </WjTabPanel>
  <!--  -->
</template>
<script lang="ts" setup>
import { reactive, defineExpose, ref, useOnError, defineEmits, nextTick, defineProps, computed, useDeepMerge } from '#ustra/nuxt'
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
  UIpAddressListBox,
  WjFlexGrid,
  WjFlexGridColumn,
  WjFlexGridCellTemplate,
  WjTabPanel,
  WjTab,
} from '#ustra/nuxt-wijmo/components'
import { useCollectionView, isValidCollectionView } from '#ustra/nuxt-wijmo/composables'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { Menu, useUstraMenuService } from '#ustra/nuxt/management'
import { usePathText } from './index.vue'
import Authority from './authority.vue'

import { FlexGrid } from '@grapecity/wijmo.grid'

// 메뉴 디바이스 범위 설정 사용 여부
const useMenuDeviceScopeConfig = computed(() => $ustra.management.serverAppProps.useMenuDeviceScopeConfig)

const getPathText = usePathText()
const menuService = useUstraMenuService()
const inputData: Menu = reactive({
  mnuId: null,
  proIdVal: null,
  mnuNm: null,
  mnuSrtNo: 0,
  mnuUrl: null,
  mnuTyCd: '01',
  authScopCd: '99',
  useYn: 'Y',
  delYn: 'N',
  ipLmtYn: 'N',
  dpYn: 'Y',
  ipList: null,
  uprMnuId: null,
  mnuDvcScopCd: 'A',
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
const isNew = ref(true)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
const programIdInput = ref(null)

const emits = defineEmits<{
  (e: 'updated', mnuId?: string): void
}>()

const props = defineProps<{
  /**
   * 시스템 코드
   */
  systemCode: string
}>()

/**
 * 폼 초기화
 * @param parentMenu 상위 메뉴 정보
 * @param mnuSrtNo 정렬 순번
 */
async function init(parentMenu?: Menu, mnuSrtNo?: number) {
  useDeepMerge(inputData, {
    mnuId: null,
    proIdVal: null,
    mnuNm: null,
    mnuSrtNo,
    mnuUrl: null,
    mnuTyCd: '01',
    authScopCd: '99',
    useYn: 'Y',
    delYn: 'N',
    functions: [],
    ipLmtYn: 'N',
    dpYn: 'Y',
    uprMnuId: null,
    mnuStepNo: 1,
    mnuDvcScopCd: 'A',
  })

  isNew.value = true

  if (parentMenu) {
    inputData.uprMnuId = parentMenu.mnuId
    inputData.uprMnuPathText = getPathText(parentMenu.mnuId).join(' > ')
    inputData.mnuStepNo = parentMenu.mnuStepNo + 1
  }

  validationGroup.value.init()
  await nextTick()

  if (programIdInput.value) {
    programIdInput.value.focus()
  }
}

/**
 * 상세 정보 조회
 * @param mnuId 메뉴 아이디
 */
const detail = function (mnuId: string) {
  useOnError(
    async () => {
      const result = await menuService.getMenu(mnuId)
      useDeepMerge(inputData, result)

      if (result.uprMnuId) {
        inputData.uprMnuPathText = getPathText(result.uprMnuId).join(' > ')
      }

      isNew.value = false
    },
    {
      message: '상세 정보 조회 중 오류가 발생하였습니다.',
    },
  )()
}

const save = useOnError(async () => {
  const result = await validationGroup.value.validate()

  if (!result.isValid) {
    return
  }

  if (inputData.mnuTyCd === '02') {
    const isValidFunctionGrid = isValidCollectionView(functions.collectionView.value)

    if (!isValidFunctionGrid) {
      return
    }
  } else {
    inputData.functions = []
  }

  const saveData = $ustra.utils.core.deepMerge({}, inputData)
  saveData.ipList = saveData.ipLmtYn === 'N' ? null : saveData.ipList
  saveData.sysCd = props.systemCode

  if (isNew.value) {
    const menu = await menuService.addMenu(saveData)
    emits('updated', menu.mnuId)
  } else {
    const menu = await menuService.updateMenu(saveData)
    emits('updated', menu.mnuId)
  }
})

const remove = useOnError(async () => {
  if (await confirm('메뉴 정보를 삭제하시겠습니까?')) {
    await menuService.removeMenu(inputData)
    emits('updated', inputData.uprMnuId)
  }
})

// 기능 목록
const functions = {
  collectionView: computed(() => {
    const collectionView = useCollectionView(inputData.functions, {
      getError: function (item, property, parsing) {
        if (['fncId', 'fncNm'].includes(property) && !item[property]) {
          return '필수 입력입니다.'
        }

        if (property === 'fncId') {
          for (const row of functions.collectionView.value.items) {
            if (row !== item && item.fncId === row.fncId) {
              return '동일한 아이디가 존재합니다.'
            }
          }
        }

        return null
      },
    })

    collectionView.currentChanged.addHandler((s, e) => {
      const currentItem = functions.collectionView.value.currentItem
      functions.disabledRemoveButton.value = !currentItem
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
    functions.collectionView.value.addNew({
      fncId: null,
      fncNm: null,
      prvViewYn: 'N',
    })
    await nextTick()
    functions.grid.value.startEditing(true, functions.collectionView.value.itemCount - 1, 0, true)
  },

  // row 제거
  removeRow: function () {
    functions.collectionView.value.remove(functions.collectionView.value.currentItem)
  },

  // 삭제 버튼 비활성화 여부
  disabledRemoveButton: ref(true),
}

defineExpose({ init, detail })
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemMenuForm',
}
</script>

<style lang="scss">
.menu-tab-panel {
  width: 100%;
  // height: 100%;
  display: flex;
  flex-direction: column;
}

.menu-tab-panel > div:nth-of-type(3) {
  flex: 1 1 100%;
  display: flex;
  flex-direction: column;

  & .wj-tabpanes {
    flex: 1 1 100%;
  }
}
</style>
