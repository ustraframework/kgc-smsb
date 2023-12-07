<template>
<div>
  <div class="columns has-gap">
    <UBox class="card is-sub is-search">
      <UItem class="card-body">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, 1, '170px']">
            <UField required label="시스템" >
              <UCodeComboBox v-model="selectedSystemCode" grpCd="SYS_CD" style="width: 300px" />
            </UField>
            <UField blank></UField>
            <UField blank></UField>
            <UField blank></UField>
          </UFieldRow>
        </UFieldSet>
      </UItem>
    </UBox>
  </div>

  <div class="columns has-gap">
    <UBox class="card is-sub" direction="col">
      <UItem class="card-body" :ratio="1" style="height: 780px">
        
        <WjTabPanel v-if="canHasAuthorityByUser" class="menu-tab-panel">
          <WjTab>
            <a>그룹별 권한 설정</a>
            <Group :systemCode="selectedSystemCode" />
          </WjTab>

          <WjTab>
            <a>사용자별 권한 설정</a>
            <User :systemCode="selectedSystemCode" />
          </WjTab>
        </WjTabPanel>
        <Group v-else :systemCode="selectedSystemCode" />
      </UItem>
    </UBox>
  </div>
</div>
</template>
<script lang="ts" setup>
import { ref, computed } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import Group from './groups.vue'
import User from './user.vue'

const canHasAuthorityByUser = computed(() => $ustra.management.serverAppProps.canHasAuthorityByUser)

const selectedSystemCode = ref<string>(null)
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemAuth',
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
