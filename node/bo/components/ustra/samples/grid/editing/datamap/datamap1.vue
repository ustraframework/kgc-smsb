<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <WjFlexGrid :itemsSource="data">
        <WjFlexGridColumn header="Customer" binding="customer" :isReadOnly="false" :dataMap="customerMap"></WjFlexGridColumn>
        <WjFlexGridColumn header="Country" binding="country" :dataMap="countries" :isReadOnly="false"></WjFlexGridColumn>
        <WjFlexGridColumn header="Downloads" binding="downloads" format="n0" :isReadOnly="true"></WjFlexGridColumn>
        <WjFlexGridColumn header="Sales" binding="sales" format="n0" :isReadOnly="true"></WjFlexGridColumn>
        <WjFlexGridColumn header="Expenses" binding="expenses" format="n0" :isReadOnly="true"></WjFlexGridColumn>
      </WjFlexGrid>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import doc1 from './md/datamap1-1.md'

// @ts-ignore
import doc2 from './md/datamap1-2.md'

const data = []
const countries = ['US', 'Germany', 'UK', 'Japan', 'Sweden', 'Norway', 'Denmark']
const customers = [
  { id: 0, name: 'Paul Perkins', address: '123 Main St' },
  { id: 1, name: 'Susan Smith', address: '456 Grand Ave' },
  { id: 2, name: 'Joan Jett', address: '789 Broad St' },
  { id: 3, name: 'Don Davis', address: '321 Shattuck Ave' },
]
const customerMap = new (useWijmoGrid().DataMap)(customers, 'id', 'name')
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
</script>
