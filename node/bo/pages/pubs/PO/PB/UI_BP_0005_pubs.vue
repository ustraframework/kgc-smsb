<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search" ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="채널" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField label="가맹점구분" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField></UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
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
            <span>col12</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          
          <UButtonBox class="table-buttons">
            <UButton text="신규" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="채널구분" binding="col1" width="*" />
          <WjFlexGridColumn header="가맹점구분" binding="col1" width="*" />
          <WjFlexGridColumn header="본사분담률" binding="col1" width="*" />
          <WjFlexGridColumn header="가맹점분담률" binding="col1" width="*" />
          <WjFlexGridColumn header="제휴사분담률" binding="col1" width="*" />
          <WjFlexGridColumn header="적용시작일자" binding="col1" width="*" />
          <WjFlexGridColumn header="적용종료일자" binding="col1" width="*" />
          <WjFlexGridColumn header="이력보기" binding="col1" width="*" />
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
        
        <UFieldSet class="is-large">
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="채널" required>
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField label="가맹점구분" required>
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="적용시작일자" required><UDateBox mode="date"/></UField>
            <UField label="본사분담율" required><UTextBox/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="가맹점분담율" required><UTextBox/></UField>
            <UField label="제휴사분담율" required><UTextBox/></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록일시">2023-01-01 00:00:00</UField>
            <UField label="수정일시">2023-01-01 00:00:00</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록ID">20080115</UField>
            <UField label="수정ID">20080115</UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록IP">127.0.0.1</UField>
            <UField label="수정IP">127.0.0.1</UField>
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