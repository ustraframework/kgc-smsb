<template>
  <VCard>
    <template #text>
      <h3>버튼 표시</h3>
      이미지와 동일하게 버튼 컴포넌트를 위치시킨다.
      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="Col1" binding="col1" :wordWrap="true" :width="200">
          <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
            <div>
              <UButtonBox>
                <UButton small type="primary" text="저장" :width="80" />
                <UButton small type="gray" text="삭제" :width="80" />
              </UButtonBox>
            </div>
          </wj-flex-grid-cell-template>
        </WjFlexGridColumn>
        <WjFlexGridColumn header="Col2" binding="col2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="cellTemplate3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, UMarkdownViewer, UButton, UButtonBox } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { ref } from '#ustra/nuxt'

// @ts-ignore
import cellTemplate3 from './md/cell-template3.md'

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
