<template>
  <VCard>
    <template #text>
      <h3>tooltip 텍스트 변경</h3>
      <UMarkdownViewer :content="tooltip2_1" />
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

      <UMarkdownViewer :content="tooltip2_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useUstraCodeValue } from '#ustra/nuxt/management'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import tooltip2_1 from './md/tooltip2-1.md'

// @ts-ignore
import tooltip2_2 from './md/tooltip2-2.md'

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
