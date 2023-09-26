<template>
  <VCard>
    <template #text>
      <h3>disabledCodes</h3>
      disabledCodes 코드 속성은 string[] 유형으로 설정할 수 있으며, 비활성화할 코드 목록을 지정한다.

      <div class="mt-2 mb-5">
        <UCodeCheckGroupBox v-model="checkValue" grpCd="SYS_CD" :disabledCodes="['FO', 'BT']" />
      </div>

      <UMarkdownViewer :content="check2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCodeCheckGroupBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import check2 from './md/check2.md'

const checkValue = ref(null)
</script>
