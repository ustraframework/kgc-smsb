<template>
<div>
  <!-- 검색영역 -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub is-search" ratio="1" >
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, 1, 1, '170px']">
          <UField label="검색영역" ><UTextBox></UTextBox></UField>
          <UField blank></UField>
          <UField blank></UField>
          <UField blank>
            <div class="search-btn">
              <UButton text="조회" type="is-search"/>
            </div>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>
  <!-- // 검색영역 --> 

  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>Sub title</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
        <UButtonBox class="table-buttons">
          <UButton text="처리" type="is-outline"/>
          <UButton text="취소" type="is-outline"/>
          <UButton text="저장" type="is-filled"/>
        </UButtonBox>
      </UBox>
      
      <WjFlexGrid :itemsSource="itemsSourceGrid">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="포인트유형코드" binding="col1" width="*" />
        <WjFlexGridColumn header="유형코드명" binding="col1" width="*" />
        <WjFlexGridColumn header="유형구분코드" binding="col1" width="*" />
        <WjFlexGridColumn header="유형구분코드명" binding="col1" width="*" />
        <WjFlexGridColumn header="적용시작일자" binding="col1" width="*" />
        <WjFlexGridColumn header="적용종료일자" binding="col1" width="*" />
        <WjFlexGridColumn header="유효기간개월수" binding="col1" width="*" />
      </WjFlexGrid>
    </UItem>
  </UBox>

  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>Sub title</span>
        </h2>
        <UButtonBox class="table-buttons">
          <UButton text="처리" type="is-outline"/>
          <UButton text="취소" type="is-outline"/>
          <UButton text="저장" type="is-filled"/>
        </UButtonBox>
      </UBox>
      <UFieldSet>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="DI"><UTextBox></UTextBox></UField>
          <UField label="카드번호"><UTextBox></UTextBox></UField>
          <UField label="ID"><UTextBox></UTextBox></UField>
          <UField label="PWD"><UTextBox></UTextBox></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="DI"><UTextBox></UTextBox></UField>
          <UField label="카드번호"><UTextBox></UTextBox></UField>
          <UField label="ID"><UTextBox></UTextBox></UField>
          <UField label="PWD"><UTextBox></UTextBox></UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>
</div>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub'
})
const { collectionView, loadPageData, pageSize, totalRecords, currentPageNo } = usePaginationCollectionView((pageNo, orders) => {
  return useOnError(
    async () => {
      const service = useUstraInterfaceService()
      const result = await service.getIntefaceHistories({
        header: {
          currentPage: pageNo,
          pageSize: pageSize.value,
          orders,
        },
        searchValue: {},
      })
      return {
        data: result.body,
        totalRecords: result.header.totalRecords,
      }
    },
    { message: '데이터 조회 중 오류가 발생하였습니다.' },
  )()
})

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>

</style>