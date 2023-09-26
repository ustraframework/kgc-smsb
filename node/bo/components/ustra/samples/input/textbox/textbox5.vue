<template>
  <v-card>
    <template #text>
      <h3>속성</h3>
      <br /><br />

      <UHelpBox>readonly</UHelpBox>
      <UTextBox v-model="test" readonly></UTextBox>
      <UTextBox type="mask" v-model="test" readonly />
      <UTextBox type="textarea" v-model="test" readonly />
      <UHelpBox>disabled</UHelpBox>
      <UTextBox v-model="test" disabled></UTextBox>
      <UTextBox type="mask" v-model="test" disabled />
      <UTextBox type="textarea" v-model="test" disabled />
      <UHelpBox>placeholder</UHelpBox>
      <UTextBox placeholder="입력하세요"></UTextBox>
      <UTextBox type="mask" placeholder="입력하세요" />
      <UTextBox type="textarea" placeholder="입력하세요" />
      <UMarkdownViewer>{{ textBox5 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import textBox5 from './md/textbox5.md'

const test = ref('123456789123456789')
</script>

<style scoped></style>
