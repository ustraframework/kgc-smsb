<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원정보 변경 이력 조회</span>
      </h1>
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>description</span>
        </h2>
      </div>
    </div>
    <div class="card-body">
      <form action="" class="form">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 170px;">
          </colgroup>
          <tbody>
            <tr>
              <th><span>유형코드</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th><span>유형코드명</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th><span>적용기간</span></th>
              <td>
                <UDatePeriodBox v-model:start="start" v-model:end="end" />
              </td>
              <td rowspan="2">
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search"/>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>상세내역</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <div class="buttons">
            <UButton text="신규" type="is-outline"/>
            <UButton text="삭제" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </div>
        </div>
        
        <div class="field-grid">
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
        </div>
      </div>
    </div>
  </div>
  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
              <span>상세내역</span>
          </h2>
        </div>
        
        <UFieldSet class="is-large">
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="포인트유형코드">01</UField>
            <UField label="유형코드명">매출포인트</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="포인트유형구분코드">A</UField>
            <UField label="포인트유형구분코드명">적립</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="원거래포인트유형사유코드">01</UField>
            <UField label="원거래포인트유형사유코드명">매출포인트</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="포인트유형사유코드">A</UField>
            <UField label="포인트유형사유코드명">적립</UField>
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