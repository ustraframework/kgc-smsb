<template>
  <div class="card is-sub is-search">
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

  <!-- ================== Sample 1 ================== -->
  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <div class="buttons">
            <UButton text="엑셀 다운로드" icon="excel" />
          </div>
        </div>
        
        <div class="field-grid">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
            <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
            <WjFlexGridColumn header="수정자" binding="col1" width="*" />
            <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
          </WjFlexGrid>
        </div>
      </div>
    </div>
  </div>


  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <div class="buttons">
            <UButton text="엑셀 다운로드" icon="excel" />
          </div>
        </UBox>

        <UBox class="field-grid">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
            <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
            <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
            <WjFlexGridColumn header="수정자" binding="col1" width="*" />
            <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
    </UBox>
  </div>

  <!-- ================== Sample 2 ================== -->

  <div class="columns has-gap">
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>회원 상세 정보</span>
          </h2>
        </div>

        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원번호"><UTextBox></UTextBox></UField>
            <UField label="회원명"><UTextBox></UTextBox></UField>
            <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text"/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="잔여포인트"><UTextBox></UTextBox></UField>
            <UField label="탈퇴일자"><UDateBox mode="date"/></UField>
            <UField label="삭제예정일자"><UDateBox mode="date"/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="탈퇴사유"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="복원사유"><UTextBox type="textarea" v-model="test" /></UField>
          </UFieldRow>
        </UFieldSet>
      </div>
    </div>
  </div>

  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>회원 상세 정보</span>
          </h2>
        </UBox>

        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="회원번호"><UTextBox></UTextBox></UField>
            <UField label="회원명"><UTextBox></UTextBox></UField>
            <UField label="회원유형"><UWjComboBox :itemsSource="members" displayMemberPath="text"/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="잔여포인트"><UTextBox></UTextBox></UField>
            <UField label="탈퇴일자"><UDateBox mode="date"/></UField>
            <UField label="삭제예정일자"><UDateBox mode="date"/></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="탈퇴사유"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="복원사유"><UTextBox type="textarea" v-model="test" /></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
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
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
{ col1: '텍스트' },
{ col1: '텍스트2'},
]);

</script>

<style lang="scss" scoped>

</style>