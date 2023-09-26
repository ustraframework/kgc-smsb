```html
<template>
  <UUserInputBox v-model="user" v-model:objectValue="objectValue" />

  <br />
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    user : {{ user }}
  </v-chip>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    objectValue : {{ objectValue }}
  </v-chip>

  <br />
  <UButton text="user = 'admin'" @click="() => (user = 'admin')" />
  <UButton text="user = {code:'admin', name:'관리자'}" @click="() => (user = { code: 'admin', name: '관리자' })" />
  <UButton text="user = null" @click="() => (user = null)" />
</template>
<script lang="ts" setup>
const user = ref(null)
const objectValue = ref(null)
</script>
```
