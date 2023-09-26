```html
<UCheckGroupBox :itemsSource="[{ text: 'autoSelection' }]" v-model="autoSelection"></UCheckGroupBox>

<UWjFlexGrid style="height: 150px" class="mt-5" :itemsSource="gridData" :autoSelection="autoSelection" selectionMode="Row">
  <WjFlexGridColumn :header="'Country'" :binding="'country'" width="2*" />
  <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
  <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" />
</UWjFlexGrid>
<UButton text="Load Data" @click="() => (gridData = createData())" />

<script lang="ts" setup>
const autoSelection = ref<boolean>(false)
const gridData = ref<any[]>([])

function createData() {
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
</script>
```
