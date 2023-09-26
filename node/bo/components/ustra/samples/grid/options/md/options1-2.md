```html
<template>
  <WjComboBox v-model="headersVisibility" :itemsSource="headersVisibilityItems" selectedValuePath="value" displayMemberPath="value"></WjComboBox>

  <WjFlexGrid :itemsSource="data" :headersVisibility="headersVisibility" class="mt-2">
    <WjFlexGridColumn header="컬럼1" binding="col1" />
    <WjFlexGridColumn header="컬럼2" binding="col2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjComboBox } from '#ustra/nuxt-wijmo/components'

const headersVisibility = ref('All')
const headersVisibilityItems = [{ value: 'All' }, { value: 'Row' }, { value: 'Column' }, { value: 'None' }]
const data = [
  { col1: '텍스트1-1', col2: '텍스트1-2' },
  { col1: '텍스트2-1', col2: '텍스트2-2' },
]
</script>
```
