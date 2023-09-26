<template>
  <VCard>
    <template #text>
      v-focus directive는 컴포넌트가 마운트될 시점에 컴포넌트 하위에 포커스가 가능한 dom에 포커스를 위치시키는 기능을 한다. 아래 예제를 보면 화면
      로드와 동시에 Text Box에 focus가 위치하는 것을 확인할 수 있다.
    </template>

    <div class="ma-5">
      <VTextField v-focus />
      <VTextField />
    </div>

    <UMarkdownViewer :content="doc1" />
  </VCard>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/focus1.md'
</script>
