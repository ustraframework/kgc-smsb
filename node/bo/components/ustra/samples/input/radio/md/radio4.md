```html
<template>
  <URadioGroupBox
    :items-source="[
      { value: 'left', text: 'left' },
      { value: 'center', text: 'center' },
      { value: 'right', text: 'right' },
    ]"
    v-model="alignValue"
  ></URadioGroupBox>
  <URadioGroupBox
    :items-source="[
      { value: '01', text: 'Item1' },
      { value: '01', text: 'Item2' },
      { value: '03', text: 'Item3' },
      { value: '04', text: 'Item4', disabled: true },
    ]"
    :border="true"
    :itemAlign="alignValue"
    direction="column"
    v-model="radioValue"
  >
  </URadioGroupBox>
</template>
<script lang="ts" setup>
const radioValue = ref('01')
const alignValue = ref<'left' | 'center' | 'right'>('left')
</script>
```
