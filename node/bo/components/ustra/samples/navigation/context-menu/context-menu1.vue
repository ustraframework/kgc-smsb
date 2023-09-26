<template>
  <VCard>
    <template #title>Context Menu</template>

    <template #text>
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

      <UMarkdownViewer :content="contextMenu1" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { shallowRef, ref } from '#ustra/nuxt'
import { WjMenu, WjMenuItem, WjMenuSeparator, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWjContextMenu } from '#ustra/nuxt-wijmo/composables'
import { Menu } from '@grapecity/wijmo.input'
import { FlexGrid } from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import contextMenu1 from './md/context-menu1.md'

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
