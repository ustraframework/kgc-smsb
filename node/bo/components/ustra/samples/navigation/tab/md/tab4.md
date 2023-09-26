```html
<template>
  <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
    <WjTab v-for="(tab, index) in tabData" :key="index" :isDisabled="tab.disabled" :isVisible="tab.visible">
      <a>{{ tab.title }}</a>
      <component :is="tab.component" />
    </WjTab>
  </WjTabPanel>

  <UButton text="toggle disabled" @click="() => (tabData[0].disabled = !tabData[0].disabled)" />
  <UButton text="toggle visible" @click="() => (tabData[0].visible = !tabData[0].visible)" />
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'

const tabPanel = useWijmoTabPanel()
const tabData = reactive([
  { title: 'Tab1', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl1.vue'))) },
  { title: 'Tab2', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl2.vue'))) },
  { title: 'Tab3', visible: true, disabled: false, component: markRaw(defineAsyncComponent(() => import('./sub/sub-tabl3.vue'))) },
])
</script>
```
