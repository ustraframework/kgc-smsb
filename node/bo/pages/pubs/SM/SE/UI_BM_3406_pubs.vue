<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search"  ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="발송유형">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="기준일자"><UDateBox mode="date" /></UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
    <!-- // 검색영역 -->

    <UBox class="columns" direction="row">
      <UItem class="card is-sub"  ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>100</span>건</span>
          </h2>
          
          <UButtonBox class="table-buttons">
            <UButton text="신규" type="is-outline" />
            <UButton text="저장" type="is-filled" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid" :isReadOnly="true">
          <WjFlexGridColumnGroup header="No" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="채널" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="발송유형" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="발송구분" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="적용기간 (From)" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="적용기간 (To)" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="수신가능 건수" align="center">
            <WjFlexGridColumnGroup header="일" binding="col1" width="*" />
            <WjFlexGridColumnGroup header="주" binding="col1" width="*" />
            <WjFlexGridColumnGroup header="월" binding="col1" width="*" />
          </WjFlexGridColumnGroup>
          <WjFlexGridColumnGroup header="발송가능 시간" align="center">
            <WjFlexGridColumnGroup header="From" binding="col1" width="*" />
            <WjFlexGridColumnGroup header="To" binding="col1" width="*" />
          </WjFlexGridColumnGroup>
          <WjFlexGridColumnGroup header="사용여부" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="비고" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="이력보기" binding="col1" :width="120" align="center">
            <WjFlexGridCellTemplate cellType="Cell" >
              <UButton text="이력보기" />
            </WjFlexGridCellTemplate>
          </WjFlexGridColumnGroup>
        </WjFlexGrid>
      </UItem>
    </UBox>

    <UBox class="columns" direction="row">
      <UItem class="card is-sub"  ratio="1" >
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>피로도 상세정보</span>
          </h2>
        </UBox>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1,1]">
            <UField required label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송유형">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송구분">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[2,1]">
            <UField required label="적용기간">
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
            <UField label=""></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1,1]">
            <UField required label="수신가능 건수(일)">
              <UTextBox />
            </UField>
            <UField required label="수신가능 건수(주)">
              <UTextBox />
            </UField>
            <UField required label="수신가능 건수(월)">
              <UTextBox />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[2,1]">
            <UField required label="발송가능시간">
              <div class="time_wrap">

                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                <div class="empty"> : </div>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                <div class="empty-dash"> ~ </div>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                <div class="empty"> : </div>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </div>
            </UField>
            <UField required label="사용여부">
              <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[3]">
            <UField label="비고"><UTextBox type="textarea"/></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>
  </template>
  
  <script setup>
  import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
  import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
  import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate, WjFlexGridColumnGroup } from '#ustra/nuxt-wijmo/components';
  
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
  .time_wrap{
    display: flex;
    align-items: center;

    .empty{
      margin: 0 5px;
    }

    .empty-dash{
      margin: 0 10px;
    }

  }
  </style>