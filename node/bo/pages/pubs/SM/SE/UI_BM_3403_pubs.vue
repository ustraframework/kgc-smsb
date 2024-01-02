<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search" ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="채널" required>
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="카테고리" required>
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="발송수단" required>
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 2, '170px']">
            <UField label="템플릿코드/명">
              <UTextBox />
            </UField>
            <UField label="제목">
              <UTextBox />
            </UField>
            <UField blank>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
    <!-- // 검색영역 --> 
  
    <UBox class="columns" direction="row">
      <UItem class="card is-sub" ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>Sub title</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="템플릿 등록" type="is-filled"/>
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="채널" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="발송유형" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="발송구분" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="템플릿 코드" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="템플릿명" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="발송수단" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="사용여부" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="등록일" binding="col1" width="*" align="center"/>
          <WjFlexGridColumn header="관리" binding="col1" width="*" align="center">
            <WjFlexGridCellTemplate cellType="Cell" >
              <UButton text="상세" />
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
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