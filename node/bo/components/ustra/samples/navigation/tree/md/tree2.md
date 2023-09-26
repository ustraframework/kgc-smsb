useWjTreeSelectedItemData 메소드를 사용하여 tree selection을 동적으로 감지할 수 있다.

```html
<template>
  <WjTreeView
    :itemsSource="treeData"
    :initialized="ctl => (treeView = ctl)"
    displayMemberPath="text"
    childItemsPath="items"
    :autoCollapse="false"
    style="height: 200px"
  ></WjTreeView>

  <div>selectedItem : {{ treeViewSelection }}</div>
</template>
<script lang="ts" setup>
import { TreeView } from '@grapecity/wijmo.nav'

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
```
