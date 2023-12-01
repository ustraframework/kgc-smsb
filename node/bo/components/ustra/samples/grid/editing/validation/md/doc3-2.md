
```html
<template>
  <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn header="Country" binding="country" :width="300" :isRequired="true" />
    <WjFlexGridColumn header="Sales" binding="sales" :width="300" format="n2" />
    <WjFlexGridColumn header="Expenses" binding="expenses" :width="300" format="n2" />
    <WjFlexGridColumn binding="date" header="Date" :width="300" format="yyyy-MM-dd" :isRequired="false" />
  </WjFlexGrid>

  <UButton text="데이터 변경" @click="changeData" />
  <UButton text="Validate" @click="() => checkValidate()" />
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'

const data = reactive([])
const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    date: useWijmo().DateTime.addDays(new Date(), -Math.random() * 360),
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized() {
    grid.collectionView.getError = (item, prop, parsing) => {
      // parsing errors
      if (parsing) {
        switch (prop) {
          case 'date':
            return '"2022-05-05" 이 형식에 맞춰 입력해주세요.'
          default:
            return '숫자를 입력해주세요.'
        }
      }
      // data errors
      if (prop == 'sales' && item.sales < 0) {
        return '음수는 입력이 안됩니다.'
      }
      if (prop == 'expenses' && item.expenses < 0) {
        return '음수는 입력이 안됩니다.'
      }
      // no errors
      return null
    }
  },
})

function changeData() {
  grid.collectionView.sourceCollection.forEach(data => (data.expenses = -1))
  grid.rawControl.invalidate()
}

function checkValidate() {
  if (isValidCollectionView(grid.collectionView)) {
    alert('모든 데이터가 유효합니다.')
  } else {
    alert('잘못된 입력 값이 있습니다.')
  }
}
</script>
```
