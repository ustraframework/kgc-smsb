<template>
  <v-card>
    <template #title> UField label Slot</template>
    <template #subtitle> UField 컴포넌트 안에 label slot을 활용하여 텍스트 외에 컴포넌트를 작성해 활용할 수 있다. </template>
    <template #text>
      <div class="sample-wrap">
        <UFieldSet>
          <UFieldRow>
            <UField direction="col" itemDirection="row">
              <template #label>
                <div style="margin-right: 5px">컴포넌트</div>
                <div style="margin-right: 5px">
                  <UButton icon="arr-up" />
                </div>
                <div style="margin-right: 5px">
                  <UCheckGroupBox :items-source="[{ text: 'Item1' }]" v-model="checked"> </UCheckGroupBox>
                </div>
              </template>
              <UTextBox width="100%"></UTextBox>
            </UField>
            <UField blank>
              <UButtonBox>
                <UButton text="수정" />
                <UButton text="삭제" />
              </UButtonBox>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="필드 + Slot" itemDirection="row">
              <template #label>
                <i style="margin-right: 5px">텍스트 스타일</i>
                <strong style="margin-right: 5px">bold</strong>
                <span style="color: red"> color </span>
              </template>
              <UTextBox width="100%"></UTextBox>
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
        {{ form8 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { ref } from '#ustra/nuxt'
import { WjComboBox } from '@grapecity/wijmo.vue2.input'
import './style/form.scss'
import form8 from './md/form8.md'
import UField from '#ustra/nuxt-vuetify/components/form/u-field.vue'
const checked = ref(true)
</script>

<style scoped></style>
