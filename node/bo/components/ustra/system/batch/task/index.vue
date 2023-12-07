<template>
  <UBox direction="col">
    <UItem>
      <UBox class="table-title-wrap">
        <UButtonBox>
          <UButton text="초기화" :width="80" @click="searchAction.clearSearchParam"></UButton>
          <UButton text="신규" @click="formAction.newForm" />
          <UButton text="조회" class="primary" @click="searchAction.loadSearchedData" />
        </UButtonBox>
      </UBox>

      <UFieldSet>
        <UFieldRow>
          <UField label="배치 아이디">
            <UTextBox type="text" v-model="searchAction.searchParam.batId" />
          </UField>
          <UField label="배치 명">
            <UTextBox type="text" v-model="searchAction.searchParam.batNm" />
          </UField>
          <UField blank></UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>

    <UItem style="margin-top: 30px">
      <UBox direction="row" style="gap: 15px">
        <UItem :ratio="5">
          <WjFlexGrid style="height: 545px" :initialized="gridAction.grid.initialize">
            <WjFlexGridColumn binding="batId" header="배치 아이디" width="*" />
            <WjFlexGridColumn binding="batNm" header="배치 명" width="*" />
            <WjFlexGridColumn binding="useYn" header="사용 여부" width="*" />
            <WjFlexGridColumn binding="dupExecAvlYn" header="중복 실행 가능 여부" width="*" />
          </WjFlexGrid>
        </UItem>
        <UItem :ratio="5" :disabled="formAction.formDisabled.value">

          <UBox class="table-title-wrap">
            <UButtonBox class="table-buttons">
              <UButton
                text="시작"
                icon="mdi-play-circle"
                mdiIconColor="gray"
                :width="95"
                :disabled="formAction.mode.value === 'new'"
                @click="formAction.batchStart"
              />
              
              <UButton text="삭제" :disabled="formAction.mode.value === 'new'" @click="formAction.deleteForm" />
              <UButton text="저장" @click="formAction.saveForm" type="primary" />
            </UButtonBox>
          </UBox>
          
          <UValidationGroup
            :ref="ctl => {
              validationGroup = ctl as InstanceType<typeof UValidationGroup>
            }"
          >
            <UFieldSet>
              <UFieldRow>
                <UField label="배치 아이디" required>
                  <WjInputMask
                    v-model="formAction.inputData.batId"
                    :isDisabled="formAction.mode.value === 'update'"
                    :validation="{ rules: [formAction.validateId] }"
                  />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="배치 명"><WjInputMask :isRequired="false" v-model="formAction.inputData.batNm" /> </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="배치 설명"><UTextBox :isRequired="false" type="textarea" noResize v-model="formAction.inputData.batDesc" /> </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="사용 여부" required
                  ><URadioGroupBox v-model="formAction.inputData.useYn" :itemsSource="searchAction.useYnItems" />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="스케줄 구분 코드" :required="formAction.inputData.useYn === 'Y' ? true : false">
                  <UCodeComboBox
                    grpCd="SCHDL_DV_CD"
                    :isRequired="formAction.inputData.useYn === 'Y' ? true : false"
                    v-model="formAction.inputData.schdlDvCd"
                    displayNullText="선택"
                  />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="스케줄 값" :required="formAction.inputData.useYn === 'Y' ? true : false">
                  <WjInputMask v-model="formAction.inputData.schdlVal" :isRequired="formAction.inputData.useYn === 'Y' ? true : false" />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="중복 실행 여부" required>
                  <URadioGroupBox v-model="formAction.inputData.dupExecAvlYn" :itemsSource="searchAction.avlYnItems" />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="지연 시간(S)"><WjInputNumber :isRequired="false" v-model="formAction.inputData.dlyS" /> </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="인스턴스 코드">
                  <WjMultiSelect :isRequired="false" v-model="formAction.inputData.batInstCd" :itemsSource="searchAction.workerItems.value" />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="입력 정보" v-if="formAction.mode.value === 'update'">
                  <b
                    >{{ $ustra.utils.formatting.datetime(formAction.inputData.regDttm, 'yyyy-MM-dd hh:mm:ss') }} /
                    {{ formAction.inputData.regUsrId }} / {{ formAction.inputData.regUsrIp }}
                  </b>
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="수정 정보" v-if="formAction.mode.value === 'update'">
                  <b
                    >{{ $ustra.utils.formatting.datetime(formAction.inputData.updDttm, 'yyyy-MM-dd hh:mm:ss') }} /
                    {{ formAction.inputData.updUsrId }} / {{ formAction.inputData.updUsrIp }}
                  </b>
                </UField>
              </UFieldRow>
            </UFieldSet>
          </UValidationGroup>
        </UItem>
      </UBox>
    </UItem>
    <UItem :ratio="0" height="100%">
      <template #default>
        <UPopup v-model="formAction.histShow.value" title="배치 이력 조회">
          <UBox direction="col" height="100%">
            <UItem :ratio="1">
              <template #default>
                <BatchHist ref="batchHistComp" />
              </template>
            </UItem>
          </UBox>
        </UPopup>
      </template>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, watch, onMounted, useOnError, provide, inject, shallowRef, computed, nextTick } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  WjFlexGrid,
  WjFlexGridColumn,
  WjComboBox,
  WjInputMask,
  WjInputNumber,
  UCheckGroupBox,
  UValidationGroup,
  WjMultiSelect,
} from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables/grid'
import { baseModels } from '#ustra/core/data'
import { BatchCriteria, Batch, useUstraBatchService, useUstraBatchWorkerService } from '#ustra/nuxt/management'
import BatchHist from '../hist/index.vue'
const service = useUstraBatchService()
const workerService = useUstraBatchWorkerService()
const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()
const batchHistComp = ref<InstanceType<typeof BatchHist>>()

onMounted(async () => {
  formAction.saved()

  const result = (await workerService.getWorkerList({})).body
  searchAction.workerItems.value = result.map(item => {
    return item.workerId
  })
})

const searchAction = (function () {
  const searchParam: BatchCriteria = reactive({
    batId: null,
    batNm: null,
  })

  function clearSearchParam() {
    searchParam.batId = null
    searchParam.batNm = null
  }

  async function loadSearchedData() {
    formAction.saved()
  }

  const useYnItems = reactive([
    { value: 'Y', text: '사용' },
    { value: 'N', text: '미사용' },
  ])

  const avlYnItems = reactive([
    { value: 'Y', text: '가능' },
    { value: 'N', text: '불가능' },
  ])

  const workerItems = ref<string[]>([])

  return {
    searchParam,
    clearSearchParam,
    loadSearchedData,
    useYnItems,
    avlYnItems,
    workerItems,
  }
})()

const gridAction = (function () {
  const grid = useWijmoFlexGrid({
    async onCellClick(col, row, data) {
      formAction.updateForm(data)
    },
    pagination: {
      mode: 'infinite',
      handler(currentPage, pageSize, orders) {
        return useOnError(
          async () => {
            const result = await service.getBatchList({
              ...searchAction.searchParam,
              pageSize,
              pageNo: currentPage,
            })
            return {
              data: result.body,
              totalRecords: result.header.totalRecords,
            }
          },
          { message: '데이터 조회 중 오류가 발생하였습니다.' },
        )()
      },
      pageSize: 20,
    },
  })
  return {
    grid,
  }
})()

const formAction = (function () {
  const mode = ref<baseModels.FormMode>('new')
  const formDisabled = ref(true)

  const inputData = reactive({
    batId: null,
    batNm: null,
    batDesc: null,
    useYn: 'Y',
    schdlDvCd: null,
    schdlVal: null,
    dupExecAvlYn: 'N',
    dlyS: 0,
    batInstCd: [],
    immediateStartYn: 'N',
    parameterList: [],
  })

  async function init() {
    mode.value = 'new'

    Object.assign(inputData, {
      batId: null,
      batNm: null,
      batDesc: null,
      useYn: 'Y',
      schdlDvCd: null,
      schdlVal: null,
      dupExecAvlYn: 'N',
      dlyS: 0,
      batInstCd: [],
      immediateStartYn: 'N',
      parameterList: [],
    })

    validationGroup.value && (await validationGroup.value.init())
  }

  async function updateForm(batch: Batch) {
    mode.value = 'update'

    const result = (
      await service.getBatch({
        header: {},
        batId: batch.batId,
      })
    ).body
    Object.assign(inputData, result)
    formDisabled.value = false

    const valueMap = result.insts.map(function (item) {
      return item.batInstCd
    })
    inputData.batInstCd = valueMap
  }

  function newForm() {
    formDisabled.value = false
    init()
    gridAction.grid.selection.clear()
  }

  const saveForm = useOnError(
    async () => {
      const validateResult = await validationGroup.value.validate()
      if (!validateResult || !validateResult.isValid) {
        toast('잘못 입력 된 값이 있습니다.')
        return
      }

      const realInputData = $ustra.utils.core.deepMerge({}, inputData)

      if (mode.value === 'new') {
        await service.addBatch({ header: {}, batch: realInputData })
      } else {
        await service.modBatch({ header: {}, batch: realInputData })
      }

      saved()
    },
    {
      // message: Error.message,
    },
  )

  async function deleteForm() {
    const realInputData = $ustra.utils.core.deepMerge({}, inputData)

    if (await confirm('삭제하시겠습니까?')) {
      await service.delBatch({ header: {}, batId: realInputData.batId })
      saved()
    }
  }

  async function saved() {
    formDisabled.value = true
    init()
    gridAction.grid.pagination.loadPageData(1)
  }

  const histShow = ref(false)
  async function batchStart() {
    histShow.value = true
    await nextTick()
    const realInputData = $ustra.utils.core.deepMerge({}, formAction.inputData)
    batchHistComp.value.searchAction.loadSearchedData(realInputData.batId)
    const message = await service.startBatch({ header: {}, batId: realInputData.batId })
  }

  async function validateId(batId) {
    if (!batId) return
    if (mode.value === 'update') return
    try {
      const checkId = await service.getBatch({
        header: {},
        batId,
      })
      if (checkId) {
        return '이미 사용 중인 아이디입니다.'
      }
    } catch (error) {}
    return true
  }
  return {
    mode,
    inputData,
    init,
    formDisabled,
    saveForm,
    validateId,
    validationGroup,
    newForm,
    updateForm,
    deleteForm,
    saved,
    batchStart,
    histShow,
  }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemBatchTask',
}
</script>
<style scoped></style>
