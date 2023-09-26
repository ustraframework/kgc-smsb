<template>
  <v-card>
    <template #text>
      <h3>emptyValue</h3>
      emptyValue 속성은 공백을 입력하였을 경우, default로 세팅되는 값을 지정하는 속성이다. 기본 값은 null이다.
      <br /><br />
      <UTextBox v-model="textValue" :emptyValue="null"></UTextBox>

      <div>
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          data : {{ textValue == null ? 'null' : textValue }}
        </v-chip>
      </div>
      <UMarkdownViewer>{{ textBox9 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import textBox9 from './md/textbox9.md'

const textValue = ref('')
</script>

<style scoped></style>
