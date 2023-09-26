<template>
  <v-card>
    <template #text>
      <h3>isMaxValue</h3>
      true로 지정 시, 무기한 기간 설정이 가능한 체크박스를 활성화한다. <br />
      지정 해 주지 않으면 기본값은 false이다. <br />
      박스를 체크 할 경우 종료일자가 9999-12-31 23:59:59로 변경되며, 체크 해제 시 종료일자가 현재 시각으로 셋팅된다. <br />
      <br />

      <UDatePeriodBox v-model="dateArr10" mode="datetime" :isMaxValue="true" />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        dateArr10 : {{ dateArr10 }}
      </v-chip>
      <UMarkdownViewer>{{ doc }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive, computed } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc from './md/date-period7.md'

const dateArr10 = ref(['20220507220912', '20221009220912'])
const dateArr11 = ref(['20220507', '20221009'])
</script>
<style scoped>
.samplebox {
  margin: 20px 0;
}
</style>
