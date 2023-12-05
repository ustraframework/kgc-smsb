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

  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>Sub title</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="엑셀 다운로드" icon="excel" />
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
        
        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>Sub title</span>
          </h2>
        </UBox>

        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="업무구분"><UTextBox></UTextBox></UField>
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
      </UItem>
    </UBox>
  </div>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
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

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>
<style lang="scss" scoped>

</style>