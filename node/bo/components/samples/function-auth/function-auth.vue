<template>
  <div :class="{ 'u-layout-state-disabled' : disabled}" v-if="display" @click="createMnuFncAccHist">
    <slot/>
  </div>
</template>
<script lang="ts" setup>
import { computed, withDefaults, useSlots, onMounted, ref } from '#ustra/nuxt'
const props = withDefaults(defineProps<{
  functionId: string,
  notPermitType?: 'disable' | 'hidden'
}>(),{
  notPermitType: 'hidden'
})

const disabled = ref(false);
const display = ref(true);

onMounted(() => {
  init()
})

function init() {
    if (!hasAuth()) {
      adjustNotPermit()
    }else{
      adjustPermit()
    }
}

// $ustra.hooks.hook('management:navigation:updated', (info) => {
//   console.log('hook-info', info)
//   if (!hasAuth()) {
//       adjustNotPermit()
//     }else{
//       adjustPermit()
//     }
// })

function hasAuth() {
  return $ustra.management.auth.hasFunctionAuthority(props.functionId);
}

function adjustNotPermit() {
  switch (props.notPermitType) {
    case 'hidden':
      display.value = false;
      break
    case 'disable':
      disabled.value = true;
      break
  }
}

function adjustPermit() {
  display.value = true;
  disabled.value = false;
}

function createMnuFncAccHist(){
  console.log('createMnuFncAccHist')
  // 개인 정보 이력을 위해서 별도 코딩 필요
  const currentMenu = $ustra.management.store.navigation.currentProgramMenu
  const prvViewYn = currentMenu.prvViewYn

  if (prvViewYn === 'Y') {
    // 개인 정보 조회가 있는 경우는 usePrivacyHistory를 사용해서 등록한다.
    return
  }

  $ustra.management.auth.addFunctionAccessHistory(props.functionId)
}

const definePageMeta = (arg: any) => {}
definePageMeta({
  auth: {
    required: false,
  },
  layout: 'ustra',
})

</script>
