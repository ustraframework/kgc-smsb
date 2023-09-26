<template>
  <VCard>
    <template #text>
      <h3>Workbook Customizing</h3>
      toExcel 메소드를 호출할 때, 파일 명을 null로 지정하면 onSaved callback에서 Workbook 객체를 수신받을 수 있다. Workbook 객체를 사용하여 sheet의
      추가, 제거와 각 Cell의 값과 스타일을 변경할 수 있는 기능을 제공한다.

      <WjFlexGrid :itemsSource="data" style="height: 200px" class="mt-5" :initialized="grid.initialize">
        <WjFlexGridColumn header="Country" binding="country" width="2*" />
        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
      </WjFlexGrid>

      <UButton text="Export Excel" @click="exportExcel"></UButton>
      <UMarkdownViewer :content="export2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGridColumn, WjFlexGrid } from '#ustra/nuxt-wijmo/components'
import { ref } from '#ustra/nuxt'
import { wijmoXlsx } from '#ustra/nuxt-wijmo'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import export2 from './md/export2.md'

const grid = useWijmoFlexGrid()
const _getData = () => {
  const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
  const data = []
  for (let i = 0; i < countries.length; i++) {
    data.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
    })
  }

  return data
}

const data = ref(_getData())

function exportExcel() {
  grid.export.toExcel(null, true, {
    onSaved(base64, workbook) {
      // add sheet
      const sheet = new wijmoXlsx.WorkSheet()
      workbook._addWorkSheet(sheet, 1)

      // add row
      const row = new wijmoXlsx.WorkbookRow()
      sheet._addWorkbookRow(row)

      // add cell
      const cell = new wijmoXlsx.WorkbookCell()
      row._addWorkbookCell(cell)

      // set cell value
      cell.value = 'col(0,0)'

      // set cell style
      const cellStyle = new wijmoXlsx.WorkbookStyle()
      cellStyle.font = new wijmoXlsx.WorkbookFont()
      cellStyle.font.color = '#ff0000'
      cellStyle.font.bold = true

      cell.style = cellStyle

      workbook.saveAsync('export2.xlsx')
    },
  })
}
</script>
