<template>
  <div class="login__wrap">
    <div class="login">
      <div class="login__main">
          <img src="@/assets/images/svg/logo.svg" alt="U.STRA HR" class="logo"/>
          <div class="login-form">
            <UValidationGroup ref="validationGroup">
              <WjInputMask placeholder="아이디 (이메일)" class="is-login mb-3"/>
              <WjInputMask type="password" placeholder="비밀번호" class="is-login mb-8"/>

              <div class="login__bottom">
                <UButton text="로그인" type="is-filled is-large is-full" class="mb-5"/>
                <div class="columns is-between">
                  <UCheckGroupBox :items-source="[{ text: '아이디저장' }]" v-model="checked"> </UCheckGroupBox>
                  <NuxtLink to="/about">
                    비밀번호찾기
                  </NuxtLink>
                </div>
              </div>
            </UValidationGroup>
          </div>
          <div class="login__caution mt-10">
              <div class="caution-inner">   
                  <p class="caution-desc">민감정보가 포함되어 있으니,<br>
                  <strong>사용 후 반드시 로그아웃</strong>해 주시기 바랍니다.</p>
              </div>
          </div>
          <p class="description is-copyright">COPYRIGHT © 2023 GS ITM ALL RIGHT RESERVED.</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { UValidationGroup } from '#ustra/nuxt-wijmo/components';
import { WjInputMask, UCheckGroupBox } from '#ustra/nuxt-wijmo/components';

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

</script>

<style lang="scss" scoped>
.login__wrap{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f2f5f6;

  .login {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    overflow: hidden;
  }
  .login__main {
      border-radius: 13px;
      padding: 112px 220px 224px;
      width: 800px;
      height: 800px;
      text-align: center;
      box-shadow: 0 0 8px rgba(0, 0, 0, 0.08);
      background-color: #fff;
  }

  .logo{
    width: 229px;
    height: 48px;
    margin-bottom: 40px;
    display: inline-block;
  }

  a {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 15px;
    line-height: 18px;
    color: black;
  }

  .login__caution {
    min-width: 100%;
    margin: 0 0 12px;
    padding: 15px 0;
    border-radius: 4px;
    background-color: #F2F5F6;
    

    .caution-inner{
      flex: 1;
      .caution-desc{
        width: 100%;
        position: inherit;
        color: #476C97;
        font-size: 13px;
        line-height: 18px;
        padding-left: 19px;
      }
    }
  }
}
</style>