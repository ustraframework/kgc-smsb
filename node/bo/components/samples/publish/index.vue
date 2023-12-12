<template>
  <VCard title="기본 컨텐츠 레이아웃"></VCard>
  <VCard>
    <template #text>
      <!-- 기본 컨텐츠 영역 -->
      <UBox class="columns" direction="row">
        <UItem class="card is-sub" ratio="1">
            Contents
        </UItem>
      </UBox>
      <!-- // 기본 컨텐츠 영역 -->
      <UMarkdownViewer :content="doc_basic" />
    </template>
  </VCard>

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

  <VCard title="1-1. 검색영역 활용"></VCard>
  <VCard>
    <template #text>
      <!-- 검색영역 활용-->
      <UBox class="columns" direction="row">
        <UItem class="card is-sub is-search" ratio="1" >
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 2, 1, '170px']">
              <UField label="항목구분" required>
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
              </UField>
              <UField label="변경일자" required>
                <UDatePeriodBox v-model:start="start" v-model:end="end" />
              </UField>
              <UField blank></UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search" />
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 2, 1, '170px']">
              <UField label="회원유형" required>
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
              </UField>
              <UField label="회원번호/명">
                <UBox>
                  <UTextBox type="icon"/>
                  <UTextBox/>
                </UBox>
              </UField>
              <UField blank></UField>
              <UField blank></UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
      <!-- // 검색영역 -->
      <UMarkdownViewer :content="doc1_1" />
    </template>
  </VCard>

  <VCard title="1-2. 검색영역 버튼 추가"></VCard>
  <VCard>
    <template #text>
      <!-- 검색영역 -->
      <UBox class="columns" direction="row">
        <UItem class="card is-sub is-search" ratio="1">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, 1, '340px']">
              <UField label="검색영역"><UTextBox></UTextBox></UField>
              <UField blank></UField>
              <UField blank></UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="초기화"/>
                  <UButton text="조회" type="is-search" />
                </div>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
      <!-- // 검색영역 -->
      <UMarkdownViewer :content="doc1_2" />
    </template>
  </VCard> 


  <VCard title="2. Title - 본문 타이틀"></VCard>
  <VCard>
    <template #text>
      <UBox class="columns" direction="row">
        <UItem class="card is-sub is-search" ratio="1" >
          <UBox class="card-header">
            <h1 class="page-title">
              <span>본문 제목</span>
            </h1>
          </UBox>
        </UItem>
      </UBox>
      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>

  <VCard title="2-1. Title - 컨텐츠 타이틀"></VCard>
  <VCard>
    <template #text>
      <UBox class="columns" direction="row">
        <UItem class="card is-sub" ratio="1" >
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>Contents Title</span>
              <span class="data-count">총<span>50</span>건</span>
            </h2>
            
            <UButtonBox class="table-buttons">
              <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
              <UButton text="엑셀 다운로드" icon="excel" />
              <UButton text="취소" type="is-outline" />
              <UButton text="저장" type="is-filled" />
            </UButtonBox>
          </UBox>

          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
          </WjFlexGrid>
        </UItem>
      </UBox>
      <UMarkdownViewer :content="doc2_1" />
    </template>
  </VCard>

</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { useWijmoGrid } from '#ustra/nuxt-wijmo/composables/wijmo'

// @ts-ignore
import doc_basic from './md/pub-layout-basic.md'
import doc1 from './md/pub-layout-1.md'
import doc1_1 from './md/pub-layout-1-1.md'
import doc1_2 from './md/pub-layout-1-2.md'

// @ts-ignore
import doc2 from './md/pub-layout-2.md';
import doc2_1 from './md/pub-layout-2-1.md';


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

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]

const itemsSourceGrid = ref([
  { col1: '텍스트' }, 
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
]);
</script>

<style>
.iconImage {
  width: 15px;
  height: 15px;
  margin-bottom: -3px;
  margin-right: 2px;
}
</style>
