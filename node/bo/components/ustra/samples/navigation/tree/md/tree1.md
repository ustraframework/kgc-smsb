트리는 WjTreeView 컴포넌트를 사용하여 구현할 수 있다. 아래의 속성을 바인딩하여 계층형 데이터를 트리 컴포넌트가 인식할 수 있도록 한다.
- childItemsPath : 하위 노드 데이터가 위치하는 Props
- displayMemberPath : 노드에 Display할 Path

```html
<template>
  <WjTreeView :initialized="ctl => (treeView = ctl)" :itemsSource="treeData" displayMemberPath="text" childItemsPath="items" :autoCollapse="false" style="height: 300px"></WjTreeView>
</template>
<script lang="ts" setup>
import { TreeView } from '@grapecity/wijmo.nav'

const treeView = ref<TreeView>()

const treeData = [
  { text: 'Root', items: [{ text: 'Child1' }, { text: 'Child2' }] },
  { text: 'Root2', items: [{ text: 'Child1' }, { text: 'Child2' }] },
]
</script>
```

collapseToLevel 메소드를 사용하여 트리 노드의 expand 상태를 제어할 수 있다. (https://www.grapecity.com/wijmo/api/classes/wijmo_angular2_nav.wjtreeview.html#collapsetolevel)
collapseToLevel 메소드는 특정 레벨 기준으로 노드의 접힘 상태를 설정하는데 큰 값을 설정하여 모든 노드를 펼치거나 0을 설정하여 모든 노드를 접을 수 있다.

```html
<UButton text="Collapse All" @click="() => treeView.collapseToLevel(0)" />
<UButton text="Expand All" @click="() => treeView.collapseToLevel(100)" />
```
