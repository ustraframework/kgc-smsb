<template>
  <v-card>
    <template #title> Field 안에 여러개 컴포넌트 추가 </template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UFieldSet label="1단 구조">
          <UFieldRow>
            <UField label="필드1" direction="row">
              <WjComboBox></WjComboBox>
              <WjComboBox></WjComboBox>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="필드2" direction="col">
              <WjComboBox></WjComboBox>
              <WjComboBox></WjComboBox>
            </UField>
          </UFieldRow>
        </UFieldSet>
        <UFieldSet label="2단 구조">
          <UFieldRow>
            <UField label="필드1" direction="row">
              <WjComboBox></WjComboBox>
              <WjComboBox></WjComboBox>
            </UField>
            <UField label="필드1" direction="row">
              <WjComboBox></WjComboBox>
              <WjComboBox></WjComboBox>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="필드2" direction="col">
              <WjComboBox></WjComboBox>
              <WjComboBox></WjComboBox>
            </UField>
            <UField label="필드2" direction="col">
              <WjComboBox></WjComboBox>
              <WjComboBox></WjComboBox>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </div>
      <UMarkdownViewer>
        {{ form4 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjComboBox } from '@grapecity/wijmo.vue2.input'
import './style/form.scss'
import form4 from './md/form4.md'
</script>

<style scoped></style>
