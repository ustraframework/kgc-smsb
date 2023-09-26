```html
<template>
  <WjFlexGrid :itemsSource="data" style="max-height: 300px" class="mt-2" :columnGroups="columnGroups"> </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid } from '#ustra/nuxt-wijmo/components'

const columnGroups = [
  { binding: 'seq', header: 'Seq', width: 100 },
  { binding: 'country', header: 'Country', width: 150, align: 'center' },
  {
    header: 'Sales',
    align: 'center',
    columns: [
      { binding: 'sales', header: 'Sales', format: 'n2', width: 100, cssClass: 'main-column' },
      { binding: 'data1', header: 'Data1', format: 'n2', width: 100 },
      { binding: 'data2', header: 'Data2', format: 'n2', width: 100 },
    ],
  },
  {
    header: 'Expenses',
    align: 'center',
    columns: [
      { binding: 'expenses', header: 'Expenses', format: 'n2', width: 100, cssClass: 'main-column' },
      { binding: 'data3', header: 'Data3', format: 'n2', width: 100 },
      { binding: 'data4', header: 'Data4', format: 'n2', width: 100 },
    ],
  },
]

const data = ref([])
for (let i = 0; i < 100; i++) {
  data.value.push({
    id: i,
    seq: i + 1,
    country: 'country_' + i,
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    data1: Math.random() * 1000,
    data2: Math.random() * 1000,
    data3: Math.random() * 1000,
    data4: Math.random() * 1000,
  })
}
</script>
```
