<template>
  <VCard>
    <template #text>
      <h3>Hightlight Changes</h3>
      useWijmoFlexGrid 메소드에서는 변경된 Cell을 Hightlight 해주는 기능을 제공한다. 메소드의 옵션 중 editing.highlight.enabled 속성을 true로
      변경하고, 데이터가 변경될 경우, 세팅할 class 명을 classname 속성에 설정한다. <br />
      변경된 cell은 return 값으로 반환되는 editing.clearHighlightChanges 메소드를 사용하여 초기화 할 수 있다.

      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn binding="id" header="id" :isReadOnly="true" />
        <WjFlexGridColumn binding="country" header="country" />
        <WjFlexGridColumn binding="sales" header="sales" />
        <WjFlexGridColumn binding="expenses" header="expenses" />
        <WjFlexGridColumn binding="overdue" header="overdue" />
        <WjFlexGridColumn binding="date" header="date" />
      </WjFlexGrid>

      <UButton text="초기화" @click="grid.editing.clearHighlightChanges" />

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, UMarkdownViewer, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { SelectionMode } from '@grapecity/wijmo.grid'

// @ts-ignore
import doc1 from './md/basic2.md'

const data = ref([])
const countries = ['US', 'Germany', 'UK', 'Japan', 'Italy', 'Greece']
for (let i = 0; i < countries.length; i++) {
  data.value.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    overdue: i % 4 == 0,
    date: new Date(),
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  selection: {
    mode: SelectionMode.Cell,
  },
  editing: {
    highlight: {
      enabled: true,
      classname: 'data-changes',
    },
  },
})
</script>
<style>
.wj-flexgrid .data-changes {
  background-color: pink;
}

.wj-flexgrid.wj-control .wj-cells .wj-row:hover .wj-cell.data-changes:not(.wj-state-selected):not(.wj-state-multi-selected) {
  background-color: pink;
}
</style>
