<template>
  <div class="columns has-gap">
    <UBox class="card is-sub">
      <UItem class="card-body" style="height: 750px">
        <UBox>
          <UBox direction="col">
            <UItem :ratio="1">
              <WjTabPanel class="menu-tab-panel">
                <WjTab>
                  <a>배치 작업</a>
                  <BatchTask />
                </WjTab>
                <WjTab>
                  <a>배치 작업 내역</a>
                  <BatchHist />
                </WjTab>
                <WjTab>
                  <a>배치 매니저</a>
                  <BatchManager />
                </WjTab>
                <WjTab>
                  <a>배치 워커</a>
                  <BatchWorker />
                </WjTab>
              </WjTabPanel>
            </UItem>
          </UBox>
        </UBox>
      </UItem>
    </UBox>
  </div>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UBox, UItem, UFieldSet, UFieldRow, UField, WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import BatchTask from './task/index.vue'
import BatchHist from './hist/index.vue'
import BatchManager from './manager/index.vue'
import BatchWorker from './worker/index.vue'
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemBatch',
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
