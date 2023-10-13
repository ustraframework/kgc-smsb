useUstraCkEditor5 API를 사용하는 경우, Source Editing 플러그인을 제어할 수 있는 추가 기능을 제공한다.
- sourceEditing.isEditingMode : useUstraCkEditor5 메소드에서 반환되는 속성으로 Ref<boolean> 유형의 변수이며, 소스 에디팅 모드를 조회하거나 설정하여 소스 에디팅 모드를 제어할 수 있다.

```html
<template>
  <UCkEditor5 v-model="content" :initialized="ckEditor.initialize" :height="300" :useSourceEditing="true" />

  <UButton text="소스에디팅 여부 확인" @click="() => $ustra.dom.window.alert(ckEditor.sourceEditing.isEditingMode.value)" />
  <UButton
    :text="ckEditor.sourceEditing.isEditingMode.value ? '에디터종료' : '에디터오픈'"
    @click="() => (ckEditor.sourceEditing.isEditingMode.value = !ckEditor.sourceEditing.isEditingMode.value)"
  />
</template>
<script lang="ts" setup>
const content = ref('')
const ckEditor = useUstraCkEditor5()
</script>

```
