<template>
  <VCard>
    <template #text>
      <h3>Source Editing</h3>
      <br />
      useSourceEditing 속성을 true로 설정하면 HTML 소스를 수정할 수 툴바 아이콘이 생성되어 HTML 소스를 수정할 수 있는 기능을 사용할 수 있다.
      <br /><br />

      <UCkEditor5 v-model="content" :height="200" :useSourceEditing="true" />

      <UMarkdownViewer :content="doc1" />

      <v-chip class="ma-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
        <v-icon start icon="mdi-label"></v-icon>
        content :
        <pre>{{ content }}</pre>
      </v-chip>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCkEditor5 } from '#ustra/nuxt-ckeditor5/components'

// @ts-ignore
import doc1 from './md/editor3.md'

const content = ref('')
</script>
