<template>
<div>
  <UBox class="columns" direction="row">
    <UItem class="card is-sub is-search" ratio="1" >
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="수행업무" required>
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="열람일자" required>
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
            <UField blank></UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search" />
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="프로그램ID/명">
              <UBox>
                <UTextBox type="icon"></UTextBox>
                <UTextBox disabled/>
              </UBox>
            </UField>
            <UField label="열람자ID/명">
              <UBox>
                <UTextBox type="icon"></UTextBox>
                <UTextBox disabled/>
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
          <span class="data-count">총<span>24</span>건</span>
        </h2>
        
        <UButtonBox class="table-buttons">
          <UButton text="엑셀 다운로드" icon="excel" />
        </UButtonBox>
      </UBox>
      
      <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 438px;">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="수행업무" binding="col1" width="*" />
        <WjFlexGridColumn header="프로그램ID" binding="col1" width="*" />
        <WjFlexGridColumn header="프로그램명" binding="col1" width="*" />
        <WjFlexGridColumn header="열람자 ID" binding="col1" width="*" />
        <WjFlexGridColumn header="열람자명" binding="col1" width="*" />
        <WjFlexGridColumn header="열람일시" binding="col1" width="*" />
        <WjFlexGridColumn header="열람IP" binding="col1" width="*" />
        <WjFlexGridColumn header="이용목적" binding="col1" width="*" />
        <WjFlexGridColumn header="이용사유" binding="col1" width="*" />
      </WjFlexGrid>
    </UItem>
  </UBox>
</div>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})

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

const items = [
  { value: '1', text: 'item1' },
  { value: '2', text: 'item2' },
]

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
  { col1: '텍스트' }, 
  { col1: '텍스트2' }, 
  { col1: '텍스트3' },
]);

</script>

<style lang="scss" scoped></style>
