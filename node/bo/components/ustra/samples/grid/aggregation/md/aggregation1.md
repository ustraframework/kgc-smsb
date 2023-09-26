
> 다음 단계를 통해서 columnFooters 에 합계 GroupRow 를 표시할 수 있다.
> - WjFlexGridColumn 의 aggregate 속성을 통한 표시 형식 설정
> - grid 컨트롤 로드 시, columnFooters 에 wjcGrid 모듈의 GroupRow 를 추가


Wijmo Grid에서 제공하는 집계 함수는 다음과 같으며, aggregate 속성에 넣을 수 있다. (https://www.grapecity.com/wijmo/api/enums/wijmo.aggregate.html)
- Avg : 평균 값
- Cnt : 데이터 수량 (Null 값 제외)
- CntAll : 데이터 수량 (Null 값 포함)
- First : Null 값이 아닌 첫번째 항목
- Last : Null 값이 아닌 마지막 항목
- Max : 최대 값
- Min : 최소 값
- None : 집계 하지 않음 (기본 값)
- Rng : 최대 값과 최소 값의 차
- Std : 표준 편차 (n-1 기준)
- StdPop : 표준 편차 (n 기준)
- Sum : 합계
- Var : 표본 분산 (n-1 기준)
- VarPop : 표본 분산 (n 기준)

```html
  <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
    <!-- 하단 Group Row에 포함될 컬럼의 속성 추가 aggregate="Sum" -->
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data1'" :binding="'data1'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data2'" :binding="'data2'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data3'" :binding="'data3'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data4'" :binding="'data4'" width="*" format="n2" aggregate="Sum" />
  </WjFlexGrid>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import * as wjcGrid from '@grapecity/wijmo.grid'
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
</script>
```
