<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <WjFlexGrid :initialized="grid.initialize" :itemsSource="data">
        <WjFlexGridColumn header="Customer" binding="customer" :isReadOnly="false" :dataMap="customerMap"></WjFlexGridColumn>
        <WjFlexGridColumn header="Downloads" binding="downloads" format="n0" :isReadOnly="true"></WjFlexGridColumn>
        <WjFlexGridColumn header="Sales" binding="sales" format="n0" :isReadOnly="true"></WjFlexGridColumn>
        <WjFlexGridColumn header="Expenses" binding="expenses" format="n0" :isReadOnly="true"></WjFlexGridColumn>
      </WjFlexGrid>

      <br /><br />
      수정된 데이터
      <WjFlexGrid :isReadonly="true" :itemsSource="editedData" style="height: 100px" class="mt-1"> </WjFlexGrid>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { computed } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import doc1 from './md/datamap4-1.md'

// @ts-ignore
import doc2 from './md/datamap4-2.md'

const data = []
const countries = ['US', 'Germany', 'UK', 'Japan', 'Sweden', 'Norway', 'Denmark']
const customers = [
  { id: 0, name: 'Paul Perkins', address: '123 Main St' },
  { id: 1, name: 'Susan Smith', address: '456 Grand Ave' },
  { id: 2, name: 'Joan Jett', address: '789 Broad St' },
  { id: 3, name: 'Don Davis', address: '321 Shattuck Ave' },
]
const customerMap = new wijmoGrid.DataMap(customers, 'id', 'name')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    active: i % 5 != 0,
    downloads: Math.round(Math.random() * 200000),
    sales: Math.random() * 100000,
    expenses: Math.random() * 50000,
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized() {
    grid.collectionView.trackChanges = true
  },
  editing: {
    onCellEdited(e, beforeValue, afterValue) {
      console.log('updated...', beforeValue, afterValue)

      grid.editing.restartEdit()
    },
  },
})

const editedData = computed(() => {
  if (!grid.collectionView) {
    return []
  }

  return grid.collectionView.itemsEdited
})
</script>
