<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">파라미터(대체문자)</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="390" title="파라미터(대체문자)">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 198px;" :isReadOnly="true">
          <WjFlexGridColumn header="선택" binding="col1" width="*" align="center">
            <WjFlexGridCellTemplate cellType="Cell" >
              <div style="width: 16px; height: 16px; margin-bottom: 8px;">
                <UCheckGroupBox :items-source="[{ text: '' }]"></UCheckGroupBox>
              </div>
            </WjFlexGridCellTemplate>
          </WjFlexGridColumn>
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="변수명" binding="col1" width="*" />
          <WjFlexGridColumn header="변수ID" binding="col1" width="*" />
          <WjFlexGridColumn header="표현식" binding="col1" width="*" />
          <WjFlexGridColumn header="형식" binding="col1" width="*" />
          <WjFlexGridColumn header="설명" binding="col1" width="*" />
        </WjFlexGrid>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="선택" type="primary"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components';

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