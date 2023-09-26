```html
<template>
  <UDatepicker v-model="value" class="mt-2" range :minDate="new Date()" :maxDate="$ustra.utils.date.addDays(new Date(), 60)" />
</template>
<script lang="ts" setup>
const value = ref([])
</script>
```
