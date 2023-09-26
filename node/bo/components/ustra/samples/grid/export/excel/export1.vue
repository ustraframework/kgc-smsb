<template>
  <VCard>
    <template #text>
      wijmo export 기능을 사용하여 로컬 데이터를 엑셀 파일 형태로 변환할 수 있다.
      <UMarkdownViewer :content="export1_1" />

      <WjFlexGrid :itemsSource="data" style="height: 200px" class="mt-5" :initialized="grid.initialize">
        <WjFlexGridColumn header="Country" binding="country" width="2*" />
        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
      </WjFlexGrid>

      <UButton text="Export Excel" @click="exportExcel"></UButton>
      <UMarkdownViewer :content="export1_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGridColumn, WjFlexGrid } from '#ustra/nuxt-wijmo/components'
import { ref } from '#ustra/nuxt'
import { wijmoGridXlsx } from '#ustra/nuxt-wijmo'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import export1_1 from './md/export1-1.md'

// @ts-ignore
import export1_2 from './md/export1-2.md'

const grid = useWijmoFlexGrid()
const _getData = () => {
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

const data = ref(_getData())

function exportExcel() {
  grid.export.toExcel('DownloadExcel.xlsx')
}
</script>
