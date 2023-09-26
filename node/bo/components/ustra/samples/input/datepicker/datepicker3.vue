<template>
  <VCard>
    <template #text>
      <h3>Range</h3>
      <br />
      range 속성을 사용하여 기간을 설정할 수 있으며, minDate, maxDate 속성으로 입력 기간 설정이 가능하다.
      <br /><br />

      <UDatepicker v-model="value" class="mt-2" range :minDate="new Date()" :maxDate="$ustra.utils.date.addDays(new Date(), 60)" />
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
import doc1 from './md/datepicker3.md'

const value = ref([])
</script>
