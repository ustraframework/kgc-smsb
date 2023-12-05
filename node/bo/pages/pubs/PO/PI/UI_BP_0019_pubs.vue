<template>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="소멸구분코드" >
              <UTextBox/>
            </UField>
            <UField label="본부코드" >
              <UBox>
                <UTextBox type="icon" />
                <UTextBox disabled/>
              </UBox>
            </UField>
            <UField label="조회건수">
              <UTextBox/>
            </UField>
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

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>포인트지급 정보</span>
            <span class="data-count">총<span>2</span>건</span>
          </h2>
        </UBox>

        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="지급방법" binding="col1" width="*" />
            <WjFlexGridColumn header="지급사유" binding="col1" width="*" />
            <WjFlexGridColumn header="비고(고객노출용)" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트유형그룹코드" binding="col1" width="*" />
            <WjFlexGridColumn header="소멸포인트" binding="col1" width="*" />
            <WjFlexGridColumn header="잔여포인트" binding="col1" width="*" />
            <WjFlexGridColumn header="최신3년적립포인터" binding="col1" width="*" />
            <WjFlexGridColumn header="관리매장" binding="col1" width="*" />
            <WjFlexGridColumn header="본부코드" binding="col1" width="*" />
            <WjFlexGridColumn header="소멸예상일자" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
    </UBox>
  </div>
  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
              <span>상세내역</span>
          </h2>
        </UBox>
        
        <UFieldSet class="is-large">
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow>
            <UField label="소멸구분코드">
              <UTextBox disabled/>
            </UField>
            <UField label="소멸예정일자">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="카드번호">
              <UTextBox disabled/>
            </UField>
            <UField label="포인트유형그룹코드">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="소멸포인트">
              <UTextBox disabled/>
            </UField>
            <UField label="잔여포인트">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="최신3년적립포인터">
              <UTextBox disabled/>
            </UField>
            <UField label="관리매장">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="본부코드">
              <UTextBox disabled/>
            </UField>
            <UField label="소멸예상일자">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록일자">
              <UTextBox disabled/>
            </UField>
            <UField label="등록IP">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="등록사본">
              <UTextBox disabled/>
            </UField>
            <UField label="수정일자">
              <UTextBox disabled/>
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="수정IP">
              <UTextBox disabled/>
            </UField>
            <UField label="수정일자">
              <UTextBox disabled/>
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