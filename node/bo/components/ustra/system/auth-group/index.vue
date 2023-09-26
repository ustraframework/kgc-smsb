<template>
  <UBox direction="col">
    <UItem>
      <UFieldSet>
        <UFieldRow>
          <UField direction="col" required label="시스템">
            <UCodeComboBox v-model="searchBarActions.selectedSystemCode.value" grpCd="SYS_CD" style="width: 300px" />
          </UField>
        </UFieldRow>
      </UFieldSet>
    </UItem>
    <UItem :ratio="1">
      <UBox direction="row" style="gap: 5px">
        <UItem :ratio="4">
          <WjTreeView
            style="width: 100%; height: 100%"
            displayMemberPath="authGrpNm"
            childItemsPath="items"
            :autoCollapse="false"
            :itemsSource="treeActions.items.value"
            :loadedItems="s => treeActions.onLoadedItems(s)"
            :itemClicked="e => formActions.load(e.selectedItem.authGrpId)"
            :initialized="treeActions.treeView.initialize"
          ></WjTreeView>
          <WjMenu
            style="display: none; min-width: 200px"
            :itemClicked="contextMenuActions.onItemClick"
            :initialized="e => (contextMenuActions.menu.value = e)"
          >
            <WjMenuItem value="newOnTop" v-if="!contextMenuActions.selectedContextMenuData.value"
              ><VIcon class="mr-2">mdi-plus</VIcon>권한 그룹 추가</WjMenuItem
            >
            <WjMenuItem value="newOnChild" v-if="!!contextMenuActions.selectedContextMenuData.value"
              ><VIcon class="mr-2">mdi-plus</VIcon>"{{ contextMenuActions.selectedContextMenuData.value.authGrpNm }}"의 하위 그룹 추가</WjMenuItem
            >
            <WjMenuSeparator />
            <WjMenuItem value="expandAll"><VIcon class="mr-2">mdi-arrow-expand-all</VIcon>모두 펼치기</WjMenuItem>
            <WjMenuItem value="collapsedAll"><VIcon class="mr-2">mdi-arrow-collapse-all</VIcon>모두 접기</WjMenuItem>
          </WjMenu>
        </UItem>
        <UItem :ratio="6" :disabled="formActions.disabled.value">
          <Form
            :ref="e => {
              if (e) {
                formActions.component.value = e as InstanceType<typeof Form>
              }
            }"
            :systemCode="searchBarActions.selectedSystemCode.value"
            @updated="authGrpId => treeActions.loadAuthGroups(authGrpId)"
          />
        </UItem>
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, watch, onMounted, useOnError, provide, inject, shallowRef } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTreeView, WjMenu, WjMenuItem, WjMenuSeparator } from '#ustra/nuxt-wijmo/components'
import { useExposed } from '#ustra/nuxt/composables'
import { useWjContextMenu, useWijmoTreeView } from '#ustra/nuxt-wijmo/composables'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { useUstraAuthGroupService, AuthGroup, AuthGroupTreeData } from '#ustra/nuxt/management'
import { Menu as WjMenuControl } from '@grapecity/wijmo.input'
import Form from './form.vue'

const authGroupService = useUstraAuthGroupService()

// 트리 영역
const treeActions = (function () {
  // tree view object
  const treeView = useWijmoTreeView()

  // 현재 권한 목록
  const items = ref<AuthGroupTreeData[]>([])

  // 선택된 권한 그룹 아이디
  let selectedAuthGrpId: number = null

  // 권한 그룹 로드
  function loadAuthGroups(authGrpId?: number) {
    selectedAuthGrpId = authGrpId

    return useOnError(
      async function () {
        formActions.init()
        formActions.disabled.value = true

        items.value = await authGroupService.getAuthGroups({ sysCd: searchBarActions.selectedSystemCode.value })
      },
      {
        message: '권한 그룹 조회 중 오류가 발생하였습니다.',
      },
    )()
  }

  // 아이디로 권한 그룹 정보 조회
  function findAuthGroupById(authGrpId): AuthGroupTreeData {
    if (!authGrpId) {
      return
    }

    function find(authGroups: AuthGroupTreeData[]) {
      if (!authGroups) {
        return
      }

      for (const group of authGroups) {
        if (group.authGrpId === authGrpId) {
          return group
        }

        const childResult = find(group.items)

        if (childResult) {
          return childResult
        }
      }
    }

    return find(items.value)
  }

  // 최대 정렬 순번 조회
  function getMaxSrtNo(uprGrpId?: number) {
    if (!uprGrpId) {
      return Math.max(Math.max(...items.value.map(m => m.srtNo)), items.value.length + 1)
    } else {
      const uprGrpInfo = $ustra.utils.model.findReclusiveItem(items.value, 'items', i => i.authGrpId === uprGrpId)

      if (uprGrpInfo) {
        uprGrpInfo.items = uprGrpInfo.items || []
        return Math.max(Math.max(...uprGrpInfo.items.map(m => m.srtNo)), uprGrpInfo.items.length + 1)
      }
    }
  }

  // 트리 로드 완료 시
  function onLoadedItems(treeObj) {
    treeObj.collapseToLevel(0)

    if (selectedAuthGrpId) {
      const selected = findAuthGroupById(selectedAuthGrpId)
      selectedAuthGrpId = null

      if (selected) {
        treeObj.selectedItem = selected

        if (treeObj.selectedItem) {
          formActions.load(selected.authGrpId)
        }
      }
    }
  }

  /**
   * 메뉴의 경로 명 목록 조회
   */
  function getPathText(mnuId) {
    const pathTexts = []

    while (true) {
      const menu = findAuthGroupById(mnuId)

      if (!menu) {
        break
      }

      pathTexts.unshift(menu.mnuNm)
      mnuId = menu.uprMnuId
    }

    return pathTexts
  }

  return { treeView, items, loadAuthGroups, findAuthGroupById, getMaxSrtNo, getPathText, onLoadedItems }
})()

// 검색 영역
const searchBarActions = (function () {
  // 선택 시스템 코드
  const selectedSystemCode = ref<string>(null)

  onMounted(() => {
    watch(selectedSystemCode, () => treeActions.loadAuthGroups(), { immediate: true })
  })

  return { selectedSystemCode }
})()

// context menu
const contextMenuActions = (function () {
  // wijmo menu control
  const menu = shallowRef<WjMenuControl>()
  // context tree data
  const selectedContextMenuData = ref<AuthGroupTreeData>(null)

  // init context menu
  useWjContextMenu(menu, treeActions.treeView.control, {
    onBeforeShow(e) {
      // @ts-ignore
      const treeDataNode = e.originEvent.target['wj-Data-Item'] || e.originEvent.target.parentElement['wj-Data-Item']
      selectedContextMenuData.value = treeDataNode ? treeDataNode : null
    },
  })

  function onItemClick() {
    switch (menu.value.selectedValue) {
      case 'newOnTop':
        formActions.init()
        break

      case 'newOnChild':
        formActions.init(selectedContextMenuData.value)
        break

      case 'expandAll':
        treeActions.treeView.expandAll()
        break

      case 'collapsedAll':
        treeActions.treeView.collapseAll()
        break
    }
  }

  return {
    menu,
    onItemClick,
    selectedContextMenuData,
  }
})()

// form
const formActions = (function () {
  /**
   * form disabled 여부
   */
  const disabled = ref(true)

  /**
   * form component
   */
  const component = ref<InstanceType<typeof Form>>()

  // form 초기화
  function init(parentGroup: AuthGroup = null) {
    disabled.value = false

    if (component.value.init) {
      component.value.init(parentGroup, treeActions.getMaxSrtNo(parentGroup?.authGrpId))
    }
  }

  /**
   * 상세 조회
   * @param authGrpId 권한 그룹 아이디
   */
  async function load(authGrpId: number) {
    init()

    const comp = await $ustra.utils.core.getObjectAsync(() => component.value)
    useExposed(comp).detail(authGrpId)
  }

  return { disabled, component, init, load }
})()

provide('tree:getPathText', treeActions.getPathText)
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthGroup',
}

/**
 * 경로 조회 function 사용
 */
export const usePathText = () => {
  return inject<(authGrpId: number) => string[]>('tree:getPathText')
}
</script>
