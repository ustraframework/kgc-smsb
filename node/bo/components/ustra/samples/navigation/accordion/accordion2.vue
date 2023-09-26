<template>
  <USampleContentContainer title="Panel 제어">
    <UMarkdownViewer :content="doc1" />

    <UButton text="Add Panel" @click="addPanel" />
    <UButton text="Insert Panel" @click="insertPanel" />
    <UButton text="Remove Last Panel" @click="removeLastPanel" />
    <WjAccordion ref="accordionComp" :selectedIndex="selectedIndex" class="mt-5">
      <WjAccordionPane>
        <div>Header1</div>
        <div>
          Header1 <br />
          Content
        </div>
      </WjAccordionPane>
      <WjAccordionPane>
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
import { ref, shallowRef } from '#ustra/nuxt'
import { USampleContentContainer } from '#ustra/nuxt-vuetify/samples'
import { WjAccordion, WjAccordionPane, UMarkdownViewer, UButton } from '#ustra/nuxt-wijmo/components'
import { wijmoNav } from '#ustra/nuxt-wijmo'
import { useWjAccordion } from '#ustra/nuxt-wijmo/composables/accordion'

// @ts-ignore
import doc1 from './md/accordion2.md'

const selectedIndex = ref(0)
const accordionComp = shallowRef()
const accrodion = useWjAccordion(accordionComp, {
  onAfterInitialized(control) {
    control.panes[1].isDisabled = true
  },
})

function addPanel() {
  accrodion.add(`<div>Header${accrodion.control.panes.length + 1}</div>`, `<div>Header${accrodion.control.panes.length + 1}<br />Content</div>`)
  accrodion.selectedIndex = accrodion.control.panes.length - 1
}

function insertPanel() {
  accrodion.insert(0, `<div>Header0</div>`, `<div>Header0<br />Content</div>`)
  accrodion.selectedIndex = 0
}

function removeLastPanel() {
  if (accrodion.control.panes.length > 0) {
    accrodion.removeAt(accrodion.control.panes.length - 1)
  }
}
</script>
