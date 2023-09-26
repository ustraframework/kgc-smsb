<template>
  <VCard>
    <template #text>
      accept 속성을 사용하여 지정된 형식의 파일만을 drop할 수 있는 기능을 제공한다. 아래 예제는 이미지 파일만 drop 가능하도록 설정된 예제이다.
      <UFileDropBox
        class="mt-2"
        accept="image/*"
        @dropped="
          files => {
            $ustra.global.alert(files.map(f => f.name).join(', \n'))
          }
        "
      />

      <UMarkdownViewer :content="dropbox3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UFileDropBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import dropbox3 from './md/dropbox3.md'
</script>
