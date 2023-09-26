
```html
<template>
  <WjFlexGrid :itemsSource="data" style="height: 200px" class="mt-5" :initialized="grid.initialize">
    <WjFlexGridColumn header="Country" binding="country" width="2*" />
    <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
    <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
  </WjFlexGrid>

  <UButton text="Export Excel" @click="exportExcel"></UButton>
</template>
<script lang="ts" setup>
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
```
