```html
<template>
  <div class="mt-2 mb-5">
    <UCodeRadioGroupBox v-model="radioValue" v-model:objectValue="radioObjectValue" grpCd="SYS_CD" />
  </div>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    radioValue : {{ radioValue }}
  </v-chip>
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    radioObjectValue : {{ radioObjectValue }}
  </v-chip>
</template>
<script lang="ts" setup>
const radioValue = ref(null)
const radioObjectValue = ref(null)
</script>
```
