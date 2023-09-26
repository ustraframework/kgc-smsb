```html
<template>
  <UValidationGroup ref="validationGroup">
    <USingleFileUploader fileGroupId="ustra-sample" v-model:fileId="fileId" :required="true" />
  </UValidationGroup>

  <UMarkdownViewer :content="uploader3" />
  <UButton text="Validate" @click="() => validationGroup.validate()" />
</template>
<script lang="ts" setup>
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
const fileId = ref(null)
</script>

```
