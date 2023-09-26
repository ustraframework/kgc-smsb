```html
<template>
  <UFileButton @change="e => (selectedFiles = e.srcElement.files)"> <UButton text="파일 선택" icon="mdi-file-find-outline" /> </UFileButton>

  <br />
  <v-chip class="mt-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    selectedFiles : {{ selectedFiles.length > 0 ? selectedFiles[0].name : '' }}
  </v-chip>
</template>
<script lang="ts" setup>
const selectedFiles = shallowRef<File[]>([])
</script>
```
