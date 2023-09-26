```html
<template>
  <UButton text="Render Button" @click="() => renderButton()"></UButton>
  <UButton text="Destory" @click="() => destoryButton()"></UButton>
  <div ref="renderEl" class="mt-2"></div>
</template>
<script lang="ts" setup>
const renderEl = ref()
const instance = getCurrentInstance()

const { renderButton, destoryButton } = (() => {
  const destoryFn = ref<() => void>(null)
  function renderButton() {
    const { destroy } = $ustra.utils.component.mount(UButton, instance, {
      element: renderEl.value,
      props: {
        text: '렌더링된 버튼',
        onClick() {
          alert('버튼 클릭')
        },
      },
    })
    destoryFn.value = destroy
  }

  return { renderButton, destoryButton: destoryFn }
})()
</script>
```
