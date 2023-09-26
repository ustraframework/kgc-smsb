```html
<template>
  <UValidationGroup ref="validationGroup">
    <div class="mb-2">사업자 번호</div>
    <UBizNoBox v-model="value" :required="true" />
    <br />
    <div class="mb-2">법인 번호</div>
    <UCorpNoBox v-model="value2" :required="true" />
  </UValidationGroup>
  <br />
  <UButton text="Validate" @click="() => validationGroup.validate()" />
</template>
<script lang="ts" setup>
import { UBizNoBox, UCorpNoBox } from '#ustra/nuxt-vuetify/components'

const value = ref(null)
const value2 = ref(null)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>

```
