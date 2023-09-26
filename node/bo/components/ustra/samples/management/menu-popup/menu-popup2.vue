<template>
  <VCard>
    <template #text>
      <h3>다중 선택 예제</h3>
      <br />
      <UButton text="팝업오픈" @click="() => (showPopup = true)" />
      <UMenuPopup v-model="showPopup" :multiple="true" @selected="data => (selectedItem = data)" />

      <br />
      <VChip class="ma-2 pa-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
        <VIcon start icon="mdi-label"></VIcon>
        selectedItem : {{ selectedItem }}
      </VChip>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UMenuPopup } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import doc1 from './md/menu-popup2.md'

const showPopup = ref(false)
const selectedItem = ref(null)
</script>
