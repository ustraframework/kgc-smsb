<template>
  <v-card>
    <template #text>
      <h3>상태 값 제한</h3>

      <UMarkdownViewer :content="doc1"></UMarkdownViewer>
      <br />
      <UUserInputBox v-model="user" usrSttCd="01" />
      <UMarkdownViewer :content="doc2"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UUserInputBox } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/user-popup4-1.md'

// @ts-ignore
import doc2 from './md/user-popup4-2.md'

const user = ref(null)
</script>
