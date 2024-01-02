<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">회원검색</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1100" :height="550" title="회원검색">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-search">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="고객명" >
                <UTextBox />
              </UField>
              <UField label="휴대폰번호">
                <UTextBox placeholder="(뒤4자리 또는 전체번호)"/>
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="생년월일" >
                <UDateBox mode="date" />
              </UField>
              <UField label="카드번호">
                <UTextBox />
              </UField>
              <UField blank></UField>
            </UFieldRow>
          </UFieldSet>
        </UBox>

        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 198px;">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
          <WjFlexGridColumn header="회원명" binding="col1" width="*" />
          <WjFlexGridColumn header="카드번호" binding="col1" width="*" />
          <WjFlexGridColumn header="생년월일" binding="col1" width="*" />
          <WjFlexGridColumn header="휴대폰" binding="col1" width="*" />
          <WjFlexGridColumn header="관리매장" binding="col1" width="*" />
          <WjFlexGridColumn header="등급" binding="col1" width="*" />
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