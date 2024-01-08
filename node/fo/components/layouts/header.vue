<template>
  <header class="header flex-none w-full bg-transparent h-[100px] px-[120px]">
    <div class="flex justify-between min-w-[1280px] h-full">
      <router-link class="mt-[37px]" to="/">
        <img src="@/assets/images/svg/logo.svg" alt="JUNG KWAN JANG Members" />
      </router-link>

      <nav class="gnb">
        <router-link class="gnb__link" to="/">소개</router-link>
        <router-link class="gnb__link" to="/">마이페이지</router-link>
        <router-link class="gnb__link" to="/">고객센터</router-link>

        <ul class="gnb__sub-list">
          <li class="gnb__sub-item">
            <router-link to="/">서브메뉴</router-link>
          </li>
        </ul>
      </nav>

      <nav class="sign-nav">
        <router-link class="gnb__link" to="/">로그인</router-link>
        <router-link class="gnb__link" to="/">회원가입</router-link>
      </nav>
    </div>
  </header>
</template>

<script setup>
import { ref } from 'vue';
</script>

<style lang="scss" scoped>
.header {
  z-index: 10;
  position: fixed;
  transition: 0.2s all;

  &.active {
    .gnb > a {
      transition: 0.2s all;
      color: #000;
    }

    .sign-nav > a {
      transition: 0.2s all;
      color: #030303;
    }
  }
}

.gnb {
  display: flex;
  margin-top: 37px;

  > a {
    width: 160px;
    font-weight: 700;
    font-size: 17px;
    text-align: center;
    color: #000;
  }
}

.sign-nav {
  display: flex;
  align-items: center;
  height: 100%;
  > a {
    position: relative;
    color: #000;

    &:not(:first-child) {
      margin-left: 8px;
      padding-left: 8px;
    }
  }
}
</style>
