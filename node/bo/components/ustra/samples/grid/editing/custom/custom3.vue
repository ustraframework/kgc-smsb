<template>
  <VCard>
    <template #text>
      <br /><br />

      <h3>Inline Editing</h3>
      <br />
      WjFlexGridCellTemplate의 cellType을 Cell로 설정하여 기본적으로 에디터를 노출되게 할 수 있다. 이 방법은 에디터를 바로 노출하여 편집을 쉽게 할 수
      있도록 하나 그리드 성능의 제약이 있으므로 많은 데이터를 한번에 조회하지 않는 경우에만 사용해야 한다. <br /><br />

      또한 주의할 것은 CellEdit 속성으로 에디팅 모드에서 입력되는 경우와 달리 v-model에 바인딩되는 cell.value가 아닌 cell.item 속성을 사용해야 한다.
      또한 다른 컬럼에서 업데이트 되는 컬럼 데이터를 표시하고 있다면 업데이트 시에 grid의 invalidate 메소드를 실행하여 변경된 그리드의 데이터를
      갱신하여야 한다. <br /><br />

      인라인 에디터를 사용할 때, 추적을 위해서는 useWijmoFlexGrid의 editing.useInlineEditTracking 속성을 사용한다. 해당 속성을 사용하면 선택 영역이
      변경될 때, 자동으로 commit이 이루어지므로 데이터의 변경사항을 추적할 수 있다. 따라서 수정된 데이터를 조회할 경우는 selection.clear() 메소드를
      먼저 호출해야 한다.

      <br /><br />
      <UButton
        text="수정된 데이터 조회"
        @click="
          () => {
            grid.selection.clear()
            $ustra.logger.info(grid.collectionView.itemsEdited)
          }
        "
      />
      <UButton text="데이터로드" @click="() => loadData()" />

      <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
        <WjFlexGridColumn header="Country" binding="country" width="*" />

        <WjFlexGridColumn header="System" binding="system" width="*" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)">
          <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
            <UCodeInputBox v-model="cell.item.system" grpCd="SYS_CD" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n0">
          <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
            <WjInputNumber v-model="cell.item.expenses" :step="1" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n0">
          <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
            <WjInputNumber v-model="cell.item.sales" :step="1" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd">
          <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
            <WjInputDate v-model="cell.item.date" @update:modelValue="() => $nextTick(() => grid.rawControl.invalidate())" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>

        <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd"> </WjFlexGridColumn>
        <WjFlexGridColumn binding="desc" header="Description" :width="200">
          <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
            <UTextBox v-model="cell.item.desc" />
          </WjFlexGridCellTemplate>
        </WjFlexGridColumn>
      </WjFlexGrid>

      <br />
      <VBanner :border="true" :rounded="true" theme="dark">
        <pre>{{ JSON.stringify(data, null, 4) }}</pre>
      </VBanner>

      <UMarkdownViewer :content="doc3" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref, onMounted } from '#ustra/nuxt'
import { useUstraCodeValue } from '#ustra/nuxt/management/composables'
import { useWijmo } from '#ustra/nuxt-wijmo/composables'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate, WjInputNumber, UButton, UTextBox } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { UCodeInputBox } from '#ustra/nuxt-wijmo/management/components'

// @ts-ignore
import doc3 from './md/custom3.md'

const data = ref([])

function loadData() {
  const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
  const rows = []
  for (let i = 0; i < countries.length; i++) {
    rows.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      date: useWijmo().DateTime.addDays(new Date(), -Math.random() * 360),
      system: 'BO',
      desc: '',
    })
  }

  data.value = rows
}
onMounted(() => loadData())

const grid = useWijmoFlexGrid({
  isReadOnly: true,
  autoSelection: false,
  editing: {
    useInlineEditTracking: true,
  },
})
</script>
