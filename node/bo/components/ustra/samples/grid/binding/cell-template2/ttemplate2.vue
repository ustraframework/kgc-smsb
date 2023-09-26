<template>
  <VCard>
    <template #title>Format Utilities</template>
    <template #text>
      <UMarkdownViewer :content="cellTemplate2_1" />
      <WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource">
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

        <WjFlexGridColumn
          header="Date 포맷팅(일시)"
          binding="dateTimeTextValue"
          :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)"
        ></WjFlexGridColumn>

        <WjFlexGridColumn
          header="시간포맷팅(HH:mm)"
          binding="timeTextValue"
          :cellTemplate="ctx => $ustra.utils.formatting.time(ctx.value)"
        ></WjFlexGridColumn>

        <WjFlexGridColumn
          header="시간포맷팅(HH:mm:ss)"
          binding="timeTextValue2"
          :cellTemplate="ctx => $ustra.utils.formatting.time(ctx.value)"
        ></WjFlexGridColumn>

        <WjFlexGridColumn header="카드 번호" binding="cardNoText" :cellTemplate="ctx => $ustra.utils.formatting.cardNo(ctx.value)"></WjFlexGridColumn>
        <WjFlexGridColumn
          header="사업자 번호"
          binding="corpRegNoText"
          :cellTemplate="ctx => $ustra.utils.formatting.corpRegNo(ctx.value)"
        ></WjFlexGridColumn>
        <WjFlexGridColumn
          header="파일사이즈"
          binding="fileSize"
          :cellTemplate="ctx => $ustra.utils.formatting.fileSize(ctx.value)"
        ></WjFlexGridColumn>
      </WjFlexGrid>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { useUstraCodeValue } from '#ustra/nuxt/management'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import cellTemplate2_1 from './md/cell-template2-1.md'

const itemsSource = ref([
  {
    toCurrency: 90121,
    dateValue: new Date(),
    dateTextValue: '20221123',
    dateTimeTextValue: '20221123105921',
    timeTextValue: '2130',
    timeTextValue2: '213012',
    cardNoText: '4879214569578136',
    corpRegNoText: '69815487985',
    fileSize: 189636181,
  },
])
</script>
