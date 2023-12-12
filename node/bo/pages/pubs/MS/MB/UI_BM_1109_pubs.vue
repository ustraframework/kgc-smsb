<template>
<div>
  <UBox class="columns" direction="row">
    <UItem class="card is-sub is-search" ratio="1" >
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, '500px', 1, '170px']">
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
        <UFieldRow :ratio="[1, '500px', 1, '170px']">
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

  <!-- ------------------------------------------------------------------ -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span class="data-count">총<span>50</span>건</span>
        </h2>
        
        <UButtonBox class="table-buttons">
          <UButton text="엑셀 다운로드" icon="excel" />
        </UButtonBox>
      </UBox>
      
      <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 438px">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
        <WjFlexGridColumn header="회원명" binding="col1" width="*" />
        <WjFlexGridColumn header="회원유형" binding="col1" width="*" />
        <WjFlexGridColumn header="항목구분" binding="col1" width="*" />
        <WjFlexGridColumn header="항목구분명" binding="col1" width="*" />
        <WjFlexGridColumn header="변경이전 값" binding="col1" width="*" />
        <WjFlexGridColumn header="변경이후 값" binding="col1" width="*" />
        <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
        <WjFlexGridColumn header="변경자" binding="col1" width="*" />
        <WjFlexGridColumn header="변경일시" binding="col1" width="*" />
        <WjFlexGridColumn header="변경자IP" binding="col1" width="*" />
      </WjFlexGrid>
    </UItem>
  </UBox>
</div>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

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
  layout: 'ustra-pub',
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
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
  { col1: '텍스트' }, 
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
  { col1: '텍스트' }, 
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
  { col1: '텍스트' }, 
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
  { col1: '텍스트' }, 
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
]);
</script>

<style lang="scss" scoped></style>
