```html
<template>
  <WjFlexGrid style="height: 150px" class="mt-5" :itemsSource="gridData" :initialized="grid.initialize">
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
const grid = useWijmoFlexGrid()
</script>
```
