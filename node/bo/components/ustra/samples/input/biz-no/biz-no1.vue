<template>
  <v-card>
    <template #text>
      UBizNoBox 컴포넌트를 사용하여 사업자 번호를 입력할 수 있다. UCorpNoBox는 WjInputMask 컴포넌트를 기반으로 제작되었으므로 WjInputMask 컴포넌트의
      속성을 모두 사용할 수 있다.

      <br /><br />

      <UBizNoBox v-model="value" />
      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        value : {{ value }}
      </v-chip>

      <UMarkdownViewer :content="doc1" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UBizNoBox, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/biz-no1.md'

const value = ref(null)
</script>
