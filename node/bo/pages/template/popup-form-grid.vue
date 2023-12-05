<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">클럽 대상 추가</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="600" title="클럽 대상 추가">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="작업선택">
                <URadioGroupBox v-model="solarValue" :itemsSource="workItems" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="엑셀 파일">
                <USingleFileUploader ref="uploader" fileGroupId="menuIcon" v-model:fileId="fileId" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="타겟팅">
                <UTextBox type="icon"/>
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="대상 인원">
                <UTextBox/>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>

        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span>클럽 대상</span>
            <span class="data-count">총<span>24</span>건</span>
          </h2>
          <UButtonBox class="table-buttons">
            <UButton text="대상자 업로드" type="is-outline"/>
            <UButton text="추가" type="is-outline"/>
            <UButton text="삭제" type="is-outline"/>
          </UButtonBox>
        </UBox>
        
        <UBox height="170px">
          <WjFlexGrid :itemsSource="itemsSourceGrid">
            <WjFlexGridColumn header="No" binding="col1" width="*" />
            <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
            <WjFlexGridColumn header="채널" binding="col1" width="*" />
            <WjFlexGridColumn header="회원명" binding="col1" width="*" />
            <WjFlexGridColumn header="컬럼라벨" binding="col1" width="*" />
            <WjFlexGridColumn header="변경전데이터" binding="col1" width="*" />
          </WjFlexGrid>
        </UBox>
      </UItem>

      <!-- footer 버튼 영역 -->
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="secondary" :width="80" />
          <UButton text="저장" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
})  

const itemsSourceGrid = ref([
{ col1: '텍스트' },
{ col1: '텍스트2'},
{ col1: '텍스트3'},
]);

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)

const workItems = reactive([
{ value: '1', text: '엑셀업로드' },
{ value: '2', text: '타겟팅' },
{ value: '2', text: '수기등록' },
]);
const solarValue = ref('1');

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>