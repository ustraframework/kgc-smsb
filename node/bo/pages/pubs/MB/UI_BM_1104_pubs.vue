<template>
  <div class="card is-sub is-noSearch">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원 등록 처리</span>
      </h1>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="card is-sub mb-5">
    <div class="card-body">
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>회원정보를 등록 합니다.</span>
        </h2>
        <div class="buttons">
          <UButton text="신규" type="is-outline"/>
          <UButton text="저장" type="is-filled"/>
        </div>
      </div>
      <UFieldSet>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text"/></UField>
          <UField label="CI"><UTextBox></UTextBox></UField>
          <UField label="DI"><UTextBox></UTextBox></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="회원번호"><UTextBox></UTextBox></UField>
          <UField label="회원명"><UTextBox></UTextBox></UField>
          <UField label="카드번호"><UTextBox></UTextBox></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="생년월일"><UDateBox mode="date"/></UField>
          <UField label="실생일"><UDateBox mode="date"/></UField>
          <UField label="양/음력"><URadioGroupBox v-model="solarValue" :itemsSource="solarItems" /></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="성별"><URadioGroupBox v-model="genderValue" :itemsSource="genderItems" /></UField>
          <UField label="내/외국인"><URadioGroupBox v-model="nationalityValue" :itemsSource="nationalityItems" /></UField>
          <UField label="국적"><UWjComboBox :itemsSource="items" displayMemberPath="text"/></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="핸드폰"><UTextBox></UTextBox></UField>
          <UField label="인증방식 (수정필요)">
            <UButton text="본인인증" type="is-secondary is-medium" class="is-login"/>
            <UButton text="점유인증" type="is-secondary is-medium" class="is-login"/>
          </UField>
          <UField label="인증확인 (수정필요)">
            <UTextBox></UTextBox>
            <UButton text="확인" type="is-filled is-medium" class="is-login"/>
          </UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="이메일 (수정필요)">
            <UTextBox></UTextBox>
            <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
          </UField>
          <UField label="단골매장"><UTextBox type="icon"/></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="주소"><UTextBox type="icon"/></UField>
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
          <UField label="가맹점 (수정필요)"><UTextBox type="icon"/><UTextBox/></UField>
          <UField></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="법인여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
          <UField label="사업자등록번호"><UTextBox/></UField>
          <UField label="법인명"><UTextBox/></UField>
        </UFieldRow>
        <!-- ------------------------------------------------------------------ -->
        <UFieldRow>
          <UField label="이용약관 동의여부 (수정필요)">테이블 필요</UField>
        </UFieldRow>
      </UFieldSet>
    </div>
  </div>
</template>

<script setup>
definePageMeta({
auth: {
  required: false,
},
})

const members = [
{ value : '1' , text: '일반회원'},
];

const solarItems = reactive([
{ value: '1', text: '양력' },
{ value: '2', text: '음력' },
]);
const solarValue = ref('1');

const genderItems = reactive([
{ value: '1', text: '남' },
{ value: '2', text: '여' },
]);
const genderValue = ref('1');

const nationalityItems = reactive([
{ value: '1', text: '내국인' },
{ value: '2', text: '외국인' },
]);
const nationalityValue = ref('1');

const radioItems = reactive([
{ value: 'y', text: '예' },
{ value: 'n', text: '아니오' },
]);
const radioValue = ref('y');

const items = [
{ value : '1' , text: 'item1'},
{ value : '2' , text: 'item2'},
]

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>

</style>