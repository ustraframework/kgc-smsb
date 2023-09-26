<template>
  <v-card>
    <template #text>
      <UMarkdownViewer>{{ basicBinding2_1 }}</UMarkdownViewer>

      <WjFlexGrid :itemsSource="cv" style="height: 200px">
        <WjFlexGridColumn header="Country" binding="country" width="2*" />
        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
      </WjFlexGrid>

      <UButton text="Load Data" @click="() => (countries = _getData())"></UButton>

      <UMarkdownViewer>{{ basicBinding2_2 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { WjFlexGridColumn, WjFlexGrid } from '#ustra/nuxt-wijmo/components'
import { useCollectionView } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { ref, computed } from '#ustra/nuxt'

// @ts-ignore
import basicBinding2_1 from './md/basic-binding2-1.md'

// @ts-ignore
import basicBinding2_2 from './md/basic-binding2-2.md'

interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}
const countries = ref<Country[]>([])
const cv = computed(() => {
  return useCollectionView<Country>(countries.value)
})

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
</script>
