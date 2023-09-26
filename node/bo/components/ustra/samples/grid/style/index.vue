<template>
  <div>
    <VCard title="Style">
      <template #text> 그리드 상에서 Row 또는 Column에 커스톰 스타일을 적용하는 방법에 대해 안내한다. </template>
    </VCard>
    <Style1 class="mt-2" />
    <Style2 class="mt-2" />
    <Style3 class="mt-2" />
  </div>
</template>
<script lang="ts" setup>
import Style1 from './style1.vue'
import Style2 from './style2.vue'
import Style3 from './style3.vue'
</script>
