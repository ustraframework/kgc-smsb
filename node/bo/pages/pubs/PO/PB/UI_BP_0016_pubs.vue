<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search" ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[2, 2, 1, '170px']">
            <UField label="지사" ><UTextBox></UTextBox></UField>
            <UField label="매장코드" >
              <UBox>
                <UTextBox type="icon" width="200" />
                <UTextBox/>
              </UBox>
            </UField>
            <UField></UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[2,2,1, '170px']">
            <UField label="조회기간">
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
            <UField></UField>
            <UField></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
    <!-- /검색영역 -->
  
    <!-- ------------------------------------------------------------------ -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>24</span>건</span>
          </h2>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="승인일자" binding="col1" width="*" />
          <WjFlexGridColumn header="승인번호" binding="col1" width="*" />
          <WjFlexGridColumn header="대표승인번호" binding="col1" width="*" />
          <WjFlexGridColumn header="발생일자" binding="col1" width="*" />
          <WjFlexGridColumn header="제휴사승인번호" binding="col1" width="*" />
          <WjFlexGridColumn header="카드번호" binding="col1" width="*" />
          <WjFlexGridColumn header="발생구분코드" binding="col1" width="*" />
          <WjFlexGridColumn header="관련번호" binding="col1" width="*" />
          <WjFlexGridColumn header="발생유형구분코드" binding="col1" width="*" />
          <WjFlexGridColumn header="포인트" binding="col1" width="*" />
          <WjFlexGridColumn header="총매출금액" binding="col1" width="*" />
          <WjFlexGridColumn header="순매출금액" binding="col1" width="*" />
          <WjFlexGridColumn header="비고" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
    </UBox>
  
    <!-- ------------------------------------------------------------------ -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
              <span>상세내역</span>
          </h2>
        </UBox>
        
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="승인일자">2022-02-22</UField>
            <UField label="승인번호">12345678</UField>
            <UField label="대표승인번호">12345678</UField>
            <UField label="발생일자">2022-02-22</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="제휴사 승인번호">987654321</UField>
            <UField label="카드번호">3452-****-****-4521</UField>
            <UField label="발생구분코드">1010</UField>
            <UField label="관련번호">1322</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="발생유형코드">1010</UField>
            <UField label="포인트">1,000</UField>
            <UField label="총매출금액">10,000</UField>
            <UField label="순매출금액">10,000</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="매장코드">12345</UField>
            <UField label="매장분담금액">500</UField>
            <UField label="적립한도초과여부">N</UField>
            <UField label="적립요청포인트">1,000</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="원거래승인일자">-</UField>
            <UField label="원거래승인번호">-</UField>
            <UField label="주문번호">23456789</UField>
            <UField label="조회가능여부">Y</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="취소일자">-</UField>
            <UField label="프로모션번호">-</UField>
            <UField label="시스템코드">GB01</UField>
            <UField label="지급사유명">적립</UField>
          </UFieldRow>
          <UFieldRow :ratio="[4]">
            <UField label="비고">-</UField>
          </UFieldRow>
          <UFieldRow :ratio="[1,1,2]">
            <UField label="등록일시">2022/02/22 16:43:55</UField>
            <UField label="등록ID">20080115</UField>
            <UField label="등록IP">10.0.0.1</UField>
          </UFieldRow>
          <UFieldRow :ratio="[1,1,2]">
            <UField label="수정일자">2022/02/22 16:43:55</UField>
            <UField label="수정사번">20080115</UField>
            <UField label="수정IP">10.0.0.1</UField>
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