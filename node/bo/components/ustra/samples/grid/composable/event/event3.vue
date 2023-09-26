<template>
  <VCard title="3) onAfterInitialized">
    <template #subtitle>그리드 control이 초기화 됐을 때 발생한다.</template>
    <template #text>
      <WjFlexGrid style="height: 150px" class="mt-5" :initialized="grid.initialize">
        <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
        <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
      </WjFlexGrid>

      <UMarkdownViewer :content="event3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import event3 from './md/event3.md'

const grid = useWijmoFlexGrid({
  onAfterInitialized(control) {
    console.log('그리드 초기화 완료', control)
  },
})
</script>
