<template>
  <v-card>
    <template #title> Disabled </template>
    <template #subtitle> </template>
    <template #text>
      <UPhoneNoBox v-model="test4" />
      <UPhoneNoBox v-model="test4" disabled />
      <UMarkdownViewer>{{ phoneNo4 }}</UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import phoneNo4 from './md/phone-no4.md'

const test4 = ref('')
</script>

<style scoped></style>
