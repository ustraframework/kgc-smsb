WjFlexGridCellTemplate과 URadioGroupBox 컴포넌트를 사용하여 Radio Button 기반의 Selection 을 구현할 수 있다. 단, URadioGroupBox는 name은 동일한 값으로 설정하고 id는 row 마다 다른 값을 설정해야 하므로 name과 id 속성을 상황에 맞게 세팅해야 한다.

```html
<template>
  <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" :initialized="grid.initialize">
    <WjFlexGridColumn :width="30">
      <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
        <URadioGroupBox
          name="checkRadio"
          :id="`checkRadio-${cell.row.index}`"
          v-model="selectedIndex"
          :itemsSource="[{ value: cell.row.index, text: ' ' }]"
          itemAlign="center"
        />
      </WjFlexGridCellTemplate>
    </WjFlexGridColumn>
    <WjFlexGridColumn header="이름" binding="name" :width="100" />
    <WjFlexGridColumn header="주소" binding="address" width="*" />
  </WjFlexGrid>

  <v-chip class="ma-2" color="pink" label text-color="white">
    <v-icon start icon="mdi-label"></v-icon>
    selectedIndex : {{ selectedIndex }}
  </v-chip>
</template>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate } from '#ustra/nuxt-wijmo/components'
import { SelectionMode } from '@grapecity/wijmo.grid'


const grid = useWijmoFlexGrid({
  selection: {
    mode: SelectionMode.None,
  },
})

const selectedIndex = ref(-1)

const gridData = reactive([
  {
    selected: null,
    name: '홍길동',
    address: '서울시 강남구 양재동',
  },
  {
    selected: null,
    name: '강감찬',
    address: '서울 서초구 양재동',
  },
  {
    selected: null,
    name: '유관순',
    address: '서울시 중구 종로동',
  },
])
</script>
```
