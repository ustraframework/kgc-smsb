<template>
    <div class="card is-sub mb-5">
      <div class="card-header">
        <h1 class="page-title">
          <span>회원정보 조회</span>
        </h1>
      </div>
      <div class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow>
            <UField label="법인명"><UTextBox></UTextBox></UField>
            <UField label="법인명"><UTextBox></UTextBox></UField>
            <UField label="법인명"><UTextBox></UTextBox></UField>
            <UField><UButton text="조회" type="is-search"/></UField>
          </UFieldRow>
        </UFieldSet>
      </div>
    </div>

    <!-- ------------------------------------------------------------------ -->
    <div class="card is-sub mb-5">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-tite">
            <span>상세내역</span>
          </h2>
          <div class="buttons">
            <UWjComboBox :itemsSource="pwd" displayMemberPath="text" />
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </div>
        </div>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text"/></UField>
            <UField label="회원번호"><UTextBox></UTextBox></UField>
            <UField label="회원명"><UTextBox></UTextBox></UField>
            <UField label="CI"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="DI"><UTextBox></UTextBox></UField>
            <UField label="카드번호"><UTextBox></UTextBox></UField>
            <UField label="ID"><UTextBox></UTextBox></UField>
            <UField label="PWD"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="생년월일"><UDateBox mode="date"/></UField>
            <UField label="실생일"><UDateBox mode="date"/></UField>
            <UField label="양/음력"><URadioGroupBox v-model="solarValue" :itemsSource="solarItems" /></UField>
            <UField label="연령"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="단골매장"><UTextBox type="icon"/></UField>
            <UField label="주소"><UTextBox type="icon"/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="가입일자"><UDateBox mode="date"/></UField>
            <UField label="가입경로"><UWjComboBox :itemsSource="items" displayMemberPath="text"/></UField>
            <UField label="회원상태"><UWjComboBox :itemsSource="items" displayMemberPath="text"/></UField>
            <UField label="회원등급"><UWjComboBox :itemsSource="items" displayMemberPath="text"/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원통합여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
            <UField label="클랜징 상태"><UWjComboBox :itemsSource="items" displayMemberPath="text"/></UField>
            <UField label="클랜징 일자"><UTextBox/></UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[2, 1, 1]">
            <UField label="가맹점"><UTextBox type="icon"/></UField>
            <UField></UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="법인여부"><URadioGroupBox v-model="radioValue" :itemsSource="radioItems" /></UField>
            <UField label="사업자등록번호"><UTextBox/></UField>
            <UField label="법인명"><UTextBox/></UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
        </UFieldSet>
      </div>
    </div>

    <!-- ------------------------------------------------------------------ -->
    <div class="card is-sub mb-5">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-tite">
            <span>회원 이력 정보</span>
          </h2>
        </div>

        <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
          <WjTab>
            <a>포인트</a>
            <WjFlexGrid style="height: 200px" :itemsSource="itemsSourcePoint">
              <WjFlexGridColumn header="포인트" binding="row01" width="2*" />
              <WjFlexGridColumn header="포인트" binding="row01" width="*" />
            </WjFlexGrid>
          </WjTab>

          <WjTab>
            <a>회원변경</a>
            <div>222</div>
          </WjTab>
        </WjTabPanel>
      </div>
    </div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components';

const tabPanel = useWijmoTabPanel()

definePageMeta({
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

const itemsSourcePoint = ref([
  { item01: '2023.10.20 12:30:30', item02: '지급', item03: '1200', item04: '상품구매로 지급', item05: '2025.10.10 09:00:00' },
  { item01: '2023.10.20 12:30:30', item02: '사용', item03: '560', item04: '주문사용', item05: '2025.10.10 09:00:00' },
  { item01: '2023.10.20 12:30:30', item02: '소멸', item03: '200', item04: '유효기간 만료', item05: '2025.10.10 09:00:00' },
]);
</script>

<style lang="scss" scoped>

</style>