```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn binding="id" header="id" :isReadOnly="true" />
    <WjFlexGridColumn binding="country" header="country" />
    <WjFlexGridColumn binding="sales" header="sales" />
    <WjFlexGridColumn binding="expenses" header="expenses" />
    <WjFlexGridColumn binding="overdue" header="overdue" />
    <WjFlexGridColumn binding="date" header="date" />
  </WjFlexGrid>

  <UButton text="초기화" @click="grid.editing.clearHighlightChanges" />
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { SelectionMode } from '@grapecity/wijmo.grid'

const data = ref([])
const countries = ['US', 'Germany', 'UK', 'Japan', 'Italy', 'Greece']
for (let i = 0; i < countries.length; i++) {
  data.value.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    overdue: i % 4 == 0,
    date: new Date(),
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  selection: {
    mode: SelectionMode.Cell,
  },
  editing: {
    highlight: {
      enabled: true,
      classname: 'data-changes',
    },
  },
})
</script>
<style>
.wj-flexgrid .data-changes {
  background-color: pink;
}

.wj-flexgrid.wj-control .wj-cells .wj-row:hover .wj-cell.data-changes:not(.wj-state-selected):not(.wj-state-multi-selected) {
  background-color: pink;
}
</style>
```
