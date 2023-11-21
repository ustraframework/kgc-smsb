<template>
  <VCard>
    <template #text>
      <h3>복호화 된 파일 다운로드</h3>
      <UMarkdownViewer :content="doc1" />

      <USingleFileUploader ref="fileUploader" v-model:fileId="fileId" fileGroupId="ustra-sample-excel" />
      <UButton text="Upload" @click="() => fileUploader.upload()" class="mt-2" />

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { USingleFileUploader } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import doc1 from './md/file2-1.md'

// @ts-ignore
import doc2 from './md/file2-2.md'

const fileUploader = ref<InstanceType<typeof USingleFileUploader>>()

const fileId = ref(null)
</script>
