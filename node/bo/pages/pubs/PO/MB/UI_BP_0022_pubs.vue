<template>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField required label="지사" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="매장코드/명" >
              <UBox>
                <UTextBox type="icon" />
                <UTextBox disabled/>
              </UBox>
            </UField>
            <UField required label="요청상태">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField required label="요청기간" >
              <UDatePeriodBox v-model="dateArr1" />
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>영수증포인트적립확정</span>
            <span class="data-count">총<span>100</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="반려" type="is-outline"/>
            <UButton text="승인" type="is-filled"/>
          </UButtonBox>
        </UBox>

        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="요청일자" binding="col1" width="*" />
            <WjFlexGridColumn header="요청매장" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트유형그룹요청상태코드" binding="col1" width="*" />
            <WjFlexGridColumn header="판매일자" binding="col1" width="*" />
            <WjFlexGridColumn header="POS기기" binding="col1" width="*" />
            <WjFlexGridColumn header="영수증번호" binding="col1" width="*" />
            <WjFlexGridColumn header="판매분류" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />            <WjFlexGridColumn header="연락처" binding="col1" width="*" />
            <WjFlexGridColumn header="매출금액" binding="col1" width="*" />
            <WjFlexGridColumn header="매출수량" binding="col1" width="*" />
            <WjFlexGridColumn header="적립POINT" binding="col1" width="*" />
            <WjFlexGridColumn header="사유" binding="col1" width="*" />
            <WjFlexGridColumn header="처리내역" binding="col1" width="*" />
            <WjFlexGridColumn header="처리일자" binding="col1" width="*" />
            <WjFlexGridColumn header="확정자명" binding="col1" width="*" />
            <WjFlexGridColumn header="구매내역" binding="col1" width="*" />
            <WjFlexGridColumn header="영수내용" binding="col1" width="*" />

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
              <span>영수증포인트적립확정 상세</span>
          </h2>
        </UBox>
        
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField required label="영수증바코드번호">
                <UTextBox type="icon" />
            </UField>
            <UField required label="판매일자">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField required label="매출금액">
              <UTextBox disabled/>
            </UField>
            <UField required label="POS기기">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField required label="적립POINT">
              <UTextBox disabled/>
            </UField>
            <UField required label="영수증번호">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField required label="매출수량">
              <UTextBox disabled/>
            </UField>
            <UField label="">
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField required label="회원번호/명">
              <UBox>
                <UTextBox type="icon" style="width: 200px"/>
                <UTextBox disabled></UTextBox>
              </UBox>
            </UField>
            <UField label="요청상태">
              <UTextBox readonly/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="요청사유">
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

// const items = [
// { value : '1' , text: 'item1'},
// { value : '2' , text: 'item2'},
// ]


</script>

<style lang="scss" scoped>

</style>