<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search"  ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField required label="발송상태">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송구분">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="발송유형">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 2, '170px']">
            <UField label="발송ID/명">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송기간">
              <UDatePeriodBox v-model:start="start" v-model:end="end" />
            </UField>
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
            <span>발송 내역</span>
          </h2>
          
          <UButtonBox class="table-buttons">
            <UButton text="미리보기" type="is-outline" />
            <UButton text="발송취소" type="is-outline" />
            <UButton text="발송처리" type="is-filled" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid" :isReadOnly="true">
          <WjFlexGridColumn header="선택" binding="col1" width="*" align="center">
            <WjFlexGridCellTemplate cellType="Cell">
              <div style="margin-top: 10px;">
                <UCheckGroupBox :items-source="[{ text: '' }]" style="width:16px; margin-right: 0;" />
              </div>
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="발송ID" binding="col1" width="*" />
          <WjFlexGridColumn header="발송명" binding="col1" width="*" />
          <WjFlexGridColumn header="발송유형" binding="col1" width="*" />
          <WjFlexGridColumn header="발송구분" binding="col1" width="*" />
          <WjFlexGridColumn header="발송방식" binding="col1" width="*" />
          <WjFlexGridColumn header="발송일시" binding="col1" width="*" />
          <WjFlexGridColumn header="발송자" binding="col1" width="*" />
          <WjFlexGridColumn header="발송상태" binding="col1" width="*" />
          <WjFlexGridColumn header="대상건수" binding="col1" width="*" />
          <WjFlexGridColumn header="실패건수" binding="col1" width="*" />
          <WjFlexGridColumn header="피로도건수" binding="col1" width="*" />
          <WjFlexGridColumn header="관리내역" binding="col1" width="*" align="center">
            <WjFlexGridCellTemplate cellType="Cell" >
              <UButton text="상세보기" />
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
        </WjFlexGrid>
      </UItem>
    </UBox>
  </div>
  </template>
  
  <script setup>
  import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
  import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
  import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';
  
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

  const start = ref('20220507')
  const end = ref('20220508')
  
  </script>
  
  <style lang="scss" scoped>
  
  </style>