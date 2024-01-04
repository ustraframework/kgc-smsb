<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">부정적립 회원관리 이력</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="520" title="부정적립 회원관리 이력">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="table-title-wrap">
          <h2 class="table-title">
            <span class="data-count">총<span>10</span>건</span>
          </h2>
        </UBox>

        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 290px;">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="작업일자" binding="col1" width="*" />
          <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
          <WjFlexGridColumn header="회원명" binding="col1" width="*" />
          <WjFlexGridColumn header="회원유형" binding="col1" width="*" />
          <WjFlexGridColumn header="회원구분" binding="col1" width="*" />
          <WjFlexGridColumn header="관리매장" binding="col1" width="*" />
          <WjFlexGridColumn header="처리상태" binding="col1" width="*" />
          <WjFlexGridColumn header="산정기간(from)" binding="col1" width="*" />
          <WjFlexGridColumn header="산정기간(to)" binding="col1" width="*" />
          <WjFlexGridColumn header="처리내역" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup lang="ts">
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

<style scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>