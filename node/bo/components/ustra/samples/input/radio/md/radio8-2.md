위의 예제는 item slot을 정의하여 각 항목의 value와 text 값을 한번에 표시하는 예제이다.

```html
<template>
  <URadioGroupBox v-model="radioValue" :itemsSource="radioItems">
    <template #item="{ item }">
      <span>{{ item.value }} : {{ item.text }}</span>
    </template>
  </URadioGroupBox>
</template>
<script lang="ts" setup>
const radioItems = reactive([
  { value: '1', text: 'radio1' },
  { value: '2', text: 'radio2', disabled: true },
  { value: '3', text: 'radio3' },
])

const radioValue = ref('1')
</script>
```
