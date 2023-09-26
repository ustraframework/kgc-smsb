<template>
  <v-card>
    <template #text>
      <h3>item template</h3>
      <UMarkdownViewer :content="doc1" />
      <URadioGroupBox v-model="radioValue" :itemsSource="radioItems">
        <template #item="{ item }">
          <span>{{ item.value }} : {{ item.text }}</span>
        </template>
      </URadioGroupBox>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        radioValue : {{ radioValue }}
      </v-chip>
      <UMarkdownViewer :content="doc2" />

      <br />
      itemTemplate 속성을 사용하여 slot의 이름을 변경할 수 있다.
      <UMarkdownViewer :content="doc3" />
      <URadioGroupBox v-model="radioValue2" :itemsSource="radioItems" itemTemplate="custom">
        <template #custom="{ item }">
          <span>{{ item.value }} : {{ item.text }}</span>
        </template>
      </URadioGroupBox>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { URadioGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/radio8-1.md'

// @ts-ignore
import doc2 from './md/radio8-2.md'

// @ts-ignore
import doc3 from './md/radio8-3.md'

const radioItems = reactive([
  { value: '1', text: 'radio1' },
  { value: '2', text: 'radio2', disabled: true },
  { value: '3', text: 'radio3' },
])

const radioValue = ref('1')
const radioValue2 = ref('1')
</script>
