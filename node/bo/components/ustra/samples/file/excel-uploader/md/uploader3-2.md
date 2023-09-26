위의 예제를 보면 excelDataPostProcessorBeanName 속성을 excelSamplePostProcessor 으로 설정하고 있으며, excelSamplePostProcessor로 등록된 Bean에서는 비동기적으로 로직을 처리하고 데이터는 비포함된 결과 값을 return 한다.
return 된 결과 값은 upload 메소드에서 수신할 수 있다.

```html
<template>
  <UExcelFileUploader
    ref="uploader"
    fileGroupId="menuIcon"
    v-model:fileId="fileId"
    modelClassName="com.gsitm.ustra.java.demo.management.bo.sample.excel.ExcelSampleUploadModel"
    excelDataPostProcessorBeanName="excelSamplePostProcessor"
    @selected="() => uploadExcelFile()"
    :headerRowIndex="1"
  />

  <ULink message="Download Sample Excel File" href="/ustra-sample-resources/excel/sample.xlsx" />
</template>
<script lang="ts" setup>
const fileId = ref<string>(null)
const uploader = shallowRef<InstanceType<typeof UExcelFileUploader>>()

async function uploadExcelFile() {
  useOnError(async () => {
    const result: any = (await uploader.value.upload()).convertData
    alert(JSON.stringify(result))
  })()
}
</script>
```
