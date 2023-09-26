<template>
  <VCard>
    <template #text>
      <h3>공통 코드</h3>
      <UMarkdownViewer :content="cellTemplate1_1" />
      <WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource">
        <WjFlexGridColumn header="시스템코드" binding="sysCd" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"></WjFlexGridColumn>
        <WjFlexGridColumn
          header="사용자상태코드"
          binding="usrSttCd"
          :cellTemplate="ctx => useUstraCodeValue('USR_STT_CD', ctx.value)"
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
import cellTemplate1_1 from './md/cell-template1-1.md'

const itemsSource = ref([
  { sysCd: 'BO', usrSttCd: '01' },
  { sysCd: 'FO', usrSttCd: '04' },
])
</script>
