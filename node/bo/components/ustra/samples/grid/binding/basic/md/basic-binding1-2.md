```html
<WjFlexGrid :itemsSource="data" style="height: 200px">
  <WjFlexGridColumn header="Country" binding="country" width="2*" />
  <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
  <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
</WjFlexGrid>

<UButton text="Load Data" @click="() => (data = _getData())"></UButton>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'

const _getData = () => {
  // create some random data
  const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
  const data = []
  for (let i = 0; i < countries.length; i++) {
    data.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
    })
  }

  return data
}

const data = ref([])
</script>
```
