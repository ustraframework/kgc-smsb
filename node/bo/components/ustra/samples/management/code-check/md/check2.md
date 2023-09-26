```html
<template>
  <UCodeCheckGroupBox v-model="checkValue" grpCd="SYS_CD" :disabledCodes="['FO', 'BT']" />
</template>
<script lang="ts" setup>
const checkValue = ref(null)
</script>
```
