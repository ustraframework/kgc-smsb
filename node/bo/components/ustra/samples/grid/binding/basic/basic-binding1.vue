<template>
  <v-card>
    <template #text>
      <UMarkdownViewer>{{ basicBinding1_1 }}</UMarkdownViewer>

      <WjFlexGrid :itemsSource="data" style="height: 200px">
        <WjFlexGridColumn header="Country" binding="country" width="2*" />
        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
      </WjFlexGrid>

      <UButton text="Load Data" @click="() => (data = _getData())"></UButton>

      <UMarkdownViewer>{{ basicBinding1_2 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { WjFlexGridColumn, WjFlexGrid } from '#ustra/nuxt-wijmo/components'
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import basicBinding1_1 from './md/basic-binding1-1.md'

// @ts-ignore
import basicBinding1_2 from './md/basic-binding1-2.md'

const _getData = () => {
  const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
  const data = []
  for (let i = 0; i < countries.length; i++) {
    data.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
    })
  }

  return data
}

const data = ref([])
</script>
