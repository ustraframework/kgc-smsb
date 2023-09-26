```html
<UCodeComboBox grpCd="SYS_CD" v-model="comboValue" displayNullText="전체" :customizeItems="adjustComboBoxItem" />

<script lang="ts" setup>
const comboValue = ref(null)

function adjustComboBoxItem(items) {
  items.push({
    display: '추가 코드',
    value: 'ADD',
  })

  return items
}
</script>
```
