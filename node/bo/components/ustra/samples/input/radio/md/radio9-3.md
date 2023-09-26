```html
<URadioGroupBox v-model="radioValue2" :itemsSource="items" itemTemplate="custom">
  <template #custom="{ item }">
    <span>{{ item.value }} : {{ item.text }}</span>
  </template>
</URadioGroupBox>
```
