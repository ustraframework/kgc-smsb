```html
<template>
  <VTextField v-focus="focusedState.first" />
  <VTextField v-focus="focusedState.second" />
  <br />
  <VBtn variant="outlined" class="mr-2" @click="() => (focusedState.first.value = true)">focus to 0</VBtn>
  <VBtn variant="outlined" @click="() => (focusedState.second.value = true)">focus to 1</VBtn>
</template>
<script lang="ts" setup>
const focusedState = {
  first: ref<boolean>(false),
  second: ref<boolean>(false),
}
</script>
```
