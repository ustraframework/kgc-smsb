```html
<UCodeMultiComboBox :grpCd="grpCd" v-model="comboValue" v-model:objectValue="comboObjectValue" style="width: 500px" />

<UButton icon="mdi-comment-edit" text="콤보 박스 값 변경" @click="changeComboValue"></UButton>
<UButton icon="mdi-comment-edit" text="그룹 코드 변경" @click="() => (grpCd = grpCd === 'SYS_CD' ? 'WORK_DV_CD' : 'SYS_CD')"></UButton>

<script lang="ts" setup>
const comboValue = ref<string[]>([])
const comboObjectValue = ref(null)
const grpCd = ref('SYS_CD')

function changeComboValue() {
  const codes = useUstraCodeList(grpCd.value, true)

  if (codes.length > 0) {
    comboValue.value = [codes[codes.length - 1].dtlCd]
  }
}
</script>
```
