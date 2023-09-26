```html
<template>
  <UValidationGroup ref="validationGroup">
    <UDatePeriodBox v-model:start="start" v-model:end="end" mode="date" valueFormat="Date" :isRequired="true" />
  </UValidationGroup>

  <UButton text="Validate" @click="() => validationGroup.validate()" class="mt-2" />
  <UButton text="Init" @click="() => validationGroup.init()" class="mt-2" />
</template>
<script lang="ts" setup>
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
const start = ref(new Date())
const end = ref(new Date())
</script>
```
