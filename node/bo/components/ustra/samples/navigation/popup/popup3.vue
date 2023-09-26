<template>
  <v-card>
    <template #subtitle> <UMarkdownViewer :content="popup4" /></template>
    <template #text>
      <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>

      <UPopup v-model="showPopup" :width="800" :height="600" title="팝업제목" @shown="() => notifyShow()" @hidden="() => notifyHidden()">
        <div>내용</div>
      </UPopup>

      <UMarkdownViewer :content="popup5" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UPopup } from '#ustra/nuxt-wijmo/components'

import popup4 from './md/popup4.md'
import popup5 from './md/popup5.md'

const showPopup = ref(false)

function notifyShow() {
  alert('팝업 shown')
}

function notifyHidden() {
  alert('팝업 hidden')
}
</script>
