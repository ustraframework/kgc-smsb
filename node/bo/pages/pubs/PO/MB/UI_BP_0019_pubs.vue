<template>
<div>
  <UBox class="columns" direction="row">
    <UItem class="card is-sub is-search" ratio="1" >
      <UFieldSet class="is-search">
        <UFieldRow :ratio="[1, 1, 1, '170px']">
          <UField label="회원번호/명" required>
            <UBox>
              <UTextBox type="icon"/>
              <UTextBox/>
            </UBox>
          </UField>
          <UField blank />
          <UField blank />
          <UField blank>
            <div class="search-btn">
              <UButton text="조회" type="is-search"/>
            </div>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>

  <!-- ------------------------------------------------------------------ -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>회원정보</span>
        </h2>
      </UBox>
      
      <UFieldSet>
        <UFieldRow>
          <UField label="통합회원번호">
            <span>00006377</span>
          </UField>
          <UField label="회원상태">
            <span>가망/입문/활성화/이탈/탈퇴</span>
          </UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="회원명">
            <span>이순정</span>
          </UField>
          <UField label="회원정보">
            <span>010-0000-0000</span>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>

  <!-- ------------------------------------------------------------------ -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span>포인트지급 정보</span>
          <span class="data-count">총<span>2</span>건</span>
        </h2>
      </UBox>
      
      <WjFlexGrid :itemsSource="itemsSourceGrid">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="지급일자" binding="col1" width="*" />
        <WjFlexGridColumn header="지급방법" binding="col1" width="*" />
        <WjFlexGridColumn header="지급사유" binding="col1" width="*" />
        <WjFlexGridColumn header="비고(고객노출용)" binding="col1" width="*" />
        <WjFlexGridColumn header="유효기간" binding="col1" width="*" />
        <WjFlexGridColumn header="추가포인트" binding="col1" width="*" />
      </WjFlexGrid>
    </UItem>
  </UBox>

  <!-- ------------------------------------------------------------------ -->
  <UBox class="columns" direction="row">
    <UItem class="card is-sub" ratio="1" >
      <UBox class="table-title-wrap">
        <h2 class="table-title">
            <span>포인트지급 정보 상세</span>
        </h2>
      </UBox>
      
      <UFieldSet>
        <UFieldRow>
          <UField label="회원번호" required>
            <UTextBox disabled/>
          </UField>
          <UField label="회원명" required>
            <UTextBox disabled/>
          </UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="포인트유형구분" required>
            <UWjComboBox :itemsSource="items" displayMemberPath="text" />
          </UField>
          <UField label="차감가능포인트">
            <UTextBox disabled/>
          </UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="유효기간">
            <UWjComboBox :itemsSource="items" displayMemberPath="text" />
          </UField>
          <UField label="적용포인트">
            <UTextBox/>
          </UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="지급사유">
            <UTextBox/>
          </UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="비고(고객노출용)" required>
            <UTextBox/>
          </UField>
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
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>

</style>