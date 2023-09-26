<template>
  <v-card>
    <template #text>
      <h3>Textarea 타입</h3>
      <br /><br />

      <UHelpBox>기본</UHelpBox>
      <UTextBox type="textarea" v-model="test" />
      <UHelpBox>rows 변경</UHelpBox>
      <UTextBox type="textarea" rows="2"></UTextBox>
      <UHelpBox>PlaceHoder 설정</UHelpBox>
      <UTextBox type="textarea" placeholder="내용을 입력해주세요."></UTextBox>
      <UHelpBox>Resize On/Off 설정</UHelpBox>
      <UTextBox type="textarea" noResize></UTextBox>
      <UHelpBox>부가설명</UHelpBox>
      <UTextBox type="textarea" hint="최대500자 가능"></UTextBox>
      <UHelpBox>MaxLength</UHelpBox>
      <UTextBox type="textarea" counter="100" :maxLength="100"></UTextBox>
      <UMarkdownViewer>{{ textBox4 }}</UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import textBox4 from './md/textbox4.md'

const test = ref('abcdefghijklmnopqrstuvwxyz')
</script>

<style scoped></style>
