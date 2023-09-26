<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { computed } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { useMediaQueryState } from '#ustra/nuxt/composables'

// @ts-ignore
import doc1 from './md/responsive-setting1.md'
</script>
