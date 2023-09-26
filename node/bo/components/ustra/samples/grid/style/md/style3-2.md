```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn header="회사" binding="company"></WjFlexGridColumn>
    <WjFlexGridColumn header="사원수" binding="empCnt"></WjFlexGridColumn>
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { random } from '#ustra/core/utils'

const grid = useWijmoFlexGrid({
  onAfterInitialized() {
    grid.rawControl.formatItem.addHandler((s, e) => {
      // cell 영역일 경우,
      if (e.panel === s.cells && e.col === 1) {
        const value = e.panel.getCellData(e.row, e.col, false)
        e.cell.style.color = value > 50 ? '#ff0000' : '#000000'
      }
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
```
