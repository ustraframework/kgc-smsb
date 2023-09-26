<template>
  <v-card>
    <template #subtitle> buttons slot을 사용하여 하단 버튼을 추가할 수 있다.</template>
    <template #text>
      <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>

      <UPopup v-model="showPopup" :width="800" :height="600" title="팝업제목">
        <div>내용</div>
        <template #buttons>
          <UButton
            text="저장"
            type="primary"
            @click="
              () => {
                useGlobal()
                  .alert('저장되었습니다.')
                  .then(() => (showPopup = false))
              }
            "
          />
          <UButton
            text="닫기"
            @click="
              () => {
                useGlobal()
                  .confirm('창을 닫으시겠습니까?')
                  .then(r => {
                    if (r) showPopup = false
                  })
              }
            "
          />
        </template>
      </UPopup>
      <UMarkdownViewer :content="popup3" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UPopup } from '#ustra/nuxt-wijmo/components'
import { useGlobal } from '#ustra/nuxt/composables'

// @ts-ignore
import popup3 from './md/popup3.md'

const showPopup = ref(false)
</script>
