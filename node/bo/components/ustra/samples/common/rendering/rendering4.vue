<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />
      <div ref="renderEl"></div>
      <UButton text="팝업 오픈" @click="() => (showPopup = true)" />
      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref, getCurrentInstance, computed, onMounted, onBeforeUnmount, VNode } from '#ustra/nuxt'
import { UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import RenderPopup from './popup/render-popup.vue'

// @ts-ignore
import doc1 from './md/rendering4-1.md'

// @ts-ignore
import doc2 from './md/rendering4-2.md'

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
