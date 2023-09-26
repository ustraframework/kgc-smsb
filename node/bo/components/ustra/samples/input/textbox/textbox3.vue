<template>
  <v-card>
    <template #text>
      <h3>Mask 타입</h3>
      <br /><br />

      <UTextBox type="mask" v-model="test1" />
      <UTextBox type="mask" mask="lll-lll-lll-lll" v-model="test2" />
      <UMarkdownViewer>{{ textBox3 }}</UMarkdownViewer></template
    >
  </v-card>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import textBox3 from './md/textbox3.md'

const test1 = ref('123456789123456789')
const test2 = ref('abcdefghijklmnopqrstuvwxyz')
</script>

<style scoped></style>
