<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <UDatepicker v-model="value" showBackdrop scrollLock />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        value : {{ value }}
      </v-chip>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import UDatepicker from '#ustra/nuxt-vuetify/components/form/u-datepicker.vue'

// @ts-ignore
import doc1 from './md/datepicker1-1.md'

// @ts-ignore
import doc2 from './md/datepicker1-2.md'

const value = ref(null)
</script>
