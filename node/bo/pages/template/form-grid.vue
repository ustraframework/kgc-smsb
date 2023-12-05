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
            <UButton text="엑셀 다운로드" icon="excel" />
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="DI"><UTextBox></UTextBox></UField>
            <UField label="카드번호"><UTextBox></UTextBox></UField>
            <UField label="ID"><UTextBox></UTextBox></UField>
            <UField label="PWD"><UTextBox></UTextBox></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="DI"><UTextBox></UTextBox></UField>
            <UField label="카드번호"><UTextBox></UTextBox></UField>
            <UField label="ID"><UTextBox></UTextBox></UField>
            <UField label="PWD"><UTextBox></UTextBox></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub" style="height: 300px;">
      <UItem class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>Sub title</span>
          </h2>
        </div>
        
        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트 지급일" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트 유형" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트" binding="col1" width="*" />
            <WjFlexGridColumn header="내용" binding="col1" width="*" />
            <WjFlexGridColumn header="소멸 예정일" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
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