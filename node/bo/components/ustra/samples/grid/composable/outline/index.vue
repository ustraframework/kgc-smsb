<template>
  <VCard title="개요">
    <template #text>
      <UMarkdownViewer :content="outline1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import outline1 from './md/outline1.md'
</script>
