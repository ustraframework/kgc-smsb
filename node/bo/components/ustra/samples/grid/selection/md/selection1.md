useWjGridSelectionData 메소드를 사용하여 선택된 데이터를 동적으로 조회하는 변수를 받을 수 있다. useWjGridSelectionData 메소드의 2번째 인자 값은 데이터를 단일 값으로 받을지 여부이며, true로 세팅할 경우, Selection이 미존재할 경우는 null로 리턴되고 그 외는 단일 select 데이터 값이 조회된다.
```html
<template>
  <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" selectionMode="Row" :initialized="e => (gridControl = e)">
    <WjFlexGridColumn header="이름" binding="name" :width="100" />
    <WjFlexGridColumn header="주소" binding="address" width="*" />
  </WjFlexGrid>

  <br />
  <UButton text="Clear Selection" @click="() => gridControl.select(-1, -1)" />
</template>

<script lang="ts" setup>
import { FlexGrid } from '@grapecity/wijmo.grid'

const gridControl = shallowRef<FlexGrid>()
const gridSelectionData = useWjGridSelectionData<GrdData>(gridControl, true)

type GrdData = {
  name: string
  address: string
}
const gridData: GrdData[] = reactive([
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
