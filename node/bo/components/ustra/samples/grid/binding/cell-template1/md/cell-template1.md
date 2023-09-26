위의 예제는 WjFlexGrid 컴포넌트 하위에 위치해야 하는 BottomLeft, TopLeft, RowHeader, RowHeaderEdit 템플릿을 설정하는 예제이다.

```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize">
    <WjFlexGridCellTemplate cellType="BottomLeft">
      <div>BottomLeft</div>
    </WjFlexGridCellTemplate>

    <WjFlexGridCellTemplate cellType="TopLeft">
      <div>TopLeft</div>
    </WjFlexGridCellTemplate>

    <WjFlexGridCellTemplate cellType="RowHeader">
      <div>RowHeader</div>
    </WjFlexGridCellTemplate>

    <WjFlexGridCellTemplate cellType="RowHeaderEdit">
      <div>RowHeaderEdit</div>
    </WjFlexGridCellTemplate>

    <WjFlexGridColumn header="Col1" binding="col1" />
    <WjFlexGridColumn header="Col2" binding="col2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid } from '#ustra/nuxt-wijmo'

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
```
