```html
<template>
  <URadioGroupBox v-model="radioValue" :itemsSource="radioItems" @click="onRadioClick" />
</template>
<script lang="ts" setup>
const radioItems = reactive([
  { value: '1', text: 'radio1' },
  { value: '2', text: 'radio2', disabled: true },
  { value: '3', text: 'radio3' },
])

const radioValue = ref('1')

function onRadioClick(e) {
  alert('radio value : ' + e.value)
}
</script>
```
