<template>
  <v-card>
    <template #text>
      <h3>itemAlign</h3>
      itemAlign 속성은 하위 아이템의 정렬 기준을 변경할 수 있다. left / center / right 값을 설정할 수 있으며, 기본 값은 center 이다.<br />

      <URadioGroupBox
        :items-source="[
          { value: 'left', text: 'left' },
          { value: 'center', text: 'center' },
          { value: 'right', text: 'right' },
        ]"
        v-model="alignValue"
      ></URadioGroupBox>
      <UCheckGroupBox
        :items-source="[
          { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
        ]"
        :border="false"
        v-model="checked5"
        direction="column"
        :item-align="alignValue"
      >
      </UCheckGroupBox>

      <UMarkdownViewer :content="check5" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { UCheckGroupBox, URadioGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import check5 from './md/check5.md'

const checked5 = reactive(['N', 'N', 'N', 'N'])

const alignValue = ref<'left' | 'center' | 'right'>('left')
</script>
