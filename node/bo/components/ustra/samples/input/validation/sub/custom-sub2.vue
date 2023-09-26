<template>
  <div ref="root">
    <UMessage message="2개 항목을 동일하게 입력하세요." />
    <WjInputMask v-model="textValue1" style="margin-right: 2px" />
    <WjInputMask v-model="textValue2" />
  </div>
</template>
<script lang="ts" setup>
import { ref, shallowRef, defineExpose } from '#ustra/nuxt'
import { WjInputMask, UMessage } from '#ustra/nuxt-wijmo/components'
import { watchValidationData } from '#ustra/nuxt-wijmo/composables'

const textValue1 = ref('')
const textValue2 = ref('')
const root = shallowRef<HTMLDivElement>()

// textValue1, textValue2 값이 변경될 경우, validation 재실행
watchValidationData([textValue1, textValue2])

defineExpose({
  validate: () => {
    let message = null
    if (!textValue1.value || !textValue2.value) {
      message = '필수 입력이예요!'
    }

    if (textValue1.value !== textValue2.value) {
      message = '동일한 값을 입력하세요!'
    }

    const els = []
    root.value.querySelectorAll('.wj-input-group').forEach(i => els.push(i))

    return {
      isValid: !message,
      els,
      message,
      onValidated(result) {
        els.forEach(el => {
          if (!result) {
            el.classList.add('ustra-invalidate')
          } else {
            el.classList.remove('ustra-invalidate')
          }
        })
      },
      onInit() {
        els.forEach(el => {
          el.classList.remove('ustra-invalidate')
        })
      },
    }
  },
})
</script>
