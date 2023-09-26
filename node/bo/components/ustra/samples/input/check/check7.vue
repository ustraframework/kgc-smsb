<template>
  <v-card>
    <template #text>
      <h3>Computed 연계</h3>
      Check Box의 경우도 Radio Box와 동일하게 event 객체의 value 값으로 Click 시 현재 입력된 value 값을 확인할 수 있다.
      <UCheckGroupBox
        :items-source="[{ text: 'Item1' }, { text: 'Item2' }, { text: 'Item3' }]"
        :border="false"
        v-model="dataSource.checkComputedValue.value"
        :stack="true"
        item-align="left"
      >
      </UCheckGroupBox>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        dataSource.checkComputedValue : {{ dataSource.checkComputedValue.value }}
      </v-chip>

      <UMarkdownViewer :content="check8" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive, computed } from '#ustra/nuxt'
import { UCheckGroupBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import check8 from './md/check8.md'

const dataSource = reactive({
  checkValues: [{ checkBoxValue: 'N' }, { checkBoxValue: 'Y' }, { checkBoxValue: 'N' }],
  checkComputedValue: computed({
    get() {
      return reactive(dataSource.checkValues.map(r => r.checkBoxValue === 'Y'))
    },
    set(v) {
      v.forEach((vv, index) => {
        dataSource.checkValues[index].checkBoxValue = vv ? 'Y' : 'N'
      })
    },
  }),
})
</script>
