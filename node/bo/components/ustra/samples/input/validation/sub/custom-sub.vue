<template>
  <div>
    <UMessage message="2개 항목을 동일하게 입력하세요." />
    <WjInputMask v-model="textValue1" />
    <WjInputMask v-model="textValue2" />
  </div>
</template>
<script lang="ts" setup>
import { ref, defineExpose } from '#ustra/nuxt'
import { WjInputMask, UMessage } from '#ustra/nuxt-wijmo/components'
import { watchValidationData } from '#ustra/nuxt-wijmo/composables'

const textValue1 = ref('')
const textValue2 = ref('')

// textValue1, textValue2 값이 변경될 경우, validation 재실행
watchValidationData([textValue1, textValue2])

defineExpose({
  validate: () => {
    if (!textValue1.value || !textValue2.value) {
      return '필수 입력이예요!'
    }

    if (textValue1.value !== textValue2.value) {
      return '동일한 값을 입력하세요!'
    }
    return true
  },
})
</script>
