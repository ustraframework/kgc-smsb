<template>
  <VCard>
    <template #title> cssClassName </template>
    <template #text>
      cssClassName 속성으로 기본적으로 설정되는 css class 명을 변경하여 validation 실패시의 스타일을 지정할 수 있다. 기본으로 설정되는 클래스는
      'ustra-validation-group' 이며, 아래와 같이 class를 변경하고 Custom 스타일을 추가 가능하다. <br /><br />
      cssClassName 속성은 nuxt.config 설정으로 전역 설정이 가능하다.

      <UMarkdownViewer :content="doc1"></UMarkdownViewer>

      지정한 클래스 하위에 또는 동일한 노드에 'ustra-invalidate' 클래스가 추가되며 이를 이용하여 커스톰 스타일을 설정한다.
      <UMarkdownViewer :content="doc2"></UMarkdownViewer>

      <UValidationGroup ref="validationGroup" cssClassName="custom-validation-group">
        <VTextField :validation="{ rules: ['required'] }" />
        <VTextField :validation="{ rules: ['required'] }" />
      </UValidationGroup>
      <UButton text="Validate" @click="() => validationGroup.validate()"></UButton>

      <UMarkdownViewer :content="doc3"></UMarkdownViewer>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UValidationGroup } from '#ustra/nuxt-vuetify/components'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/validation9-1.md'

// @ts-ignore
import doc2 from './md/validation9-2.md'

// @ts-ignore
import doc3 from './md/validation9-3.md'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
<style>
.custom-validation-group .ustra-invalidate,
.custom-validation-group.ustra-invalidate {
  border: 1px dotted blue;
}
</style>
