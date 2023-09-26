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

          <UButtonBox right top>
            <UButton text="검색" type="primary" :width="80" @click="() => listActions.load()" />
            <UButton text="신규" :width="80" @click="() => formActions.init(true)" />
          </UButtonBox>
        </UFieldRow>
      </UFieldSet>
    </UItem>
    <UItem :ratio="1">
      <UBox direction="row">
        <UItem :ratio="6" scrollType="hidden">
          <WjFlexGrid :isReadOnly="true" style="height: 100%" :itemsSource="listActions.users.value" :initialized="listActions.grid.initialize">
            <!-- <WjFlexGridColumn header="소속 그룹" binding="authGrp" /> -->
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

        <UItem :ratio="4">
          <UBox direction="col">
            <UItem :ratio="1" scrollType="auto">
              <UValidationGroup
                :ref="ctl => {
                formActions.validationGroup.value = ctl as InstanceType<typeof UValidationGroup>
              }"
              >
                <UFieldSet>
                  <UFieldRow>
                    <UField label="아이디" required>
                      <WjInputMask
                        v-model="formActions.inputData.usrId"
                        :isDisabled="!formActions.isNew.value"
                        :validation="{
                          rules: [{ type: 'custom', handler: formActions.validateId, delay: 200 }],
                        }"
                      />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="사번">
                      <WjInputMask :isRequired="false" v-model="formActions.inputData.empNo" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="이름" required>
                      <WjInputMask v-model="formActions.inputData.usrNm" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="부서명">
                      <WjInputMask :isRequired="false" v-model="formActions.inputData.deptNm" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="회사명">
                      <UCodeComboBox :isRequired="false" v-model="formActions.inputData.orgCd" grpCd="ORG_CD" displayNullText="없음." />
                    </UField>
                  </UFieldRow>

                  <UFieldRow :ratio="formActions.isNew.value || formActions.inputData.pwdResetYn === 'Y' ? [2, 1] : [1]">
                    <UField label="비밀번호" required v-if="formActions.isNew.value || formActions.inputData.pwdResetYn === 'Y'">
                      <WjInputMask :isReadOnly="true" :isRequired="false" v-model="formActions.inputData.pwd" />
                    </UField>
                    <UField :blank="formActions.isNew.value || formActions.inputData.pwdResetYn === 'Y'" label="비밀번호">
                      <UButtonBox :right="formActions.isNew.value || formActions.inputData.pwdResetYn === 'Y'">
                        <UButton
                          text="초기화"
                          @click="
                            () => {
                              formActions.inputData.pwd = $ustra.utils.system.uuidBase62().substring(0, 8)
                              formActions.inputData.pwdResetYn = 'Y'
                            }
                          "
                        />
                      </UButtonBox>
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="구분" required>
                      <UCodeComboBox v-model="formActions.inputData.useDvCd" grpCd="USE_DV_CD" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow v-if="authActions.canUpdateAuthWhenEditUser">
                    <UField label="권한그룹">
                      <WjMultiSelect
                        :itemsSource="authActions.selectableAuthGroups.value"
                        displayMemberPath="authGrpFullNm"
                        selectedValuePath="authGrpId"
                        :maxHeaderItems="100"
                        :isAnimated="true"
                        :isRequired="false"
                      />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="상태" required>
                      <UCodeComboBox v-model="formActions.inputData.usrSttCd" grpCd="USR_STT_CD" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="이메일" required>
                      <WjInputMask v-model="formActions.inputData.email" :validation="{ rules: ['email'] }" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="전화번호">
                      <UPhoneNoBox v-model="formActions.inputData.phNo" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="핸드폰번호">
                      <UPhoneNoBox v-model="formActions.inputData.cphNo" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="팩스번호">
                      <UPhoneNoBox v-model="formActions.inputData.faxNo" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="사용기간">
                      <UDatePeriodBox v-model:start="formActions.inputData.useSrtDt" v-model:end="formActions.inputData.useEndDt" />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="아이피 제한">
                      <UCheckGroupBox
                        itemAlign="left"
                        :items-source="[{ trueValue: 'Y', falseValue: 'N', text: 'IP 접근 제한' }]"
                        v-model="formActions.inputData.ipLmtYn"
                      >
                      </UCheckGroupBox>
                      <UIpAddressListBox
                        v-model="formActions.inputData.ipInputList"
                        :isRequired="true"
                        v-if="formActions.inputData.ipLmtYn === 'Y'"
                      />
                    </UField>
                  </UFieldRow>

                  <UFieldRow>
                    <UField label="비고">
                      <UTextBox type="textarea" v-model="formActions.inputData.rmk"> </UTextBox>
                    </UField>
                  </UFieldRow>
                </UFieldSet>
              </UValidationGroup>
            </UItem>
            <UItem>
              <UButtonBox right top>
                <UButton
                  text="저장"
                  type="primary"
                  :width="80"
                  @click="() => formActions.save()"
                  v-if="formActions.isNew.value || (!formActions.isNew.value && authActions.hasApprovalStatus.value)"
                />
                <UButton
                  text="삭제"
                  :width="80"
                  v-if="!formActions.isNew.value && authActions.hasApprovalStatus.value"
                  @click="() => formActions.remove()"
                />

                <ApprovalPopup
                  v-model="approvalActions.opened.value"
                  :ref="popup => {
                    approvalActions.popup.value = popup as InstanceType<typeof ApprovalPopup>
                  }"
                ></ApprovalPopup>
              </UButtonBox>
            </UItem>
          </UBox>
        </UItem>
      </UBox>
    </UItem>
  </UBox>
</template>

<script lang="ts" setup>
import { reactive, ref, shallowRef, onBeforeMount, useDeepMerge, useOnError, computed, watch } from '#ustra/nuxt'
import {
  UBox,
  UItem,
  WjInputMask,
  UIpAddressListBox,
  WjMultiSelect,
  UFieldSet,
  UFieldRow,
  UField,
  WjFlexGrid,
  WjFlexGridColumn,
  UDatePeriodBox,
  UCheckGroupBox,
  UTextBox,
  UPhoneNoBox,
  UValidationGroup,
} from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import {
  useUstraCodeValue,
  useUstraUserService,
  useUstraUserDeptName,
  useUstraAuthGroupService,
  useUstraUserApprovalService,
  useUstraLoginService,
  useUstraAuthService,
} from '#ustra/nuxt/management'
import { UCodeComboBox } from '#ustra/nuxt-wijmo/management/components'
import { UserCriteria, User, AuthGroup, UserApproval, useUstraManagementUser } from '#ustra/nuxt/management'
import ApprovalPopup from '../../common/approval-popup.vue'
import toNumber from 'lodash/toNumber'

const userService = useUstraUserService()
const authGroupService = useUstraAuthGroupService()
const userApprovalService = useUstraUserApprovalService()
const loginService = useUstraLoginService()
const authService = useUstraAuthService()

// 검색 관련 기능
const searchActions = (() => {
  const criteria: UserCriteria = reactive({
    usrNm: null,
    usrSttCd: null,
  })

  return { criteria }
})()

// 사용자 목록 기능
const listActions = (() => {
  /**
   * 조회 사용자 목록
   */
  const users = ref<User[]>([])

  /**
   * 사용자 검색
   */
  async function load() {
    users.value = await userService.getUsers(searchActions.criteria)
  }

  /**
   * grid control
   */
  const grid = useWijmoFlexGrid<User>()

  watch(grid.selectionData, v => {
    v ? formActions.load((v as User).usrId) : formActions.init()
  })

  /**
   * 추가 시 처리
   * @param usrId 사용자 아이디
   */
  async function whenAdded(usrId: string) {
    const user = await userService.getUser(usrId)
    if (user) {
      users.value.unshift(user)
      grid.control.value.collectionView.refresh()
      grid.control.value.select(0, 0)
    }
  }

  /**
   * 업데이트 시 처리
   * @param usrId
   */
  async function whenUpdated(usrId: string) {
    const user = await userService.getUser(usrId)
    const selectedRow = grid.control.value.selectedRows[0]
    if (user && selectedRow) {
      selectedRow.dataItem = $ustra.utils.core.deepMerge(selectedRow.dataItem, user)
      grid.control.value.collectionView.refresh()
      grid.control.value.select(selectedRow.index, 0)
    }
  }

  /**
   * 삭제 시 처리
   */
  async function whenRemoved() {
    const selectedRow = grid.control.value.selectedRows[0]

    if (selectedRow) {
      grid.control.value.collectionView.items.splice(selectedRow.index, 1)
      grid.control.value.collectionView.refresh()
    }
  }

  return { users, load, selectionData: grid.selectionData, grid, whenAdded, whenUpdated, whenRemoved }
})()

// form 기능
const formActions = (() => {
  /**
   * 입력 데이터
   */
  let inputData: User = reactive({})

  /**
   * 신규 여부
   */
  const isNew = ref(false)

  // validation group control
  const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()

  /**
   * 아이디 검증
   * @param value
   */
  async function validateId(value) {
    if (!value || !isNew.value) {
      return true
    }

    const result = await loginService.validId(value)
    if (!result.valid) {
      return result.invalidMessage
    }

    const user = await userService.getUser(value)
    if (user) {
      return '이미 사용 중인 아이디입니다.'
    }
    return true
  }

  /**
   * 폼 초기화
   */
  async function init(updatePassword = false) {
    isNew.value = true
    authActions.hasApprovalStatus.value = false

    useDeepMerge(inputData, {
      usrId: null,
      usrNm: null,
      pwd: null,
      email: null,
      phNo: null,
      cphNo: null,
      faxNo: null,
      usrSttCd: '01',
      useSrtDt: null,
      useEndDt: null,
      useDvCd: '20',
      rmk: null,
      empNo: null,
      loginFailCnt: 0,
      pwdResetYn: 'Y',
      orgCd: null,
      ipLmtYn: 'N',
      ipList: null,
      apvCmplYn: 'N',
      deptNm: null,
      deptCd: null,
      ipInputList: computed({
        get() {
          if (!inputData.ipList) {
            return []
          }

          return (inputData.ipList || '').split(',')
        },
        set(v: string[]) {
          inputData.ipList = v.join(',')
        },
      }),
    })

    if (updatePassword) {
      // 초기 패스워드 조회
      inputData.pwd = $ustra.utils.system.uuidBase62().substring(0, 8)
    }

    validationGroup.value && (await validationGroup.value.init())
  }

  /**
   * 사용자 정보 조회
   * @param usrId
   */
  async function load(usrId: string) {
    await init()

    const user = await userService.getUser(usrId)
    await authActions.loadUserAuthorityGroups(usrId)
    await authActions.loadHasApprovalStatus(usrId)
    isNew.value = false
    user.pwdResetYn = 'N'
    useDeepMerge(inputData, user)

    validationGroup.value && (await validationGroup.value.init())
  }

  /**
   * 저장
   */
  function save() {
    return useOnError(
      async () => {
        const validationResult = await validationGroup.value.validate()
        if (!validationResult.isValid) {
          return
        }

        const saveData = useDeepMerge({}, inputData)
        if (isNew.value) {
          saveData.apvCmplYn = 'Y'
          const result = await userService.add(saveData)

          // 승인 필요
          if (result.resultCode === 'FM11') {
            await approvalActions.openPopupForAdd(saveData)
          } else {
            listActions.whenAdded(inputData.usrId)
            init(true)
          }
        } else {
          if (!authActions.hasApprovalStatus.value) {
            alert('저장 권한이 없습니다.')
          }

          await userService.edit(saveData)
          listActions.whenUpdated(inputData.usrId)
        }
      },
      {
        message: '저장 중 오류가 발생하였습니다.',
      },
    )()
  }

  async function remove() {
    if (await confirm('삭제 후 사용자는 시스템을 사용할 수 없으며, 모든 권한은 제거됩니다.\n삭제하시겠습니까?')) {
      await userService.remove(inputData.usrId)
      listActions.whenRemoved()
      await init()
    }
  }

  onBeforeMount(() => init())

  return { inputData, init, validationGroup, save, isNew, validateId, load, remove }
})()

// form 권한 관련 처리
const authActions = await (async () => {
  /**
   * 사용자 상태 값 변경 가능 여부
   */
  const hasApprovalStatus = ref(false)

  // 사용자 정보 수정 시, 권한 정보 업데이트 가능 여부
  const canUpdateAuthWhenEditUser = $ustra.management.serverAppProps.canUpdateAuthWhenEditUser

  // 신규로 배정 가능한 권한 그룹 목록
  const newAuthorityGroups: AuthGroup[] = reactive(
    canUpdateAuthWhenEditUser ? await authGroupService.getRequestableGroupsOfUser($ustra.management.currentSystemCode, null) : [],
  )

  // 사용자 배정 가능한 권한 그룹 목록
  const userAuthorityGroups = ref<AuthGroup[]>([])

  /**
   * 사용자 배정 가능한 권한 그룹 목록 조회
   * @param usrId 사용자 아이디
   */
  async function loadUserAuthorityGroups(usrId: string) {
    if (!canUpdateAuthWhenEditUser) {
      return
    }

    userAuthorityGroups.value = await authGroupService.getRequestableGroupsOfUser($ustra.management.currentSystemCode, usrId)
  }

  /**
   * 사용자 상태 변경 가능 여부 확인
   */
  async function loadHasApprovalStatus(usrId: string) {
    hasApprovalStatus.value = await authService.hasApprovalAuth(useUstraManagementUser().sub, usrId, '06')
  }

  /**
   * 사용자가 선택 가능한 권한 그룹 목록
   */
  const selectableAuthGroups = computed(() => {
    return formActions.isNew.value ? newAuthorityGroups : userAuthorityGroups.value
  })

  return { canUpdateAuthWhenEditUser, newAuthorityGroups, loadUserAuthorityGroups, selectableAuthGroups, hasApprovalStatus, loadHasApprovalStatus }
})()

// 승인 관련 처리
const approvalActions = (() => {
  /**
   * 팝업 오픈 여부
   */
  const opened = ref(false)

  // 팝업 객체
  const popup = shallowRef<InstanceType<typeof ApprovalPopup>>()

  /**
   * 팝업 오픈 (사용자 추가 시)
   */
  async function openPopupForAdd(user: User) {
    if (!(await confirm('승인 후 사용자 등록이 가능합니다. \n승인 요청을 진행하시겠습니까?'))) {
      return
    }
    const popupResult = await popup.value.open()

    if (!popupResult.applied) {
      return
    }

    // 승인 요청 시에는 권한 추가하지 않음.
    user.authGrps = null
    const approvalData: UserApproval = {
      reqUsrId: useUstraManagementUser().sub,
      usrApvTyCd: '05',
      apvReqOpnCont: popupResult.text,
      usrSttApproval: {
        usrId: user.sub,
        usrSttCd: user.usrSttCd,
      },
      authorityGrpApprovalList: user.authGrps.map(authGrpId => {
        return {
          authGrpId: toNumber(authGrpId),
          users: [{ usrId: user.usrId }],
        }
      }),
      usr: user,
    }
    await userApprovalService.request(approvalData)
  }

  return { opened, popup, openPopupForAdd }
})()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemUser',
}
</script>
