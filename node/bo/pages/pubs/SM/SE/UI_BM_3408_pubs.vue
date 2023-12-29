<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search"  ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="발송ID/명">
            <UTextBox></UTextBox>
            </UField>
            <UField label="발송구분">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="발송방식">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="발송채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="발송유형" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="사용여부" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
    <!-- // 검색영역 --> 
  
    <UBox class="columns" direction="row" height="1500">
      <!-- 좌측 영역 -->
      <UItem class="card is-sub" ratio="4">
        <UBox class="table-title-wrap" direction="row">
          <UItem itemDirection="row" :ratio="1">
            <h2 class="table-title">
              <span class="data-count">총<span>24</span>건</span>
            </h2>
          </UItem>
        </UBox>
        
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="발송ID" binding="col1" width="*" />
          <WjFlexGridColumn header="발송명" binding="col1" width="*" />
          <WjFlexGridColumn header="발송구분" binding="col1" width="*" />
          <WjFlexGridColumn header="발송방식" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <!-- 우측 영역 -->
      <UItem class="card is-sub" ratio="8">

        <UBox class="table-title-wrap" direction="row">
          <UItem itemDirection="row" :ratio="1">
            <UButtonBox class="table-buttons">
              <UButton text="미리보기" type="is-outline" />
              <UButton text="전송처리" type="is-outline" />
            </UButtonBox>
          </UItem>
        </UBox>
        <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
          <WjTab>
            <a>문자발송 내역</a>
            <div class="tab-grid">
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
                  <UField required label="발송구분">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField required label="발송방식">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="발송채널">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField required label="발송유형">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField label="카카오톡ID">
                    <UTextBox></UTextBox>
                  </UField>
                  <UField required label="사용여부">
                    <URadioGroupBox v-model="solarValue" :itemsSource="solarItems" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField label="템플릿ID">
                    <UTextBox type="icon"></UTextBox>
                  </UField>
                  <UField label="템플릿명">
                    <UTextBox></UTextBox>
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
                  <UField label="내용">
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
              </UFieldSet>
              
              <UBox class="table-title-wrap" style="margin-top:20px">
                <h2 class="table-title">
                  <span>파라미터(대체문자) 설정</span>
                </h2>
              </UBox>
              
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="파라미터 필드" binding="col1" width="*" />
                <WjFlexGridColumn header="표현식" binding="col1" width="*" />
                <WjFlexGridColumn header="형식" binding="col1" width="*" />
                <WjFlexGridColumn header="기본값" binding="col1" width="*" />
              </WjFlexGrid>
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
                <UFieldRow :ratio="[1,1]">
                  <UField required label="일정ID">
                    <UTextBox></UTextBox>
                  </UField>
                  <UField required label="발송주기">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
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