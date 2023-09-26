<template>
  <VCard>
    <template #text>
      <h3>위/경도 조회</h3>
      <UMarkdownViewer :content="daumPost3" />
      <UButton text="주소창 오픈" @click="showPopup = true" />
      <UDaumPostPopup v-model="showPopup" :addLatLng="true" @selected="result => (postResult = result)" />

      <br /><br />
      <v-chip class="ma-2" color="pink" label text-color="white" v-if="postResult">
        <v-icon start icon="mdi-label"></v-icon>
        위도 : {{ postResult.lat }} 경도 : {{ postResult.lng }}
      </v-chip>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { DaumPostResult } from '#ustra/nuxt/externals/daum/post'
import UDaumPostPopup from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'

// @ts-ignore
import daumPost3 from './md/daum-post3.md'

const showPopup = ref(false)
const postResult = ref<DaumPostResult>(null)
</script>
