<template>
  <UBox direction="col">
    <UItem :ratio="1">
      <UBox class="table-title-wrap">
        <UButtonBox style="padding-right: 0;">
          <UButton text="권한불러오기" @click="() => $ustra.global.alert('준비 중 입니다.')" />
          <UButton text="저장" type="is-filled"  @click="() => save()" />
        </UButtonBox>
      </UBox>

      <UValidationGroup ref="validationGroup" class="auth-form">
        <UFieldSet>
          <UFieldRow>
            <UField required label="권한사용 기간">
              <UDatePeriodBox :isRequired="true" v-model:start="inputData.useSrtDt" v-model:end="inputData.useEndDt" />
            </UField>
          </UFieldRow>
          <WjFlexGrid
            style="height: 500px; margin-top: 10px; margin-left: 0px;"
            :itemsSource="inputData.menus"
            childItemsPath="items"
            :initialized="grid.initialize"
            :loadedRows="onGridLoadedRows"
            allowSorting="None"
          >
            <WjFlexGridColumn binding="mnuNm" header="메뉴" :width="200" />
            <WjFlexGridColumn binding="mnuNm" header="기능" width="*">
              <wj-flex-grid-cell-template cellType="Cell" v-slot="cell" >
                <div>
                  <UCheckGroupBox
                    v-if="cell.item.functionItemsSource && cell.item.functionItemsSource.length > 0"
                    v-model="cell.item.functionValues"
                    :itemsSource="cell.item.functionItemsSource"
                    :stack="true"
                    :multiple="true"
                    style="max-height: 19px"
                    @click="
                      e => {
                        cell.row.isSelected = e.value.some(v => v)
                        grid.rawControl.invalidate(false)
                      }
                    "
                  />
                </div>
              </wj-flex-grid-cell-template>
            </WjFlexGridColumn>
          </WjFlexGrid>
        </UFieldSet>
      </UValidationGroup>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, defineExpose, defineProps, computed, nextTick } from '#ustra/nuxt'
import { Auth, useUstraAuthService, AuthMenuTreeData } from '#ustra/nuxt/management'
import { useDeepMerge } from '#ustra/nuxt/composables'
import {
  UValidationGroup,
  UDatePeriodBox,
  UFieldSet,
  UFieldRow,
  UField,
  WjFlexGrid,
  WjFlexGridColumn,
  WjFlexGridCellTemplate,
  UCheckGroupBox,
  USpacer,
  UButtonBox,
  UButtonBar,
} from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid, wijmo } from '#ustra/nuxt-wijmo'
import pick from 'lodash/pick'

const authService = useUstraAuthService()
const inputData: Auth = reactive({})
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
const grid = useWijmoFlexGrid<AuthMenuTreeData>({
  selection: {
    mode: 'Check',
  },
  onAfterInitialized() {
    grid.checkSelection.selector.value.itemChecked.addHandler(e => {
      grid.rawControl.rows.forEach(r => {
        const dataItem = r.dataItem as AuthMenuTreeData

        if (!r.isSelected && dataItem.authFncs && dataItem.authFncs.length > 0) {
          nextTick(() => {
            // dataItem.functionValues = dataItem.authFncs.map(f => false)
          })
        }
      })
    })
  },
})

const props = defineProps<{
  sysCd: string
}>()

/**
 * 초기화
 */
function init() {
  useDeepMerge(inputData, {
    authGrpId: null,
    usrId: null,
    useSrtDt: null,
    useEndDt: null,
    menus: [],
    authGrpDelYn: 'Y',
  })

  validationGroup.value?.init()
}
init()

function onGridLoadedRows(grid: wijmoGrid.FlexGrid) {
  grid.collapseGroupsToLevel(0)

  nextTick(() => {
    grid.rows.forEach(row => {
      row.isSelected = row.dataItem.selected
    })
  })
}

/**
 * group 권한 정보 로드
 * @param authGrpId 권한 그룹 아이디
 */
async function loadOfGroup(authGrpId: number) {
  init()
  const result = await authService.getAuthGroupInfo(authGrpId, props.sysCd)
  return generateAuthData(result)
}

/**
 * 사용자 권한 정보 로드
 * @param usrId
 */
async function loadOfUser(usrId: string) {
  init()
  const result = await authService.getUserAuthInfo(usrId, props.sysCd)
  return generateAuthData(result)
}

function generateAuthData(auth: Auth) {
  $ustra.utils.model.reclusiveEach(auth.menus, 'items', m => {
    if (m.authFncs) {
      m.functionItemsSource = m.authFncs.map(f => {
        return {
          text: f.fncNm,
        }
      })

      m.functionValues = computed({
        get() {
          return reactive(m.authFncs.map(v => v.authYn === 'Y'))
        },
        set(v) {
          v.forEach((value, index) => {
            m.authFncs[index].authYn = value ? 'Y' : 'N'
          })
        },
      })
    }
  })
  useDeepMerge(inputData, auth)
}

// 저장
async function save() {
  const validResult = await validationGroup.value.validate()

  if (!validResult.isValid) {
    return
  }

  const saveData = $ustra.utils.core.deepMerge({}, inputData)
  const menus = $ustra.utils.model.flatReclusiveArray(saveData.menus, 'items')
  saveData.menus = menus
    .filter(m => {
      return grid.rawControl.selectedItems.some(rd => rd.mnuId === m.mnuId)
    })
    .map(m => {
      m = pick(m, ['mnuId', 'authFncs', 'mnuNm', 'functionValues'])
      m.authId = saveData.authId

      if (m.authFncs) {
        m.authFncs = m.authFncs.map((authFnc, index) => {
          const newFnc = pick(authFnc, ['authId', 'authYn', 'fncId', 'mnuId'])

          // if (m.functionValues.value[index]) {
          //   newFnc.authYn = 'Y'
          // }

          return newFnc
        })
      }

      return m
    })

  const result = await authService.save(saveData)

  if (result.resultCode === 'FM11') {
    // TODO: 승인 로직 처리
    return
  }

  alert('저장이 완료되었습니다.')
}

defineExpose({
  init,
  loadOfGroup,
  loadOfUser,
})
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthForm',
}
</script>
<style scoped>
:deep(.wj-cell.wj-group) {
  background-color: unset;
}

:deep(.wj-flexgrid.wj-control.wj-content .wj-cells .wj-row .wj-cell.wj-state-multi-selected) {
  background-color: unset;
  color: #000;
}

:deep(.wj-flexgrid.wj-control.wj-content .wj-cells .wj-row .wj-cell.wj-state-selected) {
  background-color: unset;
  color: #000;
}
</style>
