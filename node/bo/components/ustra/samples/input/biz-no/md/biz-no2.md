```html
<template>
  <UValidationGroup ref="validationGroup">
    <UBizNoBox v-model="value" :isRequired="false" />
  </UValidationGroup>
  <br />
  <UButton text="Validate" @click="() => validationGroup.validate()" />
  <br />
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    radioValue : {{ value }}
  </v-chip>
</template>
<script lang="ts" setup>
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'

const value = ref(null)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>

```
