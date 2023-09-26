<template>
  <v-card>
    <template #text>
      <h3>radioBtn Custom</h3>
      radioBtn을 커스텀하여 활용할 수 있다. <br /><br />
      <UBox direction="row">
        <UItem :ratio="1">
          <UButtonGroup v-model="buttonData" v-model:checkValue="dataCheck" :id="buttonId" type="radio" @click="clickSetDate" />
        </UItem>
        <UItem :ratio="1">
          <UDatePeriodBox v-model="dateArr11" />
        </UItem>
      </UBox>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        dateArr11 : {{ dateArr11 }}
      </v-chip>
      <UMarkdownViewer>{{ doc }}</UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive, computed, watch } from 'vue'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { useDatePeriod } from '#ustra/nuxt-wijmo/composables'
import { UDatePeriodBox, UButtonGroup } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc from './md/date-period8.md'

const dateArr11 = ref(['20220507', '20221009'])

let buttonData = reactive([
  { value: '-1m', label: '-1개월' },
  { value: '-7D', label: '-1주' },
  { value: '-1d', label: '-1일' },
  { value: 0, label: '오늘' },
  { value: '1D', label: '1일' },
  { value: '7d', label: '1주' },
  { value: '1M', label: '1개월' },
  { value: 'ME', label: '월말' },
  { value: 'YE', label: '연말' },
])

const buttonId = computed(() => {
  return $ustra.utils.system.uuidBase62()
})

const clickSetDate = e => {
  if (e.target.value) {
    dateArr11.value = useDatePeriod(e.target.value)
  }
}

/**
 * 날짜 선택이 없을때 UButtonGroup 버튼 초기화
 */
const dataCheck = ref('')

watch(
  () => dateArr11.value,
  v => {
    if (v === undefined) {
      return
    }
    if (v[0] === null && v[1] === null) {
      dataCheck.value = ''
    }
  },
  {
    immediate: true,
  },
)
</script>
<style scoped>
.samplebox {
  margin: 20px 0;
}
</style>
