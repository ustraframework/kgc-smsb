<template>
  <v-app id="ustra">
    <!-- header -->
    <v-app-bar color="#003156" density="compact">
      <v-toolbar-title>
        <NuxtLink class="navbar-link" to="/main">
          <img src="@/assets/images/svg/logo.svg" alt="U.STRA HR" />
        </NuxtLink>
      </v-toolbar-title>
      <v-spacer></v-spacer>

      <!-- 2023-11-29 UI개발 -->
      <nav class="navbar-menu">
        <v-row class="navbar-left" align="center" no-gutters>
          <v-col cols="auto" class="is-active">
            <v-btn :ripple="false">
              <span class="icon">
                <img src="@/assets/images/svg/people.svg" alt="navigation icon" />
              </span>
              <span>메뉴1</span>
            </v-btn>
          </v-col>
          <v-col cols="auto">
            <v-btn :ripple="false">
              <span class="icon">
                <img src="@/assets/images/svg/people.svg" alt="navigation icon" />
              </span>
              <span>메뉴2</span>
            </v-btn>
          </v-col>
          <v-col cols="auto">
            <v-btn :ripple="false">
              <span class="icon">
                <img src="@/assets/images/svg/people.svg" alt="navigation icon" />
              </span>
              <span>메뉴3</span>
            </v-btn>
          </v-col>
        </v-row>
        <v-row class="navbar-right" align="center" no-gutters>
          <UstraConfigMenu />
        </v-row>
      </nav>
    </v-app-bar>
    <!-- // header -->

    <UstraLayoutSideMenu v-model="openSideMenu" />

    <VMain id="page_wrapper" class="t_zero">
      <div class="content">
        <div class="columns has-gap">
          <UBox class="card is-title">
            <h1 class="page-title">
              <span>메뉴명</span>
              <span class="favoriteWrap">
                <UstraLayoutFavoritesButton />
                <LayoutInfoButton />
              </span>
            </h1>
            <UBox class="table-title-wrap">
              <h2 class="table-title">
                <span>메뉴 설명</span>
              </h2>
            </UBox>
          </UBox>
        </div>
        <slot></slot>

        <!-- 2023-11-29 UI개발 -->
        <!-- <ContentsSample /> -->
      </div>
    </VMain>

    <!-- 2023-11-29 UI개발 -->
    <Mdi />
  </v-app>
</template>
<script lang="ts" setup>
import { useHead, useRouter } from '#app'
import { ref, computed, watch } from '#ustra/nuxt'
import { useUstraManagementLayoutUtils } from '#ustra/nuxt/management/composables'

import UstraLayoutHeader from '#ustra/nuxt-wijmo/management/layouts/header.vue'
import UstraLayoutSideMenu from '~/layouts/side-menu.vue'
import UstraLayoutFavoritesButton from '#ustra/nuxt-wijmo/management/layouts/favorites-button.vue'

import LayoutInfoButton from '~/components/layouts/info-button.vue'

// Header
import UstraConfigMenu from '#ustra/nuxt-wijmo/management/layouts/config-menu.vue'

// 2023-11-29
import Mdi from '@/components/layouts/mdi.vue'

// == Header ==
const emits = defineEmits(['changeNavState'])

// ============

const { openMenu, closeTabMenuByIndex } = useUstraManagementLayoutUtils()
const openSideMenu = ref(false)
const selectedTabIndex = computed({
  get() {
    return $ustra.management.store.navigation.selectedTabIndex
  },
  set(v: number) {
    $ustra.management.store.navigation.selectedTabIndex = v
  },
})
const useTabMenu = computed(() => $ustra.env.appProps.nuxt.management.ui.tabMenu.enabled)
const openedTabNavigations = computed(() => $ustra.management.store.navigation.openedTabNavigations)

// set main page
if (useTabMenu.value) {
  if (openedTabNavigations.value.length > 0) {
    selectedTabIndex.value = 0
  }
}

useHead({
  bodyAttrs: {
    class: 'ustra management',
  },
})
</script>
<script lang="ts">
export default {
  name: 'UstraMain',
}
</script>

<style lang="scss" scoped>
.ustra .v-toolbar {
  overflow: visible;
}

.ustra .v-toolbar-title__placeholder {
  color: #fff;
  font-size: 12px;
}

.ustra .v-card-item .v-card-subtitle {
  white-space: normal;
}

.ustra .markdown-body {
  margin: 5px 0;
}

.ustra .config-menu-list {
  padding: 0;

  & .v-list-item {
    cursor: pointer;

    & .v-list-item-title {
      font-size: 0.75rem;
    }
    .v-list-item__overlay {
      display: none;
    }
  }

  & .v-list-item--density-compact.v-list-item--one-line {
    min-height: min-content;
  }

  & .v-list-item__prepend > .v-icon {
    margin-inline-end: 20px;
  }
}

@import '@/assets/styles/framework/variable.scss';

.mdi {
  z-index: 9999;
  position: fixed;
  bottom: 0;
  left: 0;
  width: calc(100% + 1px);
  height: 41px;
  margin: 0 0 -1px -1px;
  border: 1px solid $gray120;
  border-radius: 0;
  .v-tab {
    padding: 0 25px;
    height: 40px;
    &:not(:first-child) {
      border-left: 1px solid $gray80;
    }
    &:last-child {
      border-right: 1px solid $gray80;
    }
    &.is-active {
      background-color: $is-primary;
      .mdi-menu {
        color: $is-white;
        font-weight: 600;
      }
    }
  }

  .mdi-menu {
    display: flex;
    align-items: center;
    position: relative;
    height: 40px;
    color: #bcbcbc;
    font-weight: 400;
    font-size: 16px;
    line-height: 40px;

    &:before {
      content: none;
    }
    &:hover {
      color: $is-primary;
    }
  }
}

.mdiShortCuts {
  display: flex;
  align-items: center;
  position: absolute;
  right: 0;
  top: 50%;
  min-width: 34px;
  height: 30px;
  transform: translateY(-50%);
  padding-right: 30px;

  .mdiShortCuts-menu {
    position: fixed;
    bottom: 0;
    right: 59px;
    height: 30px;
    .mdiShortCuts-menuOpenBtn {
      width: 30px;
      height: 30px;
      border-radius: 50%;
      background-color: $white;
      background-image: url("data:image/svg+xml,%3Csvg width='30' height='30' viewBox='0 0 30 30' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M8 10.75C8 10.3358 8.33579 10 8.75 10H21.25C21.6642 10 22 10.3358 22 10.75C22 11.1642 21.6642 11.5 21.25 11.5H8.75C8.33579 11.5 8 11.1642 8 10.75Z' fill='%23BCBCBC'/%3E%3Cpath d='M8 15.25C8 14.8358 8.33579 14.5 8.75 14.5H21.25C21.6642 14.5 22 14.8358 22 15.25C22 15.6642 21.6642 16 21.25 16H8.75C8.33579 16 8 15.6642 8 15.25Z' fill='%23BCBCBC'/%3E%3Cpath d='M8 19.75C8 19.3358 8.33579 19 8.75 19H21.25C21.6642 19 22 19.3358 22 19.75C22 20.1642 21.6642 20.5 21.25 20.5H8.75C8.33579 20.5 8 20.1642 8 19.75Z' fill='%23BCBCBC'/%3E%3C/svg%3E%0A");
      font-size: 0;
      vertical-align: top;
      transition: all 0.3s;
      border: none;

      &:hover {
        background-image: url("data:image/svg+xml,%3Csvg width='30' height='30' viewBox='0 0 30 30' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M8 10.75C8 10.3358 8.33579 10 8.75 10H21.25C21.6642 10 22 10.3358 22 10.75C22 11.1642 21.6642 11.5 21.25 11.5H8.75C8.33579 11.5 8 11.1642 8 10.75Z' fill='%23151515'/%3E%3Cpath d='M8 15.25C8 14.8358 8.33579 14.5 8.75 14.5H21.25C21.6642 14.5 22 14.8358 22 15.25C22 15.6642 21.6642 16 21.25 16H8.75C8.33579 16 8 15.6642 8 15.25Z' fill='%23151515'/%3E%3Cpath d='M8 19.75C8 19.3358 8.33579 19 8.75 19H21.25C21.6642 19 22 19.3358 22 19.75C22 20.1642 21.6642 20.5 21.25 20.5H8.75C8.33579 20.5 8 20.1642 8 19.75Z' fill='%23151515'/%3E%3C/svg%3E%0A");
        background-color: $gray60;
      }
    }
    .mdiShortCuts-menuList {
      display: none;
      position: absolute;
      right: 15px;
      bottom: 15px;
      width: 200px;
      max-height: 340px;
      background: $white;
      box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
      border-radius: 6px;
    }
    &.is-active {
      .mdiShortCuts-menuList {
        display: block;
        overflow-y: auto;
      }
      .mdiShortCuts-menuOpenBtn {
        background-image: url("data:image/svg+xml,%3Csvg width='30' height='30' viewBox='0 0 30 30' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M8 10.75C8 10.3358 8.33579 10 8.75 10H21.25C21.6642 10 22 10.3358 22 10.75C22 11.1642 21.6642 11.5 21.25 11.5H8.75C8.33579 11.5 8 11.1642 8 10.75Z' fill='%23151515'/%3E%3Cpath d='M8 15.25C8 14.8358 8.33579 14.5 8.75 14.5H21.25C21.6642 14.5 22 14.8358 22 15.25C22 15.6642 21.6642 16 21.25 16H8.75C8.33579 16 8 15.6642 8 15.25Z' fill='%23151515'/%3E%3Cpath d='M8 19.75C8 19.3358 8.33579 19 8.75 19H21.25C21.6642 19 22 19.3358 22 19.75C22 20.1642 21.6642 20.5 21.25 20.5H8.75C8.33579 20.5 8 20.1642 8 19.75Z' fill='%23151515'/%3E%3C/svg%3E%0A");
        background-color: $gray60;
      }
    }
    .mdiShortCuts-menuItem {
      display: flex;
      align-items: center;
      justify-content: space-between;
      position: relative;
      padding: 0 20px 0 30px;
      &:first-child {
        margin-top: 10px;
      }
      &:last-child {
        margin-bottom: 10px;
      }
      &:hover {
        background-color: $blue_gray200;
      }
      &::before {
        display: block;
        position: absolute;
        left: 16px;
        top: 13px;
        width: 4px;
        height: 4px;
        border: solid $is-primary;
        border-width: 1px 1px 0 0;
        transform: rotate(45deg);
        content: '';
      }

      .mdiShortCuts-menuLink {
        display: block;
        overflow: hidden;
        width: calc(100% - 20px);
        line-height: 32px;
        color: $black;
        text-overflow: ellipsis;
        white-space: nowrap;
        text-decoration: none;
      }
      .mdiShortCuts-menuCloseBtn {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 12px;
        height: 12px;
        font-size: 0;
        background: none;
        border: none;

        .icon {
          width: 10px;
          height: 10px;
          // stroke: $is-primary;
        }
        &:hover .icon {
          stroke: $gray280;
        }
      }
    }
  }
  .mdiShortCuts-hidden {
    position: fixed;
    bottom: 0;
    right: 24px;
    width: 30px;
    height: 30px;
    margin-left: 4px;
    border-radius: 50%;
    background-color: $is-white;
    background-image: url("data:image/svg+xml,%3Csvg width='30' height='30' viewBox='0 0 30 30' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cmask id='path-2-inside-1_134_6830' fill='white'%3E%3Cpath d='M6 11.5C6 10.3954 6.89543 9.5 8 9.5H22C23.1046 9.5 24 10.3954 24 11.5V14.5H6V11.5Z'/%3E%3C/mask%3E%3Cpath d='M4.5 11.5C4.5 9.567 6.067 8 8 8H22C23.933 8 25.5 9.567 25.5 11.5H22.5C22.5 11.2239 22.2761 11 22 11H8C7.72386 11 7.5 11.2239 7.5 11.5H4.5ZM24 14.5H6H24ZM4.5 14.5V11.5C4.5 9.567 6.067 8 8 8V11C7.72386 11 7.5 11.2239 7.5 11.5V14.5H4.5ZM22 8C23.933 8 25.5 9.567 25.5 11.5V14.5H22.5V11.5C22.5 11.2239 22.2761 11 22 11V8Z' fill='%23BCBCBC' mask='url(%23path-2-inside-1_134_6830)'/%3E%3Cpath d='M12 18L15 20.5L18 18' stroke='%23BCBCBC' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
    font-size: 0;
    //   transition: all 0.3s;
    border: none;
    &:hover {
      background-color: $gray60;
      background-image: url("data:image/svg+xml,%3Csvg width='30' height='30' viewBox='0 0 30 30' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cmask id='path-2-inside-1_134_6830' fill='white'%3E%3Cpath d='M6 11.5C6 10.3954 6.89543 9.5 8 9.5H22C23.1046 9.5 24 10.3954 24 11.5V14.5H6V11.5Z'/%3E%3C/mask%3E%3Cpath d='M4.5 11.5C4.5 9.567 6.067 8 8 8H22C23.933 8 25.5 9.567 25.5 11.5H22.5C22.5 11.2239 22.2761 11 22 11H8C7.72386 11 7.5 11.2239 7.5 11.5H4.5ZM24 14.5H6H24ZM4.5 14.5V11.5C4.5 9.567 6.067 8 8 8V11C7.72386 11 7.5 11.2239 7.5 11.5V14.5H4.5ZM22 8C23.933 8 25.5 9.567 25.5 11.5V14.5H22.5V11.5C22.5 11.2239 22.2761 11 22 11V8Z' fill='%23151515' mask='url(%23path-2-inside-1_134_6830)'/%3E%3Cpath d='M12 18L15 20.5L18 18' stroke='%23151515' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
    }

    &.is-default {
      top: -87px;
      background: url("data:image/svg+xml,%3Csvg width='30' height='30' viewBox='0 0 30 30' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Crect width='30' height='30' rx='15' fill='%23151515'/%3E%3Cmask id='path-2-inside-1_134_6876' fill='white'%3E%3Cpath d='M6 12.5C6 11.3954 6.89543 10.5 8 10.5H22C23.1046 10.5 24 11.3954 24 12.5V15.5H6V12.5Z'/%3E%3C/mask%3E%3Cpath d='M4.5 12.5C4.5 10.567 6.067 9 8 9H22C23.933 9 25.5 10.567 25.5 12.5H22.5C22.5 12.2239 22.2761 12 22 12H8C7.72386 12 7.5 12.2239 7.5 12.5H4.5ZM24 15.5H6H24ZM4.5 15.5V12.5C4.5 10.567 6.067 9 8 9V12C7.72386 12 7.5 12.2239 7.5 12.5V15.5H4.5ZM22 9C23.933 9 25.5 10.567 25.5 12.5V15.5H22.5V12.5C22.5 12.2239 22.2761 12 22 12V9Z' fill='white' mask='url(%23path-2-inside-1_134_6876)'/%3E%3Cpath d='M18 20.5L15 18L12 20.5' stroke='white' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
    }
  }
}

.navbar-menu {
  position: absolute;
  top: 0;
  left: 300px;
  display: flex;
  justify-content: space-between;
  padding: 0 42px 0 40px;
  width: calc(100% - 300px);
}

.navbar-left {
  display: flex;
  justify-content: flex-start;
  font-weight: 700;
  font-size: 16px;
  max-width: calc(100% - 100px);

  .v-btn__overlay,
  .v-btn__underlay {
    display: none;
  }
  .v-sheet {
    width: 100%;
  }

  .v-btn {
    border: none;
  }
  .v-col {
    :deep(.v-btn__content) {
      display: flex;
      flex-direction: column;
      justify-content: flex-start;
      height: 100%;
    }
    .v-btn__content .icon {
      align-items: baseline;
      visibility: hidden;
    }

    &:focus,
    &.is-focus,
    &.is-active {
      &::before {
        position: absolute;
        z-index: -1;
      }
    }

    &:not(:last-child) {
      margin-right: 9px;
    }

    &.is-active {
      &::before {
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 65px;
        height: 12px;
        background-color: #dde4f2;
      }
    }
  }

  .v-col {
    .v-btn {
      text-decoration: none;
      &::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: -12px;
        border-bottom-left-radius: 13px;
        border-bottom-right-radius: 13px;
      }
    }

    &:hover,
    &.is-hover,
    &.is-active {
      .v-btn {
        color: white;

        .v-btn__content span {
          margin-top: 10px;
          font-size: 17px;
          line-height: 19px;
        }
      }

      .v-btn__content .icon {
        visibility: visible;
      }
    }

    &:hover,
    &.is-hover {
      .v-btn {
        &::before {
          background-color: $gray160;
          // background-color: #d20f27;
          transition: 0.2s ease-out;
        }
      }
    }

    &.is-active {
      .v-btn {
        &::before {
          background-color: $is-primary;
          // background-color: #5f0000;
          border-radius: 0px 0px 20px 20px;
        }
      }
    }

    &.has-dropdown {
      padding: 0;
    }

    &.is-expanded {
      flex: auto;
    }

    &.is-tab {
      border-bottom: 1px solid transparent;
      padding-bottom: calc(5px - 1px);
      min-height: 32.5px;

      &:hover,
      &:focus {
        border-bottom-color: $link;
        background-color: transparent;
      }

      &.is-active {
        border-bottom-width: 3px;
        border-bottom-style: solid;
        border-bottom-color: $link;
        padding-bottom: calc(5px - 3px);
        background-color: transparent;
        color: $link;
      }
    }
  }

  .v-btn {
    display: flex;
    flex-direction: column;
    padding: 0 29px;
    font-size: 17px;
    line-height: 20px;
    font-weight: 600;
    color: #151515;

    span {
      margin-top: 0;
      transition: margin 0.3s ease-out;
    }
  }

  .v-btn__content .icon {
    width: 26px;
    height: 26px;
    color: #fffdfd;

    &:not(:last-child) {
      &:not(.is-last) {
        margin-bottom: -6px;
      }
    }
  }

  .v-btn {
    position: relative;
    display: flex;
    align-items: center;
    height: 55px;

    .v-btn__content span {
      position: relative;
    }
  }
}

.icon {
  display: flex;
  justify-content: center;
  vertical-align: middle;
}

.navbar-right {
  justify-content: flex-end;

  .v-col {
    &:not(:first-child) {
      margin-left: 16px;
    }
  }
  .v-btn {
    min-width: auto;
    border: none;
    padding: 0;

    &:hover {
      > .v-btn__overlay {
        opacity: 0;
      }
    }
  }
}

.search-emp {
  display: flex;
  position: relative;
  .v-btn {
    position: absolute;
    right: 0;
    height: 30px;
  }
}
</style>
