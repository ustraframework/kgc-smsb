<template>
  <UPopup v-model="model" :width="500" :height="600" title="코드 입력">
    <UBox direction="col">
      <UItem :ratio="1" style="overflow: auto">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="코드" :required="true" :labelWidth="100">
                <WjInputMask
                  v-model="inputFormData.dtlCd"
                  :isDisabled="isEditMode"
                  :initialized="e => !isEditMode && e.focus()"
                  :validation="{
                    rules: [
                      {
                        type: 'custom',
                        delay: 200,
                        handler: async v => {
                          if (!v) {
                            return true
                          }

                          if (props.depth < 1) {
                            if (await codeService.getCode(v, '*')) {
                              return '이미 사용 중인 코드입니다.'
                            }
                          } else {
                            if (await codeService.getCode(props.selectedCode.grpCd, v)) {
                              return '이미 사용 중인 코드입니다.'
                            }
                          }
                          return true
                        },
                      },
                    ],
                  }"
                ></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="코드명" :required="true" :labelWidth="100">
                <WjInputMask v-model="inputFormData.cdNm" :initialized="e => isEditMode && e.focus()"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow v-if="props.depth > 0">
              <UField label="정렬순번" :required="true" :labelWidth="100">
                <WjInputNumber v-model="inputFormData.srtNo"></WjInputNumber>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="사용여부" :required="true" :labelWidth="100">
                <URadioGroupBox
                  :itemsSource="[
                    { value: 'Y', text: '사용' },
                    { value: 'N', text: '미사용' },
                  ]"
                  v-model="inputFormData.useYn"
                ></URadioGroupBox>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="코드 설명" :labelWidth="100">
                <UTextBox v-model="inputFormData.cdDesc" type="textarea"></UTextBox>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="기타필드1" :labelWidth="100">
                <WjInputMask v-model="inputFormData.etc1" :isRequired="false"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="기타필드2" :labelWidth="100">
                <WjInputMask v-model="inputFormData.etc2" :isRequired="false"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="기타필드3" :labelWidth="100">
                <WjInputMask v-model="inputFormData.etc3" :isRequired="false"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="기타필드4" :labelWidth="100">
                <WjInputMask v-model="inputFormData.etc4" :isRequired="false"></WjInputMask>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="기타필드5" :labelWidth="100">
                <WjInputMask v-model="inputFormData.etc5" :isRequired="false"></WjInputMask>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
      <UItem>
        <UButtonBox right top>
          <UButton text="저장" type="primary" :width="80" @click="save" />
          <UButton text="삭제" v-if="isEditMode" :width="80" @click="remove" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>
<script lang="ts" setup>
import {
  UPopup,
  UFieldSet,
  UFieldRow,
  UField,
  WjInputMask,
  WjInputNumber,
  URadioGroupBox,
  UTextBox,
  UValidationGroup,
  UBox,
  UItem,
} from '#ustra/nuxt-wijmo/components'
import { Code, useUstraCodeService } from '#ustra/nuxt/management'
import { withDefaults, defineProps, reactive, ref, watch, computed, useDeepMerge, defineEmits, useOnError } from '#ustra/nuxt'
import { useVModel } from '@vueuse/core'

const codeService = useUstraCodeService()

// for interface
const props = withDefaults(
  defineProps<{
    /**
     * 팝업 오픈 여부
     */
    modelValue: boolean

    /**
     * 선택된 코드 정보
     */
    selectedCode?: Code

    /**
     * 등록 depth (0~3)
     */
    depth?: number

    /**
     * 정렬 순번
     */
    sortNo: number
  }>(),
  {
    selectedCode: null,
    depth: 0,
  },
)

const emits = defineEmits<{
  (e: 'updated', depth: number, selectedCode: string)
}>()

const model = useVModel(props, 'modelValue')

// for form
const inputFormData: Code = reactive({
  dtlCd: null,
  cdNm: null,
  srtNo: 0,
  useYn: 'Y',
  cdDesc: null,
  etc1: null,
  etc2: null,
  etc3: null,
  etc4: null,
  etc5: null,
})

// init form
const isEditMode = computed(() => !!props.selectedCode?.dtlCd)
watch(model, v => {
  if (v) {
    init()
  }
})

async function init() {
  inputFormData.dtlCd = null
  inputFormData.cdNm = null
  inputFormData.srtNo = props.sortNo
  inputFormData.useYn = 'Y'
  inputFormData.cdDesc = null
  inputFormData.etc1 = null
  inputFormData.etc2 = null
  inputFormData.etc3 = null
  inputFormData.etc4 = null
  inputFormData.etc5 = null

  await loadDetail()
  if (validationGroup.value) {
    validationGroup.value.init()
  }
}

async function loadDetail() {
  if (isEditMode.value) {
    const codeInfo = await codeService.getCode(props.selectedCode.grpCd, props.selectedCode.dtlCd)
    for (const key of Object.keys(codeInfo)) {
      inputFormData[key] = codeInfo[key]
    }

    if (props.depth === 0) {
      inputFormData.dtlCd = inputFormData.grpCd
    }
  }
}

// validation & save
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

async function save() {
  return useOnError(
    async () => {
      const result = await validationGroup.value.validate()

      if (!result.isValid) {
        return
      }

      const saveData = useDeepMerge({}, inputFormData)

      saveData.grpCd = props.depth === 0 ? saveData.dtlCd : props.selectedCode.grpCd
      saveData.dtlCd = props.depth === 0 ? '*' : saveData.dtlCd
      saveData.grpNm = props.depth === 0 ? saveData.grpNm : props.selectedCode.grpNm
      saveData.uprGrpCd = props.selectedCode?.uprGrpCd || null
      saveData.uprDtlCd = props.selectedCode?.uprDtlCd || null

      const { addCode, modCode } = useUstraCodeService()

      !isEditMode.value ? await addCode(saveData) : await modCode(saveData)

      emits('updated', props.depth, props.depth === 0 ? saveData.grpCd : saveData.dtlCd)
    },
    {
      message: '저장 중 오류가 발생하였습니다.',
    },
  )()
}

async function remove() {
  return useOnError(
    async () => {
      if (props.depth === 0) {
        const codeListCheck = await codeService.getCodesByGroup(inputFormData.grpCd)

        if (codeListCheck.length > 0) {
          alert('하위 코드 삭제 후 삭제 가능합니다.')
          return
        }

        if (await confirm('삭제하시겠습니까?')) {
          await codeService.delCode(inputFormData.grpCd, '*')
          emits('updated', props.depth, null)
        }
      } else {
        const codeListCheck = await codeService.getCodeGroupDepth(inputFormData.grpCd, inputFormData.dtlCd)

        if (codeListCheck.length > 0) {
          alert('하위 코드 삭제 후 삭제 가능합니다.')
          return
        }
        if (await confirm('삭제하시겠습니까?')) {
          await codeService.delCode(inputFormData.grpCd, inputFormData.dtlCd)
          emits('updated', props.depth, null)
        }
      }
    },
    {
      message: '삭제 중 오류가 발생하였습니다.',
    },
  )()
}
</script>
<script lang="ts">
export default {
  name: 'UstraSystemCodeForm',
}
</script>
