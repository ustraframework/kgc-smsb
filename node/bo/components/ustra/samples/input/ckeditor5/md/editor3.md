```html
<template>
  <UCkEditor5 v-model="content" :height="200" :useSourceEditing="true" />
  <v-chip class="ma-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
    <v-icon start icon="mdi-label"></v-icon>
    content :
    <pre>{{ content }}</pre>
  </v-chip>
</template>
<script lang="ts" setup>
const content = ref('')
</script>

```
