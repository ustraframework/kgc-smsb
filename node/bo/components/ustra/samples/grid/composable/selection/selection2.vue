<template>
  <VCard>
    <template #title>CheckBox Selection</template>
    <template #subtitle>
      useWijmoFlexGrid 메소드 사용 시, selection option을 세팅하여 그리드의 선택 옵션 및 변경 데이터 등에 쉽게 Access 할 수 있다.
    </template>
    <template #text>
      <WjFlexGrid style="height: 300px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
      </WjFlexGrid>

      <UButton text="체크 Row 삭제" @click="grid.checkSelection.removeRows" :disabled="grid.checkSelection.rows.value.length < 1"></UButton>

      <br /><br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        selectionData : {{ grid.selectionData }}
      </v-chip>
      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checkedData : {{ grid.checkSelection.rowsData }}
      </v-chip>

      <UMarkdownViewer :content="selection2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer, UButton } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import selection2 from './md/selection2.md'

interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}

const grid = useWijmoFlexGrid<Country>({
  selection: {
    mode: 'Check',
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
