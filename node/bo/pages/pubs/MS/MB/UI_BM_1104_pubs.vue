<template>
<div>
  <UBox class="columns" direction="row">
    <UItem class="card is-sub"  ratio="1" >
      <UBox class="table-title-wrap">
        <UButtonBox class="table-buttons">
          <UButton text="신규" type="is-outline" />
          <UButton text="저장" type="is-filled" />
        </UButtonBox>
      </UBox>
      
      <UFieldSet>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text" /></UField>
          <UField label="CI"><UTextBox></UTextBox></UField>
          <UField label="DI"><UTextBox></UTextBox></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="회원번호"><UTextBox></UTextBox></UField>
          <UField label="회원명" required><UTextBox></UTextBox></UField>
          <UField label="카드번호"><UTextBox></UTextBox></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="생년월일" required><UDateBox mode="date" /></UField>
          <UField label="실생일"><UDateBox mode="date" /></UField>
          <UField label="양/음력"><URadioGroupBox v-model="solarValue" :itemsSource="solarItems" /></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="성별" required><URadioGroupBox v-model="genderValue" :itemsSource="genderItems" /></UField>
          <UField label="내/외국인" required><URadioGroupBox v-model="nationalityValue" :itemsSource="nationalityItems" /></UField>
          <UField label="국적" required><UWjComboBox :itemsSource="items" displayMemberPath="text" /></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="핸드폰" required><UTextBox></UTextBox></UField>
          <UField label="인증방식" item-direction="row" required>
            <UBox>
              <UButton text="본인인증" type="is-secondary is-medium" class="is-login" />
              <UButton text="점유인증" type="is-secondary is-medium" class="is-login" />
            </UBox>
          </UField>
          <UField label="인증확인" item-direction="row">
            <UTextBox></UTextBox>
            <UButton text="확인" type="is-filled is-medium" width="70px" />
          </UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow :ratio="[1, 2]">
          <UField label="이메일" item-direction="row">
            <UTextBox></UTextBox>
            <UWjComboBox :itemsSource="items" displayMemberPath="text" />
          </UField>
          <UField label="단골매장">
            <UBox>
              <UTextBox type="icon" />
              <UTextBox/>
            </UBox>
          </UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="주소">
            <UBox>
              <UTextBox type="icon" />
              <UTextBox/>
            </UBox>
          </UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow :ratio="[2, 1, 1]">
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
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow :ratio="[2, 1]">
          <UField label="가맹점" item-direction="row"> <UTextBox type="icon" /><UTextBox /> </UField>
          <UField></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="법인여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
          <UField label="사업자등록번호"><UTextBox /></UField>
          <UField label="법인명"><UTextBox /></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="이용약관 동의여부" required>
            <WjFlexGrid :itemsSource="itemsSourceGrid" style="max-width: 495px;">
              <WjFlexGridColumn header="이용약관" binding="col1" width="2*" />
              <WjFlexGridColumn header="동의여부" width="*" align="center">
                <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                  <UBox>
                    <UCheckGroupBox :items-source="[{ }]" v-model="checked"> </UCheckGroupBox>
                  </UBox>
                </WjFlexGridCellTemplate>
              </WjFlexGridColumn>
            </WjFlexGrid>
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
  </UBox>
</div>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components';

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub',
})

const members = [{ value: '1', text: '일반회원' }]

const solarItems = reactive([
  { value: '1', text: '양력' },
  { value: '2', text: '음력' },
])
const solarValue = ref('1')

const genderItems = reactive([
  { value: '1', text: '남' },
  { value: '2', text: '여' },
])
const genderValue = ref('1')

const nationalityItems = reactive([
  { value: '1', text: '내국인' },
  { value: '2', text: '외국인' },
])
const nationalityValue = ref('1')

const radioItems = reactive([
  { value: 'y', text: '예' },
  { value: 'n', text: '아니오' },
])
const radioValue = ref('y')

const items = [
  { value: '1', text: 'item1' },
  { value: '2', text: 'item2' },
]

const itemsSourceGrid = ref([{ col1: '텍스트' }, { col1: '텍스트2' }, { col1: '텍스트3' }])
</script>

<style lang="scss" scoped></style>
