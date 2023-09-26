<template>
  <VCard>
    <template #text>
      <h3>값 설정</h3>
      <br />
      UDatepicker는 Date 객체를 넣어 기본값을 설정할 수 있다.
      <br /><br />

      <UFieldSet>
        <UFieldRow>
          <UField label="onMounted" itemDirection="row">
            <UDatepicker v-model="value" :enableTimePicker="true" format="yyy-MM-dd HH:mm:ss" enable-seconds />
            <v-chip class="ma-2" color="pink" label text-color="white">
              <v-icon start icon="mdi-label"></v-icon>
              value : {{ value }}
            </v-chip>
          </UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="watch" itemDirection="row">
            <UDatepicker v-model="value1" :enableTimePicker="true" format="yyy-MM-dd HH:mm:ss" enable-seconds />
            <v-chip class="ma-2" color="pink" label text-color="white">
              <v-icon start icon="mdi-label"></v-icon>
              value : {{ value1 }}
            </v-chip>
          </UField>
        </UFieldRow>
      </UFieldSet>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref, onMounted, watch } from '#ustra/nuxt'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import UDatepicker from '#ustra/nuxt-vuetify/components/form/u-datepicker.vue'

// @ts-ignore
import doc1 from './md/datepicker7.md'

const value = ref(null)
onMounted(() => {
  value.value = new Date()
})

const value1 = ref(null)

watch(
  value1,
  v => {
    if (!value1.value) {
      value1.value = new Date()
    }
  },
  {
    immediate: true,
  },
)
</script>
