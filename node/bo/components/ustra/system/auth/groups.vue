<template>
  <UBox direction="row" style="gap: 5px">
    <UItem :ratio="4">
      <WjTreeView
        style="width: 100%; height: 100%"
        class="pa-2"
        displayMemberPath="authGrpNm"
        childItemsPath="items"
        :autoCollapse="false"
        :itemsSource="items"
        :loadedItems="s => onLoadedItems(s)"
        :initialized="treeView.initialize"
      ></WjTreeView>
    </UItem>
    <UItem :ratio="6" :disabled="isDisabled">
      <Form :sysCd="props.systemCode" ref="form" />
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, watch, onMounted, useOnError, provide, inject, shallowRef, defineProps } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTreeView, WjMenu, WjMenuItem, WjMenuSeparator } from '#ustra/nuxt-wijmo/components'
import { useWijmoTreeView } from '#ustra/nuxt-wijmo/composables'
import { useUstraAuthGroupService, AuthGroup, AuthGroupTreeData } from '#ustra/nuxt/management'
import Form from './form.vue'

const authGroupService = useUstraAuthGroupService()
const form = ref<InstanceType<typeof Form>>()
const isDisabled = ref(true)

const props = defineProps<{
  /**
   * 시스템 코드
   */
  systemCode: string
}>()

// tree view object
const treeView = useWijmoTreeView<AuthGroupTreeData>()

// 현재 권한 목록
const items = ref<AuthGroupTreeData[]>([])

// 권한 그룹 로드
function loadAuthGroups() {
  return useOnError(
    async function () {
      items.value = await authGroupService.getAuthGroups({ sysCd: props.systemCode })
    },
    {
      message: '권한 그룹 조회 중 오류가 발생하였습니다.',
    },
  )()
}

// 트리 로드 완료 시
function onLoadedItems(treeObj) {
  treeObj.collapseToLevel(0)
}

// 시스템 코드 변경
watch(
  () => props.systemCode,
  () => loadAuthGroups(),
  {
    immediate: true,
  },
)

watch(treeView.selectedItem, v => {
  isDisabled.value = !v
  !v ? form.value.init() : form.value.loadOfGroup(v.authGrpId)
})
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthGrps',
}

/**
 * 경로 조회 function 사용
 */
export const usePathText = () => {
  return inject<(authGrpId: number) => string[]>('tree:getPathText')
}
</script>
