<template>
  <div>
    <div class="columns has-gap">
      <UBox class="card is-sub is-search">
        <UItem class="card-body">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="채널" >
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField label="약관유형" >
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField label="약관ID/명" >
                <UTextBox></UTextBox>
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="기준일자" >
                <UDateBox mode="date" />
              </UField>
              <UField blank>
              </UField>
              <UField blank>
              </UField>
              <UField blank>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
    </div>
  
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
          
          <UBox>
            <WjFlexGrid :itemsSource="itemsSourceGrid">
              <WjFlexGridColumn header="No" binding="col1" width="*" />
              <WjFlexGridColumn header="채널" binding="col1" width="*" />
              <WjFlexGridColumn header="약관유형" binding="col1" width="*" />
              <WjFlexGridColumn header="약관ID" binding="col1" width="*" />
              <WjFlexGridColumn header="약관명" binding="col1" width="*" />
              <WjFlexGridColumn header="약관버전" binding="col1" width="*" />
              <WjFlexGridColumn header="필수동의여부" binding="col1" width="*" />
              <WjFlexGridColumn header="적용시작일자" binding="col1" width="*" />
              <WjFlexGridColumn header="적용종료일자" binding="col1" width="*" />
              <WjFlexGridColumn header="약관내용" binding="col1" width="*" />
            </WjFlexGrid>
          </UBox>
        </UItem>
      </UBox>
    </div>
  
    <div class="columns has-gap">
      <UBox class="card is-sub">
        <UItem class="card-body">
          <UBox class="table-title-wrap">
            <h2 class="table-title">
              <span>이용약관 상세정보</span>
            </h2>
          </UBox>
  
          <UFieldSet>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow>
              <UField required label="채널">
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField required label="약관유형">
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField required label="약관ID"><UTextBox></UTextBox></UField>
            </UFieldRow>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow>
              <UField required label="약관명">
                <UTextBox></UTextBox>
              </UField>
              <UField required label="약관버전">
                <UTextBox></UTextBox>
              </UField>
              <UField required label="필수동의여부">
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
            </UFieldRow>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow :ratio="[2, 1]">
              <UField required label="적용기간">
                <UDatePeriodBox v-model:start="start" v-model:end="end" />
              </UField>
              <UField></UField>
            </UFieldRow>
            <!-- ------------------------------------------------------------------ -->
            <UFieldRow>
              <UField required label="약관내용">
                <UCkEditor5 v-model="content" :height="300" :disabled="disabled" :initialized="ckEditor.initialize" /></UField>
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
  
  const ckEditor = useUstraCkEditor5()
  
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