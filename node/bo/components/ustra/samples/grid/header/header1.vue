<template>
  <VCard>
    <template #text>
      <h3>Header Grouping</h3>
      <UMarkdownViewer :content="header1_1" />
      <WjFlexGrid :itemsSource="data" style="max-height: 300px" class="mt-2">
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

      <UMarkdownViewer :content="header1_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumnGroup, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import header1_1 from './md/header1-1.md'

// @ts-ignore
import header1_2 from './md/header1-2.md'

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
