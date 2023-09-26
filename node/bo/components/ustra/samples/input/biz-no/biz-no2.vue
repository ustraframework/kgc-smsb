<template>
  <v-card>
    <template #text>
      <h3>Validation</h3>
      <br />
      UValidationGroup 컴포넌트 내에 위치할 경우, 사업자 번호의 유효성을 체크할 수 있다.

      <br /><br />
      <UValidationGroup ref="validationGroup">
        <UBizNoBox v-model="value" :isRequired="false" />
      </UValidationGroup>
      <br />
      <UButton text="Validate" @click="() => validationGroup.validate()" />
      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        value : {{ value }}
      </v-chip>

      <UMarkdownViewer :content="doc1" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UBizNoBox, UValidationGroup, UButton, UMarkdownViewer } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/biz-no2.md'

const value = ref(null)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
