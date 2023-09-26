```html
<template>
   <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
    <WjFlexGridColumn header="Country" binding="country" width="2*" :isRequired="true" />
    <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
    <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
    <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd" />
  </WjFlexGrid>

  <UButton text="데이터 변경" @click="changeData" />
  <UButton text="Validate (with focus)" @click="() => checkValidate(true)" />
  <UButton text="Validate (with focus)" @click="() => checkValidate(false)" />
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
  grid.collectionView.sourceCollection[0].expenses = -1
  grid.rawControl.invalidate()
}

function checkValidate(focus = true) {
  const result = grid.editing.isValidData(focus)

  if (result) {
    toast('모든 입력 값이 유효합니다.')
  } else {
    toast('잘못 입력 된 값이 있습니다.')
  }
}
</script>
```
