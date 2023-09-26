<template>
  <VCard>
    <template #text>
      <h3>동적 바인딩</h3>
      반응형 데이터를 사용하여 Tab을 동적 바인딩할 수 있다.

      <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
        <WjTab v-for="(tab, index) in tabData" :key="index" :isDisabled="tab.disabled" :isVisible="tab.visible">
          <a>{{ tab.title }}</a>
          <div v-if="index === 0">content1</div>
          <div v-if="index === 1">content2</div>
          <div v-if="index === 2">content3</div>
        </WjTab>
      </WjTabPanel>
    </template>

    <UButton text="toggle disabled" @click="() => (tabData[0].disabled = !tabData[0].disabled)" />
    <UButton text="toggle visible" @click="() => (tabData[0].visible = !tabData[0].visible)" />

    <UMarkdownViewer :content="tab3" />
  </VCard>
</template>
<script lang="ts" setup>
import { WjTabPanel, WjTab, UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables'
import { ref, reactive } from '#ustra/nuxt'

// @ts-ignore
import tab3 from './md/tab3.md'

const tabPanel = useWijmoTabPanel()
const tabData = reactive([
  { title: 'Tab1', visible: true, disabled: false },
  { title: 'Tab2', visible: true, disabled: false },
  { title: 'Tab3', visible: true, disabled: false },
])
</script>
