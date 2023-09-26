```html
<template>
  <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
    <WjTab v-for="(tab, index) in tabData" :key="index" :isDisabled="tab.disabled" :isVisible="tab.visible">
      <a>{{ tab.title }}</a>
      <component :is="tab.component" />
    </WjTab>
  </WjTabPanel>
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'

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
```
