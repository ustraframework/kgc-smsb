<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Grid</h1>
        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 240px">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="지급일자" binding="col1" width="*" />
          <WjFlexGridColumn header="지급방법" binding="col1" width="*" />
          <WjFlexGridColumn header="지급사유" binding="col1" width="*" />
        </WjFlexGrid>
      </div>

      <div class="column is-half">
        <h1 class="mb-4">Button Grid</h1>
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="발송채널" binding="col1" width="*" />
          <WjFlexGridColumn header="발송유형" binding="col1" width="*" />
          <WjFlexGridColumn header="적용 시작일자" binding="col1" width="*" />
          <WjFlexGridColumn header="적용 종료일자" binding="col1" width="*" />
          <WjFlexGridColumn header="건별단가(원)" binding="col1" width="*" />
          <WjFlexGridColumn header="비고" binding="col1" width="*" />
          <WjFlexGridColumn header="이력보기" binding="col1" width="*" align="center">
            <WjFlexGridCellTemplate cellType="Cell" >
              <UButton text="이력보기" />
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
        </WjFlexGrid>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mt-10 mb-4">Grid Pagination</h1>
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
          :showStartEndButtons="true"
        />
      </div>
    </div>

  </div>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

import { WjComboBox } from '#ustra/nuxt-wijmo/components'

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
});

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

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>