```html
<template>
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
</template>
<script lang="ts" setup>
import { TreeView } from '@grapecity/wijmo.nav'

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
```
