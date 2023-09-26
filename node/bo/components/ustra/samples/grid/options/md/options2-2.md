```html
<template>
  <UCheckGroupBox v-model="autoClipboard" :itemsSource="[{ text: 'autoClipboard' }]" />

  <WjFlexGrid :autoClipboard="autoClipboard" :itemsSource="data" class="mt-2">
    <WjFlexGridColumn header="컬럼1" binding="col1" />
    <WjFlexGridColumn header="컬럼2" binding="col2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjComboBox, UCheckGroupBox } from '#ustra/nuxt-wijmo/components'

const autoClipboard = ref(true)
const data = [
  { col1: '텍스트1-1', col2: '텍스트1-2' },
  { col1: '텍스트2-1', col2: '텍스트2-2' },
]
</script>

```
