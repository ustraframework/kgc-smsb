<template>
  <VCard>
    <template #text>
      <h3>JSX를 사용한 렌더링</h3>
      <UMarkdownViewer :content="doc1" />
      <render />
      <renderPopup />

      <UButton text="Open Popup" @click="() => (showPopup = true)" />
    </template>
  </VCard>
</template>
<script lang="tsx" setup>
import { ref } from '#ustra/nuxt'
import { UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import RenderPopup from './popup/render-popup.vue'

// @ts-ignore
import doc1 from './md/rendering2-1.md'

const render = () => {
  const onClick = () => alert('버튼 클릭')
  return <UButton text="렌더링된 버튼" onClick={() => alert('버튼 클릭')}></UButton>
}

const showPopup = ref(false)
const renderPopup = () => {
  return <RenderPopup modelValue={showPopup.value} onUpdate:modelValue={value => (showPopup.value = value)} />
}
</script>
