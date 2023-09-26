<template>
  <v-card>
    <template #title>공통 코드 입력 Box</template>
    <template #subtitle>UCodeInputBox 컴포넌트를 사용하여 공통 코드를 입력하거나 팝업에서 선택할 수 있는 입력 Box를 사용할 수 있다.</template>
    <template #text>
      <UCodeInputBox v-model="codeValue" v-model:objectValue="objectValue" grpCd="SYS_CD" />

      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        codeValue : {{ codeValue }}
      </v-chip>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        objectValue : {{ objectValue }}
      </v-chip>

      <br />
      <UButton text="codeValue = 'AP'" @click="() => (codeValue = 'AP')" />
      <UButton text="codeValue = null" @click="() => (codeValue = null)" />

      <UMarkdownViewer :content="codePopup2"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { UCodeInputBox } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import codePopup2 from './md/code-popup2.md'

const codeValue = ref('FO')
const objectValue = ref(null)
</script>
