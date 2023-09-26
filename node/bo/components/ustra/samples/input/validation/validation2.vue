<template>
  <v-card>
    <template #title> Custom Rule </template>
    <template #subtitle>
      <UMarkdownViewer :content="validation2_1"></UMarkdownViewer>
    </template>
    <template #text>
      <UValidationGroup ref="validationGroup">
        <UFieldSet>
          <UFieldRow>
            <UField label="현재 비밀번호">
              <WjInputMask ref="currentPasswordInput" type="password" :isRequired="true" v-model="userInput.currentPassword" />
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="신규 비밀번호">
              <WjInputMask
                type="password"
                :isRequired="true"
                v-model="userInput.newPassword"
                :validation="{
                  rules: [{ type: 'custom', handler: validateNewPassword, delay: 200 }],
                }"
              />
            </UField>
          </UFieldRow>
          <UFieldRow>
            <UField label="비밀번호 확인">
              <WjInputMask
                type="password"
                :isRequired="false"
                v-model="userInput.passwordConfirm"
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
              />
            </UField>
          </UFieldRow>
        </UFieldSet>

        <UButton text="Validate" @click="() => validateForm()" />
      </UValidationGroup>

      <UMarkdownViewer :content="validation2_2"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref, reactive, defineExpose } from '#ustra/nuxt'
import { UFieldSet, UFieldRow, UField } from '#ustra/nuxt-vuetify/components'
import { UValidationGroup, WjInputMask } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { useUstraLoginService } from '#ustra/nuxt/management/composables'

// @ts-ignore
import validation2_1 from './md/validation2-1.md'
// @ts-ignore
import validation2_2 from './md/validation2-2.md'

const userInput = reactive({
  currentPassword: null,
  newPassword: null,
  passwordConfirm: null,
})
const currentPasswordInput = ref(null)
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()

async function validateNewPassword() {
  const currentPasswordValidationResult = await currentPasswordInput.value.validate()
  if (currentPasswordValidationResult !== true) {
    return
  }

  if (!userInput.newPassword) {
    return '비밀번호를 입력해주세요.'
  }

  const { validPassword } = useUstraLoginService()
  const passwordValidResult = await validPassword(userInput.newPassword, userInput.currentPassword, 'admin')
  if (passwordValidResult.valid) {
    return true
  }

  return passwordValidResult.invalidMessage
}

async function validateForm() {
  const result = await validationGroup.value.validate()
}

defineExpose({ currentPasswordInput })
</script>
