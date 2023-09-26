<template>
  <v-card>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <UValidationGroup ref="validationGroup" :wrapContainer="false">
        <CustomSub />
      </UValidationGroup>

      <div class="mt-2">
        <UButton text="Validate" @validate="() => {}" @click="() => validationGroup.validate()" />
        <UButton text="Init" @validate="() => {}" @click="() => validationGroup.init()" />
      </div>

      <UMarkdownViewer :content="doc2" />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UValidationGroup, WjInputMask } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import CustomSub from './sub/custom-sub2.vue'

// @ts-ignore
import doc1 from './md/validation5-1.md'

// @ts-ignore
import doc2 from './md/validation5-2.md'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
