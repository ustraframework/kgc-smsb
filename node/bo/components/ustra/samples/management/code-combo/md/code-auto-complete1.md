```html
<template>
  <UCodeAutoComplete
    :grpCd="grpCd"
    v-model="comboValue"
    v-model:objectValue="comboObjectValue"
    displayNullText="선택해주세요."
    style="width: 500px"
  />

  <div>
    <v-chip class="ma-2" color="pink" label text-color="white">
      <v-icon start icon="mdi-label"></v-icon>
      comboValue : {{ comboValue }}
    </v-chip>
    <v-chip class="ma-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
      <v-icon start icon="mdi-label"></v-icon>
      comboObjectValue : {{ comboObjectValue }}
    </v-chip>
  </div>

  <div class="ma-2">
    <UButton icon="mdi-comment-edit" text="콤보 박스 값 변경" @click="changeComboValue"></UButton>
    <UButton icon="mdi-comment-edit" text="그룹 코드 변경" @click="() => (grpCd = grpCd === 'SYS_CD' ? 'WORK_DV_CD' : 'SYS_CD')"></UButton>
  </div>
</template>

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
