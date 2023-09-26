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
  <UCheckGroupBox
    :items-source="[
      { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
      { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
      { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
      { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
    ]"
    :border="false"
    v-model="checked5"
    direction="column"
    :item-align="alignValue"
  >
  </UCheckGroupBox>
</template>
<script lang="ts" setup>
const checked5 = reactive(['N', 'N', 'N', 'N'])
const alignValue = ref<'left' | 'center' | 'right'>('left')
</script>
```
