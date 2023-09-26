```html
<template>
  <WjComboBox
    :itemsSource="[
      { value: '01', text: '항목1' },
      { value: '02', text: '항목2' },
      { value: '03', text: '항목3' },
    ]"
    v-model="comboValue"
    selectedValuePath="value"
    displayMemberPath="text"
  />
</template>
<script lang="ts" setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'

const comboValue = ref(null)
</script>
```
