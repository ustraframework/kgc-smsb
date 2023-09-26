<template>
  <v-card>
    <template #title> 버튼 길이 조정</template>
    <template #subtitle> width 값으로 조정. </template>
    <template #text>
      <UBox>
        <UItem>
          <UButton text="text" type="primary" width="100" />
          <UButton text="text" type="primary" width="200" />
          <UButton text="text" type="primary" width="300" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base6 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base6 from './md/base6.md'
</script>
