<template>
  <v-card>
    <template #subtitle></template>
    <template #text>
      <h3>UMenuInputBox</h3>
      <br />
      UMenuInputBox 컴포넌트를 사용하여 사용자를 입력하거나 팝업에서 선택할 수 있는 입력 Box를 사용할 수 있다.

      <UMarkdownViewer :content="doc1"></UMarkdownViewer>

      <UMenuInputBox v-model="menu" v-model:objectValue="objectValue" :canSelectSysCd="false" />

      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        menu : {{ menu }}
      </v-chip>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        objectValue : {{ objectValue }}
      </v-chip>

      <br />
      <UButton text="menu = '3'" @click="() => (menu = '3')" />
      <UButton text="menu = null" @click="() => (menu = null)" />

      <UMarkdownViewer :content="doc2"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { UMenuInputBox } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/menu-popup3-1.md'

// @ts-ignore
import doc2 from './md/menu-popup3-2.md'

const menu = ref(null)
const objectValue = ref(null)
</script>
