<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />
      <img src="http://something.com/img/anything.jpg" v-image style="width: 300px" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/image2.md'
</script>
