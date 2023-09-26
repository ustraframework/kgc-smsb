<template>
  <VCard>
    <template #title>Selection</template>
    <template #subtitle>
      useWijmoFlexGrid 메소드 사용 시, selection option을 세팅하여 그리드의 선택 옵션 및 변경 데이터 등에 쉽게 Access 할 수 있다.
    </template>
    <template #text>
      <URadioGroupBox
        :itemsSource="[
          { value: SelectionMode.None, text: 'None' },
          { value: SelectionMode.Cell, text: 'Cell' },
          { value: SelectionMode.Row, text: 'Row' },
          { value: SelectionMode.CellRange, text: 'CellRange' },
          { value: SelectionMode.ListBox, text: 'ListBox' },
          { value: SelectionMode.MultiRange, text: 'MultiRange' },
          { value: SelectionMode.RowRange, text: 'RowRange' },
        ]"
        v-model="grid.option.selection.mode"
      />

      <WjFlexGrid style="height: 300px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
      </WjFlexGrid>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        selectionData : {{ grid.selectionData }}
      </v-chip>

      <UMarkdownViewer :content="selection1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, URadioGroupBox, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { SelectionMode } from '@grapecity/wijmo.grid'

// @ts-ignore
import selection1 from './md/selection1.md'

interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}

const grid = useWijmoFlexGrid<Country>({
  selection: {
    mode: SelectionMode.Row,
    selectionChanged: selectionData => {
      console.log('selectionData', selectionData)
    },
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
