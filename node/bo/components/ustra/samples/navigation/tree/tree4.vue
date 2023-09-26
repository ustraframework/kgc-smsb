<template>
  <VCard>
    <template #text>
      <h3>useWijmoTreeView</h3>
      <UMarkdownViewer :content="doc1" />

      <WjTreeView
        :itemsSource="treeData"
        :initialized="treeView.initialize"
        displayMemberPath="text"
        childItemsPath="items"
        :autoCollapse="false"
        :showCheckboxes="true"
        style="height: 200px"
        class="mt-2"
      ></WjTreeView>

      <UButton text="Expand All" @click="() => treeView.expandAll()" />
      <UButton text="Collapse All" @click="() => treeView.collapseAll()" />

      <br /><br />
      <VChip class="ma-2 pa-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
        <VIcon start icon="mdi-label"></VIcon>
        Checked Items : {{ treeView.checkedItems.value }}
      </VChip>
      <br />
      <VChip class="ma-2 pa-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
        <VIcon start icon="mdi-label"></VIcon>
        Selected Item : {{ treeView.selectedItem.value }}
      </VChip>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjTreeView, UButton } from '#ustra/nuxt-wijmo/components'
import { useWijmoTreeView } from '#ustra/nuxt-wijmo/composables'

import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/tree4-1.md'

// @ts-ignore
import doc2 from './md/tree4-2.md'

type TreeData = {
  id: number
  text: string
  items?: TreeData[]
}
const treeView = useWijmoTreeView<TreeData>({
  useCheckSelection: true,
})

const treeData: TreeData[] = [
  {
    id: 1,
    text: 'Root',
    items: [
      { id: 2, text: 'Child1' },
      { id: 3, text: 'Child2' },
    ],
  },
  {
    id: 4,
    text: 'Root2',
    items: [
      { id: 5, text: 'Child1' },
      { id: 6, text: 'Child2' },
    ],
  },
]
</script>
