<template>
  <v-card>
    <template #text>
      <h3>사용자 입력 Box</h3>
      <br />
      UUserInputBox 컴포넌트를 사용하여 사용자를 입력하거나 팝업에서 선택할 수 있는 입력 Box를 사용할 수 있다.
      <br /><br />
      <UUserInputBox v-model="user" v-model:objectValue="objectValue" />

      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        user : {{ user }}
      </v-chip>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        objectValue : {{ objectValue }}
      </v-chip>

      <br />
      <UButton text="user = 'admin'" @click="() => (user = 'admin')" />
      <UButton text="user = {code:'admin', name:'관리자'}" @click="() => (user = { code: 'admin', name: '관리자' })" />
      <UButton text="user = null" @click="() => (user = null)" />

      <UMarkdownViewer :content="userPopup3"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { UUserInputBox } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import userPopup3 from './md/user-popup3.md'

const user = ref(null)
const objectValue = ref(null)
</script>
