<template>
  <div>
    <VCard title="Cell Template #2">
      <template #text> 프레임워크에서 지원하는 Cell Template을 쉽게 사용할 수 있는 기능에 대해 안내한다. </template>
    </VCard>
    <CellTemplate1 />
    <CellTemplate2 />
    <CellTemplate3 />
  </div>
</template>
<script lang="ts" setup>
import CellTemplate1 from './ttemplate1.vue'
import CellTemplate2 from './ttemplate2.vue'
import CellTemplate3 from './ttemplate3.vue'
</script>
