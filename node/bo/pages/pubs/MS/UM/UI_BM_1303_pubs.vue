<template>
  <div>
    <!-- 검색영역 -->
    <div class="columns has-gap">
      <UBox class="card is-sub is-search">
        <UItem class="card-body">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField required label="작업일자" >
                <UDatePeriodBox v-model:start="start" v-model:end="end" />
              </UField>
              <UField required label="회원구분" >
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
              </UField>
              <UField required label="처리상태" >
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField required label="회원번호/명" >
                <UBox>
                  <UTextBox type="icon"></UTextBox>
                  <UTextBox></UTextBox>
                </UBox>
                </UField>
              <UField blank></UField>
              <UField blank></UField>
              <UField blank></UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
    </div>
    <!-- // 검색영역 --> 
  
    <!-- ------------------------------------------------------------------ -->
    <div class="columns has-gap">
      <UBox class="card is-sub">
        <UItem class="card-body">
          <UBox class="table-title-wrap">
              <h2 class="table-title">
                <span class="data-count">총<span>24</span>건</span>
              </h2>
              <UButtonBox class="table-buttons">
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" style="width: 150px !important"  />
               <UButton text="처리" type="primary" />
              </UButtonBox>
            </UBox>
            
            <UBox>
              <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="선택" binding="col1" width="*" />
                <WjFlexGridColumn header="작업일자" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="회원 유형" binding="col1" width="*" />
                <WjFlexGridColumn header="회원 구분" binding="col1" width="*" />
                <WjFlexGridColumn header="처리상태" binding="col1" width="*" />
                <WjFlexGridColumn header="처리단계" binding="col1" width="*" />
                <WjFlexGridColumn header="승인상태" binding="col1" width="*" />
                <WjFlexGridColumn header="산정기간 (From)" binding="col1" width="*" />
                <WjFlexGridColumn header="산정기간 (To)" binding="col1" width="*" />
                <WjFlexGridColumn header="산정기준" binding="col1" width="*" />
                <WjFlexGridColumn header="구매이력" binding="col1" width="*" />
                <WjFlexGridColumn header="이력보기" binding="col1" width="*" />
              </WjFlexGrid>
            </UBox>
        </UItem>
      </UBox>
    </div>
    <!-- ------------------------------------------------------------------ -->
    <div class="columns has-gap">
      <UBox class="card is-sub">
        <UItem class="card-body">
          <UBox class="table-title-wrap">
              <h2 class="table-title">
                <span>처리단계</span>
              </h2>
            </UBox>
            
            <UBox>
              <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="순번" binding="col1" width="*" />
                <WjFlexGridColumn header="승인단계" binding="col1" width="*" />
                <WjFlexGridColumn header="조직코드" binding="col1" width="*" />
                <WjFlexGridColumn header="조직명" binding="col1" width="*" />
                <WjFlexGridColumn header="담당자 사번" binding="col1" width="*" />
                <WjFlexGridColumn header="담당자명" binding="col1" width="*" />
                <WjFlexGridColumn header="승인상태" binding="col1" width="*" />
                <WjFlexGridColumn header="의견" binding="col1" width="*" />
                <WjFlexGridColumn header="업무처리" binding="col1" width="*" />
              </WjFlexGrid>
            </UBox>
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