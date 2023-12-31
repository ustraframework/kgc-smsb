<template>
  <v-navigation-drawer color="grey-light-3" permanent border="0" :rail="!isOpenSideMenu" rail-width="60" class="ustra-side-menu ustra-lnb">
    <div id="search_menu" ref="domSearchMenu" :class="{ off: !isOpenSideMenu }">
      <img
        width="22"
        class="open"
        src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_menu_open.png"
        v-if="!isOpenSideMenu"
        cover
        @click="isOpenSideMenu = true"
      />
      <input type="text" name="search" placeholder="메뉴검색" v-model="searchText" @input="searchMode = !!searchText" />
      <span
        class="sm_cancel"
        v-if="searchMode"
        @click="
          () => {
            searchText = ''
            searchMode = false
          }
        "
        >취소</span
      >
      <img
        src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_menu_close.png"
        class="close"
        width="22"
        v-if="isOpenSideMenu"
        cover
        @click="isOpenSideMenu = false"
      />
    </div>

    <nav id="search_menu_result" v-show="searchMode">
      <div class="null_data" v-if="searchedNavs.length < 1">검색결과가 없습니다.</div>
      <ul class="on">
        <li :key="item.id" v-for="(item, i) in searchedNavs">
          <a @click.stop="clickSearchMenuItem(item)">
            <h3>{{ item.text }}</h3>
            <p>{{ $ustra.management.store.navigation.getNavFullName(item) }}</p>
          </a>
        </li>
      </ul>
    </nav>

    <nav id="lnb" :class="{ collapse: !isOpenSideMenu }" v-show="!searchMode">
      <UstraLayoutSideMenuItem :navigations="displayNavigations" :navigationSelected="onNavigationSelected" />
    </nav>
  </v-navigation-drawer>
</template>
<script lang="ts" setup>
import { ref, computed, defineProps, watch, PropType, markRaw } from '#ustra/nuxt'
import { useVModel } from '@vueuse/core'
import { useUstraLayoutManagementSideMenu } from '#ustra/nuxt/management/composables'
import UstraLayoutSideMenuItem from '~/layouts/side-menu-item.vue'
import { Navigation } from '#ustra/nuxt/management/store/models/navigation'

const props = defineProps({
  /**
   * side menu open 여부
   */
  modelValue: Boolean,

  /**
   * 메뉴 선택 시 callback function
   */
  navigationSelected: Function as PropType<(nav: Navigation) => void | Promise<void>>,
})
const model = useVModel(props, 'modelValue')

const { isOpenSideMenu, navigations } = useUstraLayoutManagementSideMenu()

const searchText = ref<string>(null)
const searchMode = ref(false)
const displayNavigations = computed(() => {
  return navigations.value.filter(nav => {
    return nav.visible && nav.id !== 'home'
  })
})

watch(isOpenSideMenu, v => (model.value = v), { immediate: true })
watch(model, v => (isOpenSideMenu.value = v))

function clickSearchMenuItem(nav: Navigation) {
  const component = $ustra.utils.router.findComponentByPath(nav.path)

  if (!component) {
    alert('선택 메뉴는 존재하지 않습니다. 관리자에게 문의하시기 바랍니다.')
    return
  }

  // 로컬 환경일 때는 메뉴 클릭 시, 항상 refresh 처리
  // if (!nav.component || $ustra.env.isDev) {
  //   nav.component = markRaw(component)
  // }

  onNavigationSelected(nav)
}

function onNavigationSelected(nav: Navigation) {
  // clear active state with path
  function clearActive(navs: Navigation[]) {
    if (!navs) {
      return
    }

    for (const nav of navs) {
      if (nav.path) {
        nav.active = false
      }

      clearActive(nav.items)
    }
  }

  if (nav?.path) {
    clearActive(navigations.value)
  }
  props.navigationSelected(nav)
}

const searchedNavs = computed(() => {
  if (!searchMode.value) {
    return []
  }

  const navs = $ustra.utils.model.flatReclusiveArray(displayNavigations.value, 'items', false)
  return navs.filter(nav => {
    // favorite
    if (nav.favorite || nav.originId) {
      return false
    }

    if (!nav.path || !nav.visible) {
      return false
    }

    const fullName = $ustra.management.store.navigation.getNavFullName(nav)
    return fullName.includes(searchText.value) || nav.text.includes(searchText.value)
  })
})
</script>
<script lang="ts">
export default {
  name: 'UstraLayoutSideMenu',
}
</script>
