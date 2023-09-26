<template>
  <v-card>
    <template #text>
      <h3>itemAlign</h3>
      itemAlign 속성은 하위 아이템의 정렬 기준을 변경할 수 있다. left / center / right 값을 설정할 수 있으며, 기본 값은 center 이다.<br />
      direction 속성이 "column"일 때만 유효하다.

      <URadioGroupBox
        :items-source="[
          { value: 'left', text: 'left' },
          { value: 'center', text: 'center' },
          { value: 'right', text: 'right' },
        ]"
        v-model="alignValue"
      ></URadioGroupBox>
      <URadioGroupBox
        :items-source="[
          { value: '01', text: 'Item1' },
          { value: '01', text: 'Item2' },
          { value: '03', text: 'Item3' },
          { value: '04', text: 'Item4', disabled: true },
        ]"
        :border="true"
        :itemAlign="alignValue"
        direction="column"
        v-model="radioValue"
      >
      </URadioGroupBox>

      <UMarkdownViewer :content="doc1" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { URadioGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/radio4.md'

const radioValue = ref('01')
const alignValue = ref<'left' | 'center' | 'right'>('left')
</script>
