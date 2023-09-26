<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="daumPost1_1" />

      <UFieldSet>
        <UFieldRow>
          <UField label="우편번호">
            <UTextBox type="icon" :width="100" @iconClick="() => (showPopup = true)" v-model="inputData.zipNo"></UTextBox>
            <WjInputMask v-model="inputData.address1"></WjInputMask>
            <WjInputMask v-model="inputData.address2"></WjInputMask>
          </UField>
        </UFieldRow>
      </UFieldSet>

      <UDaumPostPopup v-model="showPopup" :options="options" @selected="onSelected" />
      <br />
      <UMarkdownViewer :content="daumPost1_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { DaumPostResult, DaumPostScreenOptions } from '#ustra/nuxt/externals/daum/post'
import { reactive, ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UFieldSet, UFieldRow, UField, UTextBox, WjInputMask } from '#ustra/nuxt-wijmo/components'
import UDaumPostPopup from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'

// @ts-ignore
import daumPost1_1 from './md/daum-post1-1.md'

// @ts-ignore
import daumPost1_2 from './md/daum-post1-2.md'

const options: DaumPostScreenOptions = {
  autoClose: false,
}

const inputData = reactive({
  zipNo: null,
  address1: null,
  address2: null,
})

function onSelected(result: DaumPostResult) {
  inputData.zipNo = result.zonecode
  inputData.address1 = result.addr
}

const showPopup = ref(false)
</script>
