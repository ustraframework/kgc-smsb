```html
<template>
  <UFileDropBox v-model="files" class="mt-2" />

  <v-chip class="mt-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    selectedFiles : {{ files.map(f => f.name) }}
  </v-chip>
</template>
<script lang="ts" setup>
const files = ref<File[]>([])
</script>
```
