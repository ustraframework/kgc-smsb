<template>
  <VCard>
    <template #title><h5>비활성화 처리</h5></template>

    <template #text>
      useWjContextMenu 메소드는 ContextMenu를 비활성화할 수 있는 Funciton을 stop 속성으로 반환하며 이를 이용하여 상태를 제어할 수 있다. 단 초기
      단계에서 ContextMenu를 초기화하지 않을 경우, Menu 컴포넌트는 숨김 처리가 필요하다.

      <br /><br />
      <WjFlexGrid style="height: 200px" :initialized="ctl => (gridControl = ctl)">
        <WjFlexGridColumn header="그리드 컬럼1" />
        <WjFlexGridColumn header="그리드 컬럼2" />
      </WjFlexGrid>

      <UButton text="활성화" :disabled="!isActivatedContextMenu" @click="activateContextMenu" />
      <UButton text="비활성화" :disabled="isActivatedContextMenu" @click="deactivateContextMenu" />

      <WjMenu :initialized="ctl => (menuControl = ctl)" style="display: none">
        <WjMenuItem value="add"><VIcon class="mr-2">mdi-plus</VIcon>추가</WjMenuItem>
        <WjMenuItem value="edit"><VIcon class="mr-2">mdi-refresh</VIcon>수정</WjMenuItem>
        <WjMenuItem value="remove"><VIcon class="mr-2">mdi-delete</VIcon>삭제</WjMenuItem>
        <WjMenuSeparator />
        <WjMenuItem value="close"><VIcon class="mr-2">mdi-close</VIcon>닫기</WjMenuItem>
      </WjMenu>

      <UMarkdownViewer :content="contextMenu2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { shallowRef, computed } from '#ustra/nuxt'
import { WjMenu, WjMenuItem, WjMenuSeparator, WjFlexGrid, WjFlexGridColumn, UButton } from '#ustra/nuxt-wijmo/components'
import { useWjContextMenu } from '#ustra/nuxt-wijmo/composables'
import { Menu } from '@grapecity/wijmo.input'
import { FlexGrid } from '@grapecity/wijmo.grid'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import contextMenu2 from './md/context-menu2.md'

const gridControl = shallowRef<FlexGrid>()
const menuControl = shallowRef<Menu>()
const stopContextMenu = shallowRef<Function>(null)
const isActivatedContextMenu = computed(() => !stopContextMenu.value)

function activateContextMenu() {
  stopContextMenu.value = useWjContextMenu(menuControl, gridControl, {
    minWidth: 95,
  }).stop
}

function deactivateContextMenu() {
  stopContextMenu.value()
  stopContextMenu.value = null
}
</script>
