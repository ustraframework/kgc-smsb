<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="pagination2_1" />

      <UButton type="primary" text="Search" @click="() => grid.pagination.loadPageData()"></UButton>
      <UButton type="primary" text="Init" @click="() => (grid.pagination.currentPageNo.value = 0)"></UButton>

      <WjFlexGrid class="mt-2" :initialized="grid.initialize" style="height: 300px">
        <WjFlexGridColumn binding="procId" header="프로세스아이디" :width="300" />
        <WjFlexGridColumn binding="reqId" header="요청아이디" :width="300" />
        <WjFlexGridColumn binding="reqNo" header="요청번호" :width="100" />
        <WjFlexGridColumn binding="sysCd" header="시스템" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" :width="100" />
        <WjFlexGridColumn binding="url" header="URL" :width="300" />
        <WjFlexGridColumn binding="httpMethCd" header="Method" :width="100" />
      </WjFlexGrid>

      <UMarkdownViewer :content="pagination2_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { useOnError } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useUstraInterfaceService, useUstraCodeValue } from '#ustra/nuxt/management'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import pagination2_1 from './md/pagination2-1.md'

// @ts-ignore
import pagination2_2 from './md/pagination2-2.md'

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
    pageSize: 15,
  },
})
</script>
