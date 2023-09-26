```html
<template>
  <UCheckGroupBox v-model="states" :stack="true" :itemsSource="[{ text: 'readonly' }, { text: 'disabled' }]" />
  <UDatepicker v-model="value" class="mt-2" :readonly="states[0]" :disabled="states[1]" />
</template>
<script lang="ts" setup>
const value = ref(null)
const states = ref([false, false])
</script>
```
