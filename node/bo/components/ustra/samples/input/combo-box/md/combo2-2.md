```html
<template>
  <WjComboBox
    :itemsSource="items"
    selectedValuePath="value"
    displayMemberPath="text"
    :initialized="e => (comboBoxControl = e)"
    v-model="comboBoxValue"
  />
  <br />
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    comboBoxValue : {{ comboBoxValue }}
  </v-chip>
  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    comboBoxControl?.selectedValue : {{ comboBoxControl?.selectedValue }}
  </v-chip>
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
