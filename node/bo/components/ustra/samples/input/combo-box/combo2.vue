<template>
  <VCard>
    <template #title><h5>선택 값 조회</h5></template>
    <template #text>
      <UMarkdownViewer :content="combo2_1" />

      <WjComboBox
        :itemsSource="items"
        selectedValuePath="value"
        displayMemberPath="text"
        :initialized="e => (comboBoxControl = e)"
        v-model="comboBoxValue"
      />
      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        comboBoxValue : {{ comboBoxValue }}
      </v-chip>
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        comboBoxControl?.selectedValue : {{ comboBoxControl?.selectedValue }}
      </v-chip>
      <UMarkdownViewer :content="combo2_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { shallowRef, ref, reactive } from '#ustra/nuxt'
import { WjComboBox, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { wijmoInput } from '#ustra/nuxt-wijmo'

// @ts-ignore
import combo2_1 from './md/combo2-1.md'
// @ts-ignore
import combo2_2 from './md/combo2-2.md'

const comboBoxControl = shallowRef<wijmoInput.ComboBox>()
const comboBoxValue = ref(null)
const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]

const inputData = reactive({
  comboValue: null,
})
const comboValue2 = ref(null)
</script>
