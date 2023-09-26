<template>
  <VCard title="2) onCellDblClick">
    <template #subtitle>그리드의 Cell 더블 클릭시 발생되는 이벤트이다.</template>
    <template #text>
      <WjFlexGrid style="height: 150px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="event1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import event1 from './md/event2.md'

interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}
const grid = useWijmoFlexGrid<Country>({
  onCellDblClick: function (col, row, data) {
    alert(`col: ${col}\n row: ${row}\n data: ${JSON.stringify(data)}`)
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
