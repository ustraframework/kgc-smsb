<template>
  <div class="card is-sub is-search">
    <div class="card-header">
      <h1 class="page-title">
        <span>본문 제목</span>
        <div class="columns">
          <ul aria-label="breadcrumbs" class="breadcrumbs has-chevron-separator">
            <li class="breadcrumb"><a href="#none">인사</a></li>
            <li class="breadcrumb"><a href="#none">인사관리</a></li>
            <li aria-current="page" class="breadcrumb is-active"><a>인사코드</a></li>
          </ul>
        </div>
      </h1>
      <div class="table-title-wrap">
        <h2 class="table-title">
          <span>description</span>
        </h2>
      </div>
    </div>
    <div class="card-body">
      <form action="" class="form">
        <table class="table is-search is-fullwidth">
          <colgroup>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 130px;">
            <col>
            <col style="width: 170px;">
          </colgroup>
          <tbody>
            <tr>
              <th><span class="is-required">회원번호/명</span></th>
              <td>
                <UTextBox></UTextBox>
              </td>
              <th></th>
              <td></td>
              <th></th>
              <td></td>
              <td>
                <div class="buttons is-search">
                  <UButton text="조회" type="is-search"/>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </div>

  <div class="columns has-gap">
    <div class="card is-sub" style="width: 500px">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>상세내역</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <div class="buttons">
            <UButton text="엑셀 다운로드" icon="excel" />
          </div>
        </div>
        
        <div class="field-grid">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
          </WjFlexGrid>
        </div>
      </div>
    </div>
    <div class="card is-sub">
      <div class="card-body">
        <div class="table-title-wrap">
          <h2 class="table-title">
            <span>회원 상세 정보</span>
          </h2>
        </div>

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
      </div>
    </div>
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