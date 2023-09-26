useWjContextMenu 메소드를 사용하여 context 메뉴를 표시할 수 있다. useWjContextMenu는 다음과 같은 파라메터를 수신한다.
- menuControl : Context 메뉴 컴포넌트 (WjMenu 컴포넌트)
- targetControl : 대상 컴포넌트 (HTML 컴포넌트 또는 Wijmo 컴포넌트)
- option : 옵션 (object)
  - onBeforeShow : event 객체를 수신하여 context 메뉴 오픈 전 처리 작업을 수행한다. cancel 프로퍼티를 true로 설정하면 context 메뉴 오픈을 취소한다.

아래의 코드는 메뉴를 3번 클릭하면 cacel 속성을 true로 설정하여 메뉴가 오픈되지 않도록 처리한다.

메뉴의 클릭 이벤트는 "itemClicked" 속성을 통해 수신할 수 있으며, Menu 컨트롤의 selectedValue 속성을 통해 현재 클릭된 메뉴정보를 확인할 수 있다.
```html
<template>
  <WjFlexGrid style="height: 200px" :initialized="ctl => (gridControl = ctl)">
    <WjFlexGridColumn header="그리드 컬럼1" />
    <WjFlexGridColumn header="그리드 컬럼2" />
  </WjFlexGrid>

  <WjMenu :initialized="ctl => (menuControl = ctl)" :itemClicked="clickItem">
    <WjMenuItem value="add"><VIcon class="mr-2">mdi-plus</VIcon>추가</WjMenuItem>
    <WjMenuItem value="edit"><VIcon class="mr-2">mdi-refresh</VIcon>수정</WjMenuItem>
    <WjMenuItem value="remove"><VIcon class="mr-2">mdi-delete</VIcon>삭제</WjMenuItem>
    <WjMenuSeparator />
    <WjMenuItem value="close"><VIcon class="mr-2">mdi-close</VIcon>닫기</WjMenuItem>
  </WjMenu>
</template>
<script lang="ts" setup>
import { WjMenu, WjMenuItem, WjMenuSeparator, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { Menu } from '@grapecity/wijmo.input'
import { FlexGrid } from '@grapecity/wijmo.grid'

const gridControl = shallowRef<FlexGrid>()
const menuControl = shallowRef<Menu>()

const clickCount = ref(0)
useWjContextMenu(menuControl, gridControl, {
  // 메뉴의 최소 넓이 지정
  minWidth: 95,

  // open 전처리 핸들러
  onBeforeShow(e) {
    clickCount.value++

    if (clickCount.value % 3 === 0) {
      e.cancel = true
      alert('context menu가 열리지 않습니다.')
    }
  },
})

function clickItem() {
  alert(`선택 value 값 : ${menuControl.value.selectedValue}`)
}
</script>
```
