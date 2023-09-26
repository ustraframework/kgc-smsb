```html
<template>
  <UFileButton :disabled="disabledButton"></UFileButton>
  <br />
  <UButton class="mt-2" text="Toggle Button" @click="() => (disabledButton = !disabledButton)" />
</template>
<script lang="ts" setup>
const disabledButton = ref(false)
</script>
```
