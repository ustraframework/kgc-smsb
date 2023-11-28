<template>
  <div class="menu-tab mt-1">
    <WjTabPanel :initialized="tabPanel.initialize" class="is-menu">
      <WjTab>
        <a><span class="menu">메뉴</span></a>
        <div>
          <ul class="nav-list">
            <li
              :key="i"
              v-for="(nav, i) in displayNavigations.filter(n => n.text !== '즐겨찾기')"
              :class="[{ on: nav.active, nav: props.depth === 1 }, [props.depth < 2 ? null : props.depth === 2 ? 'sub' : 'sub' + (props.depth - 1)]]"
            >
              <component
                :is="'h' + (props.depth + 1)"
                :class="{ not: !nav.items || nav.items.filter(n => n.visible).length < 1, fa: isFavorite(nav) }"
                @click.stop="e => onClickItem(e, nav)"
              >
                <i v-if="isFavorite(nav)">
                  <!-- <img src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_star_line.png" class="fa_off" alt="즐겨찾기" /> -->
                  <img
                    src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_star_color.png"
                    class="fa_on"
                    alt="즐겨찾기"
                    @click.stop="e => removeFavorite(nav)"
                  />
                </i>
        <!-- 
                <v-icon v-if="props.depth < 2">{{ nav.id === 'favorites' ? 'mdi-star' : 'mdi-folder' }}</v-icon> -->
                <span v-if="!isFavorite(nav)">{{ nav.text }}</span>
                <span v-else>
                  <span>{{ nav.text }}</span
                  ><span>{{ getNavFullName(nav) }}</span>
                </span>
              </component>

              <!--
                메뉴 내부 내용 들어가는곳
              -->
              
              <ul class="sub_nav">
                <li
                  v-for="(child_nav, i) in nav.items"
                  :key="i"
                >
                {{ child_nav.text }}
                </li>
              </ul>
              
              <!-- <UstraLayoutSideMenuItem
                v-if="!!nav.items && nav.items.filter(n => n.visible).length > 0"
                :navigationSelected="props.navigationSelected"
                :navigations="nav.items"
                :depth="props.depth + 1"
              /> -->
            </li>
          </ul>
        </div>
      </WjTab>

      <WjTab>
        <a><span class="favorite">즐겨찾기</span></a>
        <div>
          <ul class="nav-list">
            <li
              :key="i"
              v-for="(nav, i) in displayNavigations.filter(n => n.text === '즐겨찾기'  )"
              :class="[{ on: nav.active, nav: props.depth === 1 }, [props.depth < 2 ? null : props.depth === 2 ? 'sub' : 'sub' + (props.depth - 1)], 'favorite', 'on']"
            >
              <component
                :is="'h' + (props.depth + 1)"
                :class="{ not: !nav.items || nav.items.filter(n => n.visible).length < 1, fa: isFavorite(nav) }"
                @click.stop="e => onClickItem(e, nav)"
              >
                <i v-if="isFavorite(nav)">
                  <!-- <img src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_star_line.png" class="fa_off" alt="즐겨찾기" /> -->
                  <img
                    src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_star_color.png"
                    class="fa_on"
                    alt="즐겨찾기"
                    @click.stop="e => removeFavorite(nav)"
                  />
                </i>
        <!-- 
                <v-icon v-if="props.depth < 2">{{ nav.id === 'favorites' ? 'mdi-star' : 'mdi-folder' }}</v-icon> -->
                <span v-if="!isFavorite(nav)">{{ nav.text }}</span>
                <span v-else>
                  <span>{{ nav.text }}</span
                  ><span>{{ getNavFullName(nav) }}</span>
                </span>
              </component>

              <!--
                즐겨찾기 내부 내용 들어가는곳
              -->

              <ul class="sub_nav favorite">
                <li
                  v-for="(child_nav, i) in nav.items"
                  :key="i"
                >
                <button class="favorite is-star"></button>
                {{ child_nav.text }}
                </li>
              </ul>

            </li>
          </ul>
        </div>
      </WjTab>
    </WjTabPanel>
  </div>
  
</template>
<script lang="ts" setup>
import { defineProps, PropType, computed, markRaw } from '#ustra/nuxt'
import { Navigation } from '#ustra/nuxt/management/store/models/navigation'
import UstraLayoutSideMenuItem from '~/layouts/side-menu-item.vue'
import { useUstraUserMenuService } from '#ustra/nuxt/management'
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'


const tabPanel = useWijmoTabPanel();

const userMenuService = useUstraUserMenuService()

const props = defineProps({
  /**
   * navigation 목록
   */
  navigations: { type: Object as PropType<Navigation[]>, default: [] },

  /**
   * 메뉴 depth
   */
  depth: { type: Number, default: 1 },

  /**
   * 메뉴 선택 시 callback function
   */
  navigationSelected: Function as PropType<(nav: Navigation) => void | Promise<void>>,
})

const displayNavigations = computed(() => props.navigations.filter(nav => nav.visible))
 console.log('displayNavigations', displayNavigations.value)
function isFavorite(nav: Navigation) {
  return nav.parent && nav.parent.favorite
}

function getNavFullName(nav: Navigation) {
  if (isFavorite(nav)) {
    const navInfo = $ustra.management.store.navigation.findNavigationByMenuId(nav.originId, true)

    if (navInfo) {
      return $ustra.management.store.navigation.getNavFullName(navInfo)
    }
  } else {
    return $ustra.management.store.navigation.getNavFullName(nav)
  }
}

function onClickItem(e: Event, nav: Navigation) {
  e.preventDefault()
  e.stopImmediatePropagation()

  const hasPath = !!nav.path

  if (hasPath || isFavorite(nav)) {
    const component = $ustra.utils.router.findComponentByPath(nav.path)

    if (!component) {
      // nav.path 가 http로 시작하는 URL인 경우 신규 페이지로 오픈
      if (nav.path.startsWith('http')) {
        window.open(nav.path, '_blank')
      } else {
        alert('선택 메뉴는 존재하지 않습니다. 관리자에게 문의하시기 바랍니다.')
        return
      }
    }

    // 로컬 환경일 때는 메뉴 클릭 시, 항상 refresh 처리
    if (!nav.component || $ustra.env.isDev) {
      nav.component = markRaw(component)
    }
  }

  props.navigationSelected(nav)

  nav.active = hasPath ? true : !nav.active
}

async function removeFavorite(nav: Navigation) {
  await userMenuService.removeMenu({
    mnuId: nav.originId,
  })
  $ustra.management.store.navigation.loadUserMenus()
}
</script>
<script lang="ts">
export default {
  inheritAttrs: false,
}
</script>
