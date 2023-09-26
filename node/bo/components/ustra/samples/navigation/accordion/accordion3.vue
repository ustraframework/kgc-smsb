<template>
  <USampleContentContainer title="Style customzation">
    <UMarkdownViewer :content="doc1" />

    <WjAccordion ref="accordionComp" :selectedIndex="selectedIndex" class="custom-accordion">
      <WjAccordionPane>
        <div>Header1</div>
        <div>
          Header1 <br />
          Content
        </div>
      </WjAccordionPane>
      <WjAccordionPane :isDisabled="true">
        <div>Header2</div>
        <div>
          Header2 <br />
          Content
        </div>
      </WjAccordionPane>
      <WjAccordionPane>
        <div>Header3</div>
        <div>
          Header3 <br />
          Content
        </div>
      </WjAccordionPane>
    </WjAccordion>
  </USampleContentContainer>
</template>
<script lang="ts" setup>
import { ref, reactive, shallowRef } from '#ustra/nuxt'
import { USampleContentContainer } from '#ustra/nuxt-vuetify/samples'
import { WjAccordion, WjAccordionPane, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { useWjAccordion } from '#ustra/nuxt-wijmo/composables/accordion'

// @ts-ignore
import doc1 from './md/accordion3.md'

const selectedIndex = ref(0)
const accordionComp = shallowRef()
const accrodion = useWjAccordion(accordionComp)
</script>
<style lang="scss" scoped>
.custom-accordion {
  // 헤더 기본
  &.wj-accordion > .wj-header {
    border-radius: 5px;
    margin: 5px 0;
    font-size: unset;
  }

  // Disabled 상태의 Header
  &.wj-accordion > .wj-header.wj-state-disabled:not(.wj-popup) {
    opacity: 0.4;
  }

  // 활성화 상태의 Header
  &.wj-accordion > .wj-header.wj-state-active {
    background-color: #e19730;
  }

  // 헤더의 포커스 상태
  &.wj-accordion > .wj-header:focus {
    outline: 2px solid #e7931e;
    outline-offset: -2px;
  }

  // Content 영역의 기본 클래스
  &.wj-accordion > .wj-content {
    padding: 10px;
    border: 1px dashed #ccc;
  }
}
</style>
