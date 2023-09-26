```html
<template>
  <UValidationGroup ref="validationGroup" cssClassName="custom-validation-group">
    <VTextField :validation="{ rules: ['required'] }" />
    <VTextField :validation="{ rules: ['required'] }" />
  </UValidationGroup>
  <UButton text="Validate" @click="() => validationGroup.validate()"></UButton>
</template>
<script lang="ts" setup>
import { UValidationGroup } from '#ustra/nuxt-vuetify/components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
<style>
.custom-validation-group .ustra-invalidate,
.custom-validation-group.ustra-invalidate {
  border: 1px dotted blue;
}
</style>
```
