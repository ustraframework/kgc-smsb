컴포넌트에서는 다음과 같은 메소드를 제공한다.
| name | 유형 | 설명 |
| --- | --- | --- |
| upload | () => FileOutput | 선택된 파일을 업로드하고 결과를 조회한다. |
| createFormData | () => FormData | 업로드 시 전송할 FormData를 조회한다. 한번의 API 호출로 업로드 및 데이터 저장을 처리하기 원할 경우 사용할 수 있다. |
| setFile | (file:File) => void | 업로드 컴포넌트에 파일 객체를 설정한다. 다른 컴포넌트에서 조회된 파일 정보를 로드하거나 데이터에 File 객체를 저장할 경우, 수동으로 로드하여 사용할 수 있는 기능이다. |
| load | () => void | autoLoadFileInfo 속성이 false일 경우, 수동으로 호출하여 서버 상에 저장된 이미지 정보를 로드한다. 업로드 컴포넌트가 다량으로 표시되어 API 호출이 잦을 경우, 부하를 분산하는 용도로 사용할 수 있다. |


```html
<template>
  <div class="ma-5">
    <UImageUploader ref="uploader" fileGroupId="menuIcon" :width="500" :height="500" v-model:fileId="fileId" />
  </div>
  <UButton class="mt-2" text="Upload" @click="() => uploadFile()" />
  <UButton class="mt-2" text="Form Data" @click="() => createFormData()" />
</template>
<script lang="ts" setup>
const fileId = ref(null)
const uploader = ref<InstanceType<typeof UImageUploader>>(null)
async function uploadFile() {
  const result = await uploader.value.upload()

  $ustra.logger.info('file upload result', result)
  alert('업로드가 완료되었습니다. file id : ' + result.fileId)
}

function createFormData() {
  $ustra.logger.info('file upload result', Array.from(uploader.value.createFormData().entries()))
}
</script>
```
