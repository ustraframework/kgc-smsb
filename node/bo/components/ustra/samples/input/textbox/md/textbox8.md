```html
<template>
    <UTextBox type="icon">
      <UTextBoxButtonBox align="left">
        <UTextBoxButton icon="mdi-check" @click="set(0)" />
        <UTextBoxButton icon="mdi-undo" mdiIconColor="#f00" @click="set(1)" />
      </UTextBoxButtonBox>

      <UTextBoxButtonBox align="right">
        <UTextBoxButton icon="mdi-check" @click="set(2)" />
        <UTextBoxButton icon="mdi-menu-up" mdiIconColor="red" @click="set(3)" />
        <UTextBoxButton icon="mdi-menu-down" mdiIconColor="blue" @click="set(4)" />
        <UTextBoxButton icon="mdi-menu-down" mdiIconColor="blue" @click="set(5)" />
        <UTextBoxButton icon="mdi-menu-down" mdiIconColor="blue" @click="set(6)" />
        <UTextBoxButton icon="mdi-menu-down" mdiIconColor="blue" @click="set(7)" />
        <UTextBoxButton icon="mdi-menu-down" mdiIconColor="blue" @click="set(8)" />
      </UTextBoxButtonBox>
    </UTextBox>
  <div>
    <v-chip class="ma-2" color="pink" label text-color="white">
      <v-icon start icon="mdi-label"></v-icon>
      data : {{ data }}
    </v-chip>
  </div>
</template>

<script setup lang="ts">
import { ref } from '#ustra/nuxt'

const data = ref(null)
const set = val => {
  data.value = val
}
</script>
```
