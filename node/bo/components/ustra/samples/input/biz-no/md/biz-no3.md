```html
<template>
  <UCorpNoBox v-model="value" />
  <br />
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    radioValue : {{ value }}
  </v-chip>
</template>
<script lang="ts" setup>
const value = ref(null)
</script>
```
