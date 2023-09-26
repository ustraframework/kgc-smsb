``` html
<template>
  <div>
    <UButton @click="addRow" text="로우 추가"></UButton>
    <UButton @click="removeRow" text="로우 삭제"></UButton>
  </div>
  <div>
    <UButton @click="getGridData" text="전체 데이터 조회"></UButton>
    <UButton @click="getEditedGridData" text="수정 데이터 조회"></UButton>
    <UButton @click="getAddedGridData" text="추가 데이터 조회"></UButton>
    <UButton @click="getDeletedGridData" text="삭제 데이터 조회"></UButton>
  </div>
  <div>
    그리드 by template
    <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px" :allowDelete="true">
      <WjFlexGridColumn :header="'Seq'" :binding="'seq'" :width="80" />
      <WjFlexGridColumn :header="'Country'" :binding="'country'" :width="100" />
      <WjFlexGridColumn :header="'City'" :binding="'city'" :width="80" :dataMap="cmCityCode"> </WjFlexGridColumn>
      <WjFlexGridColumn :header="'Sales'" :binding="'sales'" :width="100" format="n2" aggregate="Sum" />
      <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" :width="100" format="n2" aggregate="Sum" />
      <WjFlexGridColumn :header="'Change'" :binding="'change'" :width="100" format="p0">
        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
          <span :class="cell.item.change > 0 ? 'change-up' : 'change-down'">
            {{ wijmo.Globalize.format(cell.item.change, cell.col.format) }}
          </span>
        </WjFlexGridCellTemplate>
        <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
          <WjInputNumber v-model="cell.value" />
        </WjFlexGridCellTemplate>
      </WjFlexGridColumn>
      <WjFlexGridColumn :header="'IP'" :binding="'ip'" :width="200">
        <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
          <UIpAddressTextBox v-model="cell.value" />
        </WjFlexGridCellTemplate>
      </WjFlexGridColumn>
    </WjFlexGrid>
  </div>
  <div>
    그리드 by code
    <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px" :columnGroups="initColumns()"> </WjFlexGrid>
  </div>
  <div>
    수정 목록
    <WjFlexGrid :itemsSource="data.itemsEdited" style="max-height: 300px" :isReadOnly="true" />
    추가 목록
    <WjFlexGrid :itemsSource="data.itemsAdded" style="max-height: 300px" :isReadOnly="true" />
    삭제 목록
    <WjFlexGrid :itemsSource="data.itemsRemoved" style="max-height: 300px" :isReadOnly="true" />
  </div>

</template>
<script lang="ts" setup>

import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '@grapecity/wijmo.vue2.grid'
import * as wijmo from '@grapecity/wijmo'
import { WjInputNumber, UIpAddressTextBox } from '#ustra/nuxt-wijmo/components'
import { ref } from '#ustra/nuxt'
import { useWjGridDataMap } from '#ustra/nuxt-wijmo/composables/grid'

//#region Grid 초기 설정
/**
 * Grid 객체 ref 처리
 * <script> 내에서는 grid.value.control 로 접근
 * <template> 내에서는 grid.control 로 접근
 */
const grid = ref()

/**
 * 샘플용 Grid Data 생성
 * @param cnt Grid Row 카운트
 */
const _getData = (cnt: Number) => {
  // create some random data
  const data = []

  for (let i = 0; i < cnt; i++) {
    data.push({
      id: i,
      seq: i + 1,
      country: 'country_' + i,
      city: '0' + Math.ceil(Math.random() * (9 - 1) + 1),
      sales: Math.ceil(Math.random() * 10000 * 100) / 100,
      expenses: Math.ceil(Math.random() * 5000 * 100) / 100,
      change: Math.round((Math.random() - 0.45) * 10000) / 10000,
      ip: '111.111.111.111',
    })
  }

  console.log('##### _getData : ', data)

  // Grid 데이터 변경내용 추적을 위해 wijmo 객체에 추적 옵션 적용하여 반환
  return new wijmo.CollectionView(data, {
    trackChanges: true,
  })
}
/**
 * grid itemsSource 에 매핑하는 data 값
 */
const data = _getData(5)
//#endregion

/**
 * 공통코드 예시 데이터
 * wijmo.grid 의 DataMap 객체로 (데이터 Object, ValueKey, NameKey) 로 리턴한다
 */
const cmCityCode = useWjGridDataMap([
  { code: '01', name: '서울' },
  { code: '02', name: '대전' },
  { code: '03', name: '대구' },
  { code: '04', name: '부산' },
  { code: '05', name: '인천' },
  { code: '06', name: '수원' },
  { code: '07', name: '광주' },
  { code: '08', name: '울산' },
  { code: '09', name: '세종' },
])

/**
 * 코드 기준으로 컬럼 생성
 */
const initColumns = () => {
  const changeTemplate = '<span class=${value > 0 ? "change-up" : "change-down"}>${value}:${col.format}</span>'

  return [
    { binding: 'seq', header: 'Seq', width: 80 },
    { binding: 'country', header: 'Country', width: 100 },
    { binding: 'city', header: 'City', width: 80, dataMap: cmCityCode },
    { binding: 'sales', header: 'Sales', format: 'n2', width: 100, aggregate: 'Sum' },
    { binding: 'expenses', header: 'Expenses', format: 'n2', width: 100, aggregate: 'Sum' },
    {
      binding: 'change',
      header: 'Change',
      format: 'p0',
      width: 100,
      cellTemplate: changeTemplate,
    },
    { binding: 'ip', header: 'IP', format: 'n2', width: 200 },
  ]
}

/**
 * 로우 추가 버튼 클릭시 랜덤 데이터 추가
 */
const addRow = () => {
  grid.value.control.collectionView.addNew(
    {
      id: grid.value.control.rows.length,
      seq: grid.value.control.rows.length + 1,
      country: 'country_' + (grid.value.control.rows.length + 1),
      city: '0' + Math.ceil(Math.random() * (9 - 1) + 1),
      sales: Math.ceil(Math.random() * 10000 * 100) / 100,
      expenses: Math.ceil(Math.random() * 5000 * 100) / 100,
      change: Math.round((Math.random() - 0.45) * 10000) / 10000,
      ip: '111.111.111.111',
    },
    true,
  )
}

</script>
<style>
.change-up {
  color: darkgreen;
}
.change-up:before {
  content: '\25b2\00a0';
}
.change-down {
  color: darkred;
}
.change-down:before {
  content: '\25bc\00a0';
}
</style>

```
