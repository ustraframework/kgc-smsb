<template>
  <VCard>
    <template #title>Single Row Selection</template>
    <template #subtitle> selectionMode를 "Row"로 설정하여 단일 Row를 선택하도록 설정할 수 있다. </template>
    <template #text>
      <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" selectionMode="Row" :initialized="e => (gridControl = e)">
        <WjFlexGridColumn header="이름" binding="name" :width="100" />
        <WjFlexGridColumn header="주소" binding="address" width="*" />
      </WjFlexGrid>

      <br />
      <UButton text="Clear Selection" @click="() => gridControl.select(-1, -1)" />
      <br />

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        gridSelectionData : {{ gridSelectionData }}
      </v-chip>

      <UMarkdownViewer :content="selection1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { reactive, shallowRef } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useWjGridSelectionData } from '#ustra/nuxt-wijmo/composables'
import { FlexGrid } from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import selection1 from './md/selection1.md'

const gridControl = shallowRef<FlexGrid>()
const gridSelectionData = useWjGridSelectionData<GrdData>(gridControl, true)

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
