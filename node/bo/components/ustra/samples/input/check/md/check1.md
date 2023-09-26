itemsSource 속성을 사용하여 표시할 체크박스 목록을 설정할 수 있다.

```html
<template>
  <UCheckGroupBox :items-source="[{ text: 'Item1' }]" v-model="checked"> </UCheckGroupBox>
  <UCheckGroupBox :items-source="[{ text: 'Item2' }]" v-model="checked1"> </UCheckGroupBox>
</template>

<script lang="ts" setup>
const checked = ref(true)
const checked1 = ref(true)
</script>
```
