CkEditor 활성화 설정을 완료하면 UCkEditor5 컴포넌트를 사용하여 CkEditor를 사용할 수 있다.
- 참고 : http://guide.ustraframework.kro.kr/ref-doc/11/1RgzF3fDERrPlx4p9fWf


지원 속성은 다음과 같다.
| 명칭 | 유형 | 설명 | 기본 값 |
| --- | --- | --- | --- |
| disabled | boolean | 에디터 비활성화 여부 | false |
| height | number ｜ string | 에디터 높이 | 100% |
| initialized | (editor) ⇒ void | 에디터 초기화 시 Callback Function |  |
| editorName | string | 에디터의 전역변수 명 (해당 값에 따라 설정된 에디터 객체의 모듈 값이 다르게 설정된다.) | ClassicEditor |
| useMarkdown | boolean | markdown 문법의 컨텐츠 사용 여부 | false |


함께 제공되는 useUstraCkEditor5 메소드는 에디터 객체의 고유 기능을 쉽게 사용할 수 있도록 도와준다.

```html
<template>

  <div class="mb-2">
    <UButton :text="disabled ? '활성화' : '비활성화'" @click="disabled = !disabled" />
    <UButton :text="'초기화(history)'" @click="() => ckEditor.initEditor()" />
    <UButton :text="'초기화(value 값 포함)'" @click="() => ckEditor.initEditor(true)" />
    <UButton text="Focus" @click="() => ckEditor.focus()" />
    <UButton text="값 설정" @click="() => (content = '<p>CkEditor 컴포넌트</p>')" />
  </div>
  
  <UCkEditor5 v-model="content" :height="300" :disabled="disabled" :initialized="ckEditor.initialize" />
</template>
<script lang="ts" setup>
const content = ref('')
const disabled = ref(false)
const ckEditor = useUstraCkEditor5()
</script>
```
