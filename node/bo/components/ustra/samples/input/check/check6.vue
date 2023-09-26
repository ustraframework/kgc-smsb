<template>
  <v-card>
    <template #text>
      <h3>Click Event</h3>
      Check Box의 경우도 Radio Box와 동일하게 event 객체의 value 값으로 Click 시 현재 입력된 value 값을 확인할 수 있다.
      <UCheckGroupBox
        :items-source="[
          { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item3' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item4', disabled: true },
        ]"
        :border="false"
        v-model="checkValue"
        :stack="true"
        item-align="left"
        @click="onCheckClick"
      >
      </UCheckGroupBox>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checkValue : {{ checkValue }}
      </v-chip>

      <UMarkdownViewer :content="check7" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UCheckGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import check7 from './md/check7.md'

const checkValue = ref(['N', 'N', 'N', 'N'])

function onCheckClick(e) {
  alert('check value : ' + e.value)
}
</script>
