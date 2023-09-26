<template>
  <!-- <UButtonBar> -->
  <UFieldSet>
    <UFieldRow>
      <UField label="프로세스 아이디">
        <WjInputMask v-model="searchCond.procId" />
      </UField>
      <UField label="요청 아이디">
        <WjInputMask v-model="searchCond.reqId" />
      </UField>
      <UField label="인터페이스 아이디">
        <WjInputMask v-model="searchCond.ifId" />
      </UField>
      <UField v-show="searchCond.sysCd !== null" label="시스템 코드">
        <UCodeComboBox v-model="searchCond.sysCd" grp-cd="SYS_CD" displayNullText="전체" />
      </UField>
    </UFieldRow>
    <UFieldRow>
      <UField label="URL">
        <WjInputMask v-model="searchCond.url" />
      </UField>
      <UField label="채널 코드">
        <UCodeComboBox v-model="searchCond.chnlCd" grp-cd="CHNL_CD" displayNullText="전체" />
      </UField>

      <UField label="성공 여부">
        <WjComboBox v-model="searchCond.succYn" :itemsSource="ynList" displayMemberPath="name" selectedValuePath="code" />
      </UField>
      <UField label="응답 코드 값">
        <WjInputMask v-model="searchCond.resCdVal" />
      </UField>
    </UFieldRow>
    <UFieldRow>
      <UField label="기간">
        <UDatePeriodBox
          :width="300"
          v-model:start="searchCond.searchSrtDttm"
          v-model:end="searchCond.searchEndDttm"
          mode="date"
          displayFormat="yyyy-MM-dd"
          valueFormat="yyyyMMdd"
        />
        <!-- <dx-date-period-box v-model="searchDttm" width="100%" mode="datetime" /> -->
      </UField>

      <UButtonBar>
        <UButton text="검색" icon="search" class="right" type="success" @click="searchHist" />
        <UButton text="엑셀다운로드" icon="xlsxfile" type="default" @click="excelDownload" />
      </UButtonBar>
    </UFieldRow>
  </UFieldSet>
  <!-- </UButtonBar> -->
</template>
<script setup lang="ts">
import { onMounted, reactive, ref, nextTick, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import { WjComboBox, UBox, UItem, WjInputMask, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { IfsHistCriteria } from '#ustra/nuxt/management'
// import querystring from 'querystring'
// import { Component, Emit, PropSync, Watch } from 'vue-property-decorator'
// import { UstraBoComponent } from '@ustra/nuxt-mng-bo/src/components/ustra-bo-component'
// import { Criteria } from '@ustra/nuxt-mng/src/system/models/ifs-hist-model'
// import { downloadExcelFile } from '@ustra/nuxt-mng-bo/src/utils/file-utils'

const props = defineProps({
  searchCond: {
    type: Object,
    default() {
      return {
        procId: null,
        reqId: null,
        ifId: null,
        sysCd: null,
        chnlCd: null,
        url: null,
        succYn: null,
        resCdVal: null,
        searchSrtDttm: null,
        searchEndDttm: null,
      }
    },
  },
})
// @PropSync('searchCond', {
//   default: () => {
//     return {
//       procId: null,
//       reqId: null,
//       ifId: null,
//       sysCd: null,
//       chnlCd: null,
//       url: null,
//       succYn: null,
//       resCdVal: null,
//       searchSrtDttm: null,
//       searchEndDttm: null,
//     }
//   },
// })

const searchCond: IfsHistCriteria['searchValue'] = reactive({
  procId: null,
  reqId: null,
  ifId: null,
  sysCd: null,
  chnlCd: null,
  url: null,
  succYn: null,
  resCdVal: null,
  searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -120), 'yyyyMMdd'),
  searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
})

const ynList = [
  { code: '', name: '전체' },
  { code: 'Y', name: '성공' },
  { code: 'N', name: '실패' },
]

// get searchDttm() {
//   return [
//     !this.innerSearchCond.searchSrtDttm
//       ? this.$ustra.utils.date.addDays(new Date(), -1)
//       : // @ts-ignore
//         this.$ustra.utils.date.parse(this.innerSearchCond.searchSrtDttm, 'yyyy-MM-dd HH:mm'),
//     // @ts-ignore
//     !this.innerSearchCond.searchEndDttm ? new Date() : this.$ustra.utils.date.parse(this.innerSearchCond.searchEndDttm, 'yyyy-MM-dd HH:mm'),
//   ]
// }

// set searchDttm(dttm) {
//   this.innerSearchCond.searchSrtDttm = this.formatters.datetime(dttm[0])
//   this.innerSearchCond.searchEndDttm = this.formatters.datetime(dttm[1])
// }

// created() {
//   this.init()
// }

onMounted(() => {
  init()
})

function init() {
  Object.assign(searchCond, {
    procId: null,
    reqId: null,
    ifId: null,
    sysCd: null,
    chnlCd: '',
    url: null,
    succYn: this.ynList[0].code,
    resCdVal: null,
    searchSrtDttm: $ustra.utils.formatting.date($ustra.utils.date.addDays(new Date(), -1), 'yyyyMMdd'),
    searchEndDttm: $ustra.utils.formatting.date(new Date(), 'yyyyMMdd'),
  })
}

// @Emit()
// function search(searchCon: IfsHistCriteria) {
//   emits('search', searchCon)
// }

function searchHist() {
  emits('search', searchCond)
}

const emits = defineEmits<{
  (e: 'search', searchCon?: IfsHistCriteria['searchValue']): void
  (e: 'export-excel', searchCon?: IfsHistCriteria['searchValue']): void
}>()

function excelDownload() {
  emits('export-excel', searchCond)
}
// #endregion

// #region watches
// @Watch('searchCond')
function searchCondChanged(v) {
  if (v.searchSrtDttm) {
    this.searchDttm = [v.searchSrtDttm, v.searchEndDttm]
  }
}
// #endregion
</script>
<style lang="scss"></style>
