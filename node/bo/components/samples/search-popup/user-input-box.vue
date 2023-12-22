<template>
  <div style="display:flex">
  <UTextBox
    ref="textBox"
    v-model="textBoxValue"
    type="icon"
    :readonly="!!selectedUser"
    @keyup.enter.stop="
      () => {
        showPopup = true
        nextTick(() => userPopup.inputAndSearch(textBoxValue))
      }
    "
    width="200"
  >
    <!-- <UTextBoxButtonBox align="left" class="mr-2">
      <VIcon class="ml-2">mdi-account-circle</VIcon>
    </UTextBoxButtonBox> -->
    <UTextBoxButtonBox align="right">
      <UTextBoxButton
        icon="mdi-close-circle"
        @click="
          () => {
            textBox.control.focus()
            selectedUser = null
          }
        "
        v-if="!!selectedUser"
      />
      <!-- <UTextBoxButton icon="mdi-magnify" @click="showPopup = true" /> -->
      <UTextBoxButton icon="mdi-magnify" @click="() => {
        showPopup = true
        nextTick(() => userPopup.inputAndSearch(textBoxValue))
      }" />
    </UTextBoxButtonBox>
    <UserPopup
      ref="userPopup"
      v-model="showPopup"
      :multiple="false"
      :usrSttCd="props.usrSttCd"
      title="사용자 조회"
      @selected="(user) =>
        {
            selectedUser = {
              code: (user as User).usrId,
              name: (user as User).usrNm,
            }
        }
      "
    ></UserPopup>
  </UTextBox>
  <UTextBox :readonly="!!selectedUser" width="200" v-model="textBoxName"></UTextBox>
  </div>
</template>
<script lang="ts" setup>
import { ref, defineProps, withDefaults, watch, nextTick, defineOptions } from '#ustra/nuxt'
// import { User, useUstraUserService, UsrSttCd } from '#ustra/nuxt/management'
import { User } from '~/models/user'
import { UsrSttCd } from '~/models/common-code'
import { useUstraUserService } from '~/services/user'
import { UTextBox, UTextBoxButtonBox, UTextBoxButton } from '#ustra/nuxt-wijmo/components'
// import { UUserPopup } from '#ustra/nuxt-wijmo/management/components'
import UserPopup from './user-popup.vue'
import { baseModels } from '#ustra/core/data'
import { useVModel } from '@vueuse/core'

defineOptions({
  // name: 'UUserInputBox',
  name: 'UserSearchInputBox',
  inheritAttrs: false,
})

const userService = useUstraUserService()

const props = withDefaults(
  defineProps<{
    modelValue: { code?: string; name?: string } | string | null
    objectValue?: baseModels.CodeNameModel | null

    /**
     * 사용자 상태 코드
     */
    usrSttCd?: UsrSttCd
  }>(),
  {
    usrSttCd: null,
  },
)

// model
const model = useVModel(props, 'modelValue')
const objectModel = useVModel(props, 'objectValue')

// 내부 선택 사용자 값
const selectedUser = ref<baseModels.CodeNameModel>(null)

// text box
const textBox = ref<InstanceType<typeof UTextBox>>()
const textBoxValue = ref<string>('')
const textBoxName = ref<string>('')


// 팝업 관련
const showPopup = ref(false)
const userPopup = ref<InstanceType<typeof UserPopup>>()

// 내부 코드 값 변경 시 처리
watch(selectedUser, v => {
  // textBoxValue.value = !v ? '' : `${v.code}: ${v.name}`
  textBoxValue.value = !v ? '' : `${v.code}`
  textBoxName.value = !v ? '' : `${v.name}`
  model.value = !v ? null : v.code
  objectModel.value = v
})

// model 변경 시 처리
watch(
  model,
  async (v, ov) => {
    if (!v) {
      selectedUser.value = null
    } else if (typeof v === 'string') {
      if (selectedUser.value?.code === v) {
        return
      }

      // get user info
      const user = await userService.getUser(v, false)

      if (!user) {
        $ustra.logger.warn(`Cannot found user : ${v}`)
        selectedUser.value = null
      } else {
        selectedUser.value = {
          code: user.usrId,
          name: user.usrNm,
        }
      }
    } else {
      const user = v as baseModels.CodeNameModel
      if (selectedUser.value && selectedUser.value.code === v.code) {
        model.value = selectedUser.value.code
        return
      }

      selectedUser.value = v
    }
  },
  {
    immediate: true,
  },
)
</script>
<script lang="ts">
export default {
  // name: 'UUserInputBox',
  name: 'UserSearchInputBox',
  inheritAttrs: false,
}
</script>
