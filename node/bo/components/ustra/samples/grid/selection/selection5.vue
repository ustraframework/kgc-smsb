<template>
  <VCard>
    <template #title>RadioBox Selection</template>
    <template #text>
      <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" :initialized="grid.initialize">
        <WjFlexGridColumn :width="30">
          <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
            <URadioGroupBox
              name="checkRadio"
              :id="`checkRadio-${cell.row.index}`"
              v-model="selectedIndex"
              :itemsSource="[{ value: cell.row.index, text: ' ' }]"
              itemAlign="center"
            />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>
        <WjFlexGridColumn header="이름" binding="name" :width="100" />
        <WjFlexGridColumn header="주소" binding="address" width="*" />
      </WjFlexGrid>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        selectedIndex : {{ selectedIndex }}
      </v-chip>

      <UMarkdownViewer :content="selection5" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { reactive, ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, URadioGroupBox } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { SelectionMode } from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import selection5 from './md/selection5.md'

const grid = useWijmoFlexGrid({
  selection: {
    mode: SelectionMode.None,
  },
})

const selectedIndex = ref(-1)

const gridData = reactive([
  {
    selected: null,
    name: '홍길동',
    address: '서울시 강남구 양재동',
  },
  {
    selected: null,
    name: '강감찬',
    address: '서울 서초구 양재동',
  },
  {
    selected: null,
    name: '유관순',
    address: '서울시 중구 종로동',
  },
])
</script>
