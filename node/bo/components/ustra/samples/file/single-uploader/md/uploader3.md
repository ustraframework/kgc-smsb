```html
<template>
  fileId :
  <UWjInputMask v-model="fileId" style="width: 400px" />
  <UImageUploader ref="uploader" fileGroupId="menuIcon" v-model:fileId="fileId" :readonly="true" />
</template>
<script lang="ts" setup>
const fileId = ref('xYjN4kTOwUDMzMDO1MEOlRXZXRERnVka1FmWzhjZPFXZpNF')

const uploader = ref<InstanceType<typeof USingleFileUploader>>(null)
</script>
```
