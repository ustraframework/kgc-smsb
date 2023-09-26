```html
<template>
  <WjFlexGrid style="height: 200px" :initialized="ctl => (gridControl = ctl)">
    <WjFlexGridColumn header="그리드 컬럼1" />
    <WjFlexGridColumn header="그리드 컬럼2" />
  </WjFlexGrid>

  <UButton text="활성화" :disabled="!isActivatedContextMenu" @click="activateContextMenu" />
  <UButton text="비활성화" :disabled="isActivatedContextMenu" @click="deactivateContextMenu" />

  <WjMenu
    :initialized="
      ctl => {
        menuControl = ctl
        menuControl.listBox.hostElement.style.minWidth = '95px'
      }
    "
    style="display: none"
  >
    <WjMenuItem value="add"><VIcon class="mr-2">mdi-plus</VIcon>추가</WjMenuItem>
    <WjMenuItem value="edit"><VIcon class="mr-2">mdi-refresh</VIcon>수정</WjMenuItem>
    <WjMenuItem value="remove"><VIcon class="mr-2">mdi-delete</VIcon>삭제</WjMenuItem>
    <WjMenuSeparator />
    <WjMenuItem value="close"><VIcon class="mr-2">mdi-close</VIcon>닫기</WjMenuItem>
  </WjMenu>
</template>
<script lang="ts" setup>
const gridControl = shallowRef<FlexGrid>()
const menuControl = shallowRef<Menu>()
const stopContextMenu = shallowRef<Function>(null)
const isActivatedContextMenu = computed(() => !stopContextMenu.value)

function activateContextMenu() {
  stopContextMenu.value = useWjContextMenu(menuControl, gridControl).stop
}

function deactivateContextMenu() {
  stopContextMenu.value()
  stopContextMenu.value = null
}
</script>
```
