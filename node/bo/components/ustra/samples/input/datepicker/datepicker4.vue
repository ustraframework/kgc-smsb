<template>
  <VCard>
    <template #text>
      <h3>Validation</h3>
      <br />
      UValidationGroup을 이용한 Validation 처리 예제이다.
      <br />
      <UValidationGroup ref="validationGroup" class="mt-2">
        <UDatepicker v-model="value" :required="true" />
      </UValidationGroup>

      <UButton text="Validate" class="mt-2" @click="() => validationGroup.validate()" />
      <UButton text="Init" class="mt-2" @click="() => validationGroup.init()" />

      <br /><br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        value : {{ value }}
      </v-chip>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref, shallowRef } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import UDatepicker from '#ustra/nuxt-vuetify/components/form/u-datepicker.vue'
import { UValidationGroup, UButton } from '#ustra/nuxt-wijmo/components'

// @ts-ignore
import doc1 from './md/datepicker4.md'

const value = ref(null)
const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()
</script>
