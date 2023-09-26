```html
<template>
  <div ref="renderEl"></div>
  <UButton text="팝업 오픈" @click="() => (showPopup = true)" />
</template>
<script lang="ts" setup>
import RenderPopup from './popup/render-popup.vue'


const renderEl = ref()

const { showPopup } = (() => {
  const instance = getCurrentInstance()
  const popupVNode = ref<VNode>()
  const showPopup = computed({
    get() {
      if (!popupVNode.value) {
        return false
      }
      return popupVNode.value.component.props.modelValue
    },
    set(value) {
      popupVNode.value.component.props.modelValue = value
    },
  })

  onMounted(() => {
    const { vNode } = $ustra.utils.component.mount(RenderPopup, instance, {
      props: {
        modelValue: showPopup.value,
        'onUpdate:modelValue': value => {
          showPopup.value = value
        },
      },
      children: undefined,
      element: renderEl.value,
    })

    popupVNode.value = vNode
  }, instance)

  onBeforeUnmount(() => (showPopup.value = false), instance)

  return { showPopup }
})()
</script>
```
