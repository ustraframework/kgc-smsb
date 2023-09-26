```html
<template>
  <WjFlexGrid style="height: 150px" class="mt-2" :itemsSource="gridData" :initialized="grid.initialize" selectionMode="Row">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
  </WjFlexGrid>

  <UButton text="Load Data" @click="() => loadData()" />
  <UButton text="Clear Data" @click="() => (gridData = [])" />
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UButton, UCheckGroupBox } from '#ustra/nuxt-wijmo/components'

const gridData = ref<any[]>([])
const grid = useWijmoFlexGrid({ autoSelection: false, isReadOnly: false, emptyText: 'No data to display...' })

function loadData() {
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

  gridData.value = data
}
</script>
```
