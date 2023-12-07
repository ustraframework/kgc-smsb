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
        <UFieldRow :ratio="[1,2]">
          <UField label="매니저 아이디">
            <UTextBox type="text" v-model="searchAction.searchParam.managerId" />
          </UField>
          <UField blank></UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
    
    <UItem :ratio="1" style="margin-top: 30px">
      <UBox direction="row" style="gap: 15px">
        <UItem :ratio="5">
          <WjFlexGrid style="height: 560px" :initialized="gridAction.grid.initialize" :itemsSource="data">
            <WjFlexGridColumn binding="managerId" header="매니저 아이디" width="*" />
            <WjFlexGridColumn binding="endpoint" header="엔드포인트" width="*" />
            <WjFlexGridColumn binding="master" header="마스터 여부" width="*" />
            <WjFlexGridColumn binding="enabled" header="사용 여부" width="*" />
          </WjFlexGrid>
        </UItem>
        <UItem :ratio="5" :disabled="formAction.formDisabled.value">
          
          <UBox class="table-title-wrap">
            <UButtonBox class="table-buttons">
                <UButton text="삭제" :disabled="formAction.mode.value === 'new'" @click="formAction.deleteForm" />
                <UButton text="저장" type="primary" @click="formAction.saveForm" />
            </UButtonBox>
          </UBox>

          <UValidationGroup
            :ref="ctl => {
              validationGroup = ctl as InstanceType<typeof UValidationGroup>
            }"
          >
            <UFieldSet>
              <UFieldRow>
                <UField label="매니저 아이디" required>
                  <WjInputMask
                    v-model="formAction.inputData.managerId"
                    :isDisabled="formAction.mode.value === 'update'"
                    :validation="{ rules: [formAction.validateId] }"
                  />
                </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="엔드포인트"><UTextBox type="textarea" noResize :isRequired="false" v-model="formAction.inputData.endpoint" /> </UField>
              </UFieldRow>
              <UFieldRow>
                <UField label="마스터 여부" required
                  ><URadioGroupBox v-model="formAction.inputData.master" :itemsSource="searchAction.masterList" />
                </UField>
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
import { BatchManager, BatchManagerCriteria, useUstraBatchManagerService } from '#ustra/nuxt/management'
const service = useUstraBatchManagerService()
const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()

onMounted(async () => {
  await nextTick()
  formAction.saved()
})

const searchAction = (function () {
  const searchParam: BatchManagerCriteria = reactive({
    managerId: null,
  })

  function clearSearchParam() {
    searchParam.managerId = null
  }

  async function loadSearchedData() {
    formAction.saved()
  }

  const masterList = reactive([
    { value: true, text: 'Active' },
    { value: false, text: 'Stand By' },
  ])

  const enabledList = reactive([
    { value: true, text: '사용' },
    { value: false, text: '미사용' },
  ])

  return {
    searchParam,
    clearSearchParam,
    loadSearchedData,
    masterList,
    enabledList,
  }
})()

const data = ref([])
const gridAction = (function () {
  async function loadData() {
    const result = await service.getManagerList({
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

  const inputData: BatchManager = reactive({
    managerId: null,
    endpoint: null,
    master: false,
    enabled: false,
  })

  async function init() {
    mode.value = 'new'

    Object.assign(inputData, {
      managerId: null,
      endpoint: null,
      master: false,
      enabled: false,
    })

    validationGroup.value && (await validationGroup.value.init())
  }

  async function updateForm(batchManager: BatchManager) {
    mode.value = 'update'
    Object.assign(inputData, batchManager)
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
        await service.createManager({ header: {}, batchManager: { ...realInputData } })
      } else {
        await service.modifyManager({ header: {}, batchManager: { ...realInputData } })
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
      await service.deleteManager({ managerId: realInputData.managerId })
      saved()
    }
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
  }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemBatchManager',
}
</script>
<style scoped></style>
