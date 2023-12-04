<template>
  <aside class="sidebar">
    <button type="button" class="button lnb-button lnb-open"></button>
    <div class="profile">
      <UBox direction="row" class="mb-4">
        <v-avatar size="50"></v-avatar>
        <div class="profile-content">
          <p class="profile-personnel">
            <span class="profile-name">김덕배</span>
            <span class="profile-position">팀장</span>
          </p>
          <p class="profile-personnel">
            <span class="profile-id" id="_profile_userId">20220243</span>
            <span class="profile-divider">|</span>
            <span class="profile-team" id="_profile_deptNm">인사팀</span>
          </p>
          <p id="_profile_emailAd" class="profile-email">duckbae@gsitm.com</p>
        </div>
      </UBox>

      <UTextBox type="icon" placeholder="메뉴검색" class="is-large"></UTextBox>
    </div>

    <div class="menu-contents">
      <!-- <UstraLayoutSideMenu v-model="openSideMenu" :navigationSelected="navigationSelected" /> -->
    </div>
  </aside>
</template>

<script lang="ts" setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'
import UstraLayoutSideMenu from '@/components/layouts/lnb.vue'

const { openMenu, closeTabMenuByIndex } = useUstraManagementLayoutUtils();

const tabPanel = useWijmoTabPanel();

const openSideMenu = ref(false);

function navigationSelected(nav: Navigation) {
  if (nav) {
    openMenu(nav)
  }

  // if (nav.component) {

  //   // if (useTabMenu.value) {

  //   //   const existsIndex = openedTabNavigations.value.findIndex(n => n.id === nav.id)

  //   //   if (existsIndex > -1) {
  //   //     selectedTabIndex.value = existsIndex
  //   //     return
  //   //   }

  //   //   openedTabNavigations.value.push(nav)
  //   //   selectedTabIndex.value = openedTabNavigations.value.length - 1
  //   // } else {
  //   //   useRouter().push(nav.path)
  //   // }
  // }
}

</script>

<style lang="scss" scoped>
.sidebar {
  position: relative;
  z-index: 999;
  width: 100%;
  border-radius: 13px;
  background-color: white;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.08);
  height: calc(100vh - 180px);

.lnb-button {
  position:absolute;
  top: 50%;
  right: -18px;
  width: 12px;
  height: 58px;
  margin-left: 0 !important;
  margin-right: 5px;
  border: none;
  border-radius: 0px 8px 8px 0px;
  background-repeat: no-repeat;
  background-position: left 4px center;
  background-color: #9A9A9A;
  background-image: url("data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_2009_25510)'%3E%3Cpath d='M9 6L15 12L9 18' stroke='white' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_2009_25510'%3E%3Crect width='24' height='24' rx='5' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
  transform: translateY(-50%);
  z-index: 100;
  cursor: pointer;
  transition: 0.15s all;


  &:hover {
    right: -41px;
    width: 35px;
    background-size: 24px auto;
  }

  &.lnb-open {
    background-color: #dbdbdb;
    background-image: url("data:image/svg+xml,%3Csvg width='24' height='24' viewBox='0 0 24 24' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_2009_24442)'%3E%3Cpath d='M15 18L9 12L15 6' stroke='white' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_2009_24442'%3E%3Crect x='24' y='24' width='24' height='24' rx='5' transform='rotate(-180 24 24)' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
  }
}

  .profile {
    position: relative;
    padding: 25px 15px 15px;
  }

  .profile-content {
    padding: 1px 0 0 10px;
    font-size: 12px;
    line-height: 14px;
    font-weight: 400;

    .profile-personnel {
      display: flex;

      &:first-child {
        margin-bottom: 6px;
        font-size: 16px;
        line-height: 20px;
      }

      &:nth-child(2) {
        span {
          &:not(:first-child) {
            color: rgba(51, 51, 51, 0.66);
          }

          &:not(:last-child) {
            margin-right: 1px;
          }
        }

        &:not(:last-child) {
          margin-bottom: 2px;
        }
      }

      &:nth-child(3) {
        margin-bottom: 2px;
      }
    }

    .profile-name {
      font-weight: 700;

      &:not(:last-child) {
        margin-right: 3px;
      }
    }
  }

  .menu-tab {
    padding: 0 15px;
  }

  .u-button {
    width: 100%;
  }
}
</style>
