```html
<UCodeRadioGroupBox
  v-model="radioValue"
  grpCd="SYS_CD"
  :customizeItems="
    items => {
      items.unshift({
        value: null,
        display: '전체선택',
      })

      return items
    }
  "
/>
```
