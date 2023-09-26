<template>
  <v-card>
    <template #text>
      <h3>displayFormat, valueFormat</h3>
      displayFormat으로 날짜 표시 포맷을 지정하고, valueFormat로 저장 될 날짜의 포맷을 변경 할 수 있다. <br /><br />
      <div class="samplebox">
        <UDatePeriodBox v-model="dateArr6" mode="datetime" displayFormat="yyyy-MM" valueFormat="yyyyMMddHHmm" />
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          dateArr6 : {{ dateArr6 }}
        </v-chip>
      </div>
      <UMarkdownViewer>{{ doc3 }}</UMarkdownViewer>

      valueFormat 값을 'Date'로 설정할 경우는 Date 원형의 값을 송수신할 수 있다.
      <div class="samplebox">
        <UDatePeriodBox v-model:start="dateValues.start" v-model:end="dateValues.end" mode="date" valueFormat="Date" />
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          startValue : {{ dateValues.start }}, endValue : {{ dateValues.end }}
        </v-chip>
      </div>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UDatePeriodBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc3 from './md/date-period3.md'

const dateArr6 = ref(['202205072209', '202210092209'])

const dateValues = reactive({
  start: new Date(),
  end: new Date(),
})
</script>
<style scoped>
.samplebox {
  margin: 20px 0;
}
</style>
