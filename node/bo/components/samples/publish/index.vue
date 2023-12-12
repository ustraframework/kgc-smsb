<template>
  <VCard title="1. 검색영역 기본"></VCard>
  <VCard>
    <template #text>
      <!-- 검색영역 -->
      <UBox class="columns" direction="row">
        <UItem class="card is-sub is-search" ratio="1">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="검색영역"><UTextBox></UTextBox></UField>
              <UField blank></UField>
              <UField blank></UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search" />
                </div>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
      <!-- // 검색영역 -->
      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
  <VCard title="2. 제목 표시"></VCard>
  <VCard>
    <template #text>
      <UBox class="columns" direction="row">
        <!-- 좌측 영역 -->
        <UItem class="card is-sub" ratio="4">
          <UBox class="table-title-wrap" direction="row">
            <UItem itemDirection="row" :ratio="1">
              <h2 class="table-title">
                <span>Sub title</span>
                <span class="data-count">총<span>24</span>건</span>
              </h2>
            </UItem>
          </UBox>

          <WjFlexGrid :itemsSource="customers">
            <WjFlexGridColumn header="ID" binding="id" width="*" />
            <WjFlexGridColumn header="이름" binding="name" width="*" />
            <WjFlexGridColumn header="주소" binding="address" width="*" />
          </WjFlexGrid>
        </UItem>
      </UBox>
      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoGrid } from '#ustra/nuxt-wijmo/composables/wijmo'

// @ts-ignore
import doc1 from './md/pub-layout-1.md'
// @ts-ignore
import doc2 from './md/pub-layout-2.md'

const data = []
const countries = ['US', 'Germany', 'UK', 'Japan', 'Sweden', 'Norway', 'Denmark']
const customers = [
  { id: 0, name: 'Paul Perkins', address: '123 Main St' },
  { id: 1, name: 'Susan Smith', address: '456 Grand Ave' },
  { id: 2, name: 'Joan Jett', address: '789 Broad St' },
  { id: 3, name: 'Don Davis', address: '321 Shattuck Ave' },
]
const customerMap = new (useWijmoGrid().DataMap)(customers, 'id', 'name')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    active: i % 5 != 0,
    downloads: Math.round(Math.random() * 200000),
    sales: Math.random() * 100000,
    expenses: Math.random() * 50000,
  })
}

const itemFormatter = (panel, r, c, cell) => {
  if (useIsHeader(panel.cellType) && (c == 0 || c == 1)) {
    cell.innerHTML = useSetImageHeader(cell)
  }
}
</script>
<style>
.iconImage {
  width: 15px;
  height: 15px;
  margin-bottom: -3px;
  margin-right: 2px;
}
</style>
