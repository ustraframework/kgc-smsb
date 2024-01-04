<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search" ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[2, 2, 1, '170px']">
            <UField required label="적용일자" >
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
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
  
    <!-- ------------------------------------------------------------------ -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>50</span>건</span>
          </h2>
          
          <UButtonBox class="table-buttons">
            <UButton text="신규" type="is-outline" />
            <UButton text="저장" type="is-filled" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="적용기간 (From)" binding="col1" width="*" />
          <WjFlexGridColumn header="적용기간 (To)" binding="col1" width="*" />
          <WjFlexGridColumn header="산정기준" binding="col1" width="*" />
          <WjFlexGridColumn header="기준1 타겟특화 브랜드" binding="col1" width="*" />
          <WjFlexGridColumn header="기준1 수량" binding="col1" width="*" />
          <WjFlexGridColumn header="기준2 구매일수" binding="col1" width="*" />
          <WjFlexGridColumn header="기준3 뿌리삼" binding="col1" width="*" />
          <WjFlexGridColumn header="비고" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
    </UBox>
    <!-- ------------------------------------------------------------------ -->
    
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>상세정보</span>
          </h2>
        </UBox>
        
        <UFieldSet class="is-large">
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[2,1]">
            <UField required label="적용기간">
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
            <UField required label="산정기준">
              <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1,1,1]">
            <UField required label="타겟특화 브랜드">
                <UTextBox type="icon"></UTextBox> 
            </UField>
            <UField required label="수량">
              <UBox>
                <UTextBox></UTextBox> 
                <span class="desc">개 이상</span>
              </UBox>
            </UField>
            <UField label=""></UField>
          </UFieldRow>
          <UFieldRow :ratio="[1,1,1]">
            <UField required label="구매일수">
              <UBox>
                <UTextBox></UTextBox> 
                <span class="desc">개 이상</span>
              </UBox>
            </UField>
            <UField required label="뿌리삼">
              <UBox>
                <UTextBox></UTextBox> 
                <span class="desc">개 이상</span>
              </UBox>
            </UField>
            <UField label=""></UField>
          </UFieldRow>
          <UFieldRow :ratio="[3]">
            <UField label="비고">
              <UTextBox type="textarea" v-model="test" />
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
  
  </script>
  
  <style lang="scss" scoped>
  
  </style>