<template>
  <VCard>
    <template #text>
      <h3>useWjTreeSelectedItemData</h3>
      <WjTreeView
        :itemsSource="treeData"
        :initialized="ctl => (treeView = ctl)"
        displayMemberPath="text"
        childItemsPath="items"
        :autoCollapse="false"
        style="height: 200px"
        class="mt-2"
      ></WjTreeView>

      <div>selectedItem : {{ treeViewSelection }}</div>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { TreeView } from '@grapecity/wijmo.nav'
import { WjTreeView } from '#ustra/nuxt-wijmo/components'
import { useWjTreeSelectedItemData } from '#ustra/nuxt-wijmo/composables'

import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/tree2.md'

type TreeData = {
  text: string
  items?: TreeData[]
}
const treeView = ref<TreeView>()
const treeViewSelection = useWjTreeSelectedItemData<TreeData>(treeView)

const treeData: TreeData[] = [
  { text: 'Root', items: [{ text: 'Child1' }, { text: 'Child2' }] },
  { text: 'Root2', items: [{ text: 'Child1' }, { text: 'Child2' }] },
]
</script>
