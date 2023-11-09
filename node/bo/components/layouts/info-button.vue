<template>
  <img src="@ustra/nuxt-wijmo/src/management/layouts/assets/img/icon_info.png" alt="도움말" v-if="currentMenu" @click="toggleInfo" />

  <UPopup v-model="showPopup" :width="800" :height="600" title="도움말">
    <UBox direction="col">
      <UItem :ratio="1" style="overflow: auto">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="담당자" :labelWidth="100">
                <UTextBox v-model="menuData.userNm" type="textarea"></UTextBox>
              </UField>
            </UFieldRow>

            <UFieldRow>
              <UField label="메뉴설명" :labelWidth="100">
                <UTextBox v-model="menuData.contents" type="textarea"></UTextBox>
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
    </UBox>
  </UPopup>
</template>
<script lang="ts" setup>
import { computed } from '#ustra/nuxt'
import { useUstraUserMenuService } from '#ustra/nuxt/management'

const userMenuService = useUstraUserMenuService()

const currentMenu = computed(() => {
  return $ustra.management.store.navigation.currentProgramMenu
})

const showPopup = ref(false)

let menuData = shallowReactive({
  userNm: ['김길동', '이길동'],
  contents: '메뉴 설명',
})

async function toggleInfo(e) {
  // e.stopPropagation()
  menuData.contents = $ustra.management.store.navigation.currentProgramMenu.mnuFullNm + ' 설명입니다'
  showPopup.value = true
}
</script>
<script lang="ts">
export default {
  name: 'LayoutInfoButton',
}
</script>
