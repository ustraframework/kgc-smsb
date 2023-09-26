<template>
  <v-card>
    <template #text>
      <h3>content template</h3>
      <UMarkdownViewer :content="doc1" />
      <URadioGroupBox v-model="radioValue" :itemsSource="items">
        <template #content="{ item, index }">
          <UBox direction="row" style="flex: 0 0 auto" :disabled="radioValue !== item.value">
            <UItem baseSize="auto" class="mr-2">
              <URadioGroupBox v-if="index == 0" v-model="item.amountType" :itemsSource="items2" direction="column" itemAlign="left"></URadioGroupBox>
              <UCheckGroupBox v-else v-model="item.selectedDcOptions" :itemsSource="items3" direction="column" itemAlign="left" />
            </UItem>
            <UItem baseSize="auto" class="ml-2 mr-2" style="align-self: center">
              <WjInputNumber v-model="item.amountValue" v-if="index == 0" style="width: 100px" />
            </UItem>
          </UBox>
        </template>
      </URadioGroupBox>

      <br />
      <VBanner :border="true" :rounded="true" theme="dark">
        <pre>{{ JSON.stringify(items, null, 4) }}</pre>
      </VBanner>
      <UMarkdownViewer :content="doc2" />

      <br />
      itemTemplate과 마찬가지로 contentTemplate 속성을 사용하여 slot의 이름을 변경할 수 있다.
      <UMarkdownViewer :content="doc3" />
      <URadioGroupBox v-model="radioValue2" :itemsSource="items" contentTemplate="custom">
        <template #custom="{ item }">
          <span>{{ item.value }} : {{ item.text }}</span>
        </template>
      </URadioGroupBox>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { URadioGroupBox, UCheckGroupBox, WjInputNumber, UBox, UItem } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/radio9-1.md'

// @ts-ignore
import doc2 from './md/radio9-2.md'

// @ts-ignore
import doc3 from './md/radio9-3.md'

const items = reactive([
  { value: '1', text: '금액설정', amountType: '1', amountValue: 0 },
  { value: '2', text: '할인설정', selectedDcOptions: [false, false] },
])

const items2 = reactive([
  { value: '1', text: '정액' },
  { value: '2', text: '정률' },
])

const items3 = reactive([{ text: '선할인' }, { text: '후적립' }])

const radioValue = ref('1')
const radioValue2 = ref('1')
</script>
