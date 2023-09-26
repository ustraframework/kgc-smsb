<template>
  <v-card>
    <template #text>
      <h3>Vuetify</h3>
      <br />
      Wijmo 모듈을 참조하지 않을 경우, UBizNoBox와 UCorpNoBox는 VTextField 기반의 Vuetify 전용 컴포넌트로 변경된다.

      <br /><br />
      <UValidationGroup ref="validationGroup">
        <div class="mb-2">사업자 번호</div>
        <UBizNoBox v-model="value" :required="true" />
        <br />
        <div class="mb-2">법인 번호</div>
        <UCorpNoBox v-model="value2" :required="true" />
      </UValidationGroup>
      <br />
      <UButton text="Validate" @click="() => validationGroup.validate()" />
      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        사업자번호 : {{ value }}
      </v-chip>
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        법인번호 : {{ value2 }}
      </v-chip>

      <UMarkdownViewer :content="doc1" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UBizNoBox, UCorpNoBox, UValidationGroup } from '#ustra/nuxt-vuetify/components'

// @ts-ignore
import doc1 from './md/biz-no5.md'

const value = ref(null)
const value2 = ref(null)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
