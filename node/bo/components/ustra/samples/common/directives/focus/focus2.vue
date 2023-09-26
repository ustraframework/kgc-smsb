<template>
  <VCard>
    <template #text>
      마운트 시가 아닌 상태 값 제어를 통해 element의 focus를 조정할 수 있다. ref 유형의 변수를 v-focus value 값으로 세팅하고, 값이 true로 세팅되면
      해당 Element에 focus가 처리된다. 단 root ref 변수를 사용하면 자동으로 wrapping이 풀리므로 object 유형의 변수 내에 ref 변수를 세팅하여 사용해야
      한다.</template
    >

    <div class="ma-5">
      <VTextField v-focus="focusedState.first" />
      <VTextField v-focus="focusedState.second" />
      <br />
      <VBtn variant="outlined" class="mr-2" @click="() => (focusedState.first.value = true)">focus to 0</VBtn>
      <VBtn variant="outlined" @click="() => (focusedState.second.value = true)">focus to 1</VBtn>
    </div>

    <UMarkdownViewer :content="doc2" />
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc2 from './md/focus2.md'

const focusedState = {
  first: ref<boolean>(false),
  second: ref<boolean>(false),
}
</script>
