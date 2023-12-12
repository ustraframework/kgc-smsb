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

  
  <UBox class="columns" direction="row" height="570">
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
      
      <WjFlexGrid :itemsSource="itemsSourceGrid">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
        <WjFlexGridColumn header="채널" binding="col1" width="*" />
        <WjFlexGridColumn header="회원명" binding="col1" width="*" />
      </WjFlexGrid>
    </UItem>
    
    <!-- 우측 영역 -->
    <UItem class="card is-sub" ratio="8">
      <!-- UBox1 -->
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>Sub title</span>
        </h2>
        <UButtonBox class="table-buttons">
          <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
          <UButton text="엑셀 다운로드" icon="excel" />
          <UButton text="취소" type="is-outline" />
          <UButton text="저장" type="is-filled" />
        </UButtonBox>
      </UBox>

      <UFieldSet>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="회원번호"><UTextBox></UTextBox></UField>
          <UField label="회원명"><UTextBox></UTextBox></UField>
          <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text"/></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="잔여포인트"><UTextBox></UTextBox></UField>
          <UField label="탈퇴일자"><UDateBox mode="date"/></UField>
          <UField label="삭제예정일자"><UDateBox mode="date"/></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="탈퇴사유"><UTextBox></UTextBox></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="복원사유"><UTextBox type="textarea" v-model="test" /></UField>
        </UFieldRow>
      </UFieldSet>

      <!-- UBox2 -->
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>Sub title</span>
        </h2>
      </UBox>
      
      <WjFlexGrid :itemsSource="itemsSourceGrid">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
        <WjFlexGridColumn header="채널" binding="col1" width="*" />
        <WjFlexGridColumn header="회원명" binding="col1" width="*" />
      </WjFlexGrid>
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