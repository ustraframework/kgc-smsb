<template>
  <VCard>
    <template #text>
      <h3>collapseTo</h3>
      collapseTo 속성은 대상 그룹을 축소할 수 있는 기능을 제공하며, 하위에 존재하는 WjFlexGridColumnGroup의 binding 항목을 string 형태로 설정한다.
      <WjFlexGrid :itemsSource="data" style="max-height: 300px" class="mt-2">
        <WjFlexGridColumnGroup header="Seq" binding="seq" :width="100" />
        <WjFlexGridColumnGroup header="Country" binding="country" :width="150" align="center" />
        <WjFlexGridColumnGroup header="Sales" align="center" collapseTo="sales">
          <WjFlexGridColumnGroup header="Sales" binding="sales" format="n2" :width="100" />
          <WjFlexGridColumnGroup header="Data1" binding="data1" format="n2" :width="100" />
          <WjFlexGridColumnGroup header="Data2" binding="data2" format="n2" :width="100" />
        </WjFlexGridColumnGroup>
        <WjFlexGridColumnGroup header="Expenses" align="center" collapseTo="expenses">
          <WjFlexGridColumnGroup header="Expenses" binding="expenses" :width="100" />
          <WjFlexGridColumnGroup header="Data3" binding="data3" :width="100" />
          <WjFlexGridColumnGroup header="Data4" binding="data4" :width="100" />
        </WjFlexGridColumnGroup>
      </WjFlexGrid>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumnGroup, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/header3.md'

const data = ref([])
for (let i = 0; i < 100; i++) {
  data.value.push({
    id: i,
    seq: i + 1,
    country: 'country_' + i,
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    data1: Math.random() * 1000,
    data2: Math.random() * 1000,
    data3: Math.random() * 1000,
    data4: Math.random() * 1000,
  })
}
</script>
