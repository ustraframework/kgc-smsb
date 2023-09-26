<template>
  <UPopup
    v-model="modelValue"
    title="비밀번호 변경"
    :width="600"
    :height="500"
    @shown="() => init()"
    @hidden="
      () => {
        if (completedCallback) {
          completedCallback(false)
        }
        emits('hidden')
      }
    "
  >
    <UBox direction="col">
      <UItem :ratio="1" style="overflow: auto">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UMessage class="mt-4 mb-4">
                <template #default>
                  <span v-html="passwordGuide"></span>
                </template>
              </UMessage>
            </UFieldRow>
            <UFieldRow>
              <UField label="아이디"> <WjInputMask :isReadOnly="true" :isRequired="false" :modelValue="user.sub" /></UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="현재 비밀번호" required>
                <WjInputMask
                  type="password"
                  ref="currentPasswordInput"
                  v-model="userInput.currentPassword"
                  :isRequired="true"
                  :initialized="e => $nextTick().then(e.focus())"
              /></UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="신규 비밀번호" required>
                <WjInputMask
                  type="password"
                  v-model="userInput.newPassword"
                  :isRequired="true"
                  :validation="{
                    rules: [{ type: 'custom', handler: validateNewPassword, delay: 200 }],
                  }"
              /></UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="비밀번호 확인" required>
                <WjInputMask
                  type="password"
                  v-model="userInput.passwordConfirm"
                  :isRequired="false"
                  :validation="{
                    rules: [
                      () => {
                        if (!userInput.passwordConfirm) {
                          return '비밀번호를 입력하십시오.'
                        }

                        if (userInput.passwordConfirm !== userInput.newPassword) {
                          return '비밀번호가 일치하지 않습니다.'
                        }
                        return true
                      },
                    ],
                  }"
              /></UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
      <UItem>
        <UButtonBox right top>
          <UButton text="변경" type="primary" :width="80" @click="save" v-if="!!user.sub" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>
<script lang="ts" setup>
import { computed, defineProps, reactive, ref, shallowRef, defineExpose, defineEmits } from '#ustra/nuxt'
import { UPopup, UMessage, UBox, UItem, UValidationGroup, UField, UFieldRow, UFieldSet, WjInputMask } from '#ustra/nuxt-wijmo/components'
import { useUstraLoginService } from '#ustra/nuxt/management'
import { useUstraManagementUser } from '#ustra/nuxt/management/composables'
import { useAsyncTask, useOnError } from '#ustra/nuxt/composables'
import { useVModel } from '@vueuse/core'

const service = useUstraLoginService()

const props = defineProps<{
  modelValue: boolean
}>()

const emits = defineEmits<{
  /**
   * 재 로그인 처리
   */
  (e: 'requiredLogin'): void

  /**
   * window hidden 시
   */
  (e: 'hidden'): void

  /**
   * update value
   */
  (e: 'update:modelValue', value: boolean): void
}>()

// ref control
const currentPasswordInput = ref()
const validationGroup = shallowRef<InstanceType<typeof UValidationGroup>>()

// input box values
const user = computed(() => useUstraManagementUser())
const userInput = reactive({
  currentPassword: null,
  newPassword: null,
  passwordConfirm: null,
})
const modelValue = useVModel(props, 'modelValue', emits)

// password text
const passwordGuide = computed(() => {
  return $ustra.env.appProps.nuxt.management.security.password.creationPolicyHtmlText
})

// 초기화
function init() {
  userInput.currentPassword = null
  userInput.newPassword = null
  userInput.passwordConfirm = null
}

async function validateNewPassword() {
  const currentPasswordValidationResult = await currentPasswordInput.value.validate()

  if (currentPasswordValidationResult !== true) {
    return
  }

  if (!userInput.newPassword) {
    return '비밀번호를 입력해주세요.'
  }

  const passwordValidResult = await service.validPassword(userInput.newPassword, userInput.currentPassword, user.value.sub)
  if (passwordValidResult.valid) {
    return true
  }

  return passwordValidResult.invalidMessage
}

async function save() {
  await useOnError(async () => {
    if (!user.value.sub) {
      await alert('유효하지 않은 요청입니다.')
      modelValue.value = false
      return
    }

    const result = await validationGroup.value.validate()
    if (!result.isValid) {
      return
    }

    if (await confirm('비밀번호를 변경하시겠습니까?')) {
      await service.updatePassword(user.value.sub, userInput.currentPassword, userInput.newPassword)
      alert('비밀번호 변경이 완료되었습니다.\n변경된 비밀번호로 로그인해주시기 바랍니다.')
      modelValue.value = false
      emits('requiredLogin')

      if (completedCallback.value) {
        completedCallback.value(true)
      }
    }
  })()
}

const { completedCallback, startTask: startOpenAndWaitTask } = useAsyncTask<boolean>()

/**
 * 패스워드 변경 창 오픈 후, 완료 시까지 대기
 */
function openAndWait() {
  return startOpenAndWaitTask(() => {
    modelValue.value = true
  })
}

defineExpose({ openAndWait })
</script>
<script lang="ts">
export default {
  name: 'UstraManagementPasswordEditPopup',
}
</script>
