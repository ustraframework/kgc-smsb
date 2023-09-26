<template>
  <VCard>
    <template #text>
      <br /><br />

      <h3>Dialog를 포함한 Custom Editor</h3>
      <br />
      Dialog를 포함한 에디터를 사용할 경우, 기본 동작은 그리드에서 포커스가 이동할 경우 에디팅이 끝나도록 처리되어 있다. 따라서 이런 경우 예외 처리가
      필요하며, 그리드 옵션의 editing.dialogEditingCols 속성을 지정한다. 해당 속성은 Dialog를 포함한 에디터를 가진 컬럼의 바인딩 명이나 컬럼 인덱스
      목록을 설정한다. <br /><br />
      아래의 예제를 보면 dialogEditingCols 속성을 추가한 System 컬럼은 정상적으로 데이터를 조회하여 바인딩이 가능하며, dialogEditingCols에서 포함되지
      않은 System2 컬럼의 경우 Dialog 창이 오픈되지 않는 등의 현상이 발생하는 것을 볼 수 있다.
      <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="Country" binding="country" :width="150" />

        <WjFlexGridColumn
          header="System"
          binding="system"
          :width="150"
          :isRequired="false"
          :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"
        >
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <UCodeInputBox v-model="cell.value" grpCd="SYS_CD" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn
          header="System2"
          binding="system2"
          :width="150"
          :isRequired="false"
          :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"
        >
          <WjFlexGridCellTemplate cellType="CellEdit" v-slot="cell">
            <UCodeInputBox v-model="cell.value" grpCd="SYS_CD" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>
      </WjFlexGrid>

      <br />
      <VBanner :border="true" :rounded="true" theme="dark">
        <pre>{{ JSON.stringify(data, null, 4) }}</pre>
      </VBanner>

      <UMarkdownViewer :content="doc1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { reactive } from '#ustra/nuxt'
import { useUstraCodeValue } from '#ustra/nuxt/management/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UCodeInputBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import doc1 from './md/custom2.md'

const data = reactive([])

const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    system: null,
    system2: null,
  })
}

const grid = useWijmoFlexGrid({
  editing: {
    // dialog를 오픈하는 컬럼 지정
    dialogEditingCols: ['system'],
  },
  isReadOnly: false,
})
</script>
