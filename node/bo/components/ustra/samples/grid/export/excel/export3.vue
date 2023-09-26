<template>
  <VCard>
    <template #text>
      <h3 class="mb-2">Grouped Header</h3>
      grid.export.toExcel 메소드를 사용하면 Grouping된 헤더 정보를 포함하여 엑셀을 다운로드 받을 수 있다.

      <WjFlexGrid :itemsSource="data" style="max-height: 300px" class="mt-2" :initialized="grid.initialize">
        <WjFlexGridColumnGroup header="Seq" binding="seq" :width="100" />
        <WjFlexGridColumnGroup header="Country" binding="country" :width="150" align="center" />
        <WjFlexGridColumnGroup header="Sales" align="center">
          <WjFlexGridColumnGroup header="Sales" binding="sales" format="n2" :width="100" />
          <WjFlexGridColumnGroup header="Data1" binding="data1" format="n2" :width="100" />
          <WjFlexGridColumnGroup header="Data2" binding="data2" format="n2" :width="100" />
        </WjFlexGridColumnGroup>
        <WjFlexGridColumnGroup header="Expenses" align="center">
          <WjFlexGridColumnGroup header="Expenses" binding="expenses" :width="100" />
          <WjFlexGridColumnGroup header="Data3" binding="data3" :width="100" />
          <WjFlexGridColumnGroup header="Data4" binding="data4" :width="100" />
        </WjFlexGridColumnGroup>
      </WjFlexGrid>

      <UButton text="Export Excel" @click="() => grid.export.toExcel('DownloadExcel.xlsx')"></UButton>
      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumnGroup } from '#ustra/nuxt-wijmo/components'
import { ref } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/export3.md'

const grid = useWijmoFlexGrid()
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
