```html
<template>
  <div>
    <UPhoneNoBox v-model="test2" />
    {{ test2 }}<br />
    <v-btn depressed @click="setTest2('010-1234-1234')"> 010-1234-1234 </v-btn>
    <v-btn depressed @click="setTest2(null)"> null </v-btn>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
const test2 = ref('')
const setTest2 = value => {
  test2.value = value
}
</script>
```
