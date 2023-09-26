<template>
  <v-card>
    <template #text>
      UDatePeriodBox 컴포넌트를 사용하여 일자 기간 입력을 처리할 수 있다. <br /><br />
      <div class="samplebox">
        <UDatePeriodBox v-model="dateArr1" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            dateArr1 : {{ dateArr1 }}
          </v-chip>
        </div>
        <UButton text="배열 일자 반영" @click="dateArr1 = ['20220507', '20221009']"></UButton>
        <UButton text="배열 null 반영" @click="dateArr1 = [null, null]"></UButton>

        <div class="samplebox" />
        <UDatePeriodBox v-model:start="start" v-model:end="end" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            start : {{ start }}
          </v-chip>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            end : {{ end }}
          </v-chip>
        </div>
        <VBtn @click="start = '20220507'">시작 일자 반영</VBtn>
        <VBtn class="ml-1" @click="start = null">시작 일자 null 반영</VBtn>
        <VBtn class="ml-1" @click="end = '20221009'">종료 일자 반영</VBtn>
        <VBtn class="ml-1" @click="end = null">종료 일자 null 반영</VBtn>
      </div>
      <UMarkdownViewer>{{ doc1 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UButton, UDatePeriodBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/date-period1.md'

const start = ref('20220507')
const end = ref('20220508')
const dateArr1 = ref(['20220507', '20220508'])
</script>
<style scoped>
.samplebox {
  margin-bottom: 30px;
}
</style>
