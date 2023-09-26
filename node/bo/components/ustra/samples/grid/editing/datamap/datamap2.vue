<template>
  <VCard>
    <template #text>
      <h3>계층화 된 DataMap</h3>
      <br />
      계층화 된 DataMap을 사용하기 위해서는 getDisplayValues 메소드를 구현하여 상위 데이터가 변경되었을 때, 선택된 항목에 맞는 데이터를 필터링하여
      제공하는 방식으로 처리한다.

      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-3">
        <WjFlexGridColumn header="Country" binding="country" :dataMap="countries" :isReadOnly="false"></WjFlexGridColumn>
        <WjFlexGridColumn header="Customer" binding="customer" :isReadOnly="false" :width="150" :dataMap="customerMap"></WjFlexGridColumn>
        <WjFlexGridColumn header="Downloads" binding="downloads" format="n0" :isReadOnly="true"></WjFlexGridColumn>
        <WjFlexGridColumn header="Sales" binding="sales" format="n0" :isReadOnly="true"></WjFlexGridColumn>
        <WjFlexGridColumn header="Expenses" binding="expenses" format="n0" :isReadOnly="true"></WjFlexGridColumn>
      </WjFlexGrid>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoGrid } from '#ustra/nuxt-wijmo/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import doc1 from './md/datamap2.md'

const data = []
const countries = ['US', 'Germany', 'UK', 'Japan', 'Sweden', 'Norway', 'Denmark']
const customerMap = new (useWijmoGrid().DataMap)([], 'value', 'text')
customerMap.getDisplayValues = dataItem => {
  return customerMap.collectionView.sourceCollection.filter(data => data.country === dataItem.country).map(data => data.text)
}

for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    active: i % 5 != 0,
    downloads: Math.round(Math.random() * 200000),
    sales: Math.random() * 100000,
    expenses: Math.random() * 50000,
  })

  for (let j = 0; j < 5; j++) {
    customerMap.collectionView.sourceCollection.push({
      value: j,
      text: 'customer:' + countries[i] + ':' + j,
      country: countries[i],
    })
  }
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})
</script>
