```html
<template>
  <UWjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
</template>
<script lang="ts" setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { wijmoInput } from '#ustra/nuxt-wijmo'

const comboBoxControl = shallowRef<wijmoInput.ComboBox>()
const comboBoxValue = ref(null)
const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]
</script>
```
