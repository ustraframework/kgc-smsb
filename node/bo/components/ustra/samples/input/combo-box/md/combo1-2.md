```html
<template>
  <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
</template>
<script lang="ts" setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]
</script>
```
