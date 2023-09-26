<template>
  <v-card>
    <template #text>
      <h3>Icon 타입</h3>
      <br /><br />
      <UTextBox type="icon" @iconClick="logMessage"></UTextBox>
      <UTextBox type="icon" iconType="refresh" @iconClick="logMessage"></UTextBox>
      <UTextBox type="icon" iconType="error"></UTextBox>
      <UMarkdownViewer>{{ textBox2 }}</UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import textBox2 from './md/textbox2.md'

const logMessage = () => {
  console.log('test message')
}
</script>

<style scoped></style>
