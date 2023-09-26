<template>
  <v-card>
    <template #title> Width </template>
    <template #subtitle> </template>
    <template #text>
      <UPhoneNoBox v-model="test3" width="150" />
      <UPhoneNoBox v-model="test3" width="300" />
      <UMarkdownViewer>{{ phoneNo3 }}</UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import phoneNo3 from './md/phone-no3.md'
const test3 = ref('')
</script>

<style scoped></style>
