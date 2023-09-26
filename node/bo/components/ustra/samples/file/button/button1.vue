<template>
  <VCard>
    <template #text>
      UFileButton 컴포넌트는 File Dialog를 Open하는 컴포넌트이다. input 태그에서 사용할 수 있는 모든 속성을 사용할 수 있다. 다음은 UFileButton
      컴포넌트의 change 이벤트를 사용하여 선택된 파일을 추적하는 기능을 구현한 예제이다. <br /><br />
      <UFileButton @change="e => (selectedFiles = e.srcElement.files)" />

      <br />
      <v-chip class="mt-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        selectedFiles : {{ selectedFiles.length > 0 ? selectedFiles[0].name : '' }}
      </v-chip>

      <UMarkdownViewer :content="button1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { shallowRef } from '#ustra/nuxt'
import { UFileButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import button1 from './md/button1.md'

const selectedFiles = shallowRef<File[]>([])
</script>
