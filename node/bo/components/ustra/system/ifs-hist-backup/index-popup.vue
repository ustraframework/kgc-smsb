<template>
  <!-- <UPopup v-model="show" width="100%" :height="800" title="인터페이스 이력 조회"> -->
  <UBox direction="col" height="100%" width="100%">
    <UItem :ratio="0" base-size="auto">
      <!-- <template #default> -->
      IfsHistSearchBar
      <IfsHistSearchBar></IfsHistSearchBar>
      <!-- <IfsHistSearchBar :search-cond.sync="searchCond" @search="search" @export-excel="list.exportExcel($event)" /> -->
      <!-- </template> -->
    </UItem>
    <UItem :ratio="1">
      <!-- <template #default> -->
      <UBox direction="row" hight="100%" width="100%">
        <UItem :ratio="2" height="100%">
          <!-- <template #default> -->
          IfsHistList
          <IfsHistList :ref="e => (list = e as InstanceType<typeof IfsHistList>)" @select="selected" />
          <!-- </template> -->
        </UItem>
        <UItem :ratio="1" :visible.sync="show">
          <!-- <template #default> -->
          IfsHistForm
          <!-- <IfsHistForm ref="form" @reload="show = false" @confirm-hist="confirmHist" /> -->
          <!-- </template> -->
        </UItem>
      </UBox>
      <!-- </template> -->
    </UItem>
  </UBox>
  <!-- </UPopup> -->
</template>

<script setup lang="ts">
import { reactive, ref, nextTick, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import { WjComboBox, UBox, UItem, WjInputMask, UFieldSet, UFieldRow, UField, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { IfsHist, IfsHistCriteria } from '#ustra/nuxt/management'
import IfsHistSearchBar from './ifs-hist-search-bar.vue'
import IfsHistList from './ifs-hist-list.vue'
// import IfsHistForm from './ifs-hist-form.vue'
// const list = shallowRef(IfsHistList)

const list = ref<InstanceType<typeof IfsHistList>>(null)
// const listComponent = ref<InstanceType<typeof IfsList>>(null)
// const form = ref<InstanceType<typeof IfsHistForm>>(null)
const searchCond: Partial<IfsHistCriteria> = reactive({
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
const showPopup = ref(false)

function search(searchCon: Partial<IfsHistCriteria>) {
  console.log('hist-search')
  // useDeepMerge(searchCond, searchCon)
  searchCond.value = searchCon
  console.log('list.value', list.value)
  list.value.loadData(searchCon)
  show.value = false
  list.value.clearSelection()
  // this.searchCond = searchCon
  // this.list.loadData(searchCon)
  // this.show = false
  // this.list.clearSelection()
}

function selected(selectData: IfsHist) {
  this.show = true
  this.form.loadData(selectData.ifHistId)
}

function confirmHist() {
  this.show = false
  this.list.clearSelection()
}
defineExpose({
  search,
})
</script>
<style lang="scss"></style>
