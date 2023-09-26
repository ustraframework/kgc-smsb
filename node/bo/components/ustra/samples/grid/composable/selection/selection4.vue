<template>
  <VCard>
    <template #text>
      filterCheckableRow 속성은 Row 객체와 Row 데이터를 수신하여 체크박스가 활성화 된 Row를 필터링하는 기능이다. false를 리턴할 경우, 체크박스는
      선택이 불가능한 상태로 변경된다. 아래 예제는 Japan, US 국가만 선택 가능하게 하는 예제이다.

      <WjFlexGrid style="height: 300px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" :width="200" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" :width="200" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" :width="200" format="n2" />
        <WjFlexGridColumn :header="'Country'" :binding="'country'" :width="200" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" :width="200" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" :width="200" format="n2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/selection4.md'

interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}

const grid = useWijmoFlexGrid<Country>({
  selection: {
    mode: 'Check',
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
