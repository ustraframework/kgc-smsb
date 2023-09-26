<template>
  <v-card>
    <template #text>
      <h3>Click Event</h3>
      일반적으로 click 이벤트가 발생할 경우, modelValue 값이 업데이트 되기 전이므로 value 값을 확인하고 싶은 경우, event 객체의 value 값으로 확인할 수
      있다.
      <URadioGroupBox v-model="radioValue" :itemsSource="radioItems" @click="onRadioClick" />

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        radioValue : {{ radioValue }}
      </v-chip>

      <UMarkdownViewer :content="radio2" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { URadioGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import radio2 from './md/radio2.md'

const radioItems = reactive([
  { value: '1', text: 'radio1' },
  { value: '2', text: 'radio2', disabled: true },
  { value: '3', text: 'radio3' },
])

const radioValue = ref('1')

function onRadioClick(e) {
  alert('radio value : ' + e.value)
}
</script>
