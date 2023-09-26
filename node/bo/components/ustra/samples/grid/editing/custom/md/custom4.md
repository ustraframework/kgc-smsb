```html
<template>
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
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjComboBox } from '#ustra/nuxt-wijmo/components'
import { SelectionMode } from '@grapecity/wijmo.grid'

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
```
