> 다음 2가지 방법을 통해서 틀 고정을 구현할 수 있다.
> - template 내 WjFlexGrid 의 frozenColumns, frozenRows 속성을 통한 초기 설정
> - grid 컨트롤의 frozenColumns, frozenRows 설정을 통한 동적 설정

```html
  <div>
    <UButton @click="() => (grid.control.frozenColumns = 2)" text="컬럼 틀고정"></UButton>
    <UButton @click="() => (grid.control.frozenRows = 2)" text="로우 틀고정"></UButton>
    <UButton
      @click="
        () => {
          grid.control.frozenColumns = grid.control.selection.col
          grid.control.frozenRows = grid.control.selection.row
        }
      "
      text="선택 컬럼 기준 틀고정"
    ></UButton>
    <br />
    <br />
    <UButton
      text="틀고정 해제"
      @click="
        () => {
          grid.control.frozenColumns = 0
          grid.control.frozenRows = 0
        }
      "
    >
    </UButton>
    <br />
    <br />
  </div>
  <!-- WjFlexGrid 속성을 통한 틀고정 초기 설정  :frozenColumns="1" :frozenRows="1" -->
  <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px; max-width: 800px" :frozenColumns="1" :frozenRows="1">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" :width="150" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" :width="150" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" :width="150" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data1'" :binding="'data1'" :width="150" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data2'" :binding="'data2'" :width="150" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data3'" :binding="'data3'" :width="150" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data4'" :binding="'data4'" :width="150" format="n2" aggregate="Sum" />
  </WjFlexGrid>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '@grapecity/wijmo.vue2.grid'
import * as wjcGrid from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { ref, onMounted } from 'vue'

/**
 * Grid 객체 ref 처리
 * <script> 내에서는 grid.value.control 로 접근
 * <template> 내에서는 grid.control 로 접근
 */
const grid = ref()

/**
 * 마운트시 total 항목 추가
 */
onMounted(() => {
  grid.value.control.columnFooters.rows.push(new wjcGrid.GroupRow())
})

/**
 * 샘플용 Grid Data 생성
 * @param cnt Grid Row 카운트
 */
const _getData = (cnt: Number) => {
  // create some random data
  const countries = 'US,Germany,UK,Japan,Italy,Greece,Korea'.split(',')
  const data = []

  for (let i = 0; i < cnt; i++) {
    data.push({
      id: i,
      country: 'country_' + i,
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      data1: Math.random() * 1000,
      data2: Math.random() * 1000,
      data3: Math.random() * 1000,
      data4: Math.random() * 1000,
    })
  }

  return data
}
/**
 * grid itemsSource 에 매핑하는 data 값
 */
const data = _getData(100)

// 코드 기반의 Freezing 처리
/**
 * Grid 선택된 컬럼 기준 Freezing 처리
 */
const setFreezing = () => {
  grid.value.control.frozenColumns = grid.value.control.selection.col
  grid.value.control.frozenRows = grid.value.control.selection.row
}

/**
 * Grid Freezing 해제
 */
const releaseFreezing = () => {
  grid.value.control.frozenColumns = 0
  grid.value.control.frozenRows = 0
}
</script>
```
