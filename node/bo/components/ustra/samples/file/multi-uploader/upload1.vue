<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="upload0" />
      (각 예제의 결과 값은 Console 창에서 확인할 수 있다.)

      <UMultiFileUploader ref="uploader" fileGroupId="ustra-sample" v-model:fileId="fileId" />
      <UButton class="mt-2" text="Upload" @click="() => uploadFile()" />
      <UButton class="mt-2" text="Form Data" @click="() => createFormData()" />

      <UMarkdownViewer :content="upload1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMultiFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import upload0 from './md/upload0.md'

// @ts-ignore
import upload1 from './md/upload1.md'

const fileId = ref(null)

const uploader = ref<InstanceType<typeof UMultiFileUploader>>(null)
async function uploadFile() {
  const result = await uploader.value.upload()

  $ustra.logger.info('file upload result', result)
  alert('업로드가 완료되었습니다. file id : ' + result.fileId)
}

function createFormData() {
  $ustra.logger.info('file upload result', Array.from(uploader.value.createFormData().entries()))
}
</script>
