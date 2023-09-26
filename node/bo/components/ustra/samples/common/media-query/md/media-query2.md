```html
<template>
  <UMarkdownViewer>
    {{ mediaQueryState }}
  </UMarkdownViewer>
</template>
<script lang="ts" setup>
const mediaQueryState = computed(() => {
  return '```json \n' + JSON.stringify(useMediaQueryState(), null, 2) + '\n```'
})
</script>

```
