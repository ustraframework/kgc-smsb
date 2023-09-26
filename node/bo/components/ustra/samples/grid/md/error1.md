```html
<template>
  <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="initializeGrid">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWijmo } from '#ustra/nuxt-wijmo/composables/wijmo'
import { reactive } from '#ustra/nuxt'

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

const data = reactive(_getData())

const initializeGrid = flex => {
  const wijmo = useWijmo()

  flex.cellEditEnding.addHandler((s, e) => {
    let col = s.columns[e.col]
    if (col.binding == 'sales' || col.binding == 'expenses') {
      let value = wijmo.changeType(s.activeEditor.value, wijmo.DataType.Number, col.format)
      if (!wijmo.isNumber(value) || value < 0) {
        e.cancel = true
        e.stayInEditMode = true
        console.log('error')
      }
    }
  })
}
</script>

```
