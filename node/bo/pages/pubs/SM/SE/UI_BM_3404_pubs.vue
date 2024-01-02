<template>
  <div>
    <UBox class="columns" direction="row" height="1350">
      <!-- 좌측 영역 -->
      <UItem class="card is-sub" ratio="4" style="height: 550px">
        <UItem :ratio="1" class="pop-contents preview">
          <div class="img">
            <img src="@/assets/images/preview.png" alt="">
          </div>
          <div class="img_desc">
            <span>기기에 따라 다르게 보일 수 있습니다.</span>
          </div>
          <UItem class="preview-form">
            <span>수신번호</span>
            <UTextBox></UTextBox>
            <UButton text="테스트 등록하기" type="is-filled"></UButton>
          </UItem>
        </UItem>
      </UItem>
      <!-- 우측 영역 -->
      <UItem class="card is-sub" ratio="8">
        <UBox class="table-title-wrap" direction="row">
          <UItem itemDirection="row" :ratio="1">
            <UButtonBox class="table-buttons">
              <UButton text="신규" type="is-outline" />
              <UButton text="저장" type="is-filled" />
            </UButtonBox>
          </UItem>
        </UBox>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송유형">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="발송수단">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송형태">
              <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="템플릿ID">
              <UTextBox></UTextBox>
            </UField>
            <UField required label="템플릿명">
              <UTextBox></UTextBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="사용여부">
              <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
            </UField>
            <UField blank></UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField label="발신프로필키">
              <UTextBox></UTextBox>
            </UField>
            <UField label="템플릿코드">
              <UTextBox></UTextBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1]">
            <UField required label="제목">
              <UBox>
                <UTextBox style="width: 100px"/>
                <UTextBox></UTextBox>
              </UBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField required label="내용">
              <UCkEditor5 v-model="content" :height="300" :disabled="disabled" :initialized="ckEditor.initialize" />  
              <UTextBox></UTextBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="첨부파일">
              <UMultiFileUploader ref="uploader" fileGroupId="menuIcon" />
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="사용변수">
              <UBox class="table-title-wrap ">
                <UButtonBox class="table-buttons">
                  <UButton text="추가" type="is-outline"/>
                  <UButton text="삭제" type="is-outline"/>
                  <UButton text="저장" type="is-filled"/>
                </UButtonBox>
              </UBox>
              
              <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2" style="margin-top: 0;">
                <WjFlexGridColumn header="선택" binding="col1" width="*" align="center">
                  <WjFlexGridCellTemplate cellType="Cell">
                    <div style="margin-top: 10px;">
                      <UCheckGroupBox :items-source="[{ text: '' }]" style="width:16px; margin-right: 0;" />
                    </div>
                  </WjFlexGridCellTemplate>
                </WjFlexGridColumn>
                <WjFlexGridColumn header="No" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="변수명" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="표현식" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="형식" binding="col1" width="*"></WjFlexGridColumn>
                <WjFlexGridColumn header="기본값" binding="col1" width="*"></WjFlexGridColumn>
              </WjFlexGrid>
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>
  </template>
  
  <script setup>
  import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
  import { WjComboBox } from '#ustra/nuxt-wijmo/components'
  import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';
  
  const grid = useWijmoFlexGrid({
  isReadOnly: true,
  })  

  const ckEditor = useUstraCkEditor5()
  
  const items = [
    { value: '01', text: '항목1' },
    { value: '02', text: '항목2' },
  ]
  
  definePageMeta({
    auth: {
      required: false,
    },
    layout: 'ustra-pub'
  })
  const { collectionView, loadPageData, pageSize, totalRecords, currentPageNo } = usePaginationCollectionView((pageNo, orders) => {
    return useOnError(
      async () => {
        const service = useUstraInterfaceService()
        const result = await service.getIntefaceHistories({
          header: {
            currentPage: pageNo,
            pageSize: pageSize.value,
            orders,
          },
          searchValue: {},
        })
        return {
          data: result.body,
          totalRecords: result.header.totalRecords,
        }
      },
      { message: '데이터 조회 중 오류가 발생하였습니다.' },
    )()
  })


const solarItems = reactive([
  { value: '1', text: '예' },
  { value: '2', text: '아니오' },
])
const solarValue = ref('1')
  
  const itemsSourceGrid = ref([
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  ]);
  
  </script>
  
  <style lang="scss" scoped>
    .img_desc{
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 13px;
    color: #8e8e8e;
  }
  </style>