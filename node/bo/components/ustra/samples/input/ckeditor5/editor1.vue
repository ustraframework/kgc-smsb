<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="editor1" />
      <div class="mb-2">
        <UButton :text="disabled ? '활성화' : '비활성화'" @click="disabled = !disabled" />
        <UButton :text="'초기화(history)'" @click="() => ckEditor.initEditor()" />
        <UButton :text="'초기화(value 값 포함)'" @click="() => ckEditor.initEditor(true)" />
        <UButton text="Focus" @click="() => ckEditor.focus()" />
        <UButton text="값 설정" @click="() => (content = '<p>CkEditor 컴포넌트</p>')" />
      </div>
      <UCkEditor5
        v-model="content"
        :height="300"
        :disabled="disabled"
        :initialized="ckEditor.initialize"
        :config="{
          link: {
            decorators: {
              isExternal: {
                mode: 'manual',
                label: 'Open in a new tab',
                attributes: {
                  target: '_blank',
                },
              },
            },
          },
        }"
      />

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
import { UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCkEditor5 } from '#ustra/nuxt-ckeditor5/components'
import { useUstraCkEditor5 } from '#ustra/nuxt-ckeditor5/composables'

// @ts-ignore
import editor1 from './md/editor1.md'

const content = ref('')
const disabled = ref(false)
const ckEditor = useUstraCkEditor5()
</script>
