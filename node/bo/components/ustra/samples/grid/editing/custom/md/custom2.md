```html
<template>
  <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn header="Country" binding="country" :width="150" />

    <WjFlexGridColumn
      header="System"
      binding="system"
      :width="150"
      :isRequired="false"
      :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"
    >
      <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
        <UCodeInputBox v-model="cell.value" grpCd="SYS_CD" />
      </WjFlexGridCellTemplate>
    </WjFlexGridColumn>

    <WjFlexGridColumn
      header="System2"
      binding="system2"
      :width="150"
      :isRequired="false"
      :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"
    >
      <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
        <UCodeInputBox v-model="cell.value" grpCd="SYS_CD" />
      </WjFlexGridCellTemplate>
    </WjFlexGridColumn>
  </WjFlexGrid>

  <br />
  <VBanner :border="true" :rounded="true" theme="dark">
    <pre>{{ JSON.stringify(data, null, 4) }}</pre>
  </VBanner>
</template>
<script lang="ts" setup>
import { reactive } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate, WjInputNumber } from '#ustra/nuxt-wijmo/components'

const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    system: null,
    system2: null,
  })
}

const grid = useWijmoFlexGrid({
  editing: {
    // dialog를 오픈하는 컬럼 지정
    dialogEditingCols: ['system'],
  },
  isReadOnly: false,
})
</script>
```
