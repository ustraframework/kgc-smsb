```html
<template>
  <UButton text="Validate" @click="() => validationGroup.validate()" />
  <UValidationGroup ref="validationGroup" class="mt-2">
    <div class="mb-2">전화번호 :</div>
    <UPhoneNoBox v-model="value" :required="true" />

    <div class="mb-2">휴대폰번호 :</div>
    <UPhoneNoBox v-model="value2" :required="true" :onlyMobileNo="true" />

    <div class="mb-2">전화번호 :</div>
    <UPhoneNoBox2 v-model="value3" :required="true" />

    <div class="mb-2">휴대폰번호 :</div>
    <UPhoneNoBox2 v-model="value4" :required="true" :onlyMobileNo="true" />
  </UValidationGroup>
</template>

<script setup lang="ts">
import { UPhoneNoBox, UValidationGroup } from '#ustra/nuxt-vuetify/components'
import { UButton, UPhoneNoBox as UPhoneNoBox2 } from '#ustra/nuxt-wijmo/components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

const value = ref('')
const value2 = ref('')
const value3 = ref('')
const value4 = ref('')
</script>
```
