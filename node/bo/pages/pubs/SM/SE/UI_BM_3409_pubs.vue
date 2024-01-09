<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">발송 대상자 등록</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1100" :height="650" title="발송 대상자 추출 - 회원등급">
    <UBox direction="col">
      <UItem :ratio="3" class="pop-contents">
        <UBox class="columns is-shuffle" direction="row">
          <UItem class="field-grid" ratio="1">
            <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
              <WjTab>
                <a>대상자 관리</a>
                <div class="tab-grid">
                  <UBox class="pop-search" style="margin-bottom: 10px;">
                    <UFieldSet class="is-search">
                      <UFieldRow :ratio="[1, 1, '170px']">
                        <UField label="발송ID" >
                          <UTextBox />
                        </UField>
                        <UField label="발송명" >
                          <UTextBox />
                        </UField>
                        <UField blank>
                          <div class="search-btn">
                            <UButton text="조회" type="is-search"/>
                          </div>
                        </UField>
                      </UFieldRow>
                      <UFieldRow :ratio="[1, 1, '170px']">
                        <UField label="회원번호/명" >
                          <UTextBox />
                        </UField>
                        <UField required label="대상자구분" >
                          <URadioGroupBox v-model="radioValue" :itemsSource="radioItems" />
                        </UField>
                        <UField blank></UField>
                      </UFieldRow>
                    </UFieldSet>
                  </UBox>

                  <UBox class="table-title-wrap mt-0" direction="row">
                    <UItem itemDirection="row" :ratio="1">
                      <UButtonBox class="table-buttons">
                        <UButton text="추가" type="is-outline" />
                        <UButton text="삭제" type="is-outline" />
                        <UButton text="저장" type="is-filled" />
                      </UButtonBox>
                    </UItem>
                  </UBox>

                  <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 198px;">
                    <WjFlexGridColumn header="선택" binding="col1" width="*" />
                    <WjFlexGridColumn header="No" binding="col1" width="*" />
                    <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                    <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                    <WjFlexGridColumn header="생년월일" binding="col1" width="*" />
                    <WjFlexGridColumn header="휴대폰" binding="col1" width="*" />
                    <WjFlexGridColumn header="관리매장" binding="col1" width="*" />
                    <WjFlexGridColumn header="대상자 구분" binding="col1" width="*" />
                  </WjFlexGrid>
                </div>
              </WjTab>

              <WjTab>
                <a>엑셀업로드</a>
                <div class="tab-grid">
                  <UButton text="샘플 파일" @click="() => createFormData()" />
                  <span class="file-desc">엑셀파일만 가능하며, 파일 형식에 맞춰서 업로드 해주시기 바랍니다.</span>
                  <USingleFileUploader ref="uploader" fileGroupId="menuIcon" v-model:fileId="fileId"  class="mt-3"/>
                </div>
              </WjTab>

              <WjTab>
                <a>제외 조건</a>
                <div class="tab-grid">

                  <UBox class="table-title-wrap">
                    <UButtonBox class="table-buttons">
                      <UButton text="저장" type="is-filled" />
                    </UButtonBox>
                  </UBox>

                  <WjFlexGrid :itemsSource="itemsSourceGrid">
                    <WjFlexGridColumn header="No" binding="col1" width="*" />
                    <WjFlexGridColumn header="구분" binding="col1" width="*" />
                    <WjFlexGridColumn header="적용여부" binding="col1" width="*" />
                    <WjFlexGridColumn header="비고" binding="col1" width="*" />
                  </WjFlexGrid>
                </div>
              </WjTab>
            </WjTabPanel>
          </UItem>
          
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline" :width="80" />
          <UButton text="등록" type="is-filled" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate, } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const tabPanel = useWijmoTabPanel()

const radioItems = reactive([
{ value: 'y', text: '발송대상자' },
{ value: 'n', text: '제외대상자' },
]);
const radioValue = ref('y');

function createFormData() {
  $ustra.logger.info('file upload result', Array.from(uploader.value.createFormData().entries()))
}

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