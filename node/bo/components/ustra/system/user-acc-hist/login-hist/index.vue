<template>
  <UBox direction="col">
    <UItem>
      <UFieldSet>
        <UFieldRow :ratio="[1, 1, 1, 1, 1]">
          <UField required direction="col" label="시스템구분">
            <UCodeComboBox grpCd="SYS_CD" v-model="searchAction.searchParam.sysCd" style="width: 250px" />
          </UField>
          <UField direction="col" label="기간">
            <UDatePeriodBox
              :width="300"
              v-model:start="searchAction.searchParam.searchSrtDttm"
              v-model:end="searchAction.searchParam.searchEndDttm"
              mode="date"
              displayFormat="yyyy-MM-dd"
              valueFormat="yyyyMMdd"
            />
          </UField>
          <UField direction="col" label="차트종류">
            <UCodeComboBox grpCd="CHRT_KIND_CD" v-model="searchAction.searchParam.chartType" style="width: 250px" />
          </UField>
          <UField direction="col" label="사용자 아이디">
            <UTextBox type="text" v-model="searchAction.searchParam.usrId" style="width: 250px" />
          </UField>
          <UField direction="col" label="사용자 명">
            <UTextBox type="text" v-model="searchAction.searchParam.usrNm" style="width: 250px" />
          </UField>
        </UFieldRow>
      </UFieldSet>
      <UButtonBox :center="true">
        <UButton class="gray ico_reset" @click="searchAction.clearSearchParam"><span class="blind">초기화</span></UButton>
        <UButton text="조회" class="primary ico_search" @click="searchAction.loadSearchedData" />
        <UButton text="엑셀다운로드" icon="xlsxfile" type="default" @click="gridAction.excelDownload" />
      </UButtonBox>
    </UItem>

    <UItem>
      <UButtonBox :right="true">
        <UButton text="PNG" class="btn btn-default" v-on:click="chartAction.exportChart('png')" :width="50" />
        <UButton text="JPEG" class="btn btn-default" v-on:click="chartAction.exportChart('jpeg')" :width="50" />
        <UButton text="SVG" class="btn btn-default" v-on:click="chartAction.exportChart('svg')" :width="50" />
      </UButtonBox>

      <WjFlexChart
        v-if="searchAction.searchParam.chartType === '10'"
        :initialized="flex => (chartAction.chart.value = flex)"
        header="오늘의 접속 이력 정보"
        bindingX="loginHour"
        selectionMode="Point"
        :itemsSource="chartAction.chartList.value"
        :tooltipContent="chartAction.tooltipContent"
      >
        <WjFlexChartLegend position="Right" />
        <WjFlexChartSeries name="건수" binding="loginCnt" />
        <WjFlexChartAnimation />
      </WjFlexChart>
      <WjFlexChart
        v-if="searchAction.searchParam.chartType === '20'"
        :initialized="flex => (chartAction.chart.value = flex)"
        header="오늘의 접속 이력 정보"
        chartType="Bar"
        bindingX="loginHour"
        stacking="Stacked"
        :itemsSource="chartAction.chartList.value"
        :tooltipContent="chartAction.tooltipContent"
      >
        <WjFlexChartLegend position="Right" />
        <WjFlexChartSeries name="건수" binding="loginCnt" />
        <WjFlexChartAxis wjProperty="axisY" :reversed="false" />
        <WjFlexChartAnimation />
      </WjFlexChart>
      <WjFlexPie
        v-if="searchAction.searchParam.chartType === '30'"
        :initialized="flex => (chartAction.chart.value = flex)"
        header="오늘의 접속 이력 정보"
        bindingName="loginHour"
        binding="loginCnt"
        :itemsSource="chartAction.chartList.value"
      >
        <WjFlexPieDataLabel :content="chartAction.getLabelContent" />
        <WjFlexChartLegend position="Right" />
      </WjFlexPie>
    </UItem>

    <UItem :ratio="1">
      <UBox direction="col">
        <WjFlexGrid style="height: 300px" :itemsSource="gridAction.data.value" :initialized="gridAction.histGrid.initialize">
          <WjFlexGridColumn binding="usrId" header="사용자 아이디" width="*" />
          <WjFlexGridColumn binding="usrNm" header="사용자 명" width="*" />
          <WjFlexGridColumn binding="accIp" header="접근 아이피" width="*" />
          <WjFlexGridColumn binding="loginDttm" header="로그인 시간" width="*" :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)" />
          <WjFlexGridColumn binding="logotDttm" header="로그아웃 시간" width="*" :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)" />
          <WjFlexGridColumn binding="useTime" header="사용시간" width="*" :cellTemplate="ctx => gridAction.renderUsetime(ctx.item)" />
        </WjFlexGrid>
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, watch, onMounted, useOnError, provide, inject, shallowRef, computed } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  WjFlexGrid,
  WjFlexGridColumn,
  WjFlexChart,
  WjFlexChartLegend,
  WjFlexChartSeries,
  WjFlexChartAnimation,
  WjFlexChartAxis,
  WjFlexPie,
  WjFlexPieDataLabel,
} from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { useWijmo } from '#ustra/nuxt-wijmo/composables'
import { LoginHistCriteria, LoginHist } from '#ustra/nuxt/management/models/login-hist'
import { useUstraLoginHistoryService, useUstraCodeList } from '#ustra/nuxt/management'

const service = useUstraLoginHistoryService()
const wijmo = useWijmo()
const sysCodeList = useUstraCodeList('SYS_CD')

const searchAction = (function () {
  const searchParam: LoginHistCriteria = reactive({
    sysCd: sysCodeList.length > 0 ? sysCodeList[0].dtlCd : null,
    searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMdd'),
    searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
    usrId: null,
    usrNm: null,
    chartType: '10',
  })

  function clearSearchParam() {
    Object.assign(searchParam, {
      sysCd: sysCodeList.length > 0 ? sysCodeList[0].dtlCd : null,
      searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMdd'),
      searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
      usrId: null,
      usrNm: null,
      chartType: '10',
    })
  }

  async function loadSearchedData() {
    gridAction.data.value = (
      await service.getLoginHistorys({
        searchValue: {
          ...searchAction.searchParam,
        },
      })
    ).body
    chartAction.chartList.value = (await service.getListHhChart(searchAction.searchParam)).body
  }

  return {
    searchParam,
    clearSearchParam,
    loadSearchedData,
  }
})()

const gridAction = (function () {
  const data = ref<LoginHist>([])

  const histGrid = useWijmoFlexGrid({})

  function renderUsetime(data: LoginHist) {
    if (data.loginDttm && data.logotDttm) {
      const milliSec = $ustra.utils.date.getMilliDuration(new Date(data.loginDttm), new Date(data.logotDttm))
      return $ustra.utils.date.formatDuration(milliSec, 'milliSec')
    }
    return null
  }

  function excelDownload() {
    histGrid.export.toExcel('DownloadExcel.xlsx')
  }

  return {
    data,
    histGrid,
    renderUsetime,
    excelDownload,
  }
})()

const chartAction = (function () {
  const chart = ref(null)
  const chartList = ref<any>([])

  function exportChart(type) {
    chart.value.saveImageToFile('FlexChart.' + type)
  }

  function getLabelContent(ht) {
    return wijmo.format('{name}시({val}건)', { name: ht.name, val: ht.value })
  }

  function tooltipContent(hti) {
    let item = hti.item
    return `<b>${item.loginHour}시</b>(${item.loginCnt}건)`
  }

  return {
    chartList,
    chart,
    exportChart,
    getLabelContent,
    tooltipContent,
  }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemLoginHist',
}
</script>
<style scoped></style>
