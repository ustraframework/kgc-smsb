<template>
  <div>
    <v-card>
      <template #title> Input - 날짜 </template>
    </v-card>

    <v-card>
      <template #title>1) 기본 사용법 </template>
      <template #subtitle> UDateBox 컴포넌트를 사용하여 일자 입력을 처리할 수 있다. </template>
      <template #text>
        <UDateBox v-model="inputValue1" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            inputValue1 : {{ inputValue1 }}
          </v-chip>
        </div>
        <VBtn @click="inputValue1 = '20220507'">일자 반영</VBtn>
        <VBtn class="ml-1" @click="inputValue1 = null">null 반영</VBtn>
        <UMarkdownViewer>{{ date1 }}</UMarkdownViewer>
      </template>
    </v-card>
    <v-card>
      <template #title> 2) mode </template>
      <template #subtitle> mode로 컴포넌트의 입력 형태를 제어할 수 있다. 따로 지정 해 주지 않으면 기본값은 'date' mode 이다. </template>
      <template #text>
        <div class="samplebox">
          <UDateBox v-model="inputValue2" mode="date" />
          <div>
            <v-chip class="ma-2" color="pink" label text-color="white">
              <v-icon start icon="mdi-label"></v-icon>
              inputValue2 : {{ inputValue2 }}
            </v-chip>
          </div>
          <UDateBox v-model="inputValue3" mode="datetime" />
          <div>
            <v-chip class="ma-2" color="pink" label text-color="white">
              <v-icon start icon="mdi-label"></v-icon>
              inputValue3 : {{ inputValue3 }}
            </v-chip>
          </div>
          <UDateBox v-model="inputValue4" mode="year" />
          <div>
            <v-chip class="ma-2" color="pink" label text-color="white">
              <v-icon start icon="mdi-label"></v-icon>
              inputValue4 :{{ inputValue4 }}
            </v-chip>
          </div>
          <UDateBox v-model="inputValue5" mode="yearmonth" />
          <div>
            <v-chip class="ma-2" color="pink" label text-color="white">
              <v-icon start icon="mdi-label"></v-icon>
              inputValue5 : {{ inputValue5 }}
            </v-chip>
          </div>
        </div>
        <UMarkdownViewer>{{ date2 }}</UMarkdownViewer>
      </template>
    </v-card>
    <v-card>
      <template #title> 3) displayFormat, valueFormat </template>
      <template #subtitle> displayFormat으로 날짜 표시 포맷을 지정하고, valueFormat로 저장 될 날짜의 포맷을 변경 할 수 있다. </template>
      <template #text>
        <div class="samplebox">
          <UDateBox v-model="inputValue6" mode="datetime" displayFormat="yyyy-MM" valueFormat="yyyyMMddHHmm" />
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            inputValue6 : {{ inputValue6 }}
          </v-chip>
        </div>
        <UMarkdownViewer>{{ date3 }}</UMarkdownViewer></template
      >
    </v-card>
    <v-card>
      <template #title> 4) readonly </template>
      <template #subtitle> 컴포넌트를 비활성화한다. 지정 해 주지 않으면 기본값은 false이다. </template>
      <template #text>
        <UDateBox v-model="inputValue7" :readonly="true" />
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          inputValue7 : {{ inputValue7 }}
        </v-chip>
        <UMarkdownViewer>{{ date4 }}</UMarkdownViewer>
      </template>
    </v-card>
    <v-card>
      <template #title> 5) isDefaultValue </template>
      <template #subtitle>
        true로 지정 시, 바인딩 된 데이터가 null인 경우에 한하여 현재 시각으로 초기화된다. <br />
        지정 해 주지 않으면 기본값은 false이다.
      </template>
      <template #text>
        <UDateBox v-model="inputValue8" mode="datetime" :isDefaultValue="true" />
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          inputValue8 : {{ inputValue8 }}
        </v-chip>
        <UMarkdownViewer>{{ date5 }}</UMarkdownViewer>
      </template>
    </v-card>
  </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UDateBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import date1 from './md/date1.md'
// @ts-ignore
import date2 from './md/date2.md'
// @ts-ignore
import date3 from './md/date3.md'
// @ts-ignore
import date4 from './md/date4.md'
// @ts-ignore
import date5 from './md/date5.md'

const inputValue1 = ref(null)
const inputValue2 = ref('20220507')
const inputValue3 = ref('20220507220912')
const inputValue4 = ref('2020')
const inputValue5 = ref('202205')
const inputValue6 = ref('202205072209')
const inputValue7 = ref('20220507')
const inputValue8 = ref(null)
</script>
<style scoped>
.samplebox {
  margin-bottom: 30px;
}
</style>
