h 메소드를 사용하여 setup 스크립트 상에서 컴포넌트를 동적으로 렌더링할 수 있다.

```html
<template>
  <render />
  <renderPopup />

  <UButton text="Open Popup" @click="() => (showPopup = true)" />
</template>
<script lang="ts" setup>
import RenderPopup from './popup/render-popup.vue'

const render = () => {
  return h(UButton, {
    text: '렌더링된 버튼',
    onClick() {
      alert('버튼 클릭')
    },
  })
}

const showPopup = ref(false)
const renderPopup = () => {
  return h(RenderPopup, {
    modelValue: showPopup.value,
    'onUpdate:modelValue'(value) {
      showPopup.value = value
    },
  })
}
</script>

```
