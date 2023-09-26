<template>
  <v-card>
    <template #text>
      <h3>direction</h3>
      direction 속성을 사용하여 하위 아이템의 방향 변경할 수 있다. <br />
      - row : 아이템을 줄 기준으로 (기본 값) <br />
      - column : 아이템을 줄이 쌓이는 형태로 <br /><br />

      <UCheckGroupBox
        :items-source="[
          { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
        ]"
        :border="true"
        v-model="checked3"
        direction="row"
      >
      </UCheckGroupBox>

      <UMarkdownViewer :content="doc" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { UCheckGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc from './md/check3.md'

const checked3 = reactive(['N', 'N', 'N', 'N'])
</script>
