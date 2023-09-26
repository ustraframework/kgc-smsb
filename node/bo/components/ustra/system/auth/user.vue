<template>
  <UBox>
    <UItem>
      <UFieldSet>
        <UFieldRow>
          <UField label="사용자 아이디/명" :totalWidth="300">
            <WjInputMask v-model="searchActions.criteria.usrNm" />
          </UField>

          <UField label="상태" :totalWidth="300">
            <UCodeComboBox grpCd="USR_STT_CD" v-model="searchActions.criteria.usrSttCd" displayNullText="전체" />
          </UField>

          <UField blank>
            <UCheckGroupBox
              v-model="searchActions.criteria.authGrpNoneYn"
              :itemsSource="[{ text: '소속 그룹 없는 사용자', trueValue: 'Y', falseValue: 'N' }]"
            />
          </UField>

          <UButtonBox right top>
            <UButton text="검색" type="primary" :width="80" @click="() => listActions.load()" />
          </UButtonBox>
        </UFieldRow>
      </UFieldSet>
    </UItem>
    <UItem>
      <UBox direction="row" style="gap: 5px">
        <UItem :ratio="4">
          <WjFlexGrid :isReadOnly="true" style="height: 600px" :itemsSource="listActions.users.value" :initialized="listActions.grid.initialize">
            <WjFlexGridColumn header="소속 그룹" binding="authGrp" :width="150" />
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
            <WjFlexGridColumn
              header="승인완료"
              binding="apvCmplYn"
              :cellTemplate="ctx => (ctx.value === 'Y' ? '완료' : '미완료')"
              align="center"
              :width="80"
            />
            <WjFlexGridColumn
              header="등록일"
              binding="regDttm"
              :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)"
              align="center"
              :width="180"
            />
          </WjFlexGrid>
        </UItem>
        <UItem :ratio="6" :disabled="isDisabled">
          <Form :sysCd="props.systemCode" ref="form" />
        </UItem>
      </UBox>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref, reactive, inject, defineProps, watch } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjInputMask, UCheckGroupBox, WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid } from '#ustra/nuxt-wijmo'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UserCriteria, User, useUstraCodeValue, useUstraUserDeptName, useUstraUserService } from '#ustra/nuxt/management'
import Form from './form.vue'

const userService = useUstraUserService()
const form = ref<InstanceType<typeof Form>>()
const isDisabled = ref(true)

const props = defineProps<{
  /**
   * 시스템 코드
   */
  systemCode: string
}>()

const searchActions = (() => {
  const criteria: UserCriteria = reactive({
    usrNm: null,
    usrSttCd: null,
    authGrpNoneYn: 'Y',
    showAuthNoneGrp: true,
  })

  return { criteria }
})()

const listActions = (() => {
  const grid = useWijmoFlexGrid<User>({
    selection: {
      mode: wijmoGrid.SelectionMode.Row,
    },
  })
  const users = ref<User[]>([])

  async function load() {
    users.value = (await userService.getUsers(searchActions.criteria)).filter(user => user.apvCmplYn === 'Y')
  }

  watch(grid.selectionData, data => {
    if (!data) {
      form.value.init()
    } else {
      form.value.loadOfUser((data as User).usrId)
    }
    isDisabled.value = !data
  })

  return { grid, load, users }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthGrp',
}

/**
 * 경로 조회 function 사용
 */
export const usePathText = () => {
  return inject<(authGrpId: number) => string[]>('tree:getPathText')
}
</script>
