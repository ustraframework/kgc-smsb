<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">발송 대상자 추출 - 회원등급</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="350" title="발송 대상자 추출 - 회원등급">
    <UBox direction="col">
      <UItem :ratio="3" class="pop-contents">
        <UBox class="columns is-shuffle" direction="row">
          <UItem class="field-grid" ratio="1">


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
                  <UField label="발송유형">
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
                  <UField label="업무내용">
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
                  <UField required label="일정방식">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField required label="시작일시">
                    <UDateBox mode="date" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[1,1]">
                  <UField required label="발송채널">
                    <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
                  </UField>
                  <UField label="발송유형">
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
                <UFieldRow :ratio="[2]">
                  <UField label="템플릿ID">
                    <UButtonBox class="table-buttons">
                      <UButton icon="arr-up" type="is-outline"/>
                      <UButton icon="arr-down" type="is-outline"/>
                    </UButtonBox>
                    
                    <WjFlexGrid :itemsSource="itemsSourceGrid" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
                      <WjFlexGridColumn header="선택" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell">
                          <UCheckGroupBox :items-source="[{ text: '' }]"></UCheckGroupBox>
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
                  <UField required label="타겟팅그룹">
                    <UDateBox mode="date" />
                  </UField>
                </UFieldRow>
                <!-- ------------------------------------------------------------------ -->
                <UFieldRow :ratio="[2]">
                  <UField label="템플릿ID">
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
                          <UCheckGroupBox :items-source="[{ text: '' }]"></UCheckGroupBox>
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn binding="col1" header="회원번호" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn header="회원명" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn header="핸드폰" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn header="피로도" binding="col1" width="*">
                        <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
                          <UCodeComboBox v-model="cell.value" />
                        </WjFlexGridCellTemplate>
                      </WjFlexGridColumn>

                      <WjFlexGridColumn header="파라미터값" binding="col1" width="*">
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
        </WjTabPanel>
          </UItem>
          
          <UItem class="buttons">
            <UButton icon="arr-left" />
            <UButton icon="arr-right" />
          </UItem>

          <UItem class="field-grid" ratio="1">
            <WjFlexGrid :itemsSource="itemsSourceGrid">
              <WjFlexGridColumn header="선택" binding="col1" width="*" />
              <WjFlexGridColumn header="구분" binding="col1" width="*" />
              <WjFlexGridColumn header="값" binding="col1" width="*" />
              <WjFlexGridColumn header="범위(From)" binding="col1" width="*" />
              <WjFlexGridColumn header="범위(To)" binding="col1" width="*" />
            </WjFlexGrid>
          </UItem>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="secondary" :width="80" />
          <UButton text="대상자 추출" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const tabPanel = useWijmoTabPanel()

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

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>