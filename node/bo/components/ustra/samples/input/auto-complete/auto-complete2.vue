<template>
  <USampleContentContainer title="API 연계">
    <UMarkdownViewer :content="doc1" />

    <WjAutoComplete v-model="value" displayMemberPath="title" selectedValuePath="id" :itemsSourceFunction="searchItems" />
    <br /><br />

    <br /><br />

    <v-chip class="ma-2" color="pink" label text-color="white">
      <v-icon start icon="mdi-label"></v-icon>
      selectedValue : {{ value }}
    </v-chip>

    <UMarkdownViewer :content="doc2" />
  </USampleContentContainer>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { USampleContentContainer } from '#ustra/nuxt-vuetify/samples'
import { WjAutoComplete, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
// @ts-ignore
import doc1 from './md/auto-complete2-1.md'

// @ts-ignore
import doc2 from './md/auto-complete2-2.md'

const value = ref(null)

function searchItems(query: string, max: number, callback: Function) {
  $ustra.api
    .call<{ userId: number; id: number; title: string; body: string }[]>({
      url: 'https://jsonplaceholder.typicode.com/posts',
      showLoadingBar: false,
    })
    .then(result => {
      callback(!query ? result.data : result.data.filter(data => data.title.includes(query)).slice(0, max))
    })
}
</script>
