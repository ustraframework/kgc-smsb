<template>
  <header id="header">
    <div class="navbar-logo">
      <a class="navbar-link" href="/main" rel="noopener">
        <img src="@/assets/images/svg/logo.svg" alt="U.STRA HR" class="megastudy-logo" />
      </a>
    </div>
    <Gnb />
  </header>
</template>

<script lang="ts" setup>
import Gnb from '@/components/layouts/gnb.vue'

</script>

<style lang="scss" scoped>
@import '@/assets/styles/framework/variable.scss';

.navbar-logo {
  display: flex;
  justify-content: center;
  margin-left: 86px;
  min-width: 124px;
}

.navbar-logo {
  .navbar-link {
    &:focus,
    &:hover {
      background-color: transparent;
    }
  }
}
</style>
