<template>
  <div class="docs__wrap">
    <!-- 1 line -->
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">Default Detail Form</h1>
        
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField required label="label left" left><UWjComboBox :itemsSource="members" displayMemberPath="text"/></UField>
            <UField label="생년월일"><UDateBox mode="date"/></UField>
            <UField label="회원명"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="양/음력"><URadioGroupBox v-model="solarValue" :itemsSource="solarItems" /></UField>
            <UField label="단골매장"><UTextBox type="icon"/></UField>
            <UField label="ID"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="회원통합여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
            <UField label="마케팅 동의">
              <UCheckGroupBox
                :items-source="[
                  { trueValue: 'Y', falseValue: 'N', text: 'SMS' },
                  { trueValue: 'Y', falseValue: 'N', text: 'DM' },
                  { trueValue: 'Y', falseValue: 'N', text: 'EMAIL' },
                  { trueValue: 'Y', falseValue: 'N', text: 'TM' },
                ]"
                :border="false"
                :stack="true"
              >
              </UCheckGroupBox>
            </UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="주소">
              <UBox>
                <UTextBox type="icon" style="width: 200px"/>
                <UTextBox></UTextBox>
              </UBox>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">Detail Form : 가로형</h1>

        <UFieldSet>
          <UFieldRow>
            <UField direction="col" required label="소속 조직장 의견"><UTextBox type="textarea" placeholder="입력하세요" /></UField>
            <UField direction="col" required label="퇴직에 따른 충원여부"><UTextBox type="textarea" placeholder="입력하세요" /></UField>
            <UField direction="col" required label="퇴직사유"><UTextBox type="textarea" placeholder="입력하세요" /></UField>
          </UFieldRow>
        </UFieldSet>
      </div>
    </div>
  </div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const pwd = [
{ value : 'reset' , text: '비밀번호 초기화'}
];

const members = [
{ value : '1' , text: '일반회원'},
];

const solarItems = reactive([
{ value: '1', text: '양력' },
{ value: '2', text: '음력' },
]);
const solarValue = ref('1');

const radioItems = reactive([
{ value: 'y', text: '예' },
{ value: 'n', text: '아니오' },
]);
const radioValue = ref('y');

const items = [
{ value : '1' , text: 'item1'},
{ value : '2' , text: 'item2'},
]
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>
