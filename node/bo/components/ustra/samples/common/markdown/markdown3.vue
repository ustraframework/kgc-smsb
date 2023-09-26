<template>
  <v-card>
    <template #subtitle> 만약 custom markdown loader 등을 사용하여 html 형태의 문자열을 사용할 때는 html 속성을 설정한다. </template>
    <template #text> <UMarkdownViewer :content="markdown3"></UMarkdownViewer></template>
  </v-card>
</template>
<script lang="ts" setup>
import markdown3 from './md/markdown3.md'
import { UMarkdownViewer } from '#ustra/nuxt/components'
</script>
