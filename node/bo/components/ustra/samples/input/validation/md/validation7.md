```html
<template>
  <UValidationGroup ref="validationGroup" :checkValidationOnUpdate="checkValidationOnUpdate">
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
  <UButton
    :text="checkValidationOnUpdate ? '입력비감지로 전환' : '입력감지로 전환'"
    @click="() => (checkValidationOnUpdate = !checkValidationOnUpdate)"
  ></UButton>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UValidationGroup, WjInputMask } from '#ustra/nuxt-wijmo/components'

const fieldValue1 = ref(null)
const fieldValue2 = ref(null)
const checkValidationOnUpdate = ref(false)

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
async function validateForm() {
  const result = await validationGroup.value.validate()

  console.log('result', result)
}
</script>

```
