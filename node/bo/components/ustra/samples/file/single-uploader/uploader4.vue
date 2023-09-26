<template>
  <VCard>
    <template #text>
      <h3>required</h3>
      <br />
      required 속성을 true로 설정하면 선택되거나 업로드된 파일이 없을 경우, Validation 오류를 발생한다.<br /><br />

      <UValidationGroup ref="validationGroup">
        <USingleFileUploader fileGroupId="ustra-sample" v-model:fileId="fileId" :required="true" />
      </UValidationGroup>

      <br />
      <UButton text="Validate" @click="() => validationGroup.validate()" />

      <UMarkdownViewer :content="uploader3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { USingleFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer, UWjInputMask, UValidationGroup, UButton } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import uploader3 from './md/uploader4.md'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

const fileId = ref(null)

const uploader = ref<InstanceType<typeof USingleFileUploader>>(null)
</script>
