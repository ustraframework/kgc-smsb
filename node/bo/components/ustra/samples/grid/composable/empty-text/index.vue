<template>
  <VCard>
    <template #title>emptyText</template>
    <template #text>
      emptyText 속성을 사용하여, 조회된 데이터가 없을 시 기본적으로 노출할 Text를 지정할 수 있다. 기본 값은 '조회된 데이터가 없습니다.' 이다.
      <br /><br />

      <WjFlexGrid style="height: 300px" class="mt-2" :itemsSource="gridData" :initialized="grid.initialize" selectionMode="Row">
        <WjFlexGridColumn :header="'Country'" binding="country" :width="300" />
        <WjFlexGridColumn :header="'Sales'" binding="sales" :width="400" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" binding="expenses" :width="400" format="n2" />
      </WjFlexGrid>

      <UButton text="Load Data" @click="() => loadData()" />
      <UButton text="Clear Data" @click="() => (gridData = [])" />

      <UMarkdownViewer :content="content" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UButton, UCheckGroupBox, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import content from './md/empty-text1.md'

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
loadData()
</script>
