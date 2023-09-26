```html
<template>
  <UButton text="팝업오픈" @click="() => (showPopup = true)" />
  <UUserPopup v-model="showPopup" @selected="data => (selectedItem = data)" />

  <br />
  <v-chip class="ma-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
    <v-icon start icon="mdi-label"></v-icon>
    selectedItem : {{ selectedItem }}
  </v-chip>
</template>
<script lang="ts" setup>
const showPopup = ref(false)
const selectedItem = ref(null)
</script>
```
