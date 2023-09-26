위의 예제는 헤더 컬럼인 경우, "Header" 문자열을 추가하여 보여주는 예제이다.

```html
<template>
  <WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource" :initialized="grid.initialize">
    <WjFlexGridColumn header="시스템코드" binding="sysCd" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"></WjFlexGridColumn>
    <WjFlexGridColumn
      header="사용자상태코드"
      binding="usrSttCd"
      :cellTemplate="ctx => useUstraCodeValue('USR_STT_CD', ctx.value)"
    ></WjFlexGridColumn>
    <WjFlexGridColumn
      header="숫자 포맷팅"
      binding="toCurrency"
      :cellTemplate="ctx => $ustra.utils.formatting.currency(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="숫자 포맷팅(소수점)"
      binding="toCurrency"
      :cellTemplate="ctx => $ustra.utils.formatting.currency(ctx.value, 2)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일자)"
      binding="dateValue"
      :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일자)"
      binding="dateTextValue"
      :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일시)"
      binding="dateValue"
      :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)"
    ></WjFlexGridColumn>
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid({
  tooltip: {
    enabled: true,
    modifyTooltipText(grid, e, text) {
      // when header row
      if (e.panel === grid.columnHeaders) {
        return `<strong>Header : ${text}</strong>`
      }
      return text
    },
  },
})

const itemsSource = ref([
  { sysCd: 'BO', usrSttCd: '01', toCurrency: 90121, dateValue: new Date(), dateTextValue: '20221123' },
  { sysCd: 'FO', usrSttCd: '04', toCurrency: 90121, dateValue: new Date(), dateTextValue: '20221123' },
])
</script>
```
