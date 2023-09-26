<template>
  <v-card>
    <template #text>
      <h3>isDefaultValue</h3>
      true로 지정 시, 바인딩 된 데이터가 null인 경우에 한하여 현재 시각으로 초기화된다. <br />
      지정 해 주지 않으면 기본값은 false이다.<br /><br />

      <UDatePeriodBox v-model="dateArr8" mode="datetime" :isDefaultValue="true" />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        dateArr8 : {{ dateArr8 }}
      </v-chip>
      <UMarkdownViewer>{{ doc1 }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UDatePeriodBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/date-period5.md'

const dateArr8 = ref([null, null])
</script>
<style scoped>
.samplebox {
  margin: 20px 0;
}
</style>
