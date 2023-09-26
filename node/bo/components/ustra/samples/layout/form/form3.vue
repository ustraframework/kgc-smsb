<template>
  <v-card>
    <template #title> Label 너비 조정</template>
    <template #subtitle>UField의 labelWidth 속성은 label의 널이 조정이 가능하다. </template>
    <template #text>
      <div class="sample-wrap">
        <UFieldSet label="제목">
          <UFieldRow>
            <UField required label="필드1" labelWidth="300" direction="row"><WjComboBox></WjComboBox></UField>
          </UFieldRow>
          <UFieldRow>
            <UField required label="필드1" labelWidth="400" direction="row"><WjComboBox></WjComboBox></UField>
          </UFieldRow>
          <UFieldRow>
            <UField required label="필드1" labelWidth="100" direction="row"><WjComboBox></WjComboBox></UField>
          </UFieldRow>
        </UFieldSet>
      </div>
      <UMarkdownViewer>
        {{ form3 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjComboBox } from '@grapecity/wijmo.vue2.input'
import './style/form.scss'
import form3 from './md/form3.md'
</script>

<style scoped></style>
