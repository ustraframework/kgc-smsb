위의 예제는 그리드의 바인딩된 데이터를 변환하는 기본적인 예제이다.
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
  grid.export.toExcel('DownloadExcel.xlsx')
}
</script>
```
