<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search"  ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 2, 1, '170px']">
            <UField required label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="정산기간">
              <UDatePeriodBox v-model="dateArr1" />
            </UField>
            <UField label="발송채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 2, 1, '170px']">
            <UField label="확정여부">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="전송여부">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank></UField>
            <UField blank></UField>
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
            <span>처리업무</span> 
            <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 150px !important" />
            <UButton text="처리" type="is-filled" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="선택" binding="col1" width="*" />
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="정산월" binding="col1" width="*" />
          <WjFlexGridColumn header="발송채널" binding="col1" width="*" />
          <WjFlexGridColumn header="발송유형" binding="col1" width="*" />
          <WjFlexGridColumn header="부서" binding="col1" width="*" />
          <WjFlexGridColumn header="가맹점" binding="col1" width="*" />
          <WjFlexGridColumn header="발송건수" binding="col1" width="*" />
          <WjFlexGridColumn header="발송금액" binding="col1" width="*" />
          <WjFlexGridColumn header="확정여부" binding="col1" width="*" />
          <WjFlexGridColumn header="확정일시" binding="col1" width="*" />
          <WjFlexGridColumn header="확정자" binding="col1" width="*" />
          <WjFlexGridColumn header="전송여부" binding="col1" width="*" />
          <WjFlexGridColumn header="전송일시" binding="col1" width="*" />
          <WjFlexGridColumn header="전송자" binding="col1" width="*" />
        </WjFlexGrid>
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