<template>
  <UPopup
    v-model="model"
    :width="600"
    :height="500"
    :title="popupTitle"
    @hidden="
      () => {
        if (taskCallback) {
          taskCallback({ applied: false, text: null })
        }
        taskCallback = null
      }
    "
  >
    <UFieldSet>
      <UFieldRow>
        <UField label="Input your comment." required>
          {{ $props.modelValue }}
        </UField>
      </UFieldRow>
    </UFieldSet>
  </UPopup>
</template>
<script lang="ts" setup>
import { UBox, UItem, UPopup, UFieldSet, UFieldRow, UField } from '#ustra/nuxt-wijmo/components'
import { defineProps, withDefaults, defineExpose, ref, watch } from '#ustra/nuxt'
import { useVModel } from '@vueuse/core'

/**
 * 입력 결과
 */
export interface ApprovalPopupResult {
  applied: boolean

  text: string
}

const props = withDefaults(
  defineProps<{
    /**
     * 팝업 노출 여부
     */
    modelValue: boolean

    /**
     * 반려 여부
     */
    isReject?: boolean

    /**
     * 승인 여부
     */
    isProcess?: boolean
  }>(),
  {
    isReject: false,
    isProcess: false,
  },
)

const model = useVModel(props, 'modelValue')
const popupTitle = ref<string>('승인 요청')

let taskCallback = null
function open(title: string = '승인 요청') {
  return new Promise<ApprovalPopupResult>(resolve => {
    model.value = true
    popupTitle.value = title
    taskCallback = resolve
  })
}

watch(
  () => props.modelValue,
  () => {
    console.log('modelValue changed....', $ustra)
  },
)

defineExpose({ open })
</script>
<script lang="ts">
export default {
  name: 'UstraManagementApprovalPopup',
}
</script>
