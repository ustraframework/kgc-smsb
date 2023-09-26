<template>
  <VCard>
    <template #text>
      <WjTreeView
        :itemsSource="treeData"
        :initialized="ctl => (treeView = ctl)"
        displayMemberPath="text"
        childItemsPath="items"
        :autoCollapse="false"
        style="height: 200px"
      ></WjTreeView>

      <div class="mt-2">
        <UButton text="Collapse All" @click="() => treeView.collapseToLevel(0)" />
        <UButton text="Expand All" @click="() => treeView.collapseToLevel(100)" />
      </div>

      <UMarkdownViewer :content="treeDesc" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjTreeView } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { TreeView } from '@grapecity/wijmo.nav'

// @ts-ignore
import treeDesc from './md/tree1.md'

const treeView = ref<TreeView>()

const treeData = [
  { text: 'Root', items: [{ text: 'Child1' }, { text: 'Child2' }] },
  { text: 'Root2', items: [{ text: 'Child1' }, { text: 'Child2' }] },
]
</script>
