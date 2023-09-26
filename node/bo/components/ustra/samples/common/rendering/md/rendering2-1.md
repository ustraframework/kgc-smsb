setup 스크립트의 lang 속성을 tsx로 지정하여 JSX 문법을 사용하여 템플릿을 동적으로 생성할 수 있다.

```html
<template>
  <render />
  <renderPopup />

  <UButton text="Open Popup" @click="() => (showPopup = true)" />
</template>
<script lang="tsx" setup>
import RenderPopup from './popup/render-popup.vue'

const render = () => {
  const onClick = () => alert('버튼 클릭')
  return <UButton text="렌더링된 버튼" onClick={() => alert('버튼 클릭')}></UButton>
}

const showPopup = ref(false)
const renderPopup = () => {
  return <RenderPopup modelValue={showPopup.value} onUpdate:modelValue={value => (showPopup.value = value)} />
}
</script>
```
