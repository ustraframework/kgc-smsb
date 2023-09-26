<template>
  <VCard>
    <template #title> wrapContainer </template>
    <template #text>
      UValidationGroup의 wrapContainer 속성은 boolean 형이며, div 태그 기반의 container element를 렌더링할지 여부를 선택한다. 기본 값은 ture이며,
      false를 설정할 경우 Root Element를 생성하지 않아 Element의 구조를 유지할 수 있다. <br /><br />
      <UValidationGroup ref="validationGroup" :wrapContainer="false">
        <VTextField :validation="{ rules: ['required'] }" />
        <VTextField :validation="{ rules: ['required'] }" />
      </UValidationGroup>
      <UButton text="Validate" @click="() => validationGroup.validate()"></UButton>

      <UMarkdownViewer :content="doc1"></UMarkdownViewer>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UValidationGroup } from '#ustra/nuxt-vuetify/components'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/validation8.md'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
