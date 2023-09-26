
페이징 등의 상황 또는 집계 값을 수동으로 세팅해야하는 시점에는 데이터 로드 시점에 columnFooters와 bottomLeftCells 등의 객체에 직접 접근하여 각 데이터의 집계 값을 수동으로 세팅하거나 스타일을 변경할 수 있다.
```html
  <UButton text="Load Data" @click="grid.pagination.loadPageData()" />
  <UButton text="Init Data" @click="grid.pagination.currentPageNo.value = 0" />
  <WjFlexGrid class="mt-2" :initialized="grid.initialize" style="height: 300px">
    <WjFlexGridColumn binding="procId" header="프로세스아이디" />
    <WjFlexGridColumn binding="reqId" header="요청아이디" />
    <WjFlexGridColumn binding="reqNo" header="요청번호" aggregate="Sum" />
    <WjFlexGridColumn binding="url" header="URL" />
    <WjFlexGridColumn binding="httpMethCd" header="Method" />
  </WjFlexGrid>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid } from '#ustra/nuxt-wijmo'

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
```
