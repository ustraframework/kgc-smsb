<template>
  <VCard>
    <template #text>
      <h3>Excel 다운로드</h3>
      <UMarkdownViewer :content="doc1" />
      <UButton text="Download Excel" @click="() => download()" class="mt-2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UExcelFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { WjFlexGrid } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/file4-1.md'

// @ts-ignore
import doc2 from './md/file3-2.md'

async function download() {
  $ustra.api.downloadFile({
    fileName: 'sample.xlsx',
    url: '/api/sample/excel/download',
    method: 'POST',
  })
}
</script>
