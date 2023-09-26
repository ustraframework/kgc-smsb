<template>
  <VCard>
    <template #text>
      <h3>direction</h3>
      direction 속성을 사용하여 하위 아이템의 방향 변경할 수 있다. <br />
      - row : 아이템을 줄 기준으로 (기본 값) <br />
      - column : 아이템을 줄이 쌓이는 형태로 <br /><br />

      <URadioGroupBox
        :items-source="[
          { value: '01', text: 'Item1' },
          { value: '01', text: 'Item2' },
          { value: '03', text: 'Item3' },
          { value: '04', text: 'Item4', disabled: true },
        ]"
        :border="true"
        v-model="radioValue"
        direction="column"
      >
      </URadioGroupBox>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { URadioGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/radio3.md'

const radioValue = ref('01')
</script>
