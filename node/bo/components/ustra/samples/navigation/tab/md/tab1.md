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
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'

const tabPanel = useWijmoTabPanel()
</script>
```
