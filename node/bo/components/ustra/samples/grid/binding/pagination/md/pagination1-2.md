```html
<template>
  <UButton type="primary" text="Search" @click="loadPageData()"></UButton>
  <UButton
    type="primary"
    text="Init"
    @click="
      () => {
        currentPageNo = 0
      }
    "
  ></UButton>

  <WjFlexGrid :itemsSource="collectionView" class="mt-2" :isReadOnly="true">
    <WjFlexGridColumn binding="procId" header="프로세스아이디" />
    <WjFlexGridColumn binding="reqId" header="요청아이디" />
    <WjFlexGridColumn binding="reqNo" header="요청번호" />
    <WjFlexGridColumn binding="sysCd" header="시스템" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
    <WjFlexGridColumn binding="url" header="URL" />
    <WjFlexGridColumn binding="httpMethCd" header="Method" />
  </WjFlexGrid>

  <UPaginationBar v-model="currentPageNo" :pageSize="pageSize" :totalRecords="totalRecords" />
</template>

<script lang="ts" setup>
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
</script>
```
