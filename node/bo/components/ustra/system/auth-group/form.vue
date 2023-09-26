<template>
  <UBox direction="col" style="padding: 5px">
    <UItem :ratio="1">
      <UValidationGroup ref="validationGroup">
        <UFieldSet>
          <UFieldRow>
            <UField label="상위 권한 그룹 명">
              <div>{{ inputData.uprAuthGrpId ? inputData.uprAuthGrpPathText : '없음.' }}</div>
            </UField>
          </UFieldRow>

          <UFieldRow v-if="!isNew">
            <UField label="그룹 아이디">{{ inputData.authGrpId }}</UField>
          </UFieldRow>

          <UFieldRow>
            <UField required label="권한그룹 명"><WjInputMask v-model="inputData.authGrpNm" :initialized="e => (authGroupNameInput = e)" /></UField>
          </UFieldRow>

          <UFieldRow>
            <UField label="권한그룹 구분 ID"><WjInputMask v-model="inputData.authGrpDvVal" :isRequired="false" /></UField>
          </UFieldRow>

          <UFieldRow>
            <UField label="설명"><UTextBox v-model="inputData.authGrpDesc" type="textarea"></UTextBox></UField>
          </UFieldRow>

          <UFieldRow>
            <UField required label="순번"><WjInputNumber v-model="inputData.srtNo" /></UField>
          </UFieldRow>

          <UFieldRow v-if="configProps.limitAuthGroupByUserType">
            <UField label="배정 가능 사용자 유형">
              <UCodeMultiComboBox grpCd="USE_DV_CD" v-model="inputData.useDvCdList" />
            </UField>
          </UFieldRow>

          <UFieldRow>
            <UField blank>
              <UCheckGroupBox :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '사용' }]" v-model="inputData.useYn"> </UCheckGroupBox>
              <UCheckGroupBox
                v-if="configProps.isPersonalInfoSystem"
                :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '개인정보 접근여부' }]"
                v-model="inputData.prvTrtYn"
              >
              </UCheckGroupBox>
              <UCheckGroupBox
                v-if="configProps.useApproval"
                :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '승인 그룹 여부' }]"
                v-model="inputData.apvGrpYn"
              >
              </UCheckGroupBox>
              <UCheckGroupBox
                v-if="configProps.useApproval"
                :items-source="[{ trueValue: 'Y', falseValue: 'N', text: '승인 필요 여부' }]"
                v-model="inputData.apvNecYn"
              >
              </UCheckGroupBox>
            </UField>
          </UFieldRow>

          <!-- 승인 필요 여부시, 승인 대상자 그룹 선정 -->

          <!-- 권한 신청 배정 가능 범위 설정 -->

          <!-- 사용자 배정 -->
          <Users v-model="inputData.users" />
        </UFieldSet>
      </UValidationGroup>
    </UItem>
    <UItem>
      <UButtonBox right top>
        <UButton text="저장" type="primary" :width="80" @click="() => save()" />
        <UButton v-if="!isNew" text="삭제" :width="80" @click="() => remove()" />
      </UButtonBox>
    </UItem>
  </UBox>
  <!--  -->
</template>
<script lang="ts" setup>
import { reactive, defineExpose, ref, useOnError, defineEmits, nextTick, defineProps, computed, useDeepMerge, shallowRef } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  UFieldSet,
  UFieldRow,
  UField,
  UTextBox,
  UValidationGroup,
  UCheckGroupBox,
  WjInputMask,
  WjInputNumber,
} from '#ustra/nuxt-wijmo/components'
import { wijmoInput } from '#ustra/nuxt-wijmo'
import { UCodeMultiComboBox } from '#ustra/nuxt-wijmo/management/components'
import { AuthGroup, useUstraAuthGroupService, useUstraAuthService, useUstraManagementUser } from '#ustra/nuxt/management'
import { usePathText } from './index.vue'
import Users from './users.vue'

const getPathText = usePathText()
const authGroupService = useUstraAuthGroupService()
const ustraAuthService = useUstraAuthService()

const inputData: AuthGroup = reactive({
  authGrpId: null,
  uprAuthGrpId: null,
  authGrpDvVal: null,
  authGrpNm: null,
  authGrpDesc: null,
  srtNo: 0,
  useYn: 'Y',
  delYn: 'N',
  prvTrtYn: 'N',
  sysCd: null,
  apvGrpYn: 'N',
  apvNecYn: null,
  authGrpStepNo: 1,
  addRolListVal: '',
  useDvCdListVal: '',
  apvAuthGrps: [],
  users: [],
  requetTargetGroups: [],
  useDvCdList: computed({
    get() {
      if (!inputData.useDvCdListVal) {
        return []
      }

      return (inputData.useDvCdListVal || '').split(',')
    },
    set(v: string[]) {
      inputData.useDvCdListVal = v.join(',')
    },
  }),
})
const isNew = ref(true)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
const authGroupNameInput = shallowRef<wijmoInput.InputMask>()

const emits = defineEmits<{
  (e: 'updated', authGrpId?: number): void
}>()

const props = defineProps<{
  /**
   * 시스템 코드
   */
  systemCode: string
}>()

/**
 * 폼 초기화
 * @param parentMenu 상위 그룹 정보
 * @param srtNo 정렬 순번
 */
async function init(parentGroup?: AuthGroup, srtNo?: number) {
  useDeepMerge(inputData, {
    authGrpId: null,
    uprAuthGrpId: parentGroup ? parentGroup.authGrpId : null,
    authGrpDvVal: null,
    authGrpNm: null,
    authGrpDesc: null,
    srtNo: srtNo || 0,
    useYn: 'Y',
    delYn: 'N',
    prvTrtYn: 'N',
    sysCd: props.systemCode,
    apvGrpYn: 'N',
    apvNecYn: this.hasApproval ? 'Y' : 'N',
    authGrpStepNo: 1,
    addRolListVal: '',
    useDvCdListVal: '',
    useDvCdList: [],
    apvAuthGrps: [],
    users: [],
    requetTargetGroups: [],
  })

  isNew.value = true

  if (parentGroup) {
    inputData.uprAuthGrpId = parentGroup.authGrpId
    inputData.uprAuthGrpPathText = getPathText(parentGroup.authGrpId).join(' > ')
    inputData.authGrpStepNo = parentGroup.authGrpStepNo + 1
  }

  validationGroup.value.init()
  await nextTick()

  if (authGroupNameInput.value) {
    authGroupNameInput.value.focus()
  }
}

/**
 * 상세 정보 조회
 * @param authGrpId 권한 그룹 아이디
 */
const detail = function (authGrpId: number) {
  useOnError(
    async () => {
      const result = await authGroupService.getAuthGroup(authGrpId)
      useDeepMerge(inputData, result)

      if (result.uprAuthGrpId) {
        inputData.uprAuthGrpPathText = getPathText(result.uprAuthGrpId).join(' > ')
      }

      isNew.value = false
    },
    {
      message: '상세 정보 조회 중 오류가 발생하였습니다.',
    },
  )()
}

const save = useOnError(async () => {
  const result = await validationGroup.value.validate()
  if (!result.isValid) {
    return
  }
  const saveData = $ustra.utils.core.deepMerge({}, inputData)
  saveData.sysCd = props.systemCode
  if (isNew.value) {
    const result = await authGroupService.add(saveData)

    if (result.resultCode === 'FM11') {
      // TODO: 승인 요청 처리
      return
    }

    emits('updated', result.body.authGrpId)
  } else {
    const result = await authGroupService.edit(saveData)

    if (result.resultCode === 'FM11') {
      // TODO: 승인 요청 처리
      return
    }

    emits('updated', result.body.authGrpId)
  }
})

const remove = useOnError(async () => {
  if (await confirm('권한 그룹을 삭제하시겠습니까?')) {
    const result = await authGroupService.remove(inputData)

    if (result.resultCode === 'FM11') {
      // TODO: 승인 요청 처리
      return
    }
    emits('updated', inputData.uprAuthGrpId)
  }
})

const configProps = await (async () => {
  /**
   * 승인 유형
   */
  const approvalType = $ustra.management.serverAppProps.authApprovalType

  /**
   * 승인 사용 여부
   */
  const useApproval = approvalType != 'NONE'

  /**
   * 커스톰 권한 승인 지정일 경우, 승인 그룹을 권한 그룹별로 별도 지정
   */
  const isSelectApvAuthGrp = computed(() => {
    return approvalType === 'CUSTOM_BY_GROUP' && inputData.apvNecYn === 'Y'
  })

  /**
   * 개인 정보 시스템 여부
   */
  const isPersonalInfoSystem = $ustra.management.serverAppProps.isPersonalInfoSystem

  /**
   * 사용자 구분 제한 여부
   */
  const limitAuthGroupByUserType = $ustra.management.serverAppProps.limitAuthGroupByUserType

  /**
   * 사용자 신청 가능 권한 그룹 사용 여부
   */
  const useUserRequestableAuthGroup = $ustra.management.serverAppProps.useUserRequestableAuthGroup

  /**
   * 권한 그룹을 승인할 수 있는 권한 보유 여부
   */
  const hasAuthApproval = await ustraAuthService.hasApprovalAuth(useUstraManagementUser().sub, null, '07')

  return {
    approvalType,
    useApproval,
    isSelectApvAuthGrp,
    isPersonalInfoSystem,
    limitAuthGroupByUserType,
    useUserRequestableAuthGroup,
    hasAuthApproval,
  }
})()

defineExpose({ init, detail })
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthGroupForm',
}
</script>
