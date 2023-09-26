> WjFlexGrid의 columnGroups 속성을 통해서 축소/확대할 컬럼을 설정 할 수 있다
> - template 내 WjFlexGrid 의 columnGroups 속성에 Columns 설정을 반환할 메소드를 등록한다.
> - Columns 설정시 columns 값을 통해 축소할 그룹을 만들고, collapseTo 값에 축소시 표시할 바인딩 데이터를 설정한다.
```json
// 예시 바인딩 데이터 형식
[
  { id: 1, seq: 1, country: 'country_1', 
    sales: { sales: 1000, data1: 3000, data2: 4000 },
    expenses: { expenses: 2000, data3: 5000, data4: 6000 }
  },
  { id: 2, seq: 2, country: 'country_2',
    sales: { sales: 1000, data1: 3000, data2: 4000 },
    expenses: { expenses: 2000, data3: 5000, data4: 6000 }
  },
  { id: 3, seq: 3, country: 'country_3',
    sales: { sales: 1000, data1: 3000, data2: 4000 },
    expenses: { expenses: 2000, data3: 5000, data4: 6000 }
  }
]
```
```html
<template>
  복합 Object 데이터 그리드 by template
  <WjFlexGrid ref="gridMix2" :itemsSource="mixedObjectData" style="max-height: 300px">
    <WjFlexGridColumnGroup :header="'Seq'" :binding="'seq'" :width="100" />
    <WjFlexGridColumnGroup :header="'Country'" :binding="'country'" :width="150" align="center" />
    <WjFlexGridColumnGroup :header="'Sales'" :collapseTo="'sales.sales'" align="center">
      <WjFlexGridColumnGroup :header="'Sales'" :binding="'sales.sales'" format="n2" :width="100" cssClass="main-column" />
      <WjFlexGridColumnGroup :header="'Data1'" :binding="'sales.data1'" format="n2" :width="100" />
      <WjFlexGridColumnGroup :header="'Data2'" :binding="'sales.data2'" format="n2" :width="100" />
    </WjFlexGridColumnGroup>
    <WjFlexGridColumnGroup :header="'Expenses'" :collapseTo="'expenses.expenses'" align="center">
      <WjFlexGridColumnGroup :header="'Expenses'" :binding="'expenses.expenses'" :width="100" cssClass="main-column" />
      <WjFlexGridColumnGroup :header="'Data3'" :binding="'expenses.data3'" :width="100" />
      <WjFlexGridColumnGroup :header="'Data4'" :binding="'expenses.data4'" :width="100" />
    </WjFlexGridColumnGroup>
  </WjFlexGrid>
  복합 Object 데이터 그리드 by code
  <WjFlexGrid ref="gridMix" :itemsSource="mixedObjectData" style="max-height: 300px" :columnGroups="initMixedObjectDataColumns()" />
</template>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumnGroup } from '#ustra/nuxt-wijmo/components'
import { ref } from '#ustra/nuxt'

/**
 * 샘플용 Grid Data 생성
 * @param cnt Grid Row 카운트
 */
const _getMixedObjectData = (cnt: Number) => {
  // create some random data
  const data = []
  for (let i = 0; i < cnt; i++) {
    data.push({
      id: i,
      seq: i + 1,
      country: 'country_' + i,
      sales: {
        sales: Math.random() * 10000,
        data1: Math.random() * 1000,
        data2: Math.random() * 1000,
      },
      expenses: {
        expenses: Math.random() * 5000,
        data3: Math.random() * 1000,
        data4: Math.random() * 1000,
      },
    })
  }
  return data
}

/**
 * MixedObject 컬럼 구성
 */
const initMixedObjectDataColumns = () => {
  return [
    { binding: 'seq', header: 'Seq', width: 100 },
    { binding: 'country', header: 'Country', width: 150, align: 'center' },
    {
      header: 'Sales',
      align: 'center',
      // 축소시 보여줄 binding 데이터 설정
      collapseTo: 'sales.sales',
      // 축소/확대 그룹의 컬럼 설정
      columns: [
        { binding: 'sales.sales', header: 'Sales', format: 'n2', width: 100, cssClass: 'main-column' },
        { binding: 'sales.data1', header: 'Data1', format: 'n2', width: 100 },
        { binding: 'sales.data2', header: 'Data2', format: 'n2', width: 100 },
      ],
    },
    {
      header: 'Expenses',
      align: 'center',
      // 축소시 보여줄 binding 데이터 설정
      collapseTo: 'expenses.expenses',
      // 축소/확대 그룹의 컬럼 설정
      columns: [
        { binding: 'expenses.expenses', header: 'Expenses', format: 'n2', width: 80, cssClass: 'main-column' },
        { binding: 'expenses.data3', header: 'Data3', format: 'n2', width: 80 },
        { binding: 'expenses.data4', header: 'Data4', format: 'n2', width: 80 },
      ],
    },
  ]
}

/**
 * Grid 객체 ref 처리
 * <script> 내에서는 grid.value.control 로 접근
 * <template> 내에서는 grid.control 로 접근
 */
const gridMix = ref()

/**
 * 복합 Object 그리드 itemsSource 에 매핑하는 data 값
 */
const mixedObjectData = _getMixedObjectData(5)

</script>
<style>
/* highlight the main column in the group */
.wj-flexgrid .wj-cells .wj-cell.main-column {
  background: #e3f4ff;
}
</style>

```
