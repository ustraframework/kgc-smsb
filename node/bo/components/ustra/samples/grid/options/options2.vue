<template>
  <VCard>
    <template #text>
      <h3>autoClipboard</h3>
      <UMarkdownViewer :content="doc1" />

      아래 예제에서 autoClipboard 속성을 변경하고, Row를 선택한 후 복사 붙여넣기 작업을 통해 차이점을 확인할 수 있다.
      <br /><br />
      <UCheckGroupBox v-model="autoClipboard" :itemsSource="[{ text: 'autoClipboard' }]" />

      <WjFlexGrid :autoClipboard="autoClipboard" :itemsSource="data" class="mt-2">
        <WjFlexGridColumn header="컬럼1" binding="col1" />
        <WjFlexGridColumn header="컬럼2" binding="col2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { WjFlexGrid, WjFlexGridColumn, WjComboBox, UCheckGroupBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/options2-1.md'

// @ts-ignore
import doc2 from './md/options1-2.md'

const autoClipboard = ref(true)
const data = [
  { col1: '텍스트1-1', col2: '텍스트1-2' },
  { col1: '텍스트2-1', col2: '텍스트2-2' },
]
</script>
