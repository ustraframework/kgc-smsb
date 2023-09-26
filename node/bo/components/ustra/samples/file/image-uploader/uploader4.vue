<template>
  <VCard>
    <template #text>
      <h3>upload 이미지 조회</h3>
      <br />
      업로드 된 이미지 파일은 "$ustra.management.file.getViewUrl" 메소드를 사용하여 조회할 수 있다. <br />
      해당 메소드는 fileId와 fileNo, fileGroupId(필수 아님)를 인자 값으로 받으며 fileNo는 생략가능하고 기본 값은 1이다. <br />

      아래 fileId와 fileNo 값을 변경하여 이미지 조회를 테스트할 수 있다.
      <br /><br />

      fileGroupId : <UWjInputMask v-model="fileGroupId" /> <br />
      fileId : <UWjInputMask v-model="fileId" /> <br />
      fileNo : <WjInputNumber v-model="fileNo" /> <br />

      <img :src="$ustra.management.file.getViewUrl(fileId, fileNo, fileGroupId)" style="max-height: 200px" />

      <UMarkdownViewer :content="doc1" />

      <br /><br />
      "$ustra.management.file.getWebAccessUrl" 메소드를 사용하여 파일 정보에서 저장된 Web Server 접근 URL을 조회할 수 있다. <br />
      해당 메소드는 fileId, fileNo, fileGroupId를 인자 값으로 받으며 모든 값은 필수이다.
      <br /><br />
      <UButton text="Image URL 조회" @click="getWebImageUrl" />
      <img :src="webFileImageUrl" v-if="webFileImageUrl" style="max-height: 200px" />

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer, UWjInputMask, WjInputNumber, UButton } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/uploader4-1.md'

// @ts-ignore
import doc2 from './md/uploader4-2.md'

const fileGroupId = ref('ustra-sample-image')
const fileId = ref('xYjN4kzM3MjN5ATM1IGZmVlVWdWONlGVRZWTsFTUCNnWmRG')
const fileNo = ref(1)

const webFileImageUrl = ref(null)
async function getWebImageUrl() {
  webFileImageUrl.value = await $ustra.management.file.getWebAccessUrl(fileId.value, fileNo.value, 'ustra-sample-image')
}
</script>
