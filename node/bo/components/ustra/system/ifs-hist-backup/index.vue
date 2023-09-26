<template>
  <UBox direction="col">
    <UItem baseSize="100">
      <!-- <template #default> -->
      <IfsHistSearchBar :searchCond="searchCond" @search="search" @export-excel="exportExcel" />
      <!-- </template> -->
    </UItem>
    <UItem :ratio="1">
      <!-- <template #default> -->
      <UBox direction="row">
        <UItem :ratio="2">
          <!-- <template #default> -->
          <IfsHistList :ref="e => (list = e as InstanceType<typeof IfsHistList>)" @select="selected" />
          <!-- </template> -->
        </UItem>
        <UItem :ratio="1" v-show="show">
          <!-- <template #default> -->
          <IfsHistForm :ref="e => (form = e as InstanceType<typeof IfsHistForm>)" @reload="show = false" @confirm-hist="confirmHist" />
          <!-- </template> -->
        </UItem>
      </UBox>
      <!-- </template> -->
    </UItem>
  </UBox>
</template>

<script setup lang="ts">
import { reactive, ref, nextTick, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import { WjComboBox, UBox, UItem, WjInputMask, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { IfsHist, IfsHistCriteria } from '#ustra/nuxt/management'
import IfsHistSearchBar from './ifs-hist-search-bar.vue'
import IfsHistList from './ifs-hist-list.vue'
import IfsHistForm from './ifs-hist-form.vue'

const list = ref<InstanceType<typeof IfsHistList>>(null)
// const listComponent = ref<InstanceType<typeof IfsList>>(null)
const form = ref<InstanceType<typeof IfsHistForm>>(null)
const searchCond: IfsHistCriteria['searchValue'] = reactive({
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
})

const show = ref(false)

function search(searchCon: IfsHistCriteria['searchValue']) {
  console.log('hist-search', searchCon)
  searchCond.value = searchCon

  list.value.loadData(searchCon)
  show.value = false
  list.value.clearSelection()
  // this.searchCond = searchCon
  // this.list.loadData(searchCon)
  // this.show = false
  // this.list.clearSelection()
}

function selected(selectData: IfsHist) {
  show.value = true
  form.value.loadData(selectData.ifHistId)
}

function confirmHist() {
  show.value = false
  //this.list.clearSelection()
}

function exportExcel(selectData: IfsHistCriteria['searchValue']) {
  console.log('exportExcel', selectData)
  list.value.exportExcel(selectData)
}

defineExpose({
  search,
})
</script>
<style lang="scss"></style>
