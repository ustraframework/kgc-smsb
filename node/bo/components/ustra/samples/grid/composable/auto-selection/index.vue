<template>
  <VCard>
    <template #title>autoSelection</template>
    <template #text>
      autoSelection 옵션은 데이터 로드 시 첫번째 항목을 자동 선택하는 기능이다. WjFlexGrid 컴포넌트의 경우 기본적으로 활성화 되어 있는 기능이나
      useWijmoFlexGrid 메소드를 사용할 경우는 해당 옵션이 false가 기본 값으로 비활성화 되어 있다.
      <br /><br />

      <UCheckGroupBox :itemsSource="[{ text: 'autoSelection' }]" v-model="grid.option.autoSelection"></UCheckGroupBox>

      <WjFlexGrid style="height: 150px" class="mt-2" :itemsSource="gridData" :initialized="grid.initialize" selectionMode="Row">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
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
import content from './md/auto-selection1.md'

const gridData = ref<any[]>([])
const grid = useWijmoFlexGrid({ autoSelection: false, isReadOnly: false })

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
