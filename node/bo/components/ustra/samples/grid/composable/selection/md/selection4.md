```html
<template>
  <WjFlexGrid style="height: 300px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'


interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}

const grid = useWijmoFlexGrid<Country>({
  selection: {
    mode: 'Check',
    // Japan, US만 선택 가능하게 처리...
    filterCheckableRow: (row, data) => ['Japan', 'US'].includes(data.country),
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
```
