<template>
  <VCard>
    <template #text>
      dropped 이벤트를 사용하여 현재 drop된 파일 목록을 확인할 수 있다.
      <UFileDropBox
        class="mt-2"
        @dropped="
          files => {
            $ustra.global.alert(files.map(f => f.name).join(', \n'))
          }
        "
      />

      <UMarkdownViewer :content="dropbox2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { UFileDropBox } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import dropbox2 from './md/dropbox2.md'
</script>
