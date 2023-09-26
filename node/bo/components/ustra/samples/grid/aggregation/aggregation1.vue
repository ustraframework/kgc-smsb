<template>
  <v-card>
    <template #title> 전체 집계 </template>
    <template #text>
      <WjFlexGrid ref="grid" :initialized="grid.initialize" :itemsSource="data" style="max-height: 300px">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn :header="'Data1'" :binding="'data1'" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn :header="'Data2'" :binding="'data2'" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn :header="'Data3'" :binding="'data3'" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn :header="'Data4'" :binding="'data4'" width="*" format="n2" aggregate="Sum" />
      </WjFlexGrid>

      <UMarkdownViewer>{{ total1 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { ref, onMounted } from 'vue'

// @ts-ignore
import total1 from './md/aggregation1.md'

const grid = useWijmoFlexGrid({
  onAfterInitialized(control) {
    control.columnFooters.rows.push(new wijmoGrid.GroupRow())
  },
})

/**
 * 마운트시 total 항목 추가
 */
onMounted(() => {})

/**
 * 샘플용 Grid Data 생성
 * @param cnt Grid Row 카운트
 */
const _getData = (cnt: Number) => {
  // create some random data
  const countries = 'US,Germany,UK,Japan,Italy,Greece,Korea'.split(',')
  const data = []

  for (let i = 0; i < cnt; i++) {
    data.push({
      id: i,
      country: 'country_' + i,
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      data1: Math.random() * 1000,
      data2: Math.random() * 1000,
      data3: Math.random() * 1000,
      data4: Math.random() * 1000,
    })
  }

  return data
}
const data = _getData(100)
</script>
