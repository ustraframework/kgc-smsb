<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원정보 변경 이력 조회</span>
      </h1>
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>회원의 인증 이력을 조회합니다.</span>
        </h2>
      </div>
    </div>
    <div class="card-body">
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, 1, 1, '170px']">
          <UField label="사용채널" ><WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" /></UField>
          <UField label="인증일자" ><UDatePeriodBox v-model:start="start" v-model:end="end" /></UField>
          <UField label="인증채널" ><UTextBox /></UField>
          <UField blank>
            <div class="search-btn">
              <UButton text="조회" type="is-search"/>
            </div>
          </UField>
        </UFieldRow>
        <UFieldRow :ratio="[1, 1, 1, '170px']">
          <UField label="회원번호/명">
            <UBox>
              <UTextBox type="icon"/>
              <UTextBox></UTextBox>
            </UBox>
          </UField>
          <UField blank />
          <UField blank />
          <UField blank />
        </UFieldRow>
      </UFieldSet>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <div class="buttons">
            <UButton text="엑셀 다운로드" icon="excel" />
          </div>
        </div>
        
        <div class="field-grid">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
            <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
            <WjFlexGridColumn header="수정자" binding="col1" width="*" />
            <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
          </WjFlexGrid>
        </div>
      </div>
    </div>
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