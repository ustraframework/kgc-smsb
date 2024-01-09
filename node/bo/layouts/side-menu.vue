<template>
  <v-navigation-drawer :width="250" color="grey-light-3" permanent border="0" :rail="!isOpenSideMenu" rail-width="60" class="ustra-side-menu">
    <div class="profile">
      <UBox direction="row" class="mb-4">
        <!-- <v-avatar size="50"></v-avatar> -->
        <div class="profile-content">
          <p class="profile-personnel">
            <span class="profile-name">{{ user.userNm }}</span>
            <!-- <span class="profile-position">팀장</span> -->
          </p>
          <p class="profile-personnel">
            <span class="profile-id" id="_profile_userId">{{ user.sub }}</span>
            <span class="profile-divider">|</span>
            <span class="profile-team" id="_profile_deptNm">{{ user.deptNm }}</span>
          </p>
          <!-- <p id="_profile_emailAd" class="profile-email">duckbae@gsitm.com</p> -->
        </div>
      </UBox>

      <div id="search_menu" ref="domSearchMenu" :class="{ off: !isOpenSideMenu }">
        <button class="open navBtn-close" v-if="!isOpenSideMenu" cover @click="isOpenSideMenu = true"></button>
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
        <button class="close navBtn-open" v-if="isOpenSideMenu" cover @click="isOpenSideMenu = false"></button>
      </div>
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
      <UstraLayoutSideMenuItem
        :navigations="props.navigations"
        :favorNavigations="props.favorNavigations"
        :navigationSelected="onNavigationSelected"
      />
    </nav>
  </v-navigation-drawer>
</template>
<script lang="ts" setup>
import { ref, computed, defineProps, watch, PropType, markRaw, onMounted } from '#ustra/nuxt'
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

  /**
   * navigation 목록
   */
  navigations: { type: Object as PropType<Navigation[]>, default: [] },

  /**
   * 즐겨찾기 navigation 목록
   */
  favorNavigations: { type: Object as PropType<Navigation[]>, default: [] },
})
const model = useVModel(props, 'modelValue')

const { isOpenSideMenu } = useUstraLayoutManagementSideMenu()

const searchText = ref<string>(null)
const searchMode = ref(false)
// TODO: 삭제
// const displayNavigations = computed(() => {
//   console.log('=====')
//   return props.navigations.filter(nav => {
//     return nav.visible && nav.id !== 'home'
//   })
// })

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
    clearActive(props.navigations)
  }
  props.navigationSelected(nav)
}

const searchedNavs = computed(() => {
  if (!searchMode.value) {
    return []
  }

  const navs = $ustra.utils.model.flatReclusiveArray(props.navigations, 'items', false)
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

const user = useUstraManagementUser()

onMounted(() => {
  const lnb = document.querySelector('nav.ustra-side-menu') as HTMLElement;
  const header = document.querySelector('header') as HTMLElement;
  const page = document.querySelector('body') as HTMLElement;
    
  if(page) {
    page.addEventListener('scroll', (e) => {
      e.preventDefault();
      //header 
      // header.style.left = `0`;
      // if(page.scrollTop == 0 || page.scrollTop > 0 ) {
      //   header.style.left = `-${page.scrollLeft}px`;
      // }
      // header.style.transition = 'none';
      
      // //lnb
      // if(lnb.classList.contains('v-navigation-drawer--rail')) {
      //   lnb.style.left = `0`;
      //   if((page.scrollLeft > 0 && page.scrollTop == 0) || (page.scrollTop > 0 && page.scrollLeft > 0)) {
      //     lnb.style.left = `-280px`;  
      //   }
      //   lnb.style.transition = 'none';
      // } else {
      //   if((page.scrollLeft > 0 && page.scrollTop == 0) || page.scrollTop > 0 ) {
      //     if(page.scrollLeft < 0) {
      //       lnb.style.left = `${page.scrollLeft}px`;
      //     } else {
      //       lnb.style.left = `-${page.scrollLeft}px`;
      //     }
      //     lnb.style.transition = 'none';
      //   } else if(page.scrollLeft == 0 ) {
      //     lnb.style.left = `0`;
      //   }
      // }         
    })
  }
})

</script>
<script lang="ts">
export default {
  name: 'UstraLayoutSideMenu',
}
</script>
