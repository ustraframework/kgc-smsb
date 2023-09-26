<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="Country" binding="country" width="*" />

        <WjFlexGridColumn header="System" binding="system" width="*" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)">
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <UCodeComboBox v-model="cell.value" grpCd="SYS_CD" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n0">
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <WjInputNumber v-model="cell.value" :step="1" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n0">
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <WjInputNumber :modelValue="cell.item.sales" @update:modelValue="v => (cell.item.sales = v)" :step="1" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd">
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <WjInputDate v-model="cell.value" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>
      </WjFlexGrid>

      <br />
      <VBanner :border="true" :rounded="true" theme="dark">
        <pre>{{ JSON.stringify(data, null, 4) }}</pre>
      </VBanner>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { reactive } from '#ustra/nuxt'
import { useUstraCodeValue } from '#ustra/nuxt/management/composables'
import { useWijmo } from '#ustra/nuxt-wijmo/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate, WjInputNumber } from '#ustra/nuxt-wijmo/components'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/custom1-1.md'

// @ts-ignore
import doc2 from './md/custom1-2.md'

const data = reactive([])

const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    date: useWijmo().DateTime.addDays(new Date(), -Math.random() * 360),
    system: 'BO',
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})
</script>
