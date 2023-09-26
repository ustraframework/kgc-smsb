<template>
  <VCard>
    <template #text>
      페이징 등으로 분할된 그리드는 클라이언트에 데이터가 모두 존재하지 않거나 많은 용량의 데이터를 클라이언트로 한 번에 바인딩하기 쉽지 않으므로 API
      상에서 엑셀 파일을 생성하여 다운로드 하는 형태를 사용해야 한다.

      <div class="mt-4">
        <UButton type="primary" text="Search" @click="() => grid.pagination.loadPageData()"></UButton>
        <UButton text="Export Excel" @click="exportExcel" v-if="grid.pagination.currentPageNo.value > 0"></UButton>
        <UButton text="Export Excel with Provider" @click="exportExcelWithProvider" v-if="grid.pagination.currentPageNo.value > 0"></UButton>
        <WjFlexGrid style="height: 200px" class="mt-1" :initialized="grid.initialize">
          <WjFlexGridColumn header="메뉴아이디" binding="mnuId" />
          <WjFlexGridColumn header="시스템" binding="sysCd" align="center" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)" />
          <WjFlexGridColumn header="메뉴명" binding="mnuNm" />
          <WjFlexGridColumn header="정렬번호" binding="mnuSrtNo" />
          <WjFlexGridColumn header="메뉴URL" binding="mnuUrl" />
          <WjFlexGridColumn header="메뉴유형" binding="mnuTyCd" align="center" :cellTemplate="ctx => useUstraCodeValue('MNU_TY_CD', ctx.value)" />
          <WjFlexGridColumn header="사용여부" binding="useYn" align="center" :cellTemplate="ctx => (ctx.value === 'Y' ? '사용' : '미사용')" />
        </WjFlexGrid>

        <UPaginationBar
          v-model="grid.pagination.currentPageNo.value"
          :pageSize="grid.pagination.pageSize.value"
          :totalRecords="grid.pagination.totalRecords.value"
        />
      </div>

      <WjTabPanel class="mt-4">
        <WjTab>
          <a>export1.vue</a>
          <UMarkdownViewer :content="export0" style="height: 500px" />
        </WjTab>
        <WjTab>
          <a>UstraExcelCreationController.java</a>
          <MonacoEditor v-model="sourceCode1" lang="java" :options="{ theme: 'vs-dark' }" style="height: 500px" />
        </WjTab>
        <WjTab>
          <a>UstraExcelCreationModel.java</a>
          <MonacoEditor v-model="sourceCode2" lang="java" :options="{ theme: 'vs-dark' }" style="height: 500px" />
        </WjTab>
        <WjTab>
          <a>UstraExcelCreationMapper.java</a>
          <MonacoEditor v-model="sourceCode3" lang="java" :options="{ theme: 'vs-dark' }" style="height: 500px" />
        </WjTab>
        <WjTab>
          <a>UstraExcelCreationMapper.xml</a>
          <MonacoEditor v-model="sourceCode4" lang="xml" :options="{ theme: 'vs-dark' }" style="height: 500px" />
        </WjTab>
      </WjTabPanel>

      <UMarkdownViewer :content="export1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { useFetch } from '#app'
import { WjFlexGridColumn, WjFlexGrid, UPaginationBar, UButton, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useUstraCodeValue } from '#ustra/nuxt/management'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import export1 from './md/export1.md'

// @ts-ignore
import export0 from './md/export0.md'

const grid = useWijmoFlexGrid({
  pagination: {
    mode: 'normal',
    pageSize: 10,
    async handler(currentPage, pageSize, orders) {
      const result = (
        await $ustra.api.call({
          url: '/api/ustra/sample/excel/creation/list',
          method: 'POST',
          data: {
            header: {
              currentPage,
              pageSize,
              orders,
            },
            sysCd: null,
          },
        })
      )?.data

      return {
        data: result.body,
        totalRecords: result.header.totalRecords,
      }
    },
  },
})

function exportExcel() {
  $ustra.api.downloadFile({
    fileName: 'export4.xlsx',
    url: '/api/ustra/sample/excel/creation/download',
    method: 'POST',
    data: {
      cellInfos: grid.export.createExcelCellInfo(),
      criteria: {
        sysCd: null,
      },
    },
  })
}

function exportExcelWithProvider() {
  $ustra.api.downloadFile({
    fileName: 'export5.xlsx',
    url: '/api/ustra/sample/excel/creation/provider/download',
    method: 'POST',
    data: {
      cellInfos: grid.export.createExcelCellInfo(),
      criteria: {
        sysCd: null,
      },
    },
  })
}

const sourceCode1 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelCreationController.java')
const sourceCode2 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelCreationModel.java')
const sourceCode3 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelCreationMapper.java')
const sourceCode4 = await $ustra.fetch.readText('/ustra-sample-resources/excel/source-code/UstraExcelCreationMapper.xml')
</script>
