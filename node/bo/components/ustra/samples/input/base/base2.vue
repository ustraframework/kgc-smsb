<template>
  <v-card>
    <template #title> 버튼 - 기본속성</template>
    <template #subtitle> type 속성 (primary, gray)</template>
    <template #text>
      <UBox>
        <UItem>
          <UButton text="text" />
          <UButton text="text" type="primary" />
          <UButton text="text" type="gray" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base2 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
// @ts-ignore
import base2 from './md/base2.md'
</script>
