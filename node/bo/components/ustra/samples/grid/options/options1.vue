<template>
  <VCard>
    <template #text>
      <h3>headersVisibility</h3>
      <UMarkdownViewer :content="doc1" />

      <WjComboBox v-model="headersVisibility" :itemsSource="headersVisibilityItems" selectedValuePath="value" displayMemberPath="value"></WjComboBox>

      <WjFlexGrid :itemsSource="data" :headersVisibility="headersVisibility" class="mt-2">
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
import { WjFlexGrid, WjFlexGridColumn, WjComboBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/options1-1.md'

// @ts-ignore
import doc2 from './md/options1-2.md'

const headersVisibility = ref('All')
const headersVisibilityItems = [{ value: 'All' }, { value: 'Row' }, { value: 'Column' }, { value: 'None' }]
const data = [
  { col1: '텍스트1-1', col2: '텍스트1-2' },
  { col1: '텍스트2-1', col2: '텍스트2-2' },
]
</script>
