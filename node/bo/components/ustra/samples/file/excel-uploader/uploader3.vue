<template>
  <VCard>
    <template #text>
      <h3>후 처리 로직 수행</h3>
      <UMarkdownViewer :content="uploader3_1" />
      <UExcelFileUploader
        ref="uploader"
        fileGroupId="ustra-sample"
        v-model:fileId="fileId"
        modelClassName="com.gsitm.ustra.java.demo.management.bo.sample.excel.UstraExcelSampleUploadModel"
        excelDataPostProcessorBeanName="ustraExcelSamplePostProcessor"
        @selected="() => uploadExcelFile()"
        :headerRowIndex="1"
      />

      <ULink message="Download Sample Excel File" href="/ustra-sample-resources/excel/sample.xlsx" />

      <WjTabPanel class="mt-4">
        <WjTab>
          <a>uploader3.vue</a>
          <UMarkdownViewer :content="uploader3_2" />
        </WjTab>
        <WjTab>
          <a>UstraExcelSampleUploadModel.java</a>
          <MonacoEditor v-model="sourceCode1" lang="java" :options="{ theme: 'vs-dark' }" style="height: 300px" />
        </WjTab>
        <WjTab>
          <a>UstraExcelSamplePostProcessor.java</a>
          <MonacoEditor v-model="sourceCode2" lang="java" :options="{ theme: 'vs-dark' }" style="height: 300px" />
        </WjTab>
      </WjTabPanel>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { useFetch } from '#app'
import { ref, shallowRef } from '#ustra/nuxt'
import { UMarkdownViewer, ULink, WjFlexGrid, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { UExcelFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { useOnError } from '#ustra/nuxt/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import uploader3_1 from './md/uploader3-1.md'

// @ts-ignore
import uploader3_2 from './md/uploader3-2.md'

const fileId = ref<string>(null)
const uploader = shallowRef<InstanceType<typeof UExcelFileUploader>>()

async function uploadExcelFile() {
  useOnError(async () => {
    const result: any = (await uploader.value.upload()).convertData
    alert(JSON.stringify(result))
  })()
}

const sourceCode1 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelSampleUploadModel.java')
const sourceCode2 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelSamplePostProcessor.java')
</script>
