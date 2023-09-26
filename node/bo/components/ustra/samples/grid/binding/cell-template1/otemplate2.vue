<template>
  <VCard>
    <template #text>
      <h3>이미지 표시</h3>
      Cell Template을 사용하여 썸네일을 표시할 수 있다. 단 그리드의 사이즈를 맞추기 위해 loadedRows 속성에서 height 값을 강제 조정해야 할 수 있다.
      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="Col1" binding="col1" :wordWrap="true">
          <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
            <img src="@ustra/nuxt-wijmo/src/samples/assets/img/avatar1.png" style="height: 100px" v-if="cell.item.index === 0" />
            <img src="@ustra/nuxt-wijmo/src/samples/assets/img/avatar2.png" style="height: 100px" v-if="cell.item.index === 1" />
            <img src="@ustra/nuxt-wijmo/src/samples/assets/img/avatar3.png" style="height: 100px" v-if="cell.item.index === 2" />
          </wj-flex-grid-cell-template>
        </WjFlexGridColumn>
        <WjFlexGridColumn header="Col2" binding="col2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="cellTemplate2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { ref } from '#ustra/nuxt'

// @ts-ignore
import cellTemplate2 from './md/cell-template2.md'

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
