<template>
  <UFieldSet label="소속 사용자" class="mt-2">
    <UFieldRow v-if="canAssignUserInAuthorityGroup">
      <UButtonBar>
        <UButtonBox right>
          <UButton icon="mdi-folder-plus" @click="showUserPopup = true"></UButton>
          <UButton icon="mdi-folder-minus" :disabled="grid.checkSelection.rows.value.length < 1" @click="grid.checkSelection.removeRows()"></UButton>
        </UButtonBox>
      </UButtonBar>
    </UFieldRow>
    <UFieldRow>
      <WjFlexGrid style="height: 200px" :initialized="grid.initialize" :itemsSource="modelValue">
        <WjFlexGridColumn header="아이디" binding="usrId" />
        <WjFlexGridColumn header="이름" binding="usrNm" />
        <WjFlexGridColumn header="회사명" binding="orgCd" :cellTemplate="ctx => useUstraCodeValue('ORG_CD', ctx.value)" />
        <WjFlexGridColumn header="부서명" binding="deptCd" :cellTemplate="ctx => useUstraUserDeptName(ctx.item)" />
        <WjFlexGridColumn
          header="상태"
          binding="usrSttCd"
          :cellTemplate="ctx => useUstraCodeValue('USR_STT_CD', ctx.value)"
          align="center"
          :width="80"
        />
        <WjFlexGridColumn
          header="구분"
          binding="useDvCd"
          :cellTemplate="ctx => useUstraCodeValue('USE_DV_CD', ctx.value)"
          align="center"
          :width="120"
        />
      </WjFlexGrid>
    </UFieldRow>

    <UUserPopup v-model="showUserPopup" :multiple="true" @selected="addUsers" />
  </UFieldSet>
</template>
<script lang="ts" setup>
import { ref, defineProps, watch, computed } from '#ustra/nuxt'
import { UFieldSet, UFieldRow, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { useUstraCodeValue, useUstraUserDeptName, User } from '#ustra/nuxt/management'
import { UUserPopup } from '#ustra/nuxt-wijmo/management/components'
import { useVModel } from '@vueuse/core'

const props = defineProps<{
  modelValue: User[]
}>()

const modelValue = useVModel(props, 'modelValue')
watch(
  props.modelValue,
  () => {
    grid.collectionView?.refresh()
  },
  { deep: true },
)

const grid = useWijmoFlexGrid({
  selection: {
    mode: 'Check',
  },
})

// 사용자 배정 기능 사용 여부
const canAssignUserInAuthorityGroup = computed(() => $ustra.management.serverAppProps.canAssignUserInAuthorityGroup)

const showUserPopup = ref(false)

function addUsers(users: User[]) {
  const targetUsers = users.filter(user => {
    return !modelValue.value.some(ou => ou.usrId === user.usrId)
  })
  modelValue.value.push(...targetUsers)
  grid.collectionView?.refresh()
}
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthGroupUsers',
}
</script>
