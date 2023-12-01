<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>회원정보 조회</span>
      </h1>
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>description</span>
        </h2>
      </div>
    </div>
    <div class="card-body">
      <form action="" class="form">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 170px;">
          </colgroup>
          <tbody>
            <tr>
              <th><span class="is-required">회원번호/명</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th></th>
              <td></td>
              <th></th>
              <td></td>
              <td>
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search"/>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>상세내역</span>
          </h2>
          <div class="buttons">
            <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 150px !important;"/>
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </div>
        </div>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="최초 로그인일시"></UField>
            <UField label="최종 로그인일시"></UField>
            <UField label="최초 거래일시"></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="총 포인트"></UField>
            <UField label="사용 포인트"></UField>
            <UField label="잔여 포인트"></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
        </UFieldSet>
      </div>
    </div>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <div class="card is-sub" style="height: 300px;">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>회원 이력 정보</span>
          </h2>
        </div>
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="포인트 지급일" binding="col1" width="*" />
          <WjFlexGridColumn header="포인트 유형" binding="col1" width="*" />
          <WjFlexGridColumn header="포인트" binding="col1" width="*" />
          <WjFlexGridColumn header="내용" binding="col1" width="*" />
          <WjFlexGridColumn header="소멸 예정일" binding="col1" width="*" />
        </WjFlexGrid>
      </div>
    </div>
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