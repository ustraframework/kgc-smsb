<template>
  <VCard>
    <template #text>
      <br /><br />

      <h3>계층형 콤보박스</h3>
      <br />
      상위 데이터가 변경되었을 때, 하위에 존재하는 목록이 변경되는 형태는 WjFlexGridCellTemplate과 이벤트를 사용하여 구현할 수 있다. 아래의 예제는
      Country을 선택했을 시, Sub Country 목록이 변경되어 순서대로 정보를 설정할 수 있는 예제이다.

      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="Country" binding="country" :width="150">
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <WjComboBox :itemsSource="countries" v-model="cell.value" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn header="Sub Country" binding="subCountry" :width="150">
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <WjComboBox :itemsSource="cell.item.subListData" v-model="cell.value" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>
      </WjFlexGrid>

      <br />
      <VBanner :border="true" :rounded="true" theme="dark">
        <pre>{{ JSON.stringify(data, null, 4) }}</pre>
      </VBanner>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { reactive } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { SelectionMode } from '@grapecity/wijmo.grid'

// @ts-ignore
import doc1 from './md/custom4.md'

const data = reactive([])
const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')

for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    subCountry: null,
    subListData: [],
    _loadedCountry: null,
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  selection: {
    mode: SelectionMode.Cell,
  },
  onAfterInitialized() {
    grid.rawControl.prepareCellForEdit.addHandler((s, e) => {
      getSubComboData(e.getRow().dataItem)
    })
    grid.rawControl.cellEditEnded.addHandler((s, e) => {
      getSubComboData(e.getRow().dataItem)
    })
  },
})

async function getSubComboData(itemData) {
  if (itemData._loadedCountry === itemData.country) {
    return
  }
  itemData._loadedCountry = itemData.country
  setTimeout(() => {
    const data = []
    for (let i = 0; i < 5; i++) {
      data.push(itemData.country + ':' + i)
    }
    itemData.subListData = data
  }, 500)
}
</script>
