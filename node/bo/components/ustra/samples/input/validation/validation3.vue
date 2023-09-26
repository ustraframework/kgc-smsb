<template>
  <v-card>
    <template #title> 중첩된 UValidationGroup </template>
    <template #subtitle>
      UValidationGroup을 중첩하여 선언할 경우, validate와 init 메소드의 첫번째 인자로 하위 UValidationGroup 컴포넌트의 validate와 init 메소드를 함께
      수행할지 여부를 true로 설정하여 검증 및 초기화를 한번에 수행할 수 있다.</template
    >
    <template #text>
      <UValidationGroup ref="validationGroup1">
        <WjInputMask v-model="value1" :isRequired="true" />

        <UValidationGroup ref="validationGroup2" class="mt-2">
          <WjInputMask v-model="value2" :isRequired="true" />
        </UValidationGroup>
      </UValidationGroup>

      <div class="mt-2">
        <UButton text="Validate1" @click="validation1" />
        <UButton text="Validate2" @click="validation2" />

        <UButton text="Validate All" @click="validationAll" />
        <UButton text="Init All" @click="initAll" />
      </div>

      <UMarkdownViewer :content="validation3" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UValidationGroup, WjInputMask } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import validation3 from './md/validation3.md'

const value1 = ref(null)
const value2 = ref(null)

const validationGroup1 = ref<InstanceType<typeof UValidationGroup>>()
const validationGroup2 = ref<InstanceType<typeof UValidationGroup>>()

function validation1() {
  validationGroup1.value.validate().then(result => console.log(result))
}

function validation2() {
  validationGroup2.value.validate()
}

function validationAll() {
  validationGroup1.value.validate(true)
}

async function initAll() {
  await validationGroup1.value.init(true)
}
</script>
