<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">임직원 검색</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="310" title="임직원 검색">
    <UBox direction="col">
      <UItem :ratio="3" class="pop-contents">
        <div class="columns is-shuffle">
          <div class="field-grid">
            <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
              <WjFlexGridColumn header="No" binding="col1" width="*" />
              <WjFlexGridColumn header="소속" binding="col1" width="*" />
              <WjFlexGridColumn header="사번" binding="col1" width="*" />
              <WjFlexGridColumn header="성명" binding="col1" width="*" />
              <WjFlexGridColumn header="직위/직책" binding="col1" width="*" />
            </WjFlexGrid>
          </div>
          
          <div class="buttons">
            <UButton icon="arr-left" />
            <UButton icon="arr-right" />
          </div>

          <div class="field-grid">
            <WjFlexGrid class="column-grid" :itemsSource="itemsSourceGrid">
              <WjFlexGridColumn header="No" binding="col1" width="*" />
              <WjFlexGridColumn header="소속" binding="col1" width="*" />
              <WjFlexGridColumn header="사번" binding="col1" width="*" />
              <WjFlexGridColumn header="성명" binding="col1" width="*" />
              <WjFlexGridColumn header="직위/직책" binding="col1" width="*" />
            </WjFlexGrid>
          </div>
        </div>

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
]);

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>