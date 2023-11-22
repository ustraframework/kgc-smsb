<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">프로그램 검색</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="600" title="프로그램 검색">
    <UBox direction="col">
      <UItem :ratio="1" style="overflow: auto">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 170px;">
          </colgroup>
          <tbody>
            <tr>
              <th><span>프로그램ID/명</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th><span class="is-required">개인정보여부</span></th>
              <td>
                <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
              </td>
              <td>
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search"/>
                </div>
              </td>
            </tr>
          </tbody>
        </table>

        <div class="field-grid">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="대메뉴" binding="col1" width="*" />
            <WjFlexGridColumn header="중메뉴" binding="col1" width="*" />
            <WjFlexGridColumn header="프로그램ID" binding="col1" width="*" />
            <WjFlexGridColumn header="프로그래명" binding="col1" width="*" />
            <WjFlexGridColumn header="개인정보여부" binding="col1" width="*" />
          </WjFlexGrid>
        </div>
      </UItem>
      <UItem>
        <UButtonBox right top>
          <UButton text="닫기" type="secondary" :width="80" />
          <UButton text="확인" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
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

const items = [
{ value : '1' , text: 'item1'},
{ value : '2' , text: 'item2'},
]

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>