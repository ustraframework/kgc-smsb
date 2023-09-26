```html
<template>
  <VTextField ref="textField" />
  <br />
  <VBtn variant="outlined" class="mr-2" @click="() => $ustra.utils.dom.focus(textField.$el)">focus</VBtn>
</template>
<script lang="ts" setup>
const textField = ref()
</script>
```
