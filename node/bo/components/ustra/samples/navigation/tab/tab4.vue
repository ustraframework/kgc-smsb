<template>
  <VCard>
    <template #text>
      component 태그를 사용하여 tab별로 동적인 컴포넌트를 렌더링할 수 있다.

      <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
        <WjTab v-for="(tab, index) in tabData" :key="index" :isDisabled="tab.disabled" :isVisible="tab.visible">
          <a>{{ tab.title }}</a>
          <component :is="tab.component" />
        </WjTab>
      </WjTabPanel>
    </template>

    <UMarkdownViewer :content="tab4" />
  </VCard>
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables'
import { reactive, defineAsyncComponent, markRaw } from '#ustra/nuxt'

// @ts-ignore
import tab4 from './md/tab4.md'

const tabPanel = useWijmoTabPanel()
const tabData = reactive([
  { title: 'Tab1', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl1.vue'))) },
  { title: 'Tab2', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl2.vue'))) },
  { title: 'Tab3', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl3.vue'))) },
])
</script>
