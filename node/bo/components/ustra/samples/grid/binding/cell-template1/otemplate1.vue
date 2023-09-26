<template>
  <VCard>
    <template #text>
      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize">
        <wj-flex-grid-cell-template cellType="BottomLeft">
          <div>BottomLeft</div>
        </wj-flex-grid-cell-template>

        <wj-flex-grid-cell-template cellType="TopLeft">
          <div>TopLeft</div>
        </wj-flex-grid-cell-template>

        <wj-flex-grid-cell-template cellType="RowHeader">
          <div>RowHeader</div>
        </wj-flex-grid-cell-template>

        <wj-flex-grid-cell-template cellType="RowHeaderEdit">
          <div>RowHeaderEdit</div>
        </wj-flex-grid-cell-template>

        <WjFlexGridColumn header="Col1" binding="col1" />
        <WjFlexGridColumn header="Col2" binding="col2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="cellTemplate1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { ref } from '#ustra/nuxt'

// @ts-ignore
import cellTemplate1 from './md/cell-template1.md'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized(control) {
    // 하단에 group row 추가
    control.columnFooters.rows.push(new wijmoGrid.GroupRow())
    control.rowHeaders.columns[0].width = 150
  },
})
const data = ref([
  {
    col1: 'row1-1',
    col2: 'row1-2',
  },
  {
    col1: 'row2-1',
    col2: 'row2-2',
  },
  {
    col1: 'row3-1',
    col2: 'row3-2',
  },
])
</script>
