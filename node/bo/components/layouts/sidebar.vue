<template>
  <aside class="sidebar">
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

      <UBox direction="row" class="mb-3">
        <UButton text="출근" type="primary" class="is-full" />
        <UButton text="퇴근" type="primary" class="is-full" />
      </UBox>

      <UTextBox type="icon" placeholder="메뉴검색" class="is-large"></UTextBox>
    </div>

    <div class="menu-tab mt-1">
      <WjTabPanel :initialized="tabPanel.initialize" class="is-menu">
        <WjTab>
          <a>메뉴</a>
          <div></div>
        </WjTab>

        <WjTab>
          <a>즐겨찾기</a>
          <div></div>
        </WjTab>
      </WjTabPanel>
    </div>

    <div class="menu-contents"></div>
  </aside>
</template>

<script lang="ts" setup>
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'

const tabPanel = useWijmoTabPanel()
</script>

<style lang="scss" scoped>
.sidebar {
  z-index: 999;
  width: 260px;
  border-radius: 13px;
  background-color: white;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.08);
  height: calc(100vh - 180px);

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
