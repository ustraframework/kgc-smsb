<template>
  <VCard>
    <template #text>
      <h3>disable / visible</h3>
      isDisabled, isVisible 속성을 사용하여 컴포넌트의 상태와 숨김 처리를 할 수 있으며 useWijmoTabPanel 메소드에서 반환되는 control 속성으로 세부 tab
      속성을 제어할 수 있다.

      <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
        <WjTab :isDisabled="disabledTab1" :isVisible="visiableTab1">
          <a>Tab1</a>
          <div>content1</div>
        </WjTab>

        <WjTab>
          <a>Tab2</a>
          <div>content2</div>
        </WjTab>
      </WjTabPanel>
    </template>

    <UButton text="toggle disabled" @click="() => (disabledTab1 = !disabledTab1)" />
    <UButton text="toggle visible" @click="() => (visiableTab1 = !visiableTab1)" />

    <UButton text="toggle disabled by control" @click="() => (tabPanel.control.tabs[0].isDisabled = !tabPanel.control.tabs[0].isDisabled)" />
    <UButton text="toggle visible by control" @click="() => (tabPanel.control.tabs[0].isVisible = !tabPanel.control.tabs[0].isVisible)" />

    <UMarkdownViewer :content="tab2" />
  </VCard>
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab, UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables'
import { ref } from '#ustra/nuxt'

// @ts-ignore
import tab2 from './md/tab2.md'

const tabPanel = useWijmoTabPanel()

const disabledTab1 = ref(false)
const visiableTab1 = ref(true)
</script>
