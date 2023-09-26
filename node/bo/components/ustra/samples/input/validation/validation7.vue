<template>
  <v-card>
    <template #title> checkValidationOnUpdate </template>
    <template #text>
      checkValidationOnUpdate 속성은 입력 영역의 값이 변경될 경우, validation 처리를 자동으로 처리할지 여부를 설정하는 속성이다. 기본 값은 true이며,
      false로 설정할 경우, 입력 영역에 값이 변경하더라도 validation 처리를 수행하지 않는다.
      <UValidationGroup ref="validationGroup" :checkValidationOnUpdate="checkValidationOnUpdate">
        <div class="mb-3">
          <div class="mt-2">필수 입력 : <WjInputMask ref="field1" :isRequired="true" v-model="fieldValue1" /></div>
          <div class="mt-2">
            필수 입력 :
            <UCodeComboBox grpCd="SYS_CD" v-model="fieldValue2" displayNullText="전체" />
          </div>
        </div>
      </UValidationGroup>
      <UButton text="Validate" @click="validateForm"></UButton>
      <UButton text="Init" @click="() => validationGroup.init()">Init</UButton>
      <UButton
        :text="checkValidationOnUpdate ? '입력비감지로 전환' : '입력감지로 전환'"
        @click="() => (checkValidationOnUpdate = !checkValidationOnUpdate)"
      ></UButton>

      <UMarkdownViewer :content="doc1"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UValidationGroup, WjInputMask, UButton } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/validation7.md'

const fieldValue1 = ref(null)
const fieldValue2 = ref(null)
const checkValidationOnUpdate = ref(false)

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
async function validateForm() {
  const result = await validationGroup.value.validate()

  console.log('result', result)
}
</script>
