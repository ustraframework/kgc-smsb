```html
<template>
  <UExcelFileUploader
    ref="uploader"
    fileGroupId="menuIcon"
    v-model:fileId="fileId"
    modelClassName="com.gsitm.ustra.java.management.samples.excel.ExcelSampleUploadModel"
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
</template>
<script lang="ts" setup>
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
</script>
```
