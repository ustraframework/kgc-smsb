<template>
  <VCard>
    <template #title><h5>기본 사용법</h5></template>
    <template #text>
      콤보 박스와 동일한 형태로 grpCd 속성을 입력하여 radio 버튼을 코드 목록만큼 노출할 수 있다.

      <div class="mt-2 mb-5">
        <UCodeRadioGroupBox v-model="radioValue" v-model:objectValue="radioObjectValue" grpCd="SYS_CD" />
      </div>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        radioValue : {{ radioValue }}
      </v-chip>
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        radioObjectValue : {{ radioObjectValue }}
      </v-chip>

      <UMarkdownViewer :content="radio1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCodeRadioGroupBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import radio1 from './md/radio1.md'

const radioValue = ref(null)
const radioObjectValue = ref(null)
</script>
