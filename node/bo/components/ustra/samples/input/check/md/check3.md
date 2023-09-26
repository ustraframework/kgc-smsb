여러 항목의 체크 박스를 노출할 경우에는 연동되는 model 값은 배열 형태로 변경된다.
또한 border 속성을 사용하여 항목 별로 border를 노출할 수 있다.

```html
<UCheckGroupBox
  :items-source="[
    { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
    { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
    { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
    { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
  ]"
  :border="true"
  v-model="checked3"
  direction="column"
>
</UCheckGroupBox>
```
