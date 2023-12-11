<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">alert-error</h1>
        <UButton text="alert 열기" @click="() => (alertError = true)"></UButton>
      </div>
    </div>
    
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">alert-confirm</h1>
        <UButton text="alert 열기" @click="() => (alertConfirm = true)"></UButton>
      </div>
    </div>
    
    <div class="columns has-gap mb-12">
      <div class="column">
        <h1 class="mb-4">alert-delete</h1>
        <UButton text="alert 열기" @click="() => (alertDelete = true)"></UButton>
      </div>
    </div>
  </div>

  <!-- alert error -->
  <UPopup v-model="alertError" :width="354" :height="206" title="에러" class="alert-error">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-alert">
          <div class="alertText">
            잘못 입력하였습니다.
          </div>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="확인" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>

  <!-- alert confirm -->
  <UPopup v-model="alertConfirm" :width="354" :height="206" title="확인" class="alert-confirm">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-alert">
          <div class="alertText">
            요청하신 내용이 저장되었습니다.<br>목록으로 이동합니다.
          </div>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="확인" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>

  <!-- alert delete -->
  <UPopup v-model="alertDelete" :width="354" :height="206" title="경고/삭제" class="alert-delete">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-alert">
          <div class="alertText">
            해당 항목을 삭제하시겠습니까?
          </div>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="취소" type="secondary" :width="80" />
          <UButton text="삭제" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjComboBox } from '#ustra/nuxt-wijmo/components'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

const grid = useWijmoFlexGrid({
isReadOnly: false,
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

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const alertError = ref(false)
const alertConfirm = ref(false)
const alertDelete = ref(false)

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>