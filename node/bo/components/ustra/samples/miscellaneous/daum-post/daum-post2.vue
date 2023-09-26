<template>
  <VCard>
    <template #text>
      <h3>Customization</h3>
      <UMarkdownViewer :content="daumPost2_1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import daumPost2_1 from './md/daum-post2-1.md'
</script>
