```html
<template>
  <WjFlexGrid :itemsSource="data" allowDragging="Rows">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
    <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWijmo } from '#ustra/nuxt-wijmo/composables/wijmo'
import { useCollectionView } from '#ustra/nuxt-wijmo/composables/grid'
import { reactive } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import error2 from './md/error2.md'

const _getData = () => {
  const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
  const today = new Date()
  const data = []

  for (let i = 0; i < countries.length; i++) {
    data.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      date: useWijmo().DateTime.addDays(today, -Math.random() * 360),
    })
  }
  return data
}

const data = reactive(
  useCollectionView(_getData(), {
    getError: (item, prop, parsing) => {
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
    },
  }),
)
</script>

```
