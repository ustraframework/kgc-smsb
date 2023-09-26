```html
<template>
  <UValidationGroup ref="validationGroup" :disabled="disabled">
    <div class="mb-3">
      <div class="mt-2">필수 입력 : <WjInputMask ref="field1" :isRequired="true" v-model="fieldValue1" /></div>
      <div class="mt-2">
        필수 입력 :
        <UCodeComboBox grpCd="SYS_CD" v-model="fieldValue2" displayNullText="전체" />
      </div>
    </div>
  </UValidationGroup>
  <UButton text="Validate" @click="validateForm"></UButton>
  <UButton text="Init" @click="() => validationGroup.init()">Init</UButton>
  <UButton :text="disabled ? '활성화' : '비활성화'" @click="() => (disabled = !disabled)"></UButton>
</template>
<script lang="ts" setup>
import { UValidationGroup, WjInputMask, UButton } from '#ustra/nuxt-wijmo/components'

const fieldValue1 = ref(null)
const fieldValue2 = ref(null)
const disabled = ref(false)

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
async function validateForm() {
  const result = await validationGroup.value.validate()

  console.log('result', result)
}
</script>
```
