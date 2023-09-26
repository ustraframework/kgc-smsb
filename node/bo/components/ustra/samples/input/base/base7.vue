<template>
  <v-card>
    <template #title> 그룹버튼 체크박스 & 기본값 설정 </template>
    <template #subtitle> type은 'checkbox'로 설정, v-model값으로 값 그리기, id값으로 그룹지정, checkValueArray값으로 기본 선택값 지정 </template>
    <template #text>
      <UBox>
        <UItem>
          <UButtonGroup v-model="data1" id="checkbox7" type="checkbox" />
          <UButtonGroup v-model="data1" id="checkbox71" type="checkbox" :checkValueArray="data1Check" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base7 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base7 from './md/base7.md'
import { reactive, ref } from '#ustra/nuxt'
const data1 = reactive([
  { value: 1, label: 'test1' },
  { value: 2, label: 'test2' },
  { value: 3, label: 'test3' },
  { value: 4, label: 'test4' },
])
const data1Check = ref<string[]>(['1', '3'])
</script>
