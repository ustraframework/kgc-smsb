<template>
  <div>
    <VCard title="Tab">
      <template #text>
        <UMarkdownViewer :content="tab" />
      </template>
    </VCard>
    <Tab1 />
    <Tab2 />
    <Tab3 />
    <Tab4 />
    <Tab5 />
  </div>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import tab from './md/tab.md'

import Tab1 from './tab1.vue'
import Tab2 from './tab2.vue'
import Tab3 from './tab3.vue'
import Tab4 from './tab4.vue'
import Tab5 from './tab5.vue'
</script>
