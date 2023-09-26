```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize">
    <WjFlexGridColumn header="Country" binding="country" :dataMap="countries" :isReadOnly="false"></WjFlexGridColumn>
    <WjFlexGridColumn header="Customer" binding="customer" :isReadOnly="false" :width="150" :dataMap="customerMap"></WjFlexGridColumn>
    <WjFlexGridColumn header="Downloads" binding="downloads" format="n0" :isReadOnly="true"></WjFlexGridColumn>
    <WjFlexGridColumn header="Sales" binding="sales" format="n0" :isReadOnly="true"></WjFlexGridColumn>
    <WjFlexGridColumn header="Expenses" binding="expenses" format="n0" :isReadOnly="true"></WjFlexGridColumn>
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

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
```
