<template>
  <v-card>
    <template #text>
      <h3>Icon 타입 - 2개활용</h3>
      iconType2, iconClick2 추가 사용
      <br /><br />

      <UTextBox type="icon" iconType="refresh" @iconClick="logMessage" iconType2="mdi-check" @iconClick2="logMessage"></UTextBox>
      <UTextBox type="icon" iconType="refresh" @iconClick="logMessage" iconType2="find" @iconClick2="logMessage"></UTextBox>
      <UMarkdownViewer>{{ textBox7 }}</UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import textBox7 from './md/textbox7.md'
const logMessage = () => {
  console.log('test message')
}
</script>

<style scoped></style>
