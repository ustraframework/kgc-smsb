```html
<template>
  <UValidationGroup ref="validationGroup" :wrapContainer="false">
    <VTextField :validation="{ rules: ['required'] }" />
    <VTextField :validation="{ rules: ['required'] }" />
  </UValidationGroup>
  <UButton text="Validate" @click="() => validationGroup.validate()"></UButton>
</template>
<script lang="ts" setup>
import { UValidationGroup } from '#ustra/nuxt-vuetify/components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>

```
