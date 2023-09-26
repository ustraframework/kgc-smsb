<template>
  <VCard>
    <template #text>
      <h3>allowedDates</h3>
      <br />
      allowedDates 속성은 선택 가능한 일자를 지정한다. 아래 예제는 오늘과 1일, 5일 후 일자만을 선택 가능하게 하는 예제이다.
      <br /><br />

      <UDatepicker
        v-model="value"
        class="mt-2"
        :enableTimePicker="true"
        :autoApply="false"
        format="yyyy-MM-dd HH:mm"
        :allowedDates="[new Date(), $ustra.utils.date.addDays(new Date(), 1), $ustra.utils.date.addDays(new Date(), 5)]"
      />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        value : {{ value }}
      </v-chip>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import UDatepicker from '#ustra/nuxt-vuetify/components/form/u-datepicker.vue'

// @ts-ignore
import doc1 from './md/datepicker5.md'

const value = ref(null)
</script>
