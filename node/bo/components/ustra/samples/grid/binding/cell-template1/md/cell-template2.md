```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn header="Col1" binding="col1" :wordWrap="true">
      <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
        <img src="@ustra/nuxt-wijmo/src/samples/assets/img/avatar1.png" style="height: 100px" v-if="cell.item.index === 0" />
        <img src="@ustra/nuxt-wijmo/src/samples/assets/img/avatar2.png" style="height: 100px" v-if="cell.item.index === 1" />
        <img src="@ustra/nuxt-wijmo/src/samples/assets/img/avatar3.png" style="height: 100px" v-if="cell.item.index === 2" />
      </WjFlexGridCellTemplate>
    </WjFlexGridColumn>
    <WjFlexGridColumn header="Col2" binding="col2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid } from '#ustra/nuxt-wijmo'

const data = ref([])
const grid = useWijmoFlexGrid({
  isReadOnly: true,
  onAfterInitialized(control) {
    control.autoSizeMode = wijmoGrid.AutoSizeMode.None
    control.loadedRows.addHandler(() => {
      control.rows.forEach(row => {
        row.height = 107
      })
    })
    data.value = [
      {
        index: 0,
        col1: 'row1-1',
        col2: 'row1-2',
      },
      {
        index: 1,
        col1: 'row2-1',
        col2: 'row2-2',
      },
      {
        index: 2,
        col1: 'row3-1',
        col2: 'row3-2',
      },
    ]
  },
})
</script>
```
