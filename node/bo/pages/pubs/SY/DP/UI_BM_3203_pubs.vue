<template>
  <div>
    <!-- 검색영역 -->
    <div class="columns has-gap">
      <UBox class="card is-sub is-search">
        <UItem class="card-body">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="기준일자" required>
                <UDateBox />
              </UField>
              <UField label="배너위치">
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </UField>
              <UField label="배너종류">
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, 1, '170px']">
              <UField label="배너명">
                <UTextBox />
              </UField>
              <UField blank />
              <UField blank />
              <UField blank />
            </UFieldRow>
          </UFieldSet>
        </UItem>
      </UBox>
    </div>
    <!-- // 검색영역 -->
  
    <div class="columns">
      <UBox direction="row">
        <!-- 좌측 영역 -->
        <UItem baseSize="500" class="gap-right">
          <UBox class="card is-sub" height="535px">
            <UItem class="card-body">
              <UBox class="table-title-wrap" direction="row">
                <UItem itemDirection="row" :ratio="1">
                  <h2 class="table-title">
                    <span class="data-count">총<span>100</span>건</span>
                  </h2>
                </UItem>
              </UBox>
  
              <UBox height="450px">
                <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
                  <WjFlexGridColumn header="No" binding="col1" width="*" />
                  <WjFlexGridColumn header="배너ID" binding="col1" width="*" />
                  <WjFlexGridColumn header="배너명" binding="col1" width="*" />
                  <WjFlexGridColumn header="배너종류" binding="col1" width="*" />
                </WjFlexGrid>
              </UBox>
            </UItem>
          </UBox>        
        </UItem>
  
        <!-- 우측 영역 -->
        <UItem ratio="1" class="gap-left">
          <UBox class="card is-sub" height="535px">
            <UItem class="card-body">
              <UBox class="table-title-wrap">
                <h2 class="table-title">
                  <span>배너 마스터</span>
                </h2>
              </UBox>

              <UFieldSet>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="배너ID" required><UTextBox></UTextBox></UField>
                  <UField label="배너명" required><UTextBox></UTextBox></UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="배너위치" required>
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField label="배너종류" required>
                    <URadioGroupBox v-model="radioValue" :itemsSource="radioItems" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="타겟대상" required>
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField label="사용여부" required>
                    <URadioGroupBox v-model="radioValue" :itemsSource="radioItems2" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="정렬순서" required>
                    <UTextBox />
                  </UField>
                  <UField></UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="적용기간">
                    <UDatePeriodBox v-model:start="start" v-model:end="end" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="배너설명"><UTextBox v-model="test" /></UField>
                </UFieldRow>
              </UFieldSet>
            </UItem>

            <UItem class="card-body">
              <UBox class="table-title-wrap">
                <h2 class="table-title">
                  <span>배너 마스터 상세내역</span>
                </h2>
              </UBox>
              
              <UBox height="125px">
                <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
                  <WjFlexGridColumn header="No" binding="col1" width="*" />
                  <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                  <WjFlexGridColumn header="채널" binding="col1" width="*" />
                  <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                </WjFlexGrid>
              </UBox>
            </UItem>
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
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  ]);

const radioItems = reactive([
  { value: 'pc', text: 'PC' },
  { value: 'mobile', text: '모바일' },
])

const radioItems2 = reactive([
  { value: 'y', text: '예' },
  { value: 'n', text: '아니오' },
])

</script>
<style lang="scss" scoped>

</style>