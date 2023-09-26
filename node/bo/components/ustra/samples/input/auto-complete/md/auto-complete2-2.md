```html
<template>
  <WjAutoComplete v-model="value" displayMemberPath="title" selectedValuePath="id" :itemsSourceFunction="searchItems" />
  <br /><br />

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    selectedValue : {{ value }}
  </v-chip>
</template>
<script lang="ts" setup>
import { WjAutoComplete } from '#ustra/nuxt-wijmo/components'

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
```
