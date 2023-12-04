<template>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="검색영역" ><UTextBox></UTextBox></UField>
            <UField blank></UField>
            <UField blank></UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>Sub title</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
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
            <UField label="Push 여부">
              <UCheckGroupBox
                :items-source="[
                  { trueValue: 'Y', falseValue: 'N', text: '' },
                ]"
                item-align="left"
              >
              </UCheckGroupBox>
            </UField>
            <UField></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[3, 1]">
            <UField label="기념일" >
              <div class="field-grid">
                <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
                  <WjFlexGridColumn header="기념일 구분" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value"/>
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn binding="col1" header="기념일" width="*" format="yyyy-MM-dd">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <WjInputDate v-model="cell.item.date"/>
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn header="양/음력" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value"/>
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>

                  <WjFlexGridColumn header="성별" binding="col1" width="*">
                    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                      <UCodeComboBox v-model="cell.value"/>
                    </WjFlexGridCellTemplate>
                  </WjFlexGridColumn>
                </WjFlexGrid>
              </div>
            </UField>
            <UField blanck></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="최초 로그인일시"><UTextBox/></UField>
            <UField label="최종 로그인일시"><UTextBox/></UField>
            <UField label="최초 거래일시"><UTextBox/></UField>
            <UField label="최종 거래일시"><UTextBox/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="총 포인트"><UTextBox/></UField>
            <UField label="사용 포인트"><UTextBox/></UField>
            <UField label="잔여 포인트"><UTextBox/></UField>
            <UField label="소멸 예정 포인트"><UTextBox/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
        </UFieldSet>
      </UItem>
    </UBox>
  </div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const tabPanel = useWijmoTabPanel()

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub'
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

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>

</style>