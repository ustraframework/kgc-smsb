<template>
  <UBox direction="col">
    <UItem :ratio="1">
      <WjTabPanel class="menu-tab-panel">
        <WjTab>
          <a>사용자별 권한</a>
          <UserAuthStt />
        </WjTab>
        <WjTab>
          <a>기간별 신규 권한</a>
          <PeriodAuth />
        </WjTab>
        <WjTab>
          <a>현재 권한 현황</a>
          <CurrentAuthStt />
        </WjTab>
        <WjTab>
          <a>권한 그룹 이력</a>
          <AuthGrpHist />
        </WjTab>
        <WjTab>
          <a>권한 변경 이력</a>
          <AuthHist />
        </WjTab>
      </WjTabPanel>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import UserAuthStt from './user-auth-stt/index.vue'
import PeriodAuth from './period-auth/index.vue'
import CurrentAuthStt from './current-auth-stt/index.vue'
import AuthGrpHist from './auth-grp-hist/index.vue'
import AuthHist from './auth-hist/index.vue'
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuthStt',
}
</script>
<style lang="scss">
.menu-tab-panel {
  width: 100%;
  // height: 100%;
  display: flex;
  flex-direction: column;
}

.menu-tab-panel > div:nth-of-type(3) {
  flex: 1 1 100%;
  display: flex;
  flex-direction: column;

  & .wj-tabpanes {
    flex: 1 1 100%;
  }
}
</style>
