<template>
  <v-expand-x-transition>
    <v-card class="mdi" v-show="mdiVisible">
      <v-tabs>
        <v-tab value="one" class="is-active">
          <span class="mdi-menu">메인페이지</span>
        </v-tab>
        <v-tab value="two">
          <span class="mdi-menu">메뉴1</span>
          <UButton type="icon" class="button-mdi" />
        </v-tab>
        <v-tab value="three">
          <span class="mdi-menu">메뉴2</span>
          <UButton type="icon" class="button-mdi" />
        </v-tab>
      </v-tabs>

      <div class="mdiShortCuts">
        <button class="mdiShortCuts-hidden" @click="mdiVisible = false">MDI 숨김 버튼</button>
      </div>
    </v-card>
  </v-expand-x-transition>
</template>

<script setup>
const mdiVisible = ref(true)
</script>
<style lang="scss" scoped>
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
      //background-color: $is-primary;
      background-color: #5f0000;
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
</style>
