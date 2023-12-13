<template>
  <div class="docs__wrap">
    <!-- 1 line -->
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">대타이틀</h1>            
        <UValidationGroup ref="validationGroup">
          <div class="mb-3">
            <div class="mt-2">필수 입력 : <WjInputMask ref="field1" :isRequired="true" v-model="fieldValue1" /></div>
            <div class="mt-2">
              필수 입력 :
              <UCodeComboBox grpCd="SYS_CD" v-model="fieldValue2" displayNullText="전체" />
            </div>
            <div class="mt-2">
              필수 입력 :
              <WjComboBox v-model="fieldValue3" :itemsSource="comboItems" selectedValuePath="value" displayMemberPath="text" />
            </div>
            <div class="mt-2">
              필수 입력 :
              <URadioGroupBox v-model="fieldValue4" :itemsSource="radioItems" :validation="{ rules: ['required'] }" />
            </div>
          </div>
          <VBtn @click="validateForm">Validate</VBtn>
          <VBtn @click="() => validationGroup.init()">Init</VBtn>
        </UValidationGroup>
      </div>
    </div>

  </div>
  
</template>

<script lang="ts" setup>
import {ref, reactive} from 'vue'
import { UValidationGroup, WjInputMask, WjComboBox } from '#ustra/nuxt-wijmo/components'

const fieldValue1 = ref(null)
const fieldValue2 = ref(null)
const fieldValue3 = ref(null)
const fieldValue4 = ref(null)

const comboItems = reactive([
  { value: null, text: '선택하세요.' },
  { value: '1', text: 'Item1' },
  { value: '2', text: 'Item2' },
])

const radioItems = reactive([
  { value: '1', text: 'radio1' },
  { value: '2', text: 'radio2', disabled: true },
  { value: '3', text: 'radio3' },
])

// validationGroup 컴포넌트 ref 지정
const validationGroup = ref<InstanceType<typeof UValidationGroup>>();
async function validateForm() {

  // validate 메소드 실행으로 validation 일괄 실행
  const result = await validationGroup.value.validate()

  console.log('result', result)
}

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
}
</style>
