<template>
  <VCard>
    <template #title>Multi Row Selection</template>
    <template #subtitle> selectionMode를 "RowRange"로 설정하여 Multi Row를 선택하도록 설정할 수 있다. </template>
    <template #text>
      <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" selectionMode="RowRange" :initialized="e => (gridControl = e)">
        <WjFlexGridColumn header="이름" binding="name" :width="100" />
        <WjFlexGridColumn header="주소" binding="address" width="*" />
      </WjFlexGrid>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        gridSelectionData : {{ gridSelectionData }}
      </v-chip>

      <UMarkdownViewer :content="selection2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { reactive, ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWjGridSelectionData } from '#ustra/nuxt-wijmo/composables'
import { FlexGrid } from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import selection2 from './md/selection2.md'

const gridControl = ref<FlexGrid>()
const gridSelectionData = useWjGridSelectionData<GrdData[]>(gridControl)

type GrdData = {
  name: string
  address: string
}
const gridData: GrdData[] = reactive([
  {
    name: '홍길동',
    address: '서울시 강남구 양재동',
  },
  {
    name: '강감찬',
    address: '서울 서초구 양재동',
  },
  {
    name: '유관순',
    address: '서울시 중구 종로동',
  },
])
</script>
