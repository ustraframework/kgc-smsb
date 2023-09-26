<template>
  <UBox direction="col">
    <UItem>
      <UFieldSet>
        <UFieldRow>
          <UField direction="col" required label="시스템">
            <UCodeComboBox v-model="searchBar.selectedSystemCode.value" grpCd="SYS_CD" style="width: 300px" />
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
    <UItem :ratio="1">
      <UBox direction="row" style="gap: 5px">
        <UItem :ratio="4" scrollType="hidden">
          <WjTreeView
            style="width: 100%; height: 100%"
            displayMemberPath="mnuNm"
            childItemsPath="items"
            :autoCollapse="false"
            :itemsSource="tree.menus.value"
            :loadedItems="s => tree.onLoadedItems(s)"
            :itemClicked="e => form.load(e.selectedItem.mnuId)"
            :initialized="
              e => {
                tree.treeView.value = e
                e.hostElement.addEventListener('contextmenu', e => {
                  e.preventDefault()

                  if (contextMenu.ref) {
                    contextMenu.show(e)
                  }
                })
              }
            "
          ></WjTreeView>
          <WjMenu style="display: none; min-width: 200px" :itemClicked="e => contextMenu.onClick()" :initialized="e => (contextMenu.ref = e)">
            <WjMenuItem value="newOnTop" v-if="!contextMenu.treeData.value"><VIcon class="mr-2">mdi-plus</VIcon>메뉴 추가</WjMenuItem>
            <WjMenuItem value="newOnChild" v-if="!!contextMenu.treeData.value"
              ><VIcon class="mr-2">mdi-plus</VIcon>"{{ contextMenu.treeData.value.mnuNm }}"의 하위 메뉴 추가</WjMenuItem
            >
            <WjMenuSeparator />
            <WjMenuItem value="expandAll"><VIcon class="mr-2">mdi-arrow-expand-all</VIcon>모두 펼치기</WjMenuItem>
            <WjMenuItem value="collapsedAll"><VIcon class="mr-2">mdi-arrow-collapse-all</VIcon>모두 접기</WjMenuItem>
          </WjMenu>
        </UItem>
        <UItem :ratio="6" :disabled="form.disabled.value">
          <Form
            :ref="e => (form.ref.value = e as InstanceType<typeof Form>)"
            :systemCode="searchBar.selectedSystemCode.value"
            @updated="mnuId => tree.loadMenus(mnuId)"
          />
        </UItem>
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, watch, onMounted, useOnError, provide, inject } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTreeView, WjMenu, WjMenuItem, WjMenuSeparator } from '#ustra/nuxt-wijmo/components'
import Form from './form.vue'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { useUstraMenuService, MenuTreeData, Menu } from '#ustra/nuxt/management'
import { TreeView } from '@grapecity/wijmo.nav'

const menuService = useUstraMenuService()

// 트리 영역
const tree = {
  // treeview object
  treeView: ref<TreeView>(),

  // 현재 메뉴 목록
  menus: ref<MenuTreeData[]>([]),

  // 선택된 메뉴 아이디
  selectedMnuId: null,

  // 메뉴 로드
  loadMenus(selectedMnuId?: string) {
    tree.selectedMnuId = selectedMnuId

    return useOnError(
      async function () {
        form.init()
        form.disabled.value = true

        tree.menus.value = await menuService.getMenus({ sysCd: searchBar.selectedSystemCode.value })
      },
      {
        message: '메뉴 조회 중 오류가 발생하였습니다.',
      },
    )()
  },

  // 아이디로 메뉴 정보 조회
  findMenuById(mnuId): MenuTreeData {
    if (!mnuId) {
      return
    }

    function find(menus: MenuTreeData[]) {
      if (!menus) {
        return
      }

      for (const menu of menus) {
        if (menu.mnuId === mnuId) {
          return menu
        }

        const childResult = find(menu.items)

        if (childResult) {
          return childResult
        }
      }
    }

    return find(tree.menus.value)
  },

  // 최대 정렬 순번 조회
  getMaxSrtNo(uprMnuId?: string) {
    if (!uprMnuId) {
      return Math.max(Math.max(...tree.menus.value.map(m => m.mnuSrtNo)), tree.menus.value.length + 1)
    }
    const uprInfo = $ustra.utils.model.findReclusiveItem(tree.menus.value, 'items', i => i.mnuId === uprMnuId)

    if (uprInfo) {
      uprInfo.items = uprInfo.items || []
      return Math.max(Math.max(...uprInfo.items.map(m => m.mnuSrtNo)), uprInfo.items.length + 1)
    }
  },

  // 트리 로드 완료 시
  onLoadedItems(treeObj) {
    treeObj.collapseToLevel(0)

    if (tree.selectedMnuId) {
      const selectedMenu = tree.findMenuById(tree.selectedMnuId)
      tree.selectedMnuId = null

      if (selectedMenu) {
        treeObj.selectedItem = selectedMenu

        if (treeObj.selectedItem) {
          form.load(selectedMenu.mnuId)
        }
      }
    }
  },

  /**
   * 메뉴의 경로 명 목록 조회
   */
  getPathText(mnuId) {
    const pathTexts = []

    while (true) {
      const menu = tree.findMenuById(mnuId)

      if (!menu) {
        break
      }

      pathTexts.unshift(menu.mnuNm)
      mnuId = menu.uprMnuId
    }

    return pathTexts
  },
}

// 검색 영역
const searchBar = (function () {
  // 선택 시스템 코드
  const selectedSystemCode = ref<string>(null)

  onMounted(() => {
    watch(selectedSystemCode, () => tree.loadMenus(), { immediate: true })
  })

  return { selectedSystemCode }
})()

// context menu
const contextMenu = {
  /**
   * menu ref 객체
   */
  ref: null,

  // selected tree data
  treeData: ref<MenuTreeData>(null),

  // show context menu
  show: function (e) {
    const treeDataNode = e.target['wj-Data-Item'] || e.target.parentElement['wj-Data-Item']
    contextMenu.ref.show(e)

    contextMenu.treeData.value = treeDataNode || null
  },

  // click menu button
  onClick: function () {
    switch (contextMenu.ref.selectedValue) {
      case 'newOnTop':
        form.init()
        break

      case 'newOnChild':
        form.init(contextMenu.treeData.value)
        break

      case 'expandAll':
        tree.treeView.value.collapseToLevel(100)
        break

      case 'collapsedAll':
        tree.treeView.value.collapseToLevel(0)
        break
    }
  },
}

// form
const form = {
  /**
   * form disabled 여부
   */
  disabled: ref(true),

  /**
   * form refrence
   */
  ref: ref<InstanceType<typeof Form>>(null),

  // form 초기화
  init: function (parentMenu: Menu = null) {
    form.ref.value.init(parentMenu, tree.getMaxSrtNo(parentMenu?.mnuId))
    form.disabled.value = false
  },

  // 상세 조회
  load: function (mnuId: string) {
    form.init()
    form.ref.value.detail(mnuId)
  },
}

provide('tree:getPathText', tree.getPathText)
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemMenu',
}

/**
 * 메뉴 경로 조회 function 사용
 */
export const usePathText = () => {
  return inject<(mnuId: string) => string[]>('tree:getPathText')
}
</script>
