위의 예제는 selected 이벤트가 발생하면 엑셀 파일을 업로드하고 파일의 데이터를 수신받는 예제이다.
데이터 수신 후, 그리드에 바인딩하도록 처리되어 있다.

```html
<template>
  <UExcelFileUploader ref="uploader" fileGroupId="menuIcon" v-model:fileId="fileId" @selected="() => uploadExcelFile()" :headerRowIndex="1" />

  <ULink message="Download Sample Excel File" href="/ustra-sample-resources/excel/sample.xlsx" />
  <WjFlexGrid :initialized="grid.initialize" style="height: 300px" class="mt-2"> </WjFlexGrid>
</template>
<script lang="ts" setup>
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
```
