<template>
  <VCard>
    <template #text>
      <h3>useWjTreeCheckedItems</h3>
      showCheckboxes 속성을 true로 설정할 경우, tree 노드를 체크박스 형태로 선택할 수 있으며, useWjTreeCheckedItems 메소드를 사용하여 체크된 노드의
      아이템을 확인할 수 있다.

      <WjTreeView
        :itemsSource="treeData"
        :initialized="ctl => (treeView = ctl)"
        displayMemberPath="text"
        childItemsPath="items"
        :autoCollapse="false"
        :showCheckboxes="true"
        style="height: 200px"
        class="mt-2"
      ></WjTreeView>

      <div>Checked Items : {{ treeCheckedItems }}</div>

      <UMarkdownViewer :content="tree3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { TreeView } from '@grapecity/wijmo.nav'
import { WjTreeView } from '#ustra/nuxt-wijmo/components'
import { useWjTreeCheckedItems } from '#ustra/nuxt-wijmo/composables'

import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import tree3 from './md/tree3.md'

type TreeData = {
  id: number
  text: string
  items?: TreeData[]
}
const treeView = ref<TreeView>()
const treeCheckedItems = useWjTreeCheckedItems<TreeData>(treeView)

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
