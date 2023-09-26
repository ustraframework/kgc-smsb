<template>
  <v-card>
    <template #title> Form Layout + Button</template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UFieldSet>
          <UFieldRow>
            <UField label="필드1" direction="col" itemDirection="row"><WjComboBox></WjComboBox> </UField>
            <UField blank center middle>
              <UButtonBox>
                <UButton text="수정" />
                <UButton text="삭제" />
              </UButtonBox>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="필드1" itemDirection="row">
              <WjComboBox></WjComboBox>
            </UField>
            <UField blank>
              <UButtonBox right>
                <UButton text="수정" />
                <UButton text="삭제" />
              </UButtonBox>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </div>

      <UMarkdownViewer>
        {{ form7 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjComboBox } from '@grapecity/wijmo.vue2.input'
import './style/form.scss'
import form7 from './md/form7.md'
import UField from '#ustra/nuxt-vuetify/components/form/u-field.vue'
</script>

<style scoped></style>
