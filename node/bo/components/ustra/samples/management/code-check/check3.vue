<template>
  <VCard>
    <template #text>
      <h3>customizeItems</h3>
      콤보박스와 동일하게 customizeItems 속성을 사용하여 노출할 item을 변경할 수 있다.

      <div class="mt-2 mb-5">
        <UCodeCheckGroupBox
          v-model="checkValue"
          grpCd="SYS_CD"
          :customizeItems="
            items => {
              items.unshift({
                value: null,
                display: '전체선택',
              })

              return items
            }
          "
        />
      </div>

      <UMarkdownViewer :content="check3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt-wijmo/components'
import { UCodeCheckGroupBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import check3 from './md/check3.md'

const checkValue = ref(null)
</script>
