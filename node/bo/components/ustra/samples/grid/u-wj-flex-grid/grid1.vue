<template>
  <VCard>
    <template #title>UWjFlexGrid</template>
    <template #text>
      Wijmo에서 제공되는 WjFlexGrid를 확장한 UWjFlexGrid 컴포넌트를 사용하여 편의성이 개선된 Grid 컴포넌트를 사용할 수 있다.
    </template>
  </VCard>
  <VCard>
    <template #text>
      <h3>autoSelection</h3>
      WjFlexGrid 컴포넌트는 데이터 로드 시 첫번째 행 또는 컬럼을 자동 선택한다. UWjFlexGrid를 사용할 경우, 자동 선택은 자동으로 false로 설정되며 이를
      원 동작과 동일하게 처리하려면 autoSelection 속성을 true로 세팅해야 한다.

      <br /><br />
      <UCheckGroupBox :itemsSource="[{ text: 'autoSelection' }]" v-model="autoSelection"></UCheckGroupBox>

      <UWjFlexGrid style="height: 150px" class="mt-5" :itemsSource="gridData" :autoSelection="autoSelection" selectionMode="Row">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
      </UWjFlexGrid>
      <UButton text="Load Data" @click="() => (gridData = createData())" />

      <UMarkdownViewer :content="flexGrid1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UWjFlexGrid, WjFlexGridColumn, UCheckGroupBox, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import flexGrid1 from './md/flex-grid1.md'

const autoSelection = ref<boolean>(false)
const gridData = ref<any[]>([])

function createData() {
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

  return data
}
</script>
