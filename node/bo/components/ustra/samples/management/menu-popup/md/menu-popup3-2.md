```html
<template>
  <UMenuInputBox v-model="menu" v-model:objectValue="objectValue" :canSelectSysCd="false" />

  <br />
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    menu : {{ menu }}
  </v-chip>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    objectValue : {{ objectValue }}
  </v-chip>

  <br />
  <UButton text="menu = '3'" @click="() => (menu = '3')" />
  <UButton text="menu = null" @click="() => (menu = null)" />
</template>
<script lang="ts" setup>
import { UMenuInputBox } from '#ustra/nuxt-wijmo/management/components'

const menu = ref(null)
const objectValue = ref(null)
</script>
```
