<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">회원 마스터 조회(팝업)</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1100" :height="630" title="임직원 검색">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-search" style="margin-bottom: 10px;">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="지사" >
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField label="매장코드/명">
                <UTextBox type="icon"></UTextBox>
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="고객번호/명" required>
                <UTextBox />
              </UField>
              <UField label="핸드폰번호">
                <UTextBox />
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="카드번호" required>
                <UTextBox />
              </UField>
              <UField label="등급">
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              </UFieldRow>
           </UFieldSet>
        </UBox>

        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>9</span>건</span>
          </h2>
        </UBox>

        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 208px;">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="고객번호" binding="col1" width="*" />
          <WjFlexGridColumn header="고객명" binding="col1" width="*" />
          <WjFlexGridColumn header="카드번호" binding="col1" width="*" />
          <WjFlexGridColumn header="본부" binding="col1" width="*" />
          <WjFlexGridColumn header="매장명" binding="col1" width="*" />
          <WjFlexGridColumn header="생년월일" binding="col1" width="*" />
          <WjFlexGridColumn header="핸드폰번호" binding="col1" width="*" />
          <WjFlexGridColumn header="등급" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="적용" type="is-filled"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
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

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)

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
]);


const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
];

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>