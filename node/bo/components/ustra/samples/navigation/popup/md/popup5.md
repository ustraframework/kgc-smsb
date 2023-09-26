```html
<template>
  <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>

  <UPopup v-model="showPopup" :width="800" :height="600" title="팝업제목" @shown="() => notifyShow()" @hidden="() => notifyHidden()">
    <div>내용</div>
  </UPopup>
</template>

<script lang="ts" setup>
const showPopup = ref(false)

function notifyShow() {
  alert('팝업 shown')
}

function notifyHidden() {
  alert('팝업 hidden')
}
</script>
```
