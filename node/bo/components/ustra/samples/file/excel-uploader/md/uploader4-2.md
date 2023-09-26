```html
<template>
  <UExcelFileUploader
    ref="uploader"
    fileGroupId="menuIcon"
    v-model:fileId="fileId"
    :storeResource="true"
    modelClassName="com.gsitm.ustra.java.demo.management.bo.sample.excel.ExcelSampleUploadModel"
    excelDataPostProcessorBeanName="excelSamplePostProcessor"
    @selected="() => uploadExcelFile()"
    :headerRowIndex="1"
  />
</template>
<script lang="ts" setup>
const fileId = ref<string>(null)
const uploader = shallowRef<InstanceType<typeof UExcelFileUploader>>()

async function uploadExcelFile() {
  useOnError(async () => {
    const result: any = await uploader.value.upload()
    alert(JSON.stringify(result))
  })()
}
</script>
```
