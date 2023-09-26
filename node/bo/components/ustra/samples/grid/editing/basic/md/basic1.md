```html
<template>
  <WjFlexGrid :itemsSource="data" :initialized="grid.initialize" class="mt-2"> </WjFlexGrid>
</template>
<script lang="ts" setup>
import { WjFlexGrid } from '#ustra/nuxt-wijmo/components'

const data = ref([])
const countries = ['US', 'Germany', 'UK', 'Japan', 'Italy', 'Greece']
for (let i = 0; i < countries.length; i++) {
  data.value.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
    overdue: i % 4 == 0,
    date: new Date(),
  })
}

const grid = useWijmoFlexGrid({
  isReadOnly: false,
})
</script>
```
