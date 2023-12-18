<template>
  <div id="login-box">
    <div class="inner">
      <img src="@ustra/nuxt-wijmo/src/management/resources/img/gsitm.png" style="margin-bottom: 5px" />
      <div class="top-text">{{ appTitle }}</div>
      <div class="login-form">
        <UValidationGroup ref="validationGroup">
          <WjInputMask
            v-model="inputData.userId"
            v-focus
            placeholder="ID"
            @keyup.enter="() => passwordInput.control.focus()"
            autocomplete="off"
            style="width: 100%"
          ></WjInputMask>
          <WjInputMask
            ref="passwordInput"
            type="password"
            v-model="inputData.password"
            placeholder="Password"
            class="mt-1"
            autocomplete="off"
            style="width: 100%"
            @keyup.enter="() => login()"
          ></WjInputMask>

          <div class="remember-id-check-box">
            <UCheckGroupBox :items-source="[{ text: '아이디 기억하기' }]" v-model="rememberId"> </UCheckGroupBox>
          </div>

          <div>
            <VBtn class="mt-2" color="success" style="width: 100%" @click="() => login()" theme="dark">Login</VBtn>
          </div>
        </UValidationGroup>
        <!-- <dx-validation-group ref="validator">

          <v-btn :height="30" width="100%">Login</v-btn>
        </dx-validation-group> -->
        <!-- <div class="password-link"><a @click="showPasswordEditPopup = true">Change Password</a></div> -->
      </div>
      <div class="bottom-text">{{ footerText }}</div>
    </div>
    <!-- <approval-popup ref="approvalPopup" /> -->
    <UstraManagementPasswordEditPopup ref="passwordEditPopup" v-model="showPasswordEditPopup" @hidden="() => init()" />
  </div>
</template>

<script lang="ts" setup>
import { ref, useOnError, onBeforeMount } from '#ustra/nuxt'
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'
import { useUstraManagementLoginPage } from '#ustra/nuxt/management/composables'
import { WjInputMask, UCheckGroupBox } from '#ustra/nuxt-wijmo/components'
import UstraManagementPasswordEditPopup from '#ustra/nuxt-wijmo/management/pages/common/password-edit-popup.vue'

const { inputData, doLogin, appTitle, footerText, init, getRememberId } = useUstraManagementLoginPage(true)

// ref control
const passwordInput = ref<InstanceType<typeof WjInputMask>>()
const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
const passwordEditPopup = ref<InstanceType<typeof UstraManagementPasswordEditPopup>>()
// const router = useRouter()

// checkbox value
const rememberId = ref(false)
onBeforeMount(() => {
  if (getRememberId()) {
    rememberId.value = true
  }
})

const showPasswordEditPopup = ref(false)

async function login() {
  const validationResult = await validationGroup.value.validate()

  if (!validationResult.isValid) {
    return
  }

  await useOnError(
    () =>
      doLogin({
        id: inputData.userId,
        password: inputData.password,
        storeIdOnSuccess: rememberId.value,
        onRequireApproval: async (type, name, result) => {
          console.log('result', result)
          await confirm(result.actionResponse.message)
        },
        onRequirePasswordChange: async (optional, result) => {
          if (optional) {
            const confirmResult = await confirm(result.actionResponse.message)

            if (confirmResult) {
              await passwordEditPopup.value.openAndWait()
              return
            }
            return true
          } else {
            await alert(result.actionResponse.message)
            await passwordEditPopup.value.openAndWait()
            return false
          }

          return false
        },
        onLoginSuccess: nextUrl => {
          // FIXME: nuxt3.8.1 NuxtLayout 관련 오류 사항으로 임시 수정
          console.log('process.dev', process.dev)
          console.log('nextUrl', nextUrl)
          // if (process.dev) {
          //   // nextTick(() => router.push(nextUrl))
          //   nextTick(() => navigateTo(nextUrl))
          // } else {
            window.location.href = nextUrl
          // }
        },
      }),
    {
      message: '로그인 처리 중 오류가 발생하였습니다.',
    },
  )()
}

const definePageMeta = (arg: any) => {}
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})
</script>

<style lang="scss" scoped>
#login-box {
  position: absolute;
  height: 100%;
  width: 100%;
  background-size: cover;
  background-image: url(@ustra/nuxt-wijmo/src/management/resources/img/login-background.jpg);
  background-position: center;
  display: flex;
  flex-direction: column;
  overflow: hidden;

  & .login-form {
    width: 256px;
    flex-direction: column;
    flex-shrink: 0;
    display: flex;
    overflow: hidden;
    background-color: rgba(18, 61, 64, 0.5);
    padding: 24px;
    justify-content: flex-start;
    align-items: stretch;

    & .remember-id-check-box :deep(.group_btn_list) {
      background: none;
    }

    & .remember-id-check-box :deep(.group_btn_list label) {
      color: #fff;
    }
  }

  & .bottom-text {
    margin-top: 10px;
    color: #fff;
    font-size: 13px;
  }

  & .top-text {
    color: #fff;
    margin-bottom: 20px;
    font-size: 20px;
  }

  & .password-link {
    text-align: center;
    & > a {
      color: #fff;
      text-decoration: underline;
      cursor: pointer;
      margin: auto;
      background: none;
    }
  }
}

#login-box .inner {
  background-color: rgba(0, 0, 0, 0.25);
  justify-content: center;
  align-items: center;
  flex-direction: column;
  display: flex;
  position: relative;
  overflow: hidden;
  flex: 1;
}
</style>
