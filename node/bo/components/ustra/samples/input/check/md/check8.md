```html
<template>
  <UCheckGroupBox
    :items-source="[{ text: 'Item1' }, { text: 'Item2' }, { text: 'Item3' }]"
    :border="false"
    v-model="dataSource.checkComputedValue.value"
    :stack="true"
    item-align="left"
  >
  </UCheckGroupBox>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    dataSource.checkComputedValue : {{ dataSource.checkComputedValue.value }}
  </v-chip>
</template>
<script lang="ts" setup>
const dataSource = reactive({
  checkValues: [{ checkBoxValue: 'N' }, { checkBoxValue: 'Y' }, { checkBoxValue: 'N' }],
  checkComputedValue: computed({
    get() {
      return reactive(dataSource.checkValues.map(r => r.checkBoxValue === 'Y'))
    },
    set(v) {
      v.forEach((vv, index) => {
        dataSource.checkValues[index].checkBoxValue = vv ? 'Y' : 'N'
      })
    },
  }),
})
</script>
```
