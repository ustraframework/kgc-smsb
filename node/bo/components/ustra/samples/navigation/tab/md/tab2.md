```html
<template>
  <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
    <WjTab>
      <a>Tab1</a>
      <div>content1</div>
    </WjTab>

    <WjTab>
      <a>Tab2</a>
      <div>content2</div>
    </WjTab>
  </WjTabPanel>

  <UButton text="toggle disabled" @click="() => (disabledTab1 = !disabledTab1)" />
  <UButton text="toggle visible" @click="() => (visiableTab1 = !visiableTab1)" />

  <UButton text="toggle disabled by control" @click="() => (tabPanel.control.tabs[0].isDisabled = !tabPanel.control.tabs[0].isDisabled)" />
  <UButton text="toggle visible by control" @click="() => (tabPanel.control.tabs[0].isVisible = !tabPanel.control.tabs[0].isVisible)" />
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'

const tabPanel = useWijmoTabPanel()

const disabledTab1 = ref(false)
const visiableTab1 = ref(true)
</script>
```
