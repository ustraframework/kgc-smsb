<template>
  <v-card>
    <template #title> 그룹버튼 라디오버튼 & 기본값 설정 </template>
    <template #subtitle> type은 'radio'로 설정, v-model값으로 값 그리기, id값으로 그룹지정, checkValue값으로 기본 선택값 지정 </template>
    <template #text>
      <UBox>
        <UItem>
          <UButtonGroup v-model="data2" id="radiobox8" type="radio" />
          <UButtonGroup v-model="data2" id="radiobox81" type="radio" v-model:checkValue="data2Check" />
        </UItem>
        <UItem>
          <UButton text="초기화" @click="resetBtn()" />
          <UButton text="test3 선택" @click="onClickTestBtn()" />
        </UItem>
      </UBox>

      <UMarkdownViewer>{{ base8 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import base8 from './md/base8.md'
import { reactive, ref } from '#ustra/nuxt'

const data2 = reactive([
  { value: '1', label: 'test1' },
  { value: '2', label: 'test2' },
  { value: '3', label: 'test3' },
  { value: '4', label: 'test4' },
])
const data2Check = ref<string>('1')

const resetBtn = () => {
  data2Check.value = ''
}

const onClickTestBtn = () => {
  data2Check.value = '3'
}
</script>
