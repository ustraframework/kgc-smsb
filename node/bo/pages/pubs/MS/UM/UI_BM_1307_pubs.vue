<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">상품 검색</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="1000" :height="590" title="상품 검색">
    <UBox direction="col">
      <UItem :ratio="3" class="pop-contents">
        <UBox class="pop-search">
          <UFieldSet class="is-search">
            <UFieldRow :ratio="[1, 1, '170px']">
              <UField label="대분류" required>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </UField>
              <UField label="중분류" required>
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </UField>
              <UField blank>
                <div class="search-btn">
                  <UButton text="조회" type="is-search"/>
                </div>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UBox>
        
        <UBox class="columns is-shuffle" direction="row" height="300px">
          <UItem class="field-grid" ratio="1">
            <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 290px" :initialized="e => (gridControl = markRaw(e))">
              <WjFlexGridColumn header="상품코드" binding="col1" width="*" align="center"/>
              <WjFlexGridColumn header="상품명" binding="col1" width="*" align="center"/>
            </WjFlexGrid>
          </UItem>
          
          <UItem class="buttons">
            <UButton icon="arr-left" />
            <UButton icon="arr-right" />
          </UItem>

          <UItem class="field-grid" ratio="1">
            <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 290px" :initialized="e => (gridControl2 = markRaw(e))">
              <WjFlexGridColumn header="상품코드" binding="col1" width="*" align="center"/>
              <WjFlexGridColumn header="상품명" binding="col1" width="*" align="center"/>
            </WjFlexGrid>
          </UItem>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" :width="80" type="is-outline"/>
          <UButton text="확인" type="is-filled" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup lang="ts">
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';
import { FlexGrid } from '@grapecity/wijmo.grid'

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const gridControl = shallowRef<FlexGrid>();
const gridControl2 = shallowRef<FlexGrid>()
const { selectionRowData: gridSelectionData } = useWjGridCheckBoxSelection(gridControl);
const { selectionRowData: gridSelectionData2 } = useWjGridCheckBoxSelection(gridControl2);

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})  

const showPopup = ref(false)

const items = [
  { value: '1', text: 'item1' },
  { value: '2', text: 'item2' },
]

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
]);
</script>

<style scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}

</style>