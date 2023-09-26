<template>
  <VCard>
    <template #text>
      useWijmoTabPanel 메소드의 onAfterInitialized 옵션을 통해 control이 초기화 될 때 이벤트 등을 추가할 수 있다.

      <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
        <WjTab v-for="(tab, index) in tabData" :key="index" :isDisabled="tab.disabled" :isVisible="tab.visible">
          <a>{{ tab.title }}</a>
          <component :is="tab.component" />
        </WjTab>
      </WjTabPanel>
    </template>

    <UMarkdownViewer :content="doc1" />
  </VCard>
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables'
import { reactive, defineAsyncComponent, markRaw, nextTick } from '#ustra/nuxt'

// @ts-ignore
import doc1 from './md/tab5.md'

const tabData = reactive([
  { title: 'Tab1', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl1.vue'))) },
  { title: 'Tab2', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl2.vue'))) },
  { title: 'Tab3', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl3.vue'))) },
])

const tabPanel = useWijmoTabPanel({
  onAfterInitialized(control) {
    nextTick(() => {
      control.selectedIndexChanged.addHandler((s, e) => {
        alert('tab index changed : ' + s.selectedIndex)
      })
    })
  },
})
</script>
