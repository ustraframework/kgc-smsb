<template>
<div>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="포인트유형" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField label="채널" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField label="제품유형">
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
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
            <span class="data-count">총<span>9</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="신규" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
        
        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트유형" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="제품유형" binding="col1" width="*" />
            <WjFlexGridColumn header="사용가능여부" binding="col1" width="*" />
            <WjFlexGridColumn header="적용시작일자" binding="col1" width="*" />
            <WjFlexGridColumn header="적용종료일자" binding="col1" width="*" />
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
              <span>상세내역</span>
          </h2>
        </UBox>
        
        <UFieldSet class="is-large">
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="포인트유형" required>
              <UTextBox/>
            </UField>
            <UField label="채널" required>
              <UTextBox/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="제품유형" required>
              <UTextBox/>
            </UField>
            <UField label="사용가능여부" required>
              <UTextBox/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="적용시작일자" required>
              <UDateBox mode="date"/>
            </UField>
            <UField></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록IP">
              <span>127.0.0.1</span>
            </UField>
            <UField label="등록일시">
              <span>2023-01-01 00:00:00</span>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="수정IP">
              <span>127.0.0.1</span>
            </UField>
            <UField label="수정일시">
              <span>2023-01-01 00:00:00</span>
            </UField>
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

</script>

<style lang="scss" scoped>

</style>