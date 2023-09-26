UCkEditor 컴포넌트는 이미지 업로드를 위해 다음과 같은 추가 속성을 제공한다.
| 명칭 | 유형 | 설명 | 기본 값 |
| --- | --- | --- | --- |
| useImageUpload | boolean | 이미지 업로드 사용 여부 | false |
| fileGroupId | string | 파일 그룹 아이디 |  |
| fileId | string | 파일 아이디 (v-model) |  |
| uploadApiUrl | string | 업로드 API URL | '/api/file/upload' |


useImageUpload 속성을 true로 설정하고, 파일 업로드 컴포넌트와 동일하게 fileGroupId 값을 설정해야 하며, 에디터에 업로드 되는 파일은 저장소에 별도 관리되므로 입력 값 저장 시 파일 아이디도 함께 저장해야 한다.

이미지 업로드가 완료된 후에는 useUstraCkEditor5 메소드에서 반환되는 completeUpload 메소드를 호출해야 한다. completeUpload 메소드는 업로드 된 파일 중 삭제된 파일을 제거하고 업로드 파일 목록을 갱신하는 역할을 수행하며, Undo/Redo 등의 히스토리를 초기화하여 업로드를 완료 처리할 수 있는 기능을 제공한다.

completeUpload 메소드를 호출하지 않을 경우, 사용되지 않는 리소스가 스토리지에 남아 있게 되므로 파일 저장소 내에 불필요 리소스가 존재하지 않도록 처리하기 위해서는 가급적 호출하도록 한다.

```html
<template>

  <div class="mb-2">
    <UButton text="completeUpload" @click="() => completeUpload()" />
  </div>
  <UCkEditor5
    v-model="content"
    v-model:fileId="fileId"
    :height="800"
    :disabled="disabled"
    :initialized="ckEditor.initialize"
    fileGroupId="ustra-sample-image"
    :useImageUpload="true"
  />
</template>
<script lang="ts" setup>
const content = ref('')
const disabled = ref(false)
const ckEditor = useUstraCkEditor5()
const fileId = ref(null)

async function completeUpload() {
  await ckEditor.completeUpload()
  alert('저장이 완료되었습니다.')
}
</script>
```
