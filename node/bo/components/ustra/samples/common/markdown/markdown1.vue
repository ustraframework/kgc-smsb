<template>
  <v-card>
    <template #title> 마크다운 컴포넌트 </template>
    <template #subtitle>
      UMarkdownViewer 컴포넌트는 마크다운 컨텐츠를 HTML 형태로 변경하여 노출하는 기능을 제공하며, global 컴포넌트이므로 UMarkdownViewer 태그를
      사용하면 컴포넌트를 사용할 수 있다.
    </template>
    <template #text> <UMarkdownViewer :content="markdown1"></UMarkdownViewer></template>
  </v-card>
</template>
<script lang="ts" setup>
import markdown1 from './md/markdown1.md'
import { UMarkdownViewer } from '#ustra/nuxt/components'
</script>
