<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="pagination1_1" />

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

      <UPaginationBar
        v-model="grid.pagination.currentPageNo.value"
        :pageSize="grid.pagination.pageSize.value"
        :totalRecords="grid.pagination.totalRecords.value"
      />

      <UMarkdownViewer :content="pagination1_2" />
      <UMarkdownViewer :content="pagination1_3" />
      <UMarkdownViewer :content="pagination1_4" />
      <UButton type="primary" text="Search" @click="() => grid1.pagination.loadPageData()"></UButton>
      <UButton type="primary" text="Init" @click="() => (grid1.pagination.currentPageNo.value = 0)"></UButton>

      <WjFlexGrid class="mt-2" :initialized="grid1.initialize" style="height: 300px">
        <WjFlexGridColumn binding="procId" header="프로세스아이디" />
        <WjFlexGridColumn binding="reqId" header="요청아이디" />
        <WjFlexGridColumn binding="reqNo" header="요청번호" />
        <WjFlexGridColumn binding="sysCd" header="시스템" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
        <WjFlexGridColumn binding="url" header="URL" />
        <WjFlexGridColumn binding="httpMethCd" header="Method" />
      </WjFlexGrid>
      <UPaginationBar
        v-model="grid1.pagination.currentPageNo.value"
        :pageSize="grid1.pagination.pageSize.value"
        :totalRecords="grid1.pagination.totalRecords.value"
        :showStartEndButtons="true"
      />
      <UMarkdownViewer :content="pagination1_5" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { useOnError } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UButton, UPaginationBar, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useUstraInterfaceService, useUstraCodeValue } from '#ustra/nuxt/management'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import pagination1_1 from './md/pagination1-1.md'

// @ts-ignore
import pagination1_2 from './md/pagination1-2.md'

// @ts-ignore
import pagination1_3 from './md/pagination1-3.md'

// @ts-ignore
import pagination1_4 from './md/pagination1-4.md'

// @ts-ignore
import pagination1_5 from './md/pagination1-5.md'

const grid = useWijmoFlexGrid({
  pagination: {
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
            data: result.body,
            totalRecords: result.header.totalRecords,
          }
        },
        { message: '데이터 조회 중 오류가 발생하였습니다.' },
      )()
    },
    pageSize: 20,
  },
})

const grid1 = useWijmoFlexGrid({
  pagination: {
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
            data: result.body,
            totalRecords: result.header.totalRecords,
          }
        },
        { message: '데이터 조회 중 오류가 발생하였습니다.' },
      )()
    },
    pageSize: 20,
  },
})
</script>
