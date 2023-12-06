<template>
<div>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="유형코드" ><UTextBox></UTextBox></UField>
            <UField label="유형코드명" ><UTextBox></UTextBox></UField>
            <UField label="적용기간">
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="신규" type="is-outline"/>
            <UButton text="삭제" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
        
        
        <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
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
  </div>
  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
              <span>상세내역</span>
          </h2>
        </UBox>
        
        <UFieldSet class="is-large">
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="포인트유형코드"><UTextBox/></UField>
            <UField label="유형코드명"><UTextBox/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="포인트유형구분코드"><UTextBox/></UField>
            <UField label="포인트유형구분코드명"><UTextBox/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="원거래포인트유형사유코드"><UTextBox/></UField>
            <UField label="원거래포인트유형사유코드명"><UTextBox/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="포인트유형사유코드"><UTextBox/></UField>
            <UField label="포인트유형사유코드명"><UTextBox/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="적용시작일자"><UDateBox mode="date"/></UField>
            <UField label="적용종료일자"><UDateBox mode="date"/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="유효기간개월수"><UWjComboBox :itemsSource="items" displayMemberPath="text"/></UField>
            <UField label="적용종료일자"></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록일자"><UTextBox disabled></UTextBox></UField>
            <UField label="등록IP"><UTextBox disabled></UTextBox></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록사번"><UTextBox disabled></UTextBox></UField>
            <UField label="수정일자"><UTextBox disabled></UTextBox></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="수정IP"><UTextBox disabled></UTextBox></UField>
            <UField label="수정ID"><UTextBox disabled></UTextBox></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
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