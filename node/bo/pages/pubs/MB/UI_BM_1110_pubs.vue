<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원정보 변경 이력 조회</span>
      </h1>
    </div>
    <div class="card-body">
      <form action="" class="form">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 170px;">
          </colgroup>
          <tbody>
            <tr>
              <th><span class="is-required">사용채널</span></th>
              <td>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </td>
              <th><span class="is-required">인증일자</span></th>
              <td>
                <UDateBox mode="date"/>
                <span>~</span>
                <UDateBox mode="date"/>
              </td>
              <th><span class="is-required">인증채널</span></th>
              <td>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </td>
              <td rowspan="2">
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search"/>
                </div>
              </td>
            </tr>
            <tr>
              <th>회원번호/명</th>
              <td>
                <UTextBox type="icon"/>
                <UTextBox></UTextBox>
              </td>
              <th></th>
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
          <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
            <WjFlexGridColumn header="No" binding="col1" width="*">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <UCodeComboBox v-model="cell.value"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="회원번호" binding="col1" width="*">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <UCodeComboBox v-model="cell.value"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="회원명" binding="col1" width="*">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <UCodeComboBox v-model="cell.value"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="회원구분" binding="col1" width="*">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <UCodeComboBox v-model="cell.value"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="잔여포인트" binding="col1" width="*">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                <UCodeComboBox v-model="cell.value"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="탈퇴일자" binding="col1" width="*" format="yyyy-MM-dd">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                  <WjInputDate v-model="cell.item.date"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="삭제예정일자" binding="col1" width="*" format="yyyy-MM-dd">
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                  <WjInputDate v-model="cell.item.date"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>

            <WjFlexGridColumn header="탈퇴사유" binding="col1" width="*" >
              <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                  <WjInputDate v-model="cell.value"/>
              </WjFlexGridCellTemplate>
            </WjFlexGridColumn>
          </WjFlexGrid>
          
          <UPaginationBar v-model="currentPageNo" :pageSize="pageSize" :totalRecords="totalRecords" />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  


definePageMeta({
auth: {
  required: false,
},
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

<style lang="scss" scoped>

</style>