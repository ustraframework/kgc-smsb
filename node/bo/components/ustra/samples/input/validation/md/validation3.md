```html
<template>
  <UValidationGroup ref="validationGroup1">
    <WjInputMask v-model="value1" :isRequired="true" />

    <UValidationGroup ref="validationGroup2" class="mt-2">
      <WjInputMask v-model="value2" :isRequired="true" />
    </UValidationGroup>
  </UValidationGroup>

  <div class="mt-2">
    <UButton text="Validate1" @click="validation1" />
    <UButton text="Validate2" @click="validation2" />

    <UButton text="Validate All" @click="validationAll" />
    <UButton text="Init All" @click="initAll" />
  </div>
</template>
<script lang="ts" setup>
import { UValidationGroup, WjInputMask } from '#ustra/nuxt-wijmo/components'

const value1 = ref(null)
const value2 = ref(null)

const validationGroup1 = ref<InstanceType<typeof UValidationGroup>>()
const validationGroup2 = ref<InstanceType<typeof UValidationGroup>>()

function validation1() {
  validationGroup1.value.validate()
}

function validation2() {
  validationGroup2.value.validate()
}

function validationAll() {
  validationGroup1.value.validate(true)
}

async function initAll() {
  await validationGroup1.value.init(true)
}
</script>
```
