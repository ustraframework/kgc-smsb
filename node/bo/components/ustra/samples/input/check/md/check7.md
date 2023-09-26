```html
<template>
  <UCheckGroupBox
    :items-source="[
      { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
      { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
      { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
      { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
    ]"
    :border="false"
    v-model="checkValue"
    :stack="true"
    item-align="left"
    @click="onCheckClick"
  >
  </UCheckGroupBox>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    checkValue : {{ checkValue }}
  </v-chip>
</template>
<script lang="ts" setup>
const checkValue = ref(['N', 'N', 'N', 'N'])

function onCheckClick(e) {
  alert('check value : ' + e.value)
}
</script>
```
