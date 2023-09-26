<template>
  <VCard>
    <template #text>
      <h3>readonly</h3>
      <br />
      readonly 속성은 기존 업로드 된 데이터를 조회 및 다운로드만 가능한 형태로 만든다.<br /><br />
      fileId :
      <UWjInputMask v-model="fileId" style="width: 400px" />
      <USingleFileUploader ref="uploader" fileGroupId="ustra-sample" v-model:fileId="fileId" :readonly="true" />

      <UMarkdownViewer :content="uploader3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { USingleFileUploader } from '#ustra/nuxt-wijmo/management/components'
import { UMarkdownViewer, UWjInputMask } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import uploader3 from './md/uploader3.md'

const fileId = ref('xYjN4kTOwUDMzMDO1MEOlRXZXRERnVka1FmWzhjZPFXZpNF')

const uploader = ref<InstanceType<typeof USingleFileUploader>>(null)
</script>
