```html
<template>
  <UButton text="오류 alert 창 오픈" @click="() => showErrorAlert()" />
</template>
<script lang="ts" setup>
function showErrorAlert() {
  useErrorAlert('정보를 정확하게 입력해주세요.')
}
</script>
```
