```html
<template>
  <UButton text="팝업오픈" @click="() => (showPopup = true)" />
  <UMenuPopup v-model="showPopup" :multiple="true" @selected="data => (selectedItem = data)" />

  <br />
  <VChip class="ma-2 pa-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
    <VIcon start icon="mdi-label"></VIcon>
    selectedItem : {{ selectedItem }}
  </VChip>
</template>
<script lang="ts" setup>
const showPopup = ref(false)
const selectedItem = ref(null)
</script>
```
