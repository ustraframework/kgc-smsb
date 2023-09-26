<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="uploader1_1" />
      <UExcelFileUploader ref="uploader" fileGroupId="ustra-sample" v-model:fileId="fileId" @selected="() => uploadExcelFile()" :headerRowIndex="1" />

      <ULink message="Download Sample Excel File" href="/ustra-sample-resources/excel/sample.xlsx" />
      <WjFlexGrid :initialized="grid.initialize" style="height: 300px" class="mt-2"> </WjFlexGrid>
      <UMarkdownViewer :content="uploader1_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref, shallowRef } from '#ustra/nuxt'

import { UMarkdownViewer, ULink, WjFlexGrid } from '#ustra/nuxt-wijmo/components'
import { UExcelFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { useOnError } from '#ustra/nuxt/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import uploader1_1 from './md/uploader1-1.md'

// @ts-ignore
import uploader1_2 from './md/uploader1-2.md'

const fileId = ref<string>(null)
const uploader = shallowRef<InstanceType<typeof UExcelFileUploader>>()
const grid = useWijmoFlexGrid()

async function uploadExcelFile() {
  useOnError(async () => {
    const result: any[] = (await uploader.value.upload()).convertData

    grid.rawControl.itemsSource = result.map(row => row.object)
  })()
}
</script>
