<template>
  <VCard>
    <template #text>
      <h3>공통코드 Data Map</h3>
      <br />
      <UMarkdownViewer :content="doc1" />

      <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-3">
        <WjFlexGridColumn header="시스템코드" binding="sysCd" :dataMap="createUstraCodeDataMap('SYS_CD')" :isReadOnly="false"></WjFlexGridColumn>
        <WjFlexGridColumn
          header="사용자구분코드"
          binding="useDvCd"
          :dataMap="createUstraCodeDataMap('USE_DV_CD', '없음.')"
          :isReadOnly="false"
        ></WjFlexGridColumn>
      </WjFlexGrid>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { createUstraCodeDataMap } from '#ustra/nuxt-wijmo/management/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import doc1 from './md/datamap3-1.md'

// @ts-ignore
import doc2 from './md/datamap3-2.md'

const data = []
const countries = ['US', 'Germany', 'UK', 'Japan', 'Sweden', 'Norway', 'Denmark']
const customerMap = createUstraCodeDataMap('SYS_CD')
customerMap.getDisplayValues = dataItem => {
  return customerMap.collectionView.sourceCollection.filter(data => data.country === dataItem.country).map(data => data.text)
}

for (let i = 0; i < 5; i++) {
  data.push({
    sysCd: 'BO',
    useDvCd: null,
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})
</script>
