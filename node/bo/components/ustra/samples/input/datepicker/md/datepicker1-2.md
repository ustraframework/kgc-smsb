```html
<template>
  <UMarkdownViewer :content="doc1" />
  <UDatepicker v-model="value" />
</template>
<script lang="ts" setup>
const value = ref(null)
</script>
```
