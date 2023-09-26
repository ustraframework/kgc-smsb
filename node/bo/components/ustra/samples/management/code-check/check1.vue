<template>
  <VCard>
    <template #text>
      <h3>기본 사용법</h3>
      콤보 박스와 동일한 형태로 grpCd 속성을 입력하여 radio 버튼을 코드 목록만큼 노출할 수 있다.

      <div class="mt-2 mb-5">
        <UCodeCheckGroupBox v-model="checkValue" v-model:objectValue="checkObjectValue" grpCd="SYS_CD" />
      </div>

      <UButton text="체크박스 값 설정" @click="checkValue = ['BT', 'FO']" />

      <br />
      <br />

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checkValue : {{ checkValue }}
      </v-chip>
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checkObjectValue : {{ checkObjectValue }}
      </v-chip>

      <UMarkdownViewer :content="check1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer, UButton } from '#ustra/nuxt-wijmo/components'
import { UCodeCheckGroupBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import check1 from './md/check1.md'

const checkValue = ref(null)
const checkObjectValue = ref(null)
</script>
