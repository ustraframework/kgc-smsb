<template>
  <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" selectionMode="Row" :initialized="grid.initialize">
    <!-- <dx-scrolling mode="infinite" row-rendering-mode="infinite" /> -->
    <WjFlexGridColumn binding="procId" header="프로세스아이디" />
    <WjFlexGridColumn binding="reqId" header="요청아이디" />
    <WjFlexGridColumn binding="reqNo" header="요청번호" />
    <WjFlexGridColumn binding="ifId" header="I/F아이디" />
    <WjFlexGridColumn binding="ifVer" header="I/F버전" />
    <WjFlexGridColumn binding="ifNm" header="I/F명" />
    <WjFlexGridColumn binding="sysCd" header="시스템코드" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
    <WjFlexGridColumn binding="chnlCd" header="채널코드" :cellTemplate="ctx => useUstraCodeValue('CHNL_CD', ctx.value)" />
    <WjFlexGridColumn binding="url" header="url" />
    <WjFlexGridColumn binding="httpMethCd" header="http메소드코드" :cellTemplate="ctx => useUstraCodeValue('HTTP_METH_CD', ctx.value)" />
    <WjFlexGridColumn binding="succYn" header="성공여부" />
    <WjFlexGridColumn binding="resCdVal" header="응답코드값" />
    <WjFlexGridColumn binding="httpSttCdVal" header="http상태코드값" />
    <WjFlexGridColumn binding="usrId" header="사용자아이디" />
    <WjFlexGridColumn binding="usrKey" header="사용자키" />
    <!-- <WjFlexGridColumn binding="regDttm" header="처리일시" :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)" /> -->
    <WjFlexGridColumn binding="regDttm" header="처리일시" :cellTemplate="ctx => renderUseDatetime(ctx.item)" />

    <!-- <template #datetime-cell-template="{ data }"> -->
    <!-- <div>{{ renderUseDatetime(data.value) }}</div> -->
    <!-- </template> -->
    <!-- <template #sysCd-cell-template="{ data }"> -->
    <!-- {{ getCmnCodeMappingVal('SYS_CD', data.value) }} -->
    <!-- </template> -->
    <!-- <template #chnlCd-cell-template="{ data }"> -->
    <!-- {{ getCmnCodeMappingVal('CHNL_CD', data.value) }} -->
    <!-- </template> -->
    <!-- <template #httpMethCd-cell-template="{ data }"> -->
    <!-- {{ getCmnCodeMappingVal('HTTP_METH_CD', data.value) }} -->
    <!-- </template> -->
  </WjFlexGrid>
</template>

<script setup lang="ts">
import { reactive, ref, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import { WjComboBox, UBox, UItem, WjInputMask, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { IfsHist, IfsHistCriteria, useUstraCodeValue } from '#ustra/nuxt/management'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables/grid'
import { useUstraInterfaceService } from '#ustra/nuxt/management/services/interface'
// import { DxDataGrid } from '@ustra/nuxt-dx/src/components/dx/dx-data-grid'
// import { OnError } from '@ustra/nuxt/src/vue/decorators'
// import CustomStore from 'devextreme/data/custom_store'
// import DataSource from 'devextreme/data/data_source'
// import { HttpMethod } from '@ustra/core/src/server/http/const'
// import { createPagingParameter, createGridPagingParameter } from '@ustra/nuxt-dx/src/utils/pagination-utils'
// import { downloadExcelFile } from '@ustra/nuxt-mng-bo/src/utils/file-utils'

const grid = useWijmoFlexGrid<IfsHist>()
// @Ref() readonly grid: DxDataGrid
//ifsHists: IfsHist[] = []
//gridData: DataSource = null
// const gridData = ref<IfsHist[]>([])
const gridData = ref<IfsHist[]>([])

const infService = useUstraInterfaceService()

async function loadData(searchCond: Partial<IfsHistCriteria>) {
  const list = await infService.getIntefaceHistories(searchCond)
  // useDeepMerge(gridData, list)
  gridData.value = list

  //console.log('gridData', gridData.value)

  // this.gridData = new DataSource({
  //   store: new CustomStore({
  //     key: ['ifHistId'],
  //     load: async loadOptions => {
  //       loadOptions.searchValue = searchCond
  //       const res = await this.$ustra.api.call({
  //         url: '/api/system/ifshist/list',
  //         method: HttpMethod.POST,
  //         data: createPagingParameter(loadOptions),
  //         showLoading: false,
  //       })
  //       return {
  //         data: res.data.body,
  //         totalCount: res.data.header.totalRecords,
  //       }
  //     },
  //   }),
  // })
}

function exportExcel(searchCond: IfsHistCriteria['searchValue']) {
  console.log('exportExcel')
  // const histGrid = useWijmoFlexGrid({})
  grid.export.toExcel('DownloadExcel.xlsx')
  // const pagination = createGridPagingParameter(this.grid)
  // pagination.pageSize = 0 // 전체 조회 처리

  // const url = this.$ustra.api
  //   .urlBuilder('/api/system/ifshist/download/excel')
  //   .addBase64('paginationRequest', pagination)
  //   .addBase64('criteria', { searchValue: searchCond })
  //   .build()
  // downloadExcelFile(url)
}

// @Emit()
// function select(ifsHists: IfsHist) {
//   return ifsHists
// }

// function selectRow(e) {
//   if (e.selectedRowsData.length > 0) {
//     this.select(e.selectedRowsData[0])
//   }
// }

// function getSelectRow() {
//   if (this.grid.instance.getSelectedRowsData().length > 0) {
//     return this.grid.instance.getSelectedRowsData()[0]
//   }
// }

watch(grid.selectionData, v => {
  if (v) {
    select(v as IfsHist)
  }
})

const emits = defineEmits<{
  (e: 'select', ifsHist?: IfsHist): void
}>()

function select(ifsHist: IfsHist) {
  emits('select', ifsHist)
}

function clearSelection() {
  console.log('clearSelection')
  // this.grid.instance.clearSelection()
}

function renderUseDatetime(data) {
  console.log('data.regDttm', new Date(data.regDttm))
  if (data) {
    return $ustra.utils.formatting.date(new Date(data.regDttm), 'yyyy-MM-dd HH:mm')
  }
  return null
}

defineExpose({
  loadData,
  clearSelection,
  exportExcel,
  renderUseDatetime,
})
</script>
<style scoped></style>
