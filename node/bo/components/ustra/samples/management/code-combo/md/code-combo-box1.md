```html
<UCodeComboBox :grpCd="grpCd" v-model="comboValue" v-model:objectValue="comboObjectValue" />

<v-btn prepend-icon="mdi-comment-edit" @click="() => changeComboValue">콤보 박스 값 변경</v-btn>
<v-btn class="ml-1" prepend-icon="mdi-comment-edit" 
  @click="() => (grpCd = grpCd === 'SYS_CD' ? 'WORK_DV_CD' : 'SYS_CD')">
  그룹 코드 변경</v-btn>

<script lang="ts" setup>
const comboValue = ref(null)
const comboObjectValue = ref(null)
const grpCd = ref('SYS_CD')

function changeComboValue() {
  const codes = useUstraCodeList(grpCd.value, true)

  if (codes.length > 0) {
    comboValue.value = codes[codes.length - 1].dtlCd
  }
}
</script>
```
