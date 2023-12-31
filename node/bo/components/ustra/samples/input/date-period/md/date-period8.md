```html
<template>
  <UBox direction="row">
    <UItem ratio="1">
      <UButtonGroup v-model="buttonData" v-model:checkValue="dataCheck" :id="buttonId" type="radio" @click="clickSetDate" />
    </UItem>
    <UItem ratio="1">
      <UDatePeriodBox v-model="dateArr11" />
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, computed, watch } from 'vue'
import { useDatePeriod } from '#ustra/nuxt-wijmo/composables/datePeriod'

const dateArr11 = ref(['20220507', '20221009'])

const buttonData = reactive([
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
  dateArr11.value = useDatePeriod(e.target.value)
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
```
