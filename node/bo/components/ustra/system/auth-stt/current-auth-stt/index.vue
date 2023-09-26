<template>
  <UBox direction="col">
    <UItem>
      <UFieldSet>
        <UFieldRow :ratio="[1, 1, 1, 1]">
          <UField direction="row" label="시스템 코드">
            <UCodeComboBox grpCd="SYS_CD" v-model="searchAction.searchParam.sysCd" style="width: 230px" />
          </UField>
          <UField direction="row" label="기간">
            <UDatePeriodBox
              :width="500"
              v-model:start="searchAction.searchParam.searchSrtDttm"
              v-model:end="searchAction.searchParam.searchEndDttm"
            />
          </UField>
        </UFieldRow>
      </UFieldSet>
      <UButtonBox :center="true">
        <UButton class="gray ico_reset" @click="searchAction.clearSearchParam"><span class="blind">초기화</span></UButton>
        <UButton text="조회" class="primary ico_search" @click="searchAction.loadSearchedData" />
        <UButton text="엑셀다운로드" icon="xlsxfile" type="default" @click="gridAction.excelDownload" />
      </UButtonBox>
    </UItem>

    <UItem :ratio="1">
      <UBox direction="row" style="gap: 5px">
        <UItem :ratio="6">
          <WjFlexGrid style="height: 600px" :initialized="gridAction.histGrid.initialize">
            <WjFlexGridColumn binding="usrId" header="사용자 아이디" width="*" />
            <WjFlexGridColumn binding="usrNm" header="사용자 명" width="*" />
            <WjFlexGridColumn binding="orgCd" header="회사명" :cellTemplate="ctx => useUstraCodeValue('ORG_CD', ctx.value)" />
            <WjFlexGridColumn
              binding="deptCd"
              header="부서명"
              width="*"
              :cellTemplate="
                ctx => ($ustra.management.serverAppProps.useUserDeptCodeSelectBox ? useUstraCodeValue('DEPT_CD', ctx.value) : ctx.item.deptNm)
              "
            />
            <WjFlexGridColumn binding="mnuNm" header="메뉴 명" width="*" />
            <WjFlexGridColumn binding="useSrtDt" header="권한 시작일" width="*" :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)" />
            <WjFlexGridColumn binding="useEndDt" header="권한 만료일" width="*" :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)" />
          </WjFlexGrid>
        </UItem>
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, useOnError } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { useUstraAuthSttService, AuthSttCriteria, AuthStt, useUstraCodeValue } from '#ustra/nuxt/management'
const service = useUstraAuthSttService()
const searchAction = (function () {
  const searchParam: AuthSttCriteria = reactive({
    sysCd: null,
    searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMdd'),
    searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
  })

  function clearSearchParam() {
    Object.assign(searchParam, {
      sysCd: null,
      searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMdd'),
      searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
    })
  }

  async function loadSearchedData() {
    gridAction.histGrid.pagination.loadPageData(1)
  }

  return {
    searchParam,
    clearSearchParam,
    loadSearchedData,
  }
})()

const gridAction = (function () {
  const histGrid = useWijmoFlexGrid({
    pagination: {
      mode: 'infinite',
      handler(currentPage, pageSize, orders) {
        return useOnError(
          async () => {
            const result = await service.getAuthSttPeriodList({
              header: {
                currentPage,
                pageSize,
                orders,
              },
              searchValue: {
                ...searchAction.searchParam,
              },
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

  function excelDownload() {
    histGrid.export.toExcel('DownloadExcel.xlsx')
  }

  return {
    histGrid,
    excelDownload,
  }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemPeriodAuth',
}
</script>
