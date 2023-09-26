```html
<template>
  <UDatepicker
    v-model="value"
    class="mt-2"
    :enableTimePicker="true"
    :autoApply="false"
    format="yyyy-MM-dd HH:mm"
    :allowedDates="[new Date(), $ustra.utils.date.addDays(new Date(), 1), $ustra.utils.date.addDays(new Date(), 5)]"
  />
</template>
<script lang="ts" setup>
const value = ref(null)
</script>
```
