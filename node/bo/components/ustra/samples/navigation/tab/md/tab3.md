```html
<template>
  <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
    <WjTab v-for="(tab, index) in tabData" :key="index" :isDisabled="tab.disabled" :isVisible="tab.visible">
      <a>{{ tab.title }}</a>
      <div v-if="index === 0">content1</div>
      <div v-if="index === 1">content2</div>
      <div v-if="index === 2">content3</div>
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
  { title: 'Tab1', visible: true, disabled: false },
  { title: 'Tab2', visible: true, disabled: false },
  { title: 'Tab3', visible: true, disabled: false },
])
</script>
```
