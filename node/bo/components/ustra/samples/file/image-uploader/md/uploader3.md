```html
<template>
  fileId :
  <UWjInputMask v-model="fileId" style="width: 400px" />
  <UImageUploader ref="uploader" fileGroupId="menuIcon" v-model:fileId="fileId" :readonly="true" :width="500" :height="500" />
</template>
<script lang="ts" setup>
const fileId = ref('xYjN4kzM3MjN5ATM1IGZmVlVWdWONlGVRZWTsFTUCNnWmRG')

const uploader = ref<InstanceType<typeof UImageUploader>>(null)
</script>
```
