<template>
  <v-card>
    <template #title> 그룹버튼 길이 조정 </template>
    <template #subtitle> width 값으로 길이 조정 </template>
    <template #text>
      <UBox>
        <UItem>
          <UButtonGroup v-model="data1" id="checkbox91" type="checkbox" width="300" />
          <UButtonGroup v-model="data1" id="checkbox92" type="checkbox" width="400" />
          <UButtonGroup v-model="data1" id="checkbox93" type="checkbox" width="500" />
        </UItem>
      </UBox>
      <UBox>
        <UItem>
          <UButtonGroup v-model="data2" id="radiobox91" type="radio" width="300" />
          <UButtonGroup v-model="data2" id="radiobox92" type="radio" width="400" />
          <UButtonGroup v-model="data2" id="radiobox93" type="radio" width="500" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base9 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base9 from './md/base9.md'
import { reactive, ref } from '#ustra/nuxt'
const data1 = reactive([
  { value: 1, label: 'test1' },
  { value: 2, label: 'test2' },
  { value: 3, label: 'test3' },
  { value: 4, label: 'test4' },
])
const data2 = reactive([
  { value: 1, label: 'test1' },
  { value: 2, label: 'test2' },
  { value: 3, label: 'test3' },
  { value: 4, label: 'test4' },
])
</script>
