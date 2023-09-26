```html 
<template>
  <v-card>
    <template #title>4단 검색조건</template>
    <template #subtitle></template>
    <template #text>
      <UFieldSet label="검색영역">
        <UFieldRow>
          <UField required label="검색조건"><WjComboBox></WjComboBox></UField>
          <UField required label="검색조건"
            ><WjComboBox v-model="value" :itemsSource="source" selectedValuePath="value" displayMemberPath="text" />
          </UField>
          <UField label="검색조건"><UTextBox type="icon" iconType="find" /></UField>
          <UField label="검색조건"><UTextBox type="icon" iconType="refresh" /> </UField>
        </UFieldRow>
        <UFieldRow>
          <UField required label="검색조건"><WjComboBox></WjComboBox> </UField>
          <UField label="검색조건"><WjComboBox v-model="value" :itemsSource="source" selectedValuePath="value" displayMemberPath="text" /> </UField>
          <UField label="검색조건"><UTextBox type="icon" iconType="error" /></UField>
          <UField label="검색조건"><UTextBox type="mask" /></UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="검색조건"><UIpAddressTextBox></UIpAddressTextBox> </UField>
          <UField label="검색조건"><WjComboBox v-model="value" :itemsSource="source" selectedValuePath="value" displayMemberPath="text" /> </UField>
          <UField label="검색조건"><WjComboBox v-model="value" :itemsSource="source" selectedValuePath="value" displayMemberPath="text" /> </UField>
          <UField label="검색조건"><WjComboBox></WjComboBox></UField>
        </UFieldRow>
        <UFieldRow>
          <UField label="검색조건"><UTextBox type="textarea" rows="2" noResize /> </UField>
          <UField label="검색조건"><WjComboBox></WjComboBox><WjComboBox></WjComboBox><WjComboBox></WjComboBox></UField>
          <UField label="검색조건"><WjComboBox></WjComboBox><WjComboBox></WjComboBox><WjComboBox></WjComboBox></UField>
          <UField label="검색조건"><WjComboBox></WjComboBox><WjComboBox></WjComboBox><WjComboBox></WjComboBox></UField>
        </UFieldRow>
        <UFieldRow :ratio="[3, 1]">
          <UField label="검색조건"><WjComboBox></WjComboBox></UField>
          <UField blank>
            <UButtonBox right>
              <UButton text="수정" />
              <UButton text="삭제" />
            </UButtonBox>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </template>
  </v-card>
</template>

<script setup lang="ts">
import { reactive, ref } from '#ustra/nuxt'
import { WjComboBox } from '@grapecity/wijmo.vue2.input'

const value = ref(null)

const source = reactive([
  { value: null, text: '선택하세요.' },
  { value: '1', text: 'Item1' },
  { value: '2', text: 'Item2' },
])
</script>

```
