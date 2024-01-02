<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">피로도 기준 이력</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1200" :height="390" title="피로도 기준 이력">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <WjFlexGrid :itemsSource="itemsSourceGrid">
          <WjFlexGridColumnGroup header="No" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="채널" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="발송유형" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="발송구분" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="적용기간 (From)" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="적용기간 (To)" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="수신가능 건수" align="center">
            <WjFlexGridColumnGroup header="일" binding="col1" width="*" />
            <WjFlexGridColumnGroup header="주" binding="col1" width="*" />
            <WjFlexGridColumnGroup header="월" binding="col1" width="*" />
          </WjFlexGridColumnGroup>
          <WjFlexGridColumnGroup header="발송가능 시간" align="center">
            <WjFlexGridColumnGroup header="From" binding="col1" width="*" />
            <WjFlexGridColumnGroup header="To" binding="col1" width="*" />
          </WjFlexGridColumnGroup>
          <WjFlexGridColumnGroup header="사용여부" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="비고" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="변경자" binding="col1" width="*" />
          <WjFlexGridColumnGroup header="변경일시" binding="col1" width="*" />
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
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridColumnGroup } from '#ustra/nuxt-wijmo/components';

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