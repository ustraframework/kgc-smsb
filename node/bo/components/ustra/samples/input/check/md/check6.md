```html
<UCheckGroupBox
  :items-source="[
    { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
    { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
    { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
    { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
  ]"
  :border="false"
  v-model="checked5"
  :stack="true"
  :item-align="alignValue"
>
</UCheckGroupBox>
```
