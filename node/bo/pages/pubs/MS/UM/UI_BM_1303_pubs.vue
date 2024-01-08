<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search" ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[2, 2, 1, '170px']">
              <UField required label="처리상태" >
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
              </UField>
              <UField required label="회원구분" >
                <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
              </UField>
              <UField blank></UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[2, 2, 1, '170px']">
              <UField label="관리매장코드/명" >
                <UBox>
                  <UTextBox type="icon"></UTextBox>
                  <UTextBox disabled></UTextBox>
                </UBox>
              </UField>
              <UField label="회원번호/명" >
                <UBox>
                  <UTextBox type="icon"></UTextBox>
                  <UTextBox disabled></UTextBox>
                </UBox>
              </UField>
              <UField blank></UField>
              <UField blank></UField>
            </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
    <!-- // 검색영역 --> 
  
    <!-- ------------------------------------------------------------------ -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>50</span>건</span>
          </h2>
          
          <UButtonBox class="table-buttons">
            <UButton text="부정회원 확정" type="is-outline" />
            <UButton text="부정회원 취소" type="is-outline" />
            <UButton text="부정회원 소명" type="is-outline" />
            <UButton text="리셀러 확정" type="is-outline" />
            <UButton text="리셀러 취소" type="is-outline" />
            <UButton text="리셀러 소명" type="is-outline" />
            <UButton text="삭제" type="is-outline" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid" :isReadOnly="true">
          <WjFlexGridColumn header="선택" binding="col1" width="*" align="center">
            <WjFlexGridCellTemplate cellType="Cell">
              <div style="margin-top: 10px;">
                <UCheckGroupBox :items-source="[{ text: '' }]" style="width:16px; margin-right: 0;" />
              </div>
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
          <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
          <WjFlexGridColumn header="회원명" binding="col1" width="*" />
          <WjFlexGridColumn header="회원 유형" binding="col1" width="*" />
          <WjFlexGridColumn header="회원 구분" binding="col1" width="*" />
          <WjFlexGridColumn header="관리매장" binding="col1" width="*" />
          <WjFlexGridColumn header="처리상태" binding="col1" width="*" />
          <WjFlexGridColumn header="처리단계" binding="col1" width="*" />
          <WjFlexGridColumn header="승인상태" binding="col1" width="*" />
          <WjFlexGridColumn header="산정기간 (From)" binding="col1" width="*" />
          <WjFlexGridColumn header="산정기간 (To)" binding="col1" width="*" />
          <WjFlexGridColumn header="작업일시" binding="col1" width="*" />
          <WjFlexGridColumn header="구매이력" binding="col1" width="*">
            <WjFlexGridCellTemplate cellType="Cell" >
              <UButton text="이력보기" />
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
          <WjFlexGridColumn header="이력보기" binding="col1" width="*">
            <WjFlexGridCellTemplate cellType="Cell" >
              <UButton text="이력보기" />
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
        </WjFlexGrid>
      </UItem>
    </UBox>
    <!-- ------------------------------------------------------------------ -->
    
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>처리단계</span>
          </h2>

          <UButtonBox class="table-buttons">
            <UButton text="처리" type="is-filled" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid" :isReadOnly="true">
          <WjFlexGridColumn header="순번" binding="col1" width="*" />
          <WjFlexGridColumn header="처리단계" binding="col1" width="*" />
          <WjFlexGridColumn header="조직코드" binding="col1" width="*" />
          <WjFlexGridColumn header="조직명" binding="col1" width="*" />
          <WjFlexGridColumn header="담당자 사번" binding="col1" width="*" />
          <WjFlexGridColumn header="담당자명" binding="col1" width="*" />
          <WjFlexGridColumn header="승인상태" binding="col1" width="*" />
          <WjFlexGridColumn header="의견" binding="col1" width="*" />
          <WjFlexGridColumn header="처리일시" binding="col1" width="*" />
        </WjFlexGrid>  
      </UItem>
    </UBox>
  </div>
  </template>
  
  <script setup>
  import { WjComboBox } from '#ustra/nuxt-wijmo/components'
  import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'; 

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
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
]);
  
const solarItems = reactive([
{ value: '1', text: '부정회원' },
{ value: '2', text: '리셀러' },
]);
const solarValue = ref('1');
  </script>
  
  <style lang="scss" scoped>
  
  </style>