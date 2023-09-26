<template>
  <VCard>
    <template #title><h5>주의 사항</h5></template>
    <template #text>
      WjComboBox 객체를 사용할 때, 변수에 값을 할당하지 않고 itemsSource 속성을 리터럴 객체로 바인딩할 경우, itemsSource의 update가 발생하여
      정상적으로 항목이 선택되지 않을 수 있다. 다음 예제를 확인하면 DropDown 버튼을 클릭한 후, 다른 항목을 선택하여도 값이 변경되지 않는 것을 볼 수
      있다.
      <br />
      <br />

      <WjComboBox
        :itemsSource="[
          { value: '01', text: '항목1' },
          { value: '02', text: '항목2' },
          { value: '03', text: '항목3' },
        ]"
        v-model="comboValue"
        selectedValuePath="value"
        displayMemberPath="text"
      />

      <UMarkdownViewer :content="combo3_1" />

      <br />
      반면 다음과 같이 itemsSource 속성을 선언된 변수로 세팅할 경우, 정상적으로 설정되는 것을 볼 수 있다.
      <br />
      <br />
      <WjComboBox :itemsSource="items" v-model="comboValue2" selectedValuePath="value" displayMemberPath="text" />
      <UMarkdownViewer :content="combo3_2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjComboBox, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import combo3_1 from './md/combo3-1.md'
// @ts-ignore
import combo3_2 from './md/combo3-2.md'

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
  { value: '03', text: '항목3' },
]

const comboValue = ref(null)
const comboValue2 = ref(null)
</script>
