<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Grid</h1>
        <WjFlexGrid :itemsSource="itemsSourceGrid" style="height: 240px">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="지급일자" binding="col1" width="*" />
          <WjFlexGridColumn header="지급방법" binding="col1" width="*" />
          <WjFlexGridColumn header="지급사유" binding="col1" width="*" />
        </WjFlexGrid>

        <h1 class="mt-10 mb-4">Grid Pagination</h1>
        <WjFlexGrid style="height: 256px" :initialized="grid.initialize">
          <WjFlexGridColumn header="No" binding="col1" width="*" />
          <WjFlexGridColumn header="지급일자" binding="col1" width="*" />
          <WjFlexGridColumn header="지급방법" binding="col1" width="*" />
          <WjFlexGridColumn header="지급사유" binding="col1" width="*" />
        </WjFlexGrid>

        <UPaginationBar
          v-model="grid.pagination.currentPageNo.value"
          :pageSize="grid.pagination.pageSize.value"
          :totalRecords="grid.pagination.totalRecords.value"
        />
      </div>

      <!-- search input -->
      <div class="column is-half">
        <h1 class="mb-4"></h1>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4"></h1>
      </div>
    </div>

  </div>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate } from '#ustra/nuxt-wijmo/components';

import { WjComboBox } from '#ustra/nuxt-wijmo/components'

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
});

const grid = useWijmoFlexGrid({
  pagination: {
    modelValue: 1,
    totalRecords: 100,
    pageSize: 20,
  },
})

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

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>