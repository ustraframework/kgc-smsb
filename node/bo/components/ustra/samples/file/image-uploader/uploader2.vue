<template>
  <VCard>
    <template #text>
      <h3>수정 모드</h3>
      <br />
      수정 모드는 기존에 파일을 업로드 했던 고유 파일 아이디를 설정할 경우 기존 파일 정보를 조회한 후 수정할 수 있다. <br /><br />
      fileId :
      <UWjInputMask v-model="fileId" style="width: 400px" />
      <UImageUploader ref="uploader" fileGroupId="ustra-sample-image" :width="500" :height="500" v-model:fileId="fileId" />
      <UButton class="mt-2" text="Upload" @click="() => uploadFile()" />
      <UButton class="mt-2" text="Form Data" @click="() => createFormData()" />

      <UMarkdownViewer :content="upload2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UImageUploader } from '#ustra/nuxt-wijmo/management/components'
import { UButton, UMarkdownViewer, UWjInputMask } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import upload2 from './md/uploader2.md'

const fileId = ref('xYjN4kzM3MjN5ATM1IGZmVlVWdWONlGVRZWTsFTUCNnWmRG')

const uploader = ref<InstanceType<typeof UImageUploader>>(null)
async function uploadFile() {
  const result = await uploader.value.upload()

  $ustra.logger.info('file upload result', result)
  alert('업로드가 완료되었습니다. file id : ' + result.fileId)
}

function createFormData() {
  $ustra.logger.info('file upload result', Array.from(uploader.value.createFormData().entries()))
}
</script>
