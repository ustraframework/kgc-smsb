<template>
  <header id="header">
    <div class="navbar-logo">
      <a class="navbar-link" href="/main" rel="noopener">
        <img src="@/assets/images/svg/logo.svg" alt="U.STRA HR" class="megastudy-logo" />
      </a>
    </div>
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
        <v-col cols="auto">
          <v-btn :ripple="false">
            <span class="icon">
              <img src="@/assets/images/svg/people.svg" alt="navigation icon" />
            </span>
            <span>메뉴4</span>
          </v-btn>
        </v-col>
      </v-row>
    </nav>
  </header>
</template>

<script lang="ts" setup></script>

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

.navbar-menu {
  position: absolute;
  left: 300px;
  display: flex;
  justify-content: space-between;
  padding: 0 42px 0 40px;
  width: calc(100% - 300px);
}

.navbar-left {
  display: flex;
  font-weight: 700;
  font-size: 16px;

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
          transition: 0.2s ease-out;
        }
      }
    }

    &.is-active {
      .v-btn {
        &::before {
          background-color: $is-primary;
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
</style>
