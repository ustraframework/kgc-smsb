<template>
  <VCard title="1. [프로시져] 모델"></VCard>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />
      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
// @ts-ignore
import doc1 from './md/proc-1.md'
// @ts-ignore
import doc2 from './md/proc-2.md'
</script>
<style>
.iconImage {
  width: 15px;
  height: 15px;
  margin-bottom: -3px;
  margin-right: 2px;
}
</style>
