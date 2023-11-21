<template>
  <VCard>
    <template #text>
      <h3>Excel 업로드</h3>
      <UMarkdownViewer :content="doc1" />
      <ULink message="Download Excel Sample File" href="/samples/excel-upload.xlsx"></ULink> <br /><br />
      <UExcelFileUploader ref="fileUploader" v-model:fileId="fileId" fileGroupId="ustra-sample-excel" />
      <UButton text="Upload" @click="() => upload()" class="mt-2" />

      <WjFlexGrid v-show="uploaded" style="max-height: 300px" :initialized="grid.initialize" class="mt-2" />
      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UExcelFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { WjFlexGrid } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/file3-1.md'

// @ts-ignore
import doc2 from './md/file3-2.md'

const fileUploader = ref<InstanceType<typeof UExcelFileUploader>>()
const grid = useWijmoFlexGrid()

const fileId = ref(null)
const uploaded = ref(false)

async function upload() {
  const result: any[] = (await fileUploader.value.upload()).convertData
  uploaded.value = true
  grid.rawControl.itemsSource = result.map(row => row.object)
}
</script>
