```html
<template>
  <UValidationGroup ref="validationGroup" class="mt-2">
    <UDatepicker v-model="value" :required="true" />
  </UValidationGroup>

  <UButton text="Validate" class="mt-2" @click="() => validationGroup.validate()" />
  <UButton text="Init" class="mt-2" @click="() => validationGroup.init()" />
</template>
<script lang="ts" setup>
const value = ref(null)
const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()
</script>
```
