<template>
  <div>
    <UBox class="columns" direction="row" height="1500">
      <!-- 좌측 영역 -->
      <UItem class="card is-sub" ratio="4" style="height: 600px">
        <UItem :ratio="1" class="pop-contents preview">
          <div class="img">
            <img src="" alt="" style="border: 1px solid red;">
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
                    <UTextBox></UTextBox>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField required label="내용">
                    <UCkEditor5 v-model="content" :height="300" :disabled="disabled" :initialized="ckEditor.initialize" /></UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow>
                  <UField label="첨부파일">
                    <div class="buttons">
                      <UButton text="Upload" @click="() => uploadFile()" />
                    </div>
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
                      <WjFlexGridColumn header="선택" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell">
                          <div style="margin-top: 10px;">
                            <UCheckGroupBox :items-source="[{ text: '' }]"></UCheckGroupBox>
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
            <a>발송 일정</a>
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
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField label="일정방식">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField label="시작일시">
                    <UDateBox mode="date" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[2]">
                  <UField label="발송일정">
                    <UButtonBox class="table-buttons">
                      <UButton icon="arr-up" type="is-outline"/>
                      <UButton icon="arr-down" type="is-outline"/>
                    </UButtonBox>
                    
                    <WjFlexGrid  :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2" >
                      <WjFlexGridColumn header="선택" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" >
                          <div style="margin-top: 10px;">
                            <UCheckGroupBox :items-source="[{ text: '' }]"></UCheckGroupBox>
                          </div>
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn binding="col1" header="월" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn header="주" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn header="일" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

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

                      <WjFlexGridColumn header="비고" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>
                    </WjFlexGrid>
                  </UField>
                </UFieldRow>
              </UFieldSet>
            </div>
          </WjTab>

          <WjTab>
            <a>발송 대상자</a>
            <div class="tab-grid">
              <UButtonBox class="table-buttons">
                <UButton text="저장" type="is-filled" />
              </UButtonBox>
              <UFieldSet>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="대상ID">
                    <UTextBox></UTextBox>
                  </UField>
                  <UField required label="추출일시">
                    <UDateBox v-model="inputValue3" mode="datetime" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="대상조건">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField label="타겟팅그룹">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[2]">
                  <UField label="대상자">
                    <UBox class="table-title-wrap ">
                      <h2 class="table-title">
                        <span class="data-count"><span>20</span>건 / <span>100</span>건</span>
                      </h2>
                      
                      <UButtonBox class="table-buttons">
                        <UButton text="엑셀업로드" type="is-outline" icon="excel"/>
                        <UButton text="대상선정" type="is-outline" />
                        <UButton text="삭제" type="is-outline" />
                        <UButton text="추가" type="is-filled" />
                      </UButtonBox>
                    </UBox>
                    
                    <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2" style="margin-top: 0;">
                      <WjFlexGridColumn header="선택" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell">
                          <div style="margin-top: 10px;">
                            <UCheckGroupBox :items-source="[{ text: '' }]"></UCheckGroupBox>
                          </div>
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn binding="col1" header="회원번호" width="*"></WjFlexGridColumn>

                      <WjFlexGridColumn header="회원명" binding="col1" width="*"></WjFlexGridColumn>

                      <WjFlexGridColumn header="핸드폰" binding="col1" width="*"></WjFlexGridColumn>

                      <WjFlexGridColumn header="피로도" binding="col1" width="*"></WjFlexGridColumn>

                      <WjFlexGridColumn header="파라미터값" binding="col1" width="*"></WjFlexGridColumn>
                    </WjFlexGrid>
                  </UField>
                </UFieldRow>
              </UFieldSet>
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
  
  </style>