<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">발송 채널 이력</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="390" title="발송 채널 이력">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 198px;">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="발송채널" binding="col1" width="*" />
          <WjFlexGridColumn header="발송유형" binding="col1" width="*" />
          <WjFlexGridColumn header="적용 시작일자" binding="col1" width="*" />
          <WjFlexGridColumn header="적용 종료일자" binding="col1" width="*" />
          <WjFlexGridColumn header="건별 단가(원)" binding="col1" width="*" />
          <WjFlexGridColumn header="비고" binding="col1" width="*" />
          <WjFlexGridColumn header="변경자" binding="col1" width="*" />
          <WjFlexGridColumn header="변경일시" binding="col1" width="*" />
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