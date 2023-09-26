<template>
  <v-card>
    <template #title> 집계 값 수동 변경 </template>
    <template #text>
      <UButton text="Load Data" @click="grid.pagination.loadPageData()" />
      <UButton text="Init Data" @click="grid.pagination.currentPageNo.value = 0" />
      <WjFlexGrid class="mt-2" :initialized="grid.initialize" style="height: 300px">
        <WjFlexGridColumn binding="procId" header="프로세스아이디" />
        <WjFlexGridColumn binding="reqId" header="요청아이디" />
        <WjFlexGridColumn binding="reqNo" header="요청번호" aggregate="Sum" />
        <WjFlexGridColumn binding="url" header="URL" />
        <WjFlexGridColumn binding="httpMethCd" header="Method" />
      </WjFlexGrid>

      <UMarkdownViewer>{{ aggregation2 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script lang="ts" setup>
import { useOnError } from '#ustra/nuxt'
import { useUstraInterfaceService } from '#ustra/nuxt/management'
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import aggregation2 from './md/aggregation2.md'

const grid = useWijmoFlexGrid({
  pagination: {
    mode: 'infinite',
    onAfterLoadPageData(pageNo) {
      grid.control.value.columnFooters.rows.clear()

      if (pageNo > 0) {
        const row = new wijmoGrid.GroupRow()
        grid.control.value.columnFooters.rows.push(row)

        // left 영역에 합계 입력 후, width 조정
        grid.control.value.bottomLeftCells.setCellData(0, 0, '전체합계')
        grid.control.value.rowHeaders.columns[0].width = 100

        // 건수 입력 후, right 정렬
        grid.control.value.columnFooters.setCellData(
          0,
          1,
          $ustra.utils.formatting.currency(grid.pagination.collectionView.sourceCollection.length) + ' 건',
        )

        // cell element를 refresh로 강제 생성한다.
        grid.control.value.refresh()
        grid.control.value.columnFooters.getCellElement(0, 1).style.justifyContent = 'flex-end'
        grid.control.value.columnFooters.getCellElement(0, 2).style.justifyContent = 'flex-end'
      }
    },
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
    pageSize: 500,
  },
})
</script>
