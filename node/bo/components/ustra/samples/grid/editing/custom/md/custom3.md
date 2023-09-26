```html
<UButton
  text="수정된 데이터 조회"
  @click="
    () => {
      grid.selection.clear()
      $ustra.logger.info(grid.collectionView.itemsEdited)
    }
  "
/>
<UButton text="데이터로드" @click="() => loadData()" />

<WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
  <WjFlexGridColumn header="Country" binding="country" width="*" />

  <WjFlexGridColumn header="System" binding="system" width="*" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)">
    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
      <UCodeInputBox v-model="cell.item.system" grpCd="SYS_CD" />
    </WjFlexGridCellTemplate>
  </WjFlexGridColumn>

  <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n0">
    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
      <WjInputNumber v-model="cell.item.expenses" :step="1" />
    </WjFlexGridCellTemplate>
  </WjFlexGridColumn>

  <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n0">
    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
      <WjInputNumber v-model="cell.item.sales" :step="1" />
    </WjFlexGridCellTemplate>
  </WjFlexGridColumn>

  <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd">
    <WjFlexGridCellTemplate cellType="Cell" v-slot="cell">
      <WjInputDate v-model="cell.item.date" @update:modelValue="() => $nextTick(() => grid.rawControl.invalidate())" />
    </WjFlexGridCellTemplate>
  </WjFlexGridColumn>

  <WjFlexGridColumn binding="date" header="Date" width="*" format="yyyy-MM-dd"> </WjFlexGridColumn>
</WjFlexGrid>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn, WjFlexGridCellTemplate, WjInputDate, WjInputNumber } from '#ustra/nuxt-wijmo/components'

const data = ref([])

function loadData() {
  const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
  const rows = []
  for (let i = 0; i < countries.length; i++) {
    rows.push({
      id: i,
      country: countries[i],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      date: useWijmo().DateTime.addDays(new Date(), -Math.random() * 360),
      system: 'BO',
    })
  }

  data.value = rows
}
onMounted(() => loadData())

const grid = useWijmoFlexGrid({
  isReadOnly: true,
  autoSelection: false,
  editing: {
    useInlineEditTracking: true,
  },
})
</script>
```
