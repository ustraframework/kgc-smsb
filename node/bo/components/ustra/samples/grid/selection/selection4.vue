<template>
  <VCard>
    <template #title>CheckBox Selection</template>
    <template #text>
      <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" :initialized="e => (gridControl = e)">
        <WjFlexGridColumn header="이름" binding="name" :width="100" />
        <WjFlexGridColumn header="주소" binding="address" width="*" />
      </WjFlexGrid>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        gridSelectionData : {{ gridSelectionData }}
      </v-chip>

      <UMarkdownViewer :content="selection4" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { shallowRef } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWjGridCheckBoxSelection, useCollectionView } from '#ustra/nuxt-wijmo/composables'
import { FlexGrid } from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import selection4 from './md/selection4.md'

const gridControl = shallowRef<FlexGrid>()
const { selectionRowData: gridSelectionData } = useWjGridCheckBoxSelection(gridControl)

const gridData = useCollectionView([
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
