<template>
  <UBox direction="col">
    <UItem :ratio="1">
      <WjTabPanel class="menu-tab-panel">
        <WjTab>
          <a>로그인 이력</a>
          <LoginHist />
        </WjTab>
        <WjTab>
          <a>접속 횟수</a>
          <AccCnt />
        </WjTab>
      </WjTabPanel>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import LoginHist from './login-hist/index.vue'
import AccCnt from './acc-cnt/index.vue'
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemUserAccHist',
}
</script>
<style lang="scss">
.menu-tab-panel {
  width: 100%;
  height: 100%;
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
