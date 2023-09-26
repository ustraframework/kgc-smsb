mode 설정은 WjFlexGrid의 selectionMode 옵션을 설정할 수 있다. (https://www.grapecity.com/wijmo/api/enums/wijmo_grid.selectionmode.html)
- Cell : 단일 Cell을 선택
- CellRange : Cell 범위를 선택
- ListBox : Row를 부분 멀티 선택할 수 있다. 선택은 Ctrl 마우스 클릭을 통해 할 수 있다.
- MultiRange : Multi Cell의 범위를 선택
- None : 선택 없음
- Row : 단일 Row 선택 (기본 값)
- RowRange : Multi Row의 범위를 선택


SelectionMode는 enum으로 정의되어 있으므로 옵션 설정 시 다음과 같이 SelectionMode 객체를 import 하여 사용한다.

```typescript
import { SelectionMode } from '@grapecity/wijmo.grid'

const grid = useWijmoFlexGrid({
  selection: {
    mode: SelectionMode.Row
  },
})
```
selectionChanged 속성에 핸들러를 추가하여 selection이 변경될 경우에 데이터를 수신받을 수 있다.
selectionChanged는 선택된 데이터 정보가 수신되며 mode 설정이 Row, Cell일 경우는 단일 값이 그 외는 Array 형태로 데이터를 수신한다.
데이터의 유형은 useWijmoFlexGrid 메소드를 사용할 때 첫번째 Type 값으로 지정하여 지정된 Type 값으로 데이터를 수신 가능하다.

```html
<template>
<URadioGroupBox
  :itemsSource="[
    { value: SelectionMode.None, text: 'None' },
    { value: SelectionMode.Cell, text: 'Cell' },
    { value: SelectionMode.Row, text: 'Row' },
    { value: SelectionMode.CellRange, text: 'CellRange' },
    { value: SelectionMode.ListBox, text: 'ListBox' },
    { value: SelectionMode.MultiRange, text: 'MultiRange' },
    { value: SelectionMode.RowRange, text: 'RowRange' },
  ]"
  v-model="grid.option.selection.mode"
/>

<WjFlexGrid style="height: 300px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
  <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
  <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
  <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
</WjFlexGrid>
</template>
<script lang="ts" setup>
interface Country {
  id: number
  country: string
  sales: number
  expenses: number
}

const grid = useWijmoFlexGrid<Country>({
  selection: {
    selectionChanged: selectionData => {
      console.log('selectionData', selectionData)
    },
  },
})
</script>
```

grid.selectionData 속성으로 event 방식으로 선택 데이터를 수신받는 방법 외에도 Reactive selection 데이터를 변수로 사용할 수 있다.
```html
<v-chip class="ma-2" color="pink" label text-color="white">
  <v-icon start icon="mdi-label"></v-icon>
  selectionData : {{ grid.selectionData }}
</v-chip>
```

