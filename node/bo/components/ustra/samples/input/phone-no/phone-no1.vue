<template>
  <v-card>
    <template #title> Input - 전화번호 </template>
    <template #subtitle> 전화번호 컴포넌트 설명 </template>
    <template #text>
      <UPhoneNoBox v-model="test1" />
      <UMarkdownViewer>
        {{ phoneNo1 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import phoneNo1 from './md/phone-no1.md'
const test1 = ref('')
</script>

<style scoped></style>
