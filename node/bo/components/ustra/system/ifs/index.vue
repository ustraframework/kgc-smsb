<template>
  <UBox direction="col">
    <UItem :ratio="1">
      <WjTabPanel class="menu-tab-panel">
        <WjTab>
          <a>인바운드</a>
          <IfPage :tabType="tabType[0]" />
        </WjTab>
        <WjTab>
          <a>아웃바운드</a>
          <IfPage :tabType="tabType[1]" />
        </WjTab>
      </WjTabPanel>
    </UItem>
  </UBox>
</template>

<script lang="ts" setup>
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import IfPage from './if-page.vue'
import { ref } from 'vue'

const tabType = ref(['IN', 'OUT'])
</script>

<script lang="ts">
export default {
  name: 'UstraManagementInterfaceInfo',
}
</script>

<style lang="scss" scoped>
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
