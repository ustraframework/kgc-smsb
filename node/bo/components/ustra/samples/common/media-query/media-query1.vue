<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />
      <UMarkdownViewer>
        {{ mediaQueryState }}
      </UMarkdownViewer>
      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { computed } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { useMediaQueryState } from '#ustra/nuxt/composables'

// @ts-ignore
import doc1 from './md/media-query1.md'

// @ts-ignore
import doc2 from './md/media-query2.md'

const mediaQueryState = computed(() => {
  return '```json \n' + JSON.stringify(useMediaQueryState(), null, 2) + '\n```'
})
</script>
