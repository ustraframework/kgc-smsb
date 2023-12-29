<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">발송 템플릿 검색</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="520" title="발송 템플릿 검색">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-search" style="margin-bottom: 10px;">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="채널" >
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField label="카테고리" >
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="발송수단" >
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
              <UField label="템플릿ID/명" >
                <UTextBox></UTextBox>
              </UField>
              <UField blank></UField>
            </UFieldRow>
          </UFieldSet>
        </UBox>

        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 198px;">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="채널" binding="col1" width="*" />
          <WjFlexGridColumn header="카테고리" binding="col1" width="*" />
          <WjFlexGridColumn header="템플릿ID" binding="col1" width="*" />
          <WjFlexGridColumn header="템플릿명" binding="col1" width="*" />
          <WjFlexGridColumn header="발송수단" binding="col1" width="*" />
          <WjFlexGridColumn header="발송구분" binding="col1" width="*" />
          <WjFlexGridColumn header="제목" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="확인" type="primary"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components';

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
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
  { col1: '텍스트' },
  { col1: '텍스트2'},
  { col1: '텍스트3'},
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