각 radio button의 label을 렌더링하는 itemTemplate으로 정의된 template을 생성하여 변경할 수 있다. item slot에는 각 렌더링 되는 itemsSource의 항목 값이 item으로 노출되며 item 값은 itemsSource에 세팅한 값과 동일하다.

| name | 유형 | 설명 |
| --- | --- | --- |
| item | object | 각 Radio 아이템의 row object 값 |
| item.value | string | Radio 아이템의 value 값 |
| item.disabled | boolean | 비활성화 여부 |
| index | number | item의 순번 (0부터 시작) |

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
