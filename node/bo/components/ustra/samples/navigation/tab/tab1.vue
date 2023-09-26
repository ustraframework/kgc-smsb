<template>
  <VCard>
    <template #text>
      WjTabPanel 컴포넌트를 사용하여 Tab Navigation을 구현할 수 있으며, useWijmoTabPanel 메소드는 TabPanel을 Type Safe하게 사용할 수 있도록 한다.

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

      <UMarkdownViewer :content="tab1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab, UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import tab1 from './md/tab1.md'

const tabPanel = useWijmoTabPanel()
</script>
