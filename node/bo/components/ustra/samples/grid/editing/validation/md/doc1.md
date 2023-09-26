```html
<template>
   <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
      <WjFlexGridColumn header="Country" binding="country" width="2*" :isReadOnly="true" />
      <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
      <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
    </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const data = reactive([])
const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
  })
}

const wijmo = useWijmo()
const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized() {
    grid.rawControl.cellEditEnding.addHandler((s, e) => {
      let col = s.columns[e.col]
      if (col.binding == 'sales' || col.binding == 'expenses') {
        let value = wijmo.changeType(s.activeEditor.value, wijmo.DataType.Number, col.format)
        if (!wijmo.isNumber(value) || value < 0) {
          e.cancel = true
          e.stayInEditMode = true
          toast('잘못된 데이터가 입력되었습니다.')
        }
      }
    })
  },
})
</script>
```
