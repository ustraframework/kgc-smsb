<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Popup</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="900" :height="550" title="프로그램 검색">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-search">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="사번/성명" >
                <UTextBox />
              </UField>
              <UField label="부서코드/명" required>
                <UTextBox />
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UBox>
        
        <UBox height="250px">
          <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="소속" binding="col1" width="*" />
            <WjFlexGridColumn header="사번" binding="col1" width="*" />
            <WjFlexGridColumn header="성명" binding="col1" width="*" />
            <WjFlexGridColumn header="직위/직책" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
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

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>