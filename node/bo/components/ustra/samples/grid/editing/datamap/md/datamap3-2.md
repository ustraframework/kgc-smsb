```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-3">
    <WjFlexGridColumn header="시스템코드" binding="sysCd" :dataMap="createUstraCodeDataMap('SYS_CD')" :isReadOnly="false"></WjFlexGridColumn>
    <WjFlexGridColumn
      header="사용자구분코드"
      binding="useDvCd"
      :dataMap="createUstraCodeDataMap('USE_DV_CD', '없음.')"
      :isReadOnly="false"
    ></WjFlexGridColumn>
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const data = []
const countries = ['US', 'Germany', 'UK', 'Japan', 'Sweden', 'Norway', 'Denmark']
const customerMap = createUstraCodeDataMap('SYS_CD')
customerMap.getDisplayValues = dataItem => {
  return customerMap.collectionView.sourceCollection.filter(data => data.country === dataItem.country).map(data => data.text)
}

for (let i = 0; i < 5; i++) {
  data.push({
    sysCd: 'BO',
    useDvCd: null,
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})
</script>
```
