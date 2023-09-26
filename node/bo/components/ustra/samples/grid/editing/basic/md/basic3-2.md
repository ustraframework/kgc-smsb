```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn binding="id" header="id" :isReadOnly="true" />
    <WjFlexGridColumn binding="country" header="country" />
    <WjFlexGridColumn binding="editable" header="editable" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { SelectionMode } from '@grapecity/wijmo.grid'

const data = ref([])
const countries = ['US', 'Germany', 'UK', 'Japan', 'Italy', 'Greece']
for (let i = 0; i < countries.length; i++) {
  data.value.push({
    id: i,
    country: countries[i],
    editable: false,
  })
}

for (let i = 0; i < countries.length; i++) {
  data.value.push({
    id: i + countries.length,
    country: countries[i],
    editable: false,
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  selection: {
    mode: SelectionMode.Cell,
  },
  onAfterInitialized() {
    grid.rawControl.beginningEdit.addHandler((s, e) => {
      if (e.getColumn().binding !== 'editable') {
        const rowData = e.getRow().dataItem
        if (!rowData.editable) {
          e.cancel = true
          toast('ediable 항목이 체크되지 않을 경우, 편집이 불가능합니다.')
        }
      }
    })

    grid.rawControl.cellEditEnding.addHandler((s, e) => {
      if (e.getColumn().binding === 'country') {
        if (!s.activeEditor.value) {
          toast('필수 입력입니다.')
          e.stayInEditMode = true
          return
        }
      }
    })

    grid.rawControl.cellEditEnded.addHandler((s, e) => {
      if (e.getColumn().binding === 'country') {
        // 동일한 country 항목을 찾아 변경
        grid.collectionView.sourceCollection.forEach(row => {
          // 기존 데이터와 동일한 row 조회
          if (row.country === e.data) {
            row.country = e.getRow().dataItem.country
            grid.rawControl.invalidate()
          }
        })
      }
    })
  },
})
</script>
```
