<template>
  <VCard>
    <template #text>
      <h3>Html Support</h3>
      <br />
      <UMarkdownViewer :content="doc1" />
      <br /><br />

      <UCkEditor5
        v-model="content"
        :height="200"
        :useSourceEditing="true"
        :htmlSupport="{
          allow: [
            {
              name: /.*/,
              attributes: true,
              classes: true,
              styles: true,
            },
          ],
        }"
      />

      <v-chip class="ma-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
        <v-icon start icon="mdi-label"></v-icon>
        content :
        <pre>{{ content }}</pre>
      </v-chip>

      <UMarkdownViewer :content="doc2" />

      <div class="mb-2">
        <UButton text="글자 색상 변경" @click="() => (content = `<a style='color: blue; text-decoration: underline'>테스트 링크</a>`)" />
      </div>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCkEditor5 } from '#ustra/nuxt-ckeditor5/components'

// @ts-ignore
import doc1 from './md/editor4-1.md'

// @ts-ignore
import doc2 from './md/editor4-2.md'

const content = ref('<a style="color:red;text-decoration:underline;">테스트 링크</a>')
</script>
