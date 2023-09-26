itemsSource 목록 내의 trueValue, falseValue 속성으로 입력 값을 boolean 형태가 아닌 설정된 값으로 세팅할 수 있다.

```html
<template>
  <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: 'Item1' }]" v-model="checked2"> </UCheckGroupBox>
</template>

<script lang="ts" setup>
const checked2 = ref('N')
</script>
```
