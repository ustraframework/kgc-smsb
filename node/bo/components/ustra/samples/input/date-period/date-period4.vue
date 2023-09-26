<template>
  <v-card>
    <template #text>
      <h3>readonly</h3>
      컴포넌트를 비활성화한다. 지정 해 주지 않으면 기본값은 false이다. <br /><br />

      <UDatePeriodBox v-model="dateArr7" :readonly="true" />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        dateArr7 : {{ dateArr7 }}
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
import doc from './md/date-period4.md'

const dateArr7 = ref(['20220507', '20221009'])
const dateArr11 = ref(['20220507', '20221009'])
</script>
<style scoped>
.samplebox {
  margin: 20px 0;
}
</style>
