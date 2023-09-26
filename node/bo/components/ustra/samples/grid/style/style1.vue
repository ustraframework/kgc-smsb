<template>
  <VCard>
    <template #text>
      <h3>Row Style</h3>
      <UMarkdownViewer :content="doc1" />

      <UButton text="Reload" @click="generateData" />
      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="회사" binding="company"></WjFlexGridColumn>
        <WjFlexGridColumn header="사원수" binding="empCnt"></WjFlexGridColumn>
      </WjFlexGrid>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { random } from '#ustra/core/utils'

// @ts-ignore
import doc1 from './md/style1-1.md'

// @ts-ignore
import doc2 from './md/style1-2.md'

const grid = useWijmoFlexGrid({
  onAfterInitialized() {
    // 초기화 이후 loadedRows 이벤트 핸들러를 등록
    grid.rawControl.loadedRows.addHandler(s => {
      grid.rawControl.rows.forEach(row => {
        // empCnt에 따라서 cssClass 설정 추가
        if (row.dataItem.empCnt < 30) {
          row.cssClass = 'low-emp-company'
        } else if (row.dataItem.empCnt > 70) {
          row.cssClass = 'high-emp-company'
        }
      })
    })

    generateData()
  },
})
const data = ref([])

function generateData() {
  const companies = ['회사A', '회사B', '회사C', '회사D', '회사E', '회사F', '회사G']
  data.value = companies.map(comp => {
    return {
      company: comp,
      empCnt: random.max(100),
    }
  })
}
</script>
<style>
.wj-flexgrid.wj-control.wj-content .wj-cell.low-emp-company {
  color: #ff0000;
}
.wj-flexgrid.wj-control.wj-content .wj-cell.high-emp-company {
  color: #00804f;
}
</style>
