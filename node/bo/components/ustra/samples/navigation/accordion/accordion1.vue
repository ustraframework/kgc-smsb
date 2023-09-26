<template>
  <USampleContentContainer title="개요">
    <UMarkdownViewer :content="doc1" />

    <UButton text="첫번째 항목 선택" @click="selectedIndex = 0" />
    <UButton text="두번째 항목 선택" @click="selectedIndex = 1" />
    <UButton text="세번째 항목 선택" @click="selectedIndex = 2" />
    <WjAccordion :selectedIndex="selectedIndex" :autoSwitch="true" class="mt-5">
      <WjAccordionPane v-for="item in items" :key="item.id">
        <div>{{ item.id }}</div>
        <template v-if="item.id === 'Header1'">
          <div>
            Header1 <br />
            Content
          </div>
        </template>
        <template v-if="item.id === 'Header2'">
          <div>
            Header2 <br />
            Content
          </div>
        </template>
        <template v-if="item.id === 'Header3'">
          <div>
            Header3 <br />
            Content
          </div>
        </template>
      </WjAccordionPane>
    </WjAccordion>
  </USampleContentContainer>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { USampleContentContainer } from '#ustra/nuxt-vuetify/samples'
import { WjAccordion, WjAccordionPane, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWjAccordion } from '#ustra/nuxt-wijmo/composables/accordion'

// @ts-ignore
import doc1 from './md/accordion1.md'

const selectedIndex = ref(0)

const items = reactive([{ id: 'Header1' }, { id: 'Header2' }, { id: 'Header3' }])
</script>
