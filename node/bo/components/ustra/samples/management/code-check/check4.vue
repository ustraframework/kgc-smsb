<template>
  <VCard>
    <template #text>
      <h3>displayNullText</h3>
      displayNullText 속성으로 value 값이 null로 세팅된 체크박스를 추가할 수 있으며, 콤보 박스를 전체 선택하는 기능을 제공한다.

      <div class="mt-2 mb-5">
        <UCodeCheckGroupBox v-model="checkValue" grpCd="SYS_CD" displayNullText="전체" />
      </div>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checkValue : {{ checkValue }}
      </v-chip>

      <UMarkdownViewer :content="check4" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCodeCheckGroupBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import check4 from './md/check4.md'

const checkValue = ref(null)
</script>
