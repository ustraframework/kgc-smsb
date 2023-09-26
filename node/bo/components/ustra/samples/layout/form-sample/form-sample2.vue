<template>
  <v-card>
    <template #title>Disabled 처리</template>
    <template #subtitle> UFieldSet, UFieldRow, UField 각 영역에 작성을 못하도록 disabled 처리가 가능하다.</template>
    <template #text>
      <UFieldSet label="검색영역">
        <UFieldRow>
          <UField label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
          <UField label="요청 아이디"><WjComboBox></WjComboBox> </UField>
          <UField label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
          <UField label="URL"><WjComboBox></WjComboBox> </UField>
        </UFieldRow>
        <UFieldRow :ratio="[2, 1]">
          <UField label="기간"><UDatePeriodBox /> </UField>
          <UField blank>
            <UButtonBox right>
              <UButton text="수정" />
              <UButton text="삭제" />
            </UButtonBox>
          </UField>
        </UFieldRow>
      </UFieldSet>
      <UFieldSet label="검색영역">
        <UFieldRow disabled>
          <UField label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
          <UField label="요청 아이디"><WjComboBox></WjComboBox> </UField>
          <UField label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
          <UField label="URL"><WjComboBox></WjComboBox> </UField>
        </UFieldRow>
        <UFieldRow :ratio="[2, 1]">
          <UField label="기간"><UDatePeriodBox /> </UField>
          <UField blank>
            <UButtonBox right>
              <UButton text="수정" />
              <UButton text="삭제" />
            </UButtonBox>
          </UField>
        </UFieldRow>
      </UFieldSet>
      <UFieldSet disabled label="검색영역">
        <UFieldRow>
          <UField label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
          <UField label="요청 아이디"><WjComboBox></WjComboBox> </UField>
          <UField label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
          <UField label="URL"><WjComboBox></WjComboBox> </UField>
        </UFieldRow>
        <UFieldRow :ratio="[2, 1]">
          <UField label="기간"><UDatePeriodBox /> </UField>
          <UField blank>
            <UButtonBox right>
              <UButton text="수정" />
              <UButton text="삭제" />
            </UButtonBox>
          </UField>
        </UFieldRow>
      </UFieldSet>
      <UMarkdownViewer>
        {{ formSample2 }}
      </UMarkdownViewer>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { WjComboBox } from '@grapecity/wijmo.vue2.input'
import formSample2 from './md/form-sample2.md'
import UDatePeriodBox from '#ustra/nuxt-wijmo/components/u-date-period-box.vue'
</script>

<style scoped></style>
