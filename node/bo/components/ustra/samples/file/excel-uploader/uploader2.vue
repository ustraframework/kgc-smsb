<template>
  <VCard>
    <template #text>
      <h3>Model 매핑 업로드</h3>
      <UMarkdownViewer :content="uploader2_1" />
      <UExcelFileUploader
        ref="uploader"
        fileGroupId="ustra-sample"
        v-model:fileId="fileId"
        modelClassName="com.gsitm.ustra.java.management.samples.excel.UstraExcelSampleUploadModel"
        @selected="() => uploadExcelFile()"
        :headerRowIndex="1"
      />

      <ULink message="Download Sample Excel File" href="/ustra-sample-resources/excel/sample.xlsx" />
      <WjFlexGrid :initialized="grid.initialize" style="height: 300px" class="mt-2" v-show="showGrid">
        <WjFlexGridColumn header="메뉴아이디" binding="mnuId" />
        <WjFlexGridColumn header="상위메뉴아이디" binding="uprMnuId" />
        <WjFlexGridColumn header="시스템" binding="sysCd" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
        <WjFlexGridColumn header="메뉴명" binding="mnuNm" />
      </WjFlexGrid>

      <WjTabPanel class="mt-4">
        <WjTab>
          <a>uploader2.vue</a>
          <UMarkdownViewer :content="uploader2_2" />
        </WjTab>
        <WjTab>
          <a>UstraExcelSampleUploadModel.java</a>
          <MonacoEditor v-model="sourceCode1" lang="java" :options="{ theme: 'vs-dark' }" style="height: 300px" />
        </WjTab>
      </WjTabPanel>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { useFetch } from '#app'
import { ref, shallowRef } from '#ustra/nuxt'
import { UMarkdownViewer, ULink, WjFlexGrid, WjFlexGridColumn, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { UExcelFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { useOnError } from '#ustra/nuxt/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { useUstraCodeValue } from '#ustra/nuxt/management'

// @ts-ignore
import uploader2_1 from './md/uploader2-1.md'

// @ts-ignore
import uploader2_2 from './md/uploader2-2.md'

const fileId = ref<string>(null)
const uploader = shallowRef<InstanceType<typeof UExcelFileUploader>>()
const grid = useWijmoFlexGrid()
const showGrid = ref(false)

async function uploadExcelFile() {
  useOnError(async () => {
    const result: any[] = (await uploader.value.upload()).convertData

    grid.rawControl.itemsSource = result.map(row => row.object)
    showGrid.value = true
  })()
}

const sourceCode1 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelSampleUploadModel.java')
</script>
