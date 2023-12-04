```html
<template>
  <USingleFileUploader ref="fileUploader" v-model:fileId="fileId" fileGroupId="ustra-sample-excel" />
  <UButton text="Upload" @click="() => fileUploader.upload()" class="mt-2" />
</template>
<script lang="ts" setup>
import { USingleFileUploader } from '#ustra/nuxt-wijmo/management/components'

const fileUploader = ref<InstanceType<typeof USingleFileUploader>>()
const fileId = ref(null)
</script>
```
