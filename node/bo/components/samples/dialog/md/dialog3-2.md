```html
<template>
  <UButton text="confirm 창 오픈" @click="() => showConfirm()" />
</template>
<script lang="ts" setup>
async function showConfirm() {
  const result = await useConfirm('삭제된 데이터는 복구가 불가능합니다.', '데이터를 삭제하시겠습니까?', '삭제안내', '삭제')
  useErrorAlert('결과 값 : ' + result)
}
</script>
```
