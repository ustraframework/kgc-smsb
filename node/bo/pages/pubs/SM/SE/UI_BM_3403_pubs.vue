<template>
  <div>
    <!-- 검색영역 -->
    <UBox class="columns" direction="row">
      <UItem class="card is-sub is-search"  ratio="1" >
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField required label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="카테고리">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="발송수단">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField label="템플릿코드/명" ><UTextBox></UTextBox></UField>
            <UField label="제목" ><UTextBox></UTextBox></UField>
            <UField blank></UField>
            <UField blank></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
    <!-- // 검색영역 --> 
  
    <UBox class="columns" direction="row" height="1250">
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
          <WjFlexGridColumn header="채널" binding="col1" width="*" />
          <WjFlexGridColumn header="템플릿코드" binding="col1" width="*" />
          <WjFlexGridColumn header="템플릿명" binding="col1" width="*" />
          <WjFlexGridColumn header="발송수단" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <!-- 우측 영역 -->
      <UItem class="card is-sub" ratio="8">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>템플릿 상세정보</span>
          </h2>
          
          <UButtonBox class="table-buttons">
            <UButton text="미리보기" type="is-outline" />
            <UButton text="신규" type="is-outline" />
            <UButton text="삭제" type="is-outline" />
            <UButton text="저장" type="is-filled" />
          </UButtonBox>
        </UBox>
        <UFieldSet>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="채널">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField required label="카테고리">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="발송수단">
              <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
            </UField>
            <UField label="카카오톡ID">
              <UTextBox></UTextBox>
            </UField>
          </UFieldRow>
          <!-- ------------------------------------------------------------------ -->
          <UFieldRow :ratio="[1,1]">
            <UField required label="템플릿코드">
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
            <UField label=""></UField>
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
        </UFieldSet>
        
        <UBox class="table-title-wrap" style="margin-top:20px">
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
        </WjFlexGrid>
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