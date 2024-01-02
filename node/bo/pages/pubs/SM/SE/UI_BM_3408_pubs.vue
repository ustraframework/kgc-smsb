<template>
  <div>
    <UBox class="columns" direction="row" height="1450">
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
        <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
          <WjTab>
            <a>1 메시지 작성</a>
            <div class="tab-grid">
              <UBox class="table-title-wrap" direction="row">
                <UItem itemDirection="row" :ratio="1">
                  <UButtonBox class="table-buttons">
                    <UButton text="템플릿" type="is-outline" />
                    <UButton text="신규" type="is-outline" />
                  </UButtonBox>
                </UItem>
              </UBox>
              <UFieldSet>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="발송ID">
                    <UTextBox></UTextBox>
                  </UField>
                  <UField required label="발송명">
                    <UTextBox></UTextBox>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="발송채널">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField required label="발송수단">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="발송유형">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField required label="발송형태">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
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
                <UFieldRow :ratio="[1,1]">
                  <UField required label="발송방식">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
                  <UField required label="사용여부">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
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

              <UButtonBox class="table-buttons">
                <UButton text="저장" type="is-outline" />
                <UButton text="다음" type="is-filled" />
              </UButtonBox>
            </div>
          </WjTab>

          <WjTab>
            <a>2 발송 일정</a>
            <div class="tab-grid">
              <UButtonBox class="table-buttons">
                <UButton text="저장" type="is-filled" />
              </UButtonBox>
              <UFieldSet>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField required label="실행방식">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField required label="실행주기">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField required label="실행기간">
                    <UDatePeriodBox v-model="dateArr1" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="월">
                    <UCheckGroupBox :items-source="[{ text: 'Item1'}]" v-model="checked"> </UCheckGroupBox>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="요일">
                    <UCheckGroupBox :items-source="[{ text: 'Item1' }]" v-model="checked"> </UCheckGroupBox>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="일">
                    <UCheckGroupBox :items-source="[{ text: 'Item1' }]" v-model="checked"> </UCheckGroupBox>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField required label="시간">                    
                    <WjFlexGrid  :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2" >
                      <WjFlexGridColumn header="No" binding="col1" width="*"></WjFlexGridColumn>
                      <WjFlexGridColumn header="시" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>
                      <WjFlexGridColumn header="분" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>
                      <WjFlexGridColumn header="사용여부" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>
                      <WjFlexGridColumn header="비고" binding="col1" width="*"></WjFlexGridColumn>
                    </WjFlexGrid>
                  </UField>
                </UFieldRow>
              </UFieldSet>

              <UButtonBox class="table-buttons">
                <UButton text="저장" type="is-outline" />
                <UButton text="다음" type="is-filled" />
              </UButtonBox>
            </div>
          </WjTab>

          <WjTab>
            <a>3 발송 대상자</a>
            <div class="tab-grid">
              <UButtonBox class="table-buttons">
                <UButton text="추가" type="is-filled" />
              </UButtonBox>
              
              <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 438px;">
                <WjFlexGridColumn header="총 대상자" binding="col1" width="*" />
                <WjFlexGridColumn header="추출 건수" binding="col1" width="*" />
                <WjFlexGridColumn header="수기 등록 건수" binding="col1" width="*" />
                <WjFlexGridColumn header="제외 대상건수" binding="col1" width="*" />
                <WjFlexGridColumn header="마케팅 미수신 대상 건수" binding="col1" width="*" />
                <WjFlexGridColumn header="피로도 대상건수" binding="col1" width="*" />
              </WjFlexGrid>

              <UButtonBox class="table-buttons">
                <UButton text="발송 등록" type="is-outline" />
                <UButton text="즉시 발송" type="is-filled" />
              </UButtonBox>
            </div>
          </WjTab>
        </WjTabPanel>
        
        <!-- <UBox class="table-title-wrap" style="margin-top:20px">
          <h2 class="table-title">
            <span>파라미터(대체문자) 설정</span>
          </h2>

          <UButtonBox class="table-buttons">
            <UButton text="추가" type="is-outline" />
            <UButton text="삭제" type="is-outline" />
            <UButton text="저장" type="is-filled" />
          </UButtonBox>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="선택" binding="col1" width="*" />
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="파라미터 필드" binding="col1" width="*" />
          <WjFlexGridColumn header="표현식" binding="col1" width="*" />
          <WjFlexGridColumn header="형식" binding="col1" width="*" />
          <WjFlexGridColumn header="기본값" binding="col1" width="*" />
        </WjFlexGrid> -->
      </UItem>
    </UBox>
  </div>
  </template>
  
  <script setup>
  import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
  import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
  import { WjComboBox } from '#ustra/nuxt-wijmo/components'
  import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';
  
  const grid = useWijmoFlexGrid({
  isReadOnly: true,
  })  
  
  const tabPanel = useWijmoTabPanel()

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