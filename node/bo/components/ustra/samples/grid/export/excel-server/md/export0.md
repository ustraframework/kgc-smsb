```html
<template>
  <UButton type="primary" text="Search" @click="() => grid.pagination.loadPageData()"></UButton>
  <UButton text="Export Excel" @click="exportExcel" v-if="grid.pagination.currentPageNo.value > 0"></UButton>
  <UButton text="Export Excel with Provider" @click="exportExcelWithProvider" v-if="grid.pagination.currentPageNo.value > 0"></UButton>

  <WjFlexGrid style="height: 200px" class="mt-1" :initialized="grid.initialize">
    <WjFlexGridColumn header="메뉴아이디" binding="mnuId" />
    <WjFlexGridColumn header="시스템" binding="sysCd" align="center" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
    <WjFlexGridColumn header="메뉴명" binding="mnuNm" />
    <WjFlexGridColumn header="정렬번호" binding="mnuSrtNo" />
    <WjFlexGridColumn header="메뉴URL" binding="mnuUrl" />
    <WjFlexGridColumn header="메뉴유형" binding="mnuTyCd" align="center" :cellTemplate="ctx => useUstraCodeValue('MNU_TY_CD', ctx.value)" />
    <WjFlexGridColumn header="사용여부" binding="useYn" align="center" :cellTemplate="ctx => (ctx.value === 'Y' ? '사용' : '미사용')" />
  </WjFlexGrid>

  <UPaginationBar
    v-model="grid.pagination.currentPageNo.value"
    :pageSize="grid.pagination.pageSize.value"
    :totalRecords="grid.pagination.totalRecords.value"
  />
</template>
<script lang="ts" setup>
const grid = useWijmoFlexGrid({
  pagination: {
    mode: 'normal',
    pageSize: 10,
    async handler(currentPage, pageSize, orders) {
      const result = (
        await $ustra.api.call({
          url: '/api/sample/excel/creation/list',
          method: 'POST',
          data: {
            header: {
              currentPage,
              pageSize,
              orders,
            },
            sysCd: null,
          },
        })
      )?.data

      return {
        data: result.body,
        totalRecords: result.header.totalRecords,
      }
    },
  },
})

function exportExcel() {
  $ustra.api.downloadFile({
    fileName: 'export4.xlsx',
    url: '/api/sample/excel/creation/download',
    method: 'POST',
    data: {
      cellInfos: grid.export.createExcelCellInfo(),
      criteria: {
        sysCd: null,
      },
    },
  })
}

function exportExcelWithProvider() {
  $ustra.api.downloadFile({
    fileName: 'export5.xlsx',
    url: '/api/sample/excel/creation/provider/download',
    method: 'POST',
    data: {
      cellInfos: grid.export.createExcelCellInfo(),
      criteria: {
        sysCd: null,
      },
    },
  })
}
</script>
```
