<template>
  <v-card>
    <template #subtitle
      >customizeItems 속성은 함수 형태로 매핑하여 바인딩되는 item 목록 값을 변경할 수 있다. 콤보 박스에 표시될 text 항목은 display, 바인딩 되는 코드
      값은 value 로 설정한다.
    </template>
    <template #text>
      <UCodeComboBox grpCd="SYS_CD" v-model="comboValue" displayNullText="전체" :customizeItems="adjustComboBoxItem" />

      <div>
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          comboValue : {{ comboValue }}
        </v-chip>
      </div>

      <UMarkdownViewer :content="desc"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import desc from './md/code-combo-box4.md'

const comboValue = ref(null)

function adjustComboBoxItem(items) {
  items.push({
    display: '추가 코드',
    value: 'ADD',
  })

  return items
}
</script>
