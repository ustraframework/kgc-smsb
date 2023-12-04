```html
<template>
  <UButton text="일반 alert 창 오픈" @click="() => showAlert()" />  
</template>
<script lang="ts" setup>
function showAlert() {
  useAlert('성공적으로 완료됨.', '완료되었습니다.', '완료안내')
}
</script>
```
