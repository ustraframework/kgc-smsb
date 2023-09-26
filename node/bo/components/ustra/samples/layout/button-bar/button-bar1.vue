<template>
  <v-card>
    <template #title> ButtonBar</template>
    <template #subtitle> </template>
    <template #text>
      <div class="sample-wrap">
        <UButtonBar title="제목">
          <UButtonBox center>
            <UButton text="신규" type="primary" />
            <UButton text="수정" />
            <UButton text="삭제" />
          </UButtonBox>
        </UButtonBar>
        <div style="margin: 15px"></div>
        <UButtonBar>
          <UFieldSet>
            <UFieldRow>
              <UField label="필드1"><WjComboBox></WjComboBox> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="필드1"><WjComboBox></WjComboBox> </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="필드1"><WjComboBox></WjComboBox> </UField>
            </UFieldRow>
          </UFieldSet>
          <UButtonBox right>
            <UButton text="수정" />
            <UButton text="삭제" />
          </UButtonBox>
        </UButtonBar>
      </div>

      <UMarkdownViewer>
        {{ buttonBar1 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjComboBox } from '@grapecity/wijmo.vue2.input'
import './style/form.scss'
import buttonBar1 from './md/button-bar1.md'
</script>

<style scoped></style>
