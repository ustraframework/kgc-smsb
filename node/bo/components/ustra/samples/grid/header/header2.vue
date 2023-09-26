<template>
  <VCard>
    <template #text>
      WjFlexGridColumnGroup 컴포넌트를 사용하지 않고, columnGroups 속성을 사용하여 배열형태로 그룹화 된 컬럼을 정의할 수 있다.
      <WjFlexGrid :itemsSource="data" style="max-height: 300px" class="mt-2" :columnGroups="columnGroups"> </WjFlexGrid>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumnGroup, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/header2-1.md'

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
