```html
<URadioGroupBox
  :items-source="[
    { value: '01', text: 'Item1' },
    { value: '01', text: 'Item2' },
    { value: '03', text: 'Item3' },
    { value: '04', text: 'Item4', disabled: true },
  ]"
  :border="true"
  v-model="radioValue"
  direction="column"
>
</URadioGroupBox>
```
