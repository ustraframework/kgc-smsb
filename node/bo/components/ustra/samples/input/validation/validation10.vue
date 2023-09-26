<template>
  <VCard>
    <template #title> onValidationChanged </template>
    <template #text>
      <UMarkdownViewer :content="doc1"></UMarkdownViewer>

      <UValidationGroup ref="validationGroup" cssClassName="custom-validation-group">
        <VTextField
          v-model="inputData.value1"
          :errorMessages="inputData.validationMessage1"
          :onValidationChanged="(isValid, message) => (inputData.validationMessage1 = message)"
          :validation="{ rules: ['required'] }"
        />
        <VTextField
          v-model="inputData.value2"
          :errorMessages="inputData.validationMessage2"
          :onValidationChanged="(isValid, message) => (inputData.validationMessage2 = message)"
          :validation="{ rules: ['required', 'email'] }"
        />
        <UWjInputMask
          :isRequired="true"
          v-model="inputData.value3"
          :onValidationChanged="(isValid, message) => (inputData.validationMessage3 = message)"
        />
        <div v-if="inputData.validationMessage3">{{ inputData.validationMessage3 }}</div>
      </UValidationGroup>
      <UButton text="Validate" @click="() => validationGroup.validate()"></UButton>

      <UMarkdownViewer :content="doc2"></UMarkdownViewer>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'
import { UButton, UWjInputMask } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/validation10-1.md'

// @ts-ignore
import doc2 from './md/validation10-2.md'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

const inputData = reactive({
  value1: null,
  value2: null,
  value3: null,
  validationMessage1: '',
  validationMessage2: '',
  validationMessage3: '',
})
</script>
