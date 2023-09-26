<template>
  <v-card>
    <template #title> 기본사용법 </template>
    <template #subtitle> </template>
    <template #text>
      <UPhoneNoBox v-model="test2" />

      {{ test2 }}<br />
      <v-btn depressed @click="setTest2('010-1234-1234')"> 010-1234-1234 </v-btn>
      <v-btn depressed @click="setTest2(null)"> null </v-btn>
      <UMarkdownViewer>{{ phoneNo2 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import phoneNo2 from './md/phone-no2.md'

const test2 = ref('')
const setTest2 = value => {
  test2.value = value
}
</script>

<style scoped></style>
