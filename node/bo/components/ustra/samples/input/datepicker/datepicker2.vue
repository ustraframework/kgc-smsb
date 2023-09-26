<template>
  <VCard>
    <template #text>
      <h3>상태 제어</h3>
      <br />
      readonly, disabled 속성을 사용하여 입력 박스의 상태를 제어할 수 있다.
      <br /><br />

      <UCheckGroupBox v-model="states" :stack="true" :itemsSource="[{ text: 'readonly' }, { text: 'disabled' }]" />

      <UDatepicker v-model="value" class="mt-2" :readonly="states[0]" :disabled="states[1]" />
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
import { UCheckGroupBox } from '#ustra/nuxt-wijmo/components'
import UDatepicker from '#ustra/nuxt-vuetify/components/form/u-datepicker.vue'

// @ts-ignore
import doc1 from './md/datepicker2.md'

const value = ref(null)
const states = ref([false, false])
</script>
