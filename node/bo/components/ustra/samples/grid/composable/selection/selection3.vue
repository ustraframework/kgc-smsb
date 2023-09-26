<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <WjFlexGrid style="height: 300px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
      </WjFlexGrid>

      <UButton small text="Select Row 1 and 2" @click="() => grid.checkSelection.checkRows([1, 2])" />
      <UButton small text="Select Row 2 and 3 after clear " @click="() => grid.checkSelection.checkRows([2, 3], true)" />
      <UButton small text="Check All" @click="() => grid.checkSelection.checkAll()" />
      <UButton small text="Uncheck All" @click="() => grid.checkSelection.uncheckAll()" />

      <br /><br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        selectionData : {{ grid.selectionData }}
      </v-chip>
      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checkedData : {{ grid.checkSelection.rowsData }}
      </v-chip>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer, UButton } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/selection3-1.md'

// @ts-ignore
import doc2 from './md/selection3-2.md'

interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}

const grid = useWijmoFlexGrid<Country>({
  selection: {
    mode: 'Check',
  },
})

// create some random data
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

const gridData = ref<any[]>(data)
</script>
