<template>
  <VCard>
    <template #text>
      WjFlexGrid가 제공하는 기본 편집 기능에 대해 안내한다. useWijmoFlexGrid 메소드를 사용할 경우, isReadOnly 속성을 false로 설정해야 그리드의 Editing
      기능이 활성화 된다. 기본적으로 데이터 유형에 맞는 에디터를 표시하므로 데이터의 유형을 의도하는 컴포넌트 유형에 맞게 생성해야 한다. <br /><br />
      특정 컬럼의 경우, 편집을 불가능하게 설정해야 할 경우는 WjFlexGridColumn의 속성 isReadOnly를 true로 세팅한다.

      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn binding="id" header="id" :isReadOnly="true" />
        <WjFlexGridColumn binding="country" header="country" />
        <WjFlexGridColumn binding="sales" header="sales" />
        <WjFlexGridColumn binding="expenses" header="expenses" />
        <WjFlexGridColumn binding="overdue" header="overdue" />
        <WjFlexGridColumn binding="date" header="date" />
      </WjFlexGrid>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, UMarkdownViewer, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import doc1 from './md/basic1.md'

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
})
</script>
