<template>
  <UBox direction="col">
    <UItem>
      <UBox class="table-title-wrap">
        <UButtonBox>
              <UButton text="초기화" :width="80" @click="searchAction.clearSearchParam"><span class="blind">초기화</span></UButton>
              <UButton text="신규" @click="formAction.newForm" />
              <UButton text="조회" class="primary" @click="searchAction.loadSearchedData" />
        </UButtonBox>
      </UBox>

      <UFieldSet>
        <UFieldRow :ratio="[1, 1, 1]">
          <UField label="워커 아이디">
            <UTextBox type="text" v-model="searchAction.searchParam.workerId" />
          </UField>
          <UField label="엔드포인트">
            <UTextBox type="text" v-model="searchAction.searchParam.endpoint" />
          </UField>
          <UField blank></UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>

    <UItem style="margin-top: 30px">
      <UBox direction="row" style="gap: 15px">
        <UItem :ratio="5">
          <WjFlexGrid style="height: 560px" :initialized="gridAction.grid.initialize" :itemsSource="data">
            <WjFlexGridColumn binding="workerId" header="워커 아이디" width="*" />
            <WjFlexGridColumn binding="endpoint" header="엔드포인트" width="*" />
            <WjFlexGridColumn binding="capacity" header="수용량" width="*" />
            <WjFlexGridColumn binding="enabled" header="사용 여부" width="*" />
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
                @click="formAction.enable"
              />
              <UButton
                text="중지"
                icon="mdi-pause-circle"
                mdiIconColor="gray"
                :width="95"
                :disabled="formAction.mode.value === 'new'"
                @click="formAction.disable"
              />
              <UButton text="삭제" :disabled="formAction.mode.value === 'new'" @click="formAction.deleteForm" />
              <UButton text="저장" class="primary" @click="formAction.saveForm" />
            </UButtonBox>
          </UBox>
          <UValidationGroup
            :ref="ctl => {
              validationGroup = ctl as InstanceType<typeof UValidationGroup>
            }"
          >
            <UFieldSet>
              <UFieldRow>
                <UField label="워커 아이디" required>
                  <WjInputMask
                    v-model="formAction.inputData.workerId"
                    :isDisabled="formAction.mode.value === 'update'"
                    :validation="{ rules: [formAction.validateId] }"
                  />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="엔드포인트" required><WjInputMask v-model="formAction.inputData.endpoint" /> </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="수용량" required><WjInputNumber v-model="formAction.inputData.capacity" /> </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="사용 여부" required
                  ><URadioGroupBox v-model="formAction.inputData.enabled" :itemsSource="searchAction.enabledList" />
                </UField>
              </UFieldRow>
            </UFieldSet>
          </UValidationGroup>
        </UItem>
      </UBox>
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
import { BatchWorker, BatchWorkerCriteria, useUstraBatchWorkerService } from '#ustra/nuxt/management'
const service = useUstraBatchWorkerService()
const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()

onMounted(async () => {
  await nextTick()
  formAction.saved()
})

const searchAction = (function () {
  const searchParam: BatchWorkerCriteria = reactive({
    workerId: null,
    endpoint: null,
  })

  function clearSearchParam() {
    searchParam.workerId = null
    searchParam.endpoint = null
  }

  async function loadSearchedData() {
    formAction.saved()
  }

  const enabledList = reactive([
    { value: true, text: '사용' },
    { value: false, text: '미사용' },
  ])

  return {
    searchParam,
    clearSearchParam,
    loadSearchedData,
    enabledList,
  }
})()

const data = ref([])
const gridAction = (function () {
  async function loadData() {
    const result = await service.getWorkerList({
      ...searchAction.searchParam,
    })
    data.value = result.body
  }
  const grid = useWijmoFlexGrid({
    async onCellClick(col, row, data) {
      formAction.updateForm(data)
    },
  })
  return {
    grid,
    loadData,
  }
})()

const formAction = (function () {
  const mode = ref<baseModels.FormMode>('new')
  const formDisabled = ref(true)

  const inputData: BatchWorker = reactive({
    workerId: null,
    endpoint: null,
    capacity: 1,
    enabled: false,
  })

  async function init() {
    mode.value = 'new'

    Object.assign(inputData, {
      workerId: null,
      endpoint: null,
      capacity: 1,
      enabled: false,
    })

    validationGroup.value && (await validationGroup.value.init())
  }

  async function updateForm(BatchWorker: BatchWorker) {
    mode.value = 'update'
    Object.assign(inputData, BatchWorker)
    formDisabled.value = false
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
        await service.createWorker({ header: {}, batchWorker: { ...realInputData } })
      } else {
        await service.modifyWorker({ header: {}, batchWorker: { ...realInputData } })
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
      await service.deleteWorker({ header: {}, workerId: realInputData.workerId })
      saved()
    }
  }

  async function enable() {
    const realInputData = $ustra.utils.core.deepMerge({}, inputData)
    await service.enableWorker({ header: {}, batchWorker: { ...realInputData } })
    saved()
  }

  async function disable() {
    const realInputData = $ustra.utils.core.deepMerge({}, inputData)
    await service.disableWorker({ header: {}, batchWorker: { ...realInputData } })
    saved()
  }

  async function saved() {
    formDisabled.value = true
    init()
    gridAction.loadData()
  }

  async function validateId(managerId) {
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
    enable,
    disable,
  }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemBatchWorker',
}
</script>
<style scoped></style>
