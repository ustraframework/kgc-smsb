<template>
  <v-app id="ustra">
    <UstraLayoutHeader @changeNavState="openSideMenu = !openSideMenu" />
    <UstraLayoutSideMenu v-model="openSideMenu" :navigationSelected="navigationSelected" />
    <VAppBar id="tab_bar" height="38" elevation="0" v-if="useTabMenu && selectedTabIndex > -1">
      <div id="tab">
        <div class="wrapper">
          <div class="bline"></div>
          <ul>
            <li
              v-for="(item, index) in openedTabNavigations"
              :key="item.id"
              :style="{ width: '150px' }"
              :class="{ on: index === selectedTabIndex }"
              @click.stop="selectedTabIndex = index"
            >
              <div class="box">
                <div class="txt">{{ item.text }}</div>
                <i class="close_btn" v-if="item.id !== 'home'" @click.stop="closeTab(index)"></i>
                <i class="blank_btn" v-if="item.id !== 'home'" @click.stop="openNewWindow(item)"></i>
              </div>
            </li>
          </ul>
        </div>
        <div class="next_btn"></div>
        <div class="prev_btn"></div>
      </div>
    </VAppBar>

    <VMain id="page_wrapper" :class="{ t_zero: openedTabNavigations.length < 1 }" v-if="useTabMenu && selectedTabIndex > -1">
      <div class="content">
        <h2 id="page_title">
          <b>{{ openedTabNavigations[selectedTabIndex] ? openedTabNavigations[selectedTabIndex].text : null }} {{ currentMenu?.mnuDesc }}</b>
          <span class="favoriteWrap">
            <UstraLayoutFavoritesButton />
            <LayoutInfoButton />
            <!-- <img src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_info.png" class="info" alt="도움말" /> -->
          </span>
        </h2>

        <div style="height: calc(100% - 59px)">
          <template v-for="(item, index) in openedTabNavigations" :key="item.id">
            <component v-if="!!item.component" v-show="selectedTabIndex === index" :is="item.component" />
          </template>
        </div>
      </div>
    </VMain>

    <VMain id="page_wrapper" v-show="!useTabMenu">
      <div class="content">
        <h2 id="page_title">
          <b v-if="currentMenu">{{ currentMenu.mnuNm }}</b>
          <span class="favoriteWrap">
            <UstraLayoutFavoritesButton />
            <img src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_info.png" class="info" alt="도움말" v-if="currentMenu" />
          </span>
        </h2>

        <div style="height: calc(100% - 59px)">
          <slot />
        </div>
      </div>
    </VMain>

    <VFooter color="#003156" app>
      <VSpacer></VSpacer>
      <span style="color: #fff">&copy; GSITM since 2020-2023</span>
    </VFooter>
  </v-app>
</template>
<script lang="ts" setup>
import { useHead, useRouter } from '#app'
import { ref, computed, watch } from '#ustra/nuxt'
import { Navigation } from '#ustra/nuxt/management/store/models/navigation'
import { useUstraManagementLayoutUtils } from '#ustra/nuxt/management/composables'

import UstraLayoutHeader from '#ustra/nuxt-wijmo/management/layouts/header.vue'
import UstraLayoutSideMenu from '~/layouts/side-menu.vue'
import UstraLayoutFavoritesButton from '#ustra/nuxt-wijmo/management/layouts/favorites-button.vue'

import LayoutInfoButton from '~/components/layouts/info-button.vue'

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
const currentMenu = computed(() => $ustra.management.store.navigation.currentProgramMenu)

// set main page
if (useTabMenu.value) {
  if (openedTabNavigations.value.length > 0) {
    selectedTabIndex.value = 0
  }
}

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

function closeTab(index: number) {
  closeTabMenuByIndex(index)
}

function openNewWindow(nav: Navigation) {
  window.open(window.location.pathname + '?id=' + nav.id, '_blank')
}

watch(selectedTabIndex, v => {
  if (useTabMenu.value) {
    $ustra.hooks.callHook('management:navigation:updated', v < 0 ? null : openedTabNavigations.value[v])
  }
})

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
<style lang="scss">
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
  }

  & .v-list-item--density-compact.v-list-item--one-line {
    min-height: min-content;
  }

  & .v-list-item__prepend > .v-icon {
    margin-inline-end: 20px;
  }
}
</style>
