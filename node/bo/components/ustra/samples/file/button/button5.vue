<template>
  <VCard>
    <template #text>
      accept 속성을 사용하여 선택 가능한 파일의 유형을 제어할 수 있다. (<a
        href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/accept"
        target="_blank"
        >https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/accept</a
      >) <br /><br />
      <VRow align="center">
        <VCol cols="auto">ExcelFile :</VCol>
        <VCol cols="auto"><UFileButton accept=".xls,.xlsx"></UFileButton></VCol>
      </VRow>

      <VRow align="center">
        <VCol cols="auto">Image :</VCol>
        <VCol cols="auto"><UFileButton accept="image/*"></UFileButton></VCol>
      </VRow>

      <UMarkdownViewer :content="button5" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UFileButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import button5 from './md/button5.md'
</script>
