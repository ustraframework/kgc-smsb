<template>
  <v-card>
    <template #title> 버튼 - 작은버튼</template>
    <template #subtitle> small 속성 활용 </template>
    <template #text>
      <UBox>
        <UItem>
          <UButton text="text" small />
          <UButton text="text" type="primary" small />
          <UButton text="text" type="gray" small />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base5 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base5 from './md/base5.md'
</script>
