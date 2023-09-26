useWjGridCheckBoxSelection 메소드를 사용하여 CheckBox Selection을 선택할 수 있다. 주의해야 할 점은 <u>Grid 객체가 Reference화 되면 CheckBox Selection이 오작동하므로 gridControl 객체를 저장하는 변수는 shallowRef로 선언해야 한다.</u>
- 참고 : https://www.grapecity.com/wijmo/demos/Grid/Selection/CheckboxSelection/vue


useWjGridCheckBoxSelection 메소드는 grid control을 인자 값으로 받으며 다음과 같은 프로퍼티를 리턴한다.
- selector : Selector 객체
- selectionRows : 선택된 Row 목록
- selectionRowData : 선택된 Row의 데이터 목록

```html
<template>
  <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" :initialized="e => (gridControl = markRaw(e))">
    <WjFlexGridColumn header="이름" binding="name" :width="100" />
    <WjFlexGridColumn header="주소" binding="address" width="*" />
  </WjFlexGrid>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    gridSelectionData : {{ gridSelectionData }}
  </v-chip>
</template>

<script lang="ts" setup>
import { FlexGrid } from '@grapecity/wijmo.grid'

const gridControl = shallowRef<FlexGrid>()
const { selectionRowData: gridSelectionData } = useWjGridCheckBoxSelection(gridControl)

const gridData = useCollectionView([
  {
    name: '홍길동',
    address: '서울시 강남구 양재동',
  },
  {
    name: '강감찬',
    address: '서울 서초구 양재동',
  },
  {
    name: '유관순',
    address: '서울시 중구 종로동',
  },
])
</script>
```
