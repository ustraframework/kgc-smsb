<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원정보 열람 이력 조회</span>
      </h1>
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>회원정보 열람 이력을 조회한다.</span>
        </h2>
      </div>
    </div>
    <div class="card-body">
      <form action="" class="form">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px" />
            <col />
            <col style="width: 130px" />
            <col />
            <col style="width: 130px" />
            <col />
            <col style="width: 170px" />
          </colgroup>
          <tbody>
            <tr>
              <th><span class="is-required">수행업무</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th><span class="is-required">열람일자</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th>프로그램ID/명</th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <td rowspan="2">
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search" />
                </div>
              </td>
            </tr>
            <tr>
              <th>프로그램ID/명</th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th>열람자ID/명</th>
              <td></td>
              <th></th>
              <td></td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <div class="buttons">
            <UButton text="엑셀 다운로드" icon="excel" />
          </div>
        </div>

        <div class="field-grid">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
            <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
            <WjFlexGridColumn header="수정자" binding="col1" width="*" />
            <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
          </WjFlexGrid>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub',
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
</script>

<style lang="scss" scoped></style>
