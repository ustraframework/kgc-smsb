위의 예제는 content slot을 정의하여 라디오 버튼의 우측에 추가 입력을 할 수 있는 컴포넌트들을 렌더링하고 itemsSource 항목에 매핑된 정보를 통해 통합적으로 입력된 정보를 관리하는 예제이다.

```html
<template>
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
</template>
<script lang="ts" setup>
const items = reactive([
  { value: '1', text: '금액설정', amountType: '1' },
  { value: '2', text: '할인설정', selectedDcOptions: [false, false] },
])

const items2 = reactive([
  { value: '1', text: '정액' },
  { value: '2', text: '정률' },
])

const items3 = reactive([{ text: '선할인' }, { text: '후적립' }])

const radioValue = ref('1')
</script>
```
