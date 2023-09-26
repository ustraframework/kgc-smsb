<template>
  <v-card>
    <template #text>
      <h3>mode</h3>
      mode로 컴포넌트의 입력 형태를 제어할 수 있다. 따로 지정 해 주지 않으면 기본값은 'date' mode 이다. <br /><br />
      <div class="samplebox">
        <UDatePeriodBox v-model="dateArr2" mode="date" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            dateArr2 : {{ dateArr2 }}
          </v-chip>
        </div>
        <UDatePeriodBox v-model="dateArr3" mode="datetime" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            dateArr3 : {{ dateArr3 }}
          </v-chip>
        </div>
        <UDatePeriodBox v-model="dateArr4" mode="year" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            dateArr4 :{{ dateArr4 }}
          </v-chip>
        </div>
        <UDatePeriodBox v-model="dateArr5" mode="yearmonth" />
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            dateArr5 : {{ dateArr5 }}
          </v-chip>
        </div>
      </div>
      <UMarkdownViewer>{{ doc1 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UDatePeriodBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/date-period2.md'

const dateArr2 = ref(['20220507', '20221009'])
const dateArr3 = ref(['20220507220912', '20221009220912'])
const dateArr4 = ref(['2020', '2030'])
const dateArr5 = ref(['202205', '202210'])
</script>
<style scoped>
.samplebox {
  margin-bottom: 30px;
}
</style>
