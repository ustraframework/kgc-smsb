<template>
  <VCard>
    <template #text>
      <h3>이미지 업로드</h3>
      <UMarkdownViewer :content="doc1" />

      <div class="mb-2">
        <UButton text="completeUpload" @click="() => completeUpload()" />
        <!-- <UButton text="setValue" @click="() => setValue()" /> -->
      </div>
      <UCkEditor5
        v-model="content"
        v-model:fileId="fileId"
        :height="800"
        :disabled="disabled"
        :initialized="ckEditor.initialize"
        fileGroupId="ustra-sample-image"
        :useImageUpload="true"
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
import doc1 from './md/editor2.md'

const content = ref('')
const disabled = ref(false)
const ckEditor = useUstraCkEditor5()
const fileId = ref(null)

async function completeUpload() {
  await ckEditor.completeUpload()
  alert('저장이 완료되었습니다.')
}

// function setValue() {
//   content.value =
//     '<figure class="image"><img data-ustra-file="CcLKj8r3GmtzN8jKEylnvKIdGnNEv3WhQijrRvPFwQPzbuzXD6wqoWNrvaSDYmKHXeNpKEEsMV006yMenmF9Cv6AoNCxlsUN" src="http://localhost:9400/upload/ustra/sample/img/ffieJD7seS3KoZkAeemiTfA.png"></figure><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>'

//   setTimeout(() => {
//     console.log(ckEditor.editorInstance.model.document.getRoot())
//   }, 1000)
// }
</script>
