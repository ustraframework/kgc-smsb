```html
<template>
  <UFileButton @change="onChangeFiles" multiple></UFileButton>

  <br />
  <v-chip class="mt-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    selectedFiles : {{ selectedFiles.map(file => file.name) }}
  </v-chip>
</template>
<script lang="ts" setup>
const selectedFiles = shallowRef<File[]>([])

function onChangeFiles(e) {
  selectedFiles.value = []
  for (let i = 0; i < e.srcElement.files.length; i++) {
    selectedFiles.value.push(e.srcElement.files[i])
  }
}
</script>
```
