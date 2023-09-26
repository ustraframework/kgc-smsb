<template>
  <VCard>
    <template #text>
      default slot을 사용하여 버튼 모양을 변경할 수 있다.
      <br /><br />
      <UFileButton @change="e => (selectedFiles = e.srcElement.files)"> <UButton text="파일 선택" icon="mdi-file-find-outline" /> </UFileButton>

      <br />
      <v-chip class="mt-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        selectedFiles : {{ selectedFiles.length > 0 ? selectedFiles[0].name : '' }}
      </v-chip>

      <UMarkdownViewer :content="button2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { shallowRef } from '#ustra/nuxt'
import { UFileButton, UMarkdownViewer, UButton } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import button2 from './md/button2.md'

const selectedFiles = shallowRef<File[]>([])
</script>
