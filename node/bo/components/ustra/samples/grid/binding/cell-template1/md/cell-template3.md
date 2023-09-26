```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn header="Col1" binding="col1" :wordWrap="true" :width="200">
      <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
        <div>
          <UButtonBox>
            <UButton small type="primary" text="저장" :width="80" />
            <UButton small type="gray" text="삭제" :width="80" />
          </UButtonBox>
        </div>
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
  selection: {
    mode: wijmoGrid.SelectionMode.None,
  },
  onAfterInitialized(control) {
    control.autoSizeMode = wijmoGrid.AutoSizeMode.None

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
