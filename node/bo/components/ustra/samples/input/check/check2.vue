<template>
  <v-card>
    <template #text>
      <h3>value 값 변경</h3>
      <UMarkdownViewer :content="check2" />

      <UButton
        text="Change Value"
        @click="
          () => {
            checked2 = ['Y', 'N']
          }
        "
      ></UButton>
      <UCheckGroupBox
        :items-source="[
          { trueValue: 'Y', falseValue: 'N', text: 'Item1' },
          { trueValue: 'Y', falseValue: 'N', text: 'Item2' },
        ]"
        v-model="checked2"
      >
      </UCheckGroupBox>

      <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        checked2 : {{ checked2 }}
      </v-chip>

      <br /><br />
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive } from '#ustra/nuxt'
import { UCheckGroupBox, UButton } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import check2 from './md/check2.md'

const checked2 = ref(['N', 'N'])
</script>
