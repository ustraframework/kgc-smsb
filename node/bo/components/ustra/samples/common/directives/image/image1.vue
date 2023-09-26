<template>
  <VCard>
    <template #text>
      v-image 디렉티브를 사용하여 이미지 리소스 조회를 실패했을 때 표시할 이미지를 설정할 수 있다. 아래 예제는 v-image 디렉티브 내에 조회 실패 시
      표시할 이미지 경로를 설정하여 기본 이미지를 노출 시키는 예제이다.

      <br />
      <img src="http://something.com/img/anything.jpg" v-image="'/ustra-sample-resources/img/not-found.jpg'" style="width: 300px" />

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/image1.md'
</script>
