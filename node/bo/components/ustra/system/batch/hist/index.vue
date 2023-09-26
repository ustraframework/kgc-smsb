<template>
  <UBox direction="col">
    <UItem>
      <UFieldSet>
        <UFieldRow :ratio="[1, 1, 1, 1]">
          <UField label="배치 이력 아이디">
            <UTextBox type="text" v-model="searchAction.searchParam.batHistId" />
          </UField>
          <UField label="배치 아이디">
            <UTextBox type="text" v-model="searchAction.searchParam.batId" />
          </UField>
          <UField label="배치 명">
            <UTextBox type="text" v-model="searchAction.searchParam.batNm" />
          </UField>
          <UField blank>
            <UButtonBox :right="true">
              <UButton class="gray ico_reset" @click="searchAction.clearSearchParam"><span class="blind">초기화</span></UButton>
              <UButton text="조회" class="primary ico_search" @click="() => searchAction.loadSearchedData()" />
            </UButtonBox>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>

    <UItem :ratio="1">
      <UBox direction="col">
        <WjFlexGrid style="height: 500px" :initialized="gridAction.histGrid.initialize">
          <WjFlexGridColumn binding="batHistId" header="배치 이력 아이디" width="*" />
          <WjFlexGridColumn binding="batId" header="배치 아이디" width="*" />
          <WjFlexGridColumn binding="batNm" header="배치 명" width="*" />
          <WjFlexGridColumn binding="accDttm" header="실행시간" width="*" :cellTemplate="ctx => gridAction.renderUsePeroid(ctx.item)" />
          <WjFlexGridColumn binding="succYn" header="성공 여부" width="*" />
          <WjFlexGridColumn binding="batInstCd" header="배치 인스턴스 코드" width="*" />
          <WjFlexGridColumn binding="batHistId" header="작업" :width="120">
            <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
              <div>
                <UButtonBox>
                  <UButton @click="gridAction.printLog(cell.item.batHistId)" small type="primary" text="로그" :width="80" />
                </UButtonBox>
              </div>
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
        </WjFlexGrid>
        <LogPopup v-model="gridAction.logShow.value" :batHistId="gridAction.logBatHistId.value" />
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, watch, onMounted, useOnError, provide, inject, shallowRef, computed } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables/grid'
import { BatchHistCriteria, BatchHist, useUstraBatchHistService } from '#ustra/nuxt/management'
import LogPopup from './popup.vue'
const service = useUstraBatchHistService()
const searchAction = (function () {
  const searchParam: BatchHistCriteria = reactive({
    batHistId: null,
    batId: null,
    batNm: null,
  })

  function clearSearchParam() {
    searchParam.batHistId = null
    searchParam.batId = null
    searchParam.batNm = null
  }

  async function loadSearchedData(batId?: string) {
    if (batId) {
      searchParam.batId = batId
    }
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
            const result = await service.getBatchHistList({
              header: {
                pageSize,
                currentPage,
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

  function renderUsePeroid(data: BatchHist) {
    if (!data.srtDttm) {
      return ''
    }

    if (!data.endDttm) {
      return `${$ustra.utils.formatting.datetime(data.srtDttm)} ~`
    }

    return `${$ustra.utils.formatting.datetime(data.srtDttm)} ~ ${$ustra.utils.formatting.datetime(data.endDttm)}`
  }

  const logShow = ref(false)
  const logBatHistId = ref(null)
  function printLog(batHistId: string) {
    logShow.value = true
    logBatHistId.value = batHistId
  }

  return {
    histGrid,
    renderUsePeroid,
    printLog,
    logShow,
    logBatHistId,
  }
})()

defineExpose({
  searchAction,
})
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemBatchHist',
}
</script>
<style scoped></style>
