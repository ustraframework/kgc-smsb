<template>
<div>
  <!-- 검색영역 -->
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
  <!-- // 검색영역 --> 

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>Sub title</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="처리" type="is-outline"/>
            <UButton text="취소" type="is-outline"/>
            <UButton text="저장" type="is-filled"/>
          </UButtonBox>
        </UBox>
        
        <UBox>
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="포인트유형코드" binding="col1" width="*" />
            <WjFlexGridColumn header="유형코드명" binding="col1" width="*" />
            <WjFlexGridColumn header="유형구분코드" binding="col1" width="*" />
            <WjFlexGridColumn header="유형구분코드명" binding="col1" width="*" />
            <WjFlexGridColumn header="적용시작일자" binding="col1" width="*" />
            <WjFlexGridColumn header="적용종료일자" binding="col1" width="*" />
            <WjFlexGridColumn header="유효기간개월수" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>
    </UBox>
  </div>

  <!-- ------------------------------------------------------------------ -->
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body">
        <WjTabPanel :initialized="tabPanel.initialize" class="mt-5">
          <WjTab>
            <a>포인트</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="포인트 지급일" binding="col1" width="*" />
                <WjFlexGridColumn header="포인트 유형" binding="col1" width="*" />
                <WjFlexGridColumn header="포인트" binding="col1" width="*" />
                <WjFlexGridColumn header="내용" binding="col1" width="*" />
                <WjFlexGridColumn header="소멸 예정일" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>

          <WjTab>
            <a>회원변경</a>
            <div class="tab-grid">
              <WjFlexGrid :itemsSource="itemsSourceGrid">
                <WjFlexGridColumn header="No" binding="col1" width="*" />
                <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
                <WjFlexGridColumn header="채널" binding="col1" width="*" />
                <WjFlexGridColumn header="회원명" binding="col1" width="*" />
                <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
                <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
                <WjFlexGridColumn header="변경후데이터" binding="col1" width="*" />
                <WjFlexGridColumn header="변경사유" binding="col1" width="*" />
                <WjFlexGridColumn header="컬럼명" binding="col1" width="*" />
                <WjFlexGridColumn header="수정자" binding="col1" width="*" />
                <WjFlexGridColumn header="수정일시" binding="col1" width="*" />
              </WjFlexGrid>
            </div>
          </WjTab>
        </WjTabPanel>
      </UItem>
    </UBox>
  </div>
</div>
</template>

<script setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components';
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab';
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const tabPanel = useWijmoTabPanel()

definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra-pub'
})

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

</script>

<style lang="scss" scoped>

</style>