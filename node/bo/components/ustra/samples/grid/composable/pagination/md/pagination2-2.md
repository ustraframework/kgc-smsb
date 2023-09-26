```html
<template>
  <UButton type="primary" text="Search" @click="() => grid.pagination.loadPageData()"></UButton>
  <UButton type="primary" text="Init" @click="() => (grid.pagination.currentPageNo.value = 0)"></UButton>

  <WjFlexGrid class="mt-2" :initialized="grid.initialize" style="height: 300px">
    <WjFlexGridColumn binding="procId" header="프로세스아이디" />
    <WjFlexGridColumn binding="reqId" header="요청아이디" />
    <WjFlexGridColumn binding="reqNo" header="요청번호" />
    <WjFlexGridColumn binding="sysCd" header="시스템" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
    <WjFlexGridColumn binding="url" header="URL" />
    <WjFlexGridColumn binding="httpMethCd" header="Method" />
  </WjFlexGrid>
</template>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  pagination: {
    mode: 'infinite',
    handler(currentPage, pageSize, orders) {
      return useOnError(
        async () => {
          const service = useUstraInterfaceService()
          const result = await service.getIntefaceHistories({
            header: {
              currentPage,
              pageSize,
              orders,
            },
            searchValue: {},
          })
          return {
            data: currentPage > 5 ? [] : result.body,
            totalRecords: result.header.totalRecords,
          }
        },
        { message: '데이터 조회 중 오류가 발생하였습니다.' },
      )()
    },
    pageSize: 100,
  },
})
</script>
```
