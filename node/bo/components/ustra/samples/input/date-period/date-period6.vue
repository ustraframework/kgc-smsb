<template>
  <v-card>
    <template #text>
      <h3>radioBtn</h3>
      true로 지정 시, 기간 설정을 간단하게 할 수 있는 라디오 버튼을 활성화 시킨다. <br />
      지정 해 주지 않으면 기본값은 false이다. <br /><br />

      <UDatePeriodBox v-model="dateArr9" :radioBtn="true" />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        dateArr9 : {{ dateArr9 }}
      </v-chip>
      <UMarkdownViewer>{{ doc }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UDatePeriodBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc from './md/date-period6.md'

const dateArr9 = ref(['20220507', '20221009'])
</script>
<style scoped>
.samplebox {
  margin: 20px 0;
}
</style>
