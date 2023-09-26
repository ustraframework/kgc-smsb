```html
<template>
  <USingleFileUploader
    ref="uploader"
    fileGroupId="ustra-sample"
    v-model:fileId="fileId"
    :messages="{
      'ustra.file.errorOnDownloadFile': '파일을 다운로드할 수 없습니다. 파일이 존재하는지 확인해주세요.',
    }"
  />
  <UButton class="mt-2" text="Upload" @click="() => uploadFile()" />
</template>
<script lang="ts" setup>
const fileId = ref(null)
const uploader = ref<InstanceType<typeof USingleFileUploader>>(null)

async function uploadFile() {
  const result = await uploader.value.upload()

  $ustra.logger.info('file upload result', result)
  alert('업로드가 완료되었습니다. file id : ' + result.fileId)
}
</script>
```
