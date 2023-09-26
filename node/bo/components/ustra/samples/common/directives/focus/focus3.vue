<template>
  <VCard>
    <template #text> $ustra.utils.dom.focus 메소드를 사용하여 특정 Element의 focus 처리를 할 수 있다.</template>

    <div class="ma-5">
      <VTextField ref="textField" />
      <br />
      <VBtn variant="outlined" class="mr-2" @click="() => $ustra.utils.dom.focus(textField.$el)">focus</VBtn>
    </div>

    <UMarkdownViewer :content="doc1" />
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/focus3.md'

const textField = ref()
</script>
