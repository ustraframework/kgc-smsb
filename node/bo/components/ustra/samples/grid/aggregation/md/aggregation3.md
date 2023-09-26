
그리드의 그룹별 집계를 처리를 하기 위해서는 CollectionView의 groupDescriptions 속성을 사용한다. groupDescriptions는 PropertyGroupDescription 객체의 배열로 설정한다.
- PropertyGroupDescription : https://www.grapecity.com/wijmo/api/classes/wijmo.propertygroupdescription.html

```typescript
import { wijmo } from '#ustra/nuxt-wijmo'

// PropertyGroupDescription 객체의 생성
new PropertyGroupDescription('country') // 집계할 필드의 명칭을 입력
```

그리드에 바인딩할 데이터는 CollectionView를 이용하여 생성한다.
```typescript
import { wijmo } from '#ustra/nuxt-wijmo'

const cv = ref<wijmo.CollectionView>(null)

const generateData = (cnt: Number) => {
  const countries = 'US,Germany,UK,Japan,Italy,Greece,Korea'.split(',')
  const data = []

  for (let i = 0; i < cnt; i++) {
    data.push({
      id: i,
      country: countries[$ustra.utils.random.max(countries.length) - 1],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      data1: Math.random() * 1000,
      data2: Math.random() * 1000,
      data3: Math.random() * 1000,
      data4: Math.random() * 1000,
    })
  }

  // CollectionView를 생성하고, groupDescriptions 옵션을 추가
  cv.value = new wijmo.CollectionView(data, {
    groupDescriptions: [new wijmo.PropertyGroupDescription('country')],
  })
}
```

groupDescriptions 옵션이 추가되며, 지정한 필드의 GroupRow가 생성된다. 전체 집계처럼 WjFlexGridColumn의 aggregate 옵션을 추가하면 집계 정보를 자동으로 세팅하나 집계 로직 또는 커스톰 컨텐츠를 추가하려면 formatItem 이벤트 핸들러를 통해 처리한다.
```typescript
const grid = useWijmoFlexGrid({
  onAfterInitialized(control) {
    generateData(100)

    control.formatItem.addHandler((s, e) => {
      if (e.panel === s.cells) {
        const group = e.getRow() instanceof wijmoGrid.GroupRow ? e.getRow().dataItem : null

        // total 컬럼의 group 및 일반 필드 값 설정
        if (e.getColumn().binding === 'total') {
          // if group row
          if (group) {
            const total = group.getAggregate('Sum', 'sales') + group.getAggregate('Sum', 'expenses')
            e.cell.textContent = wijmo.Globalize.format(total, e.getColumn().format)
          } else {
            const total = e.getRow().dataItem.sales + e.getRow().dataItem.expenses
            e.cell.textContent = wijmo.Globalize.format(total, e.getColumn().format)
          }
        }

        // country 컬럼의 Group Text 설정
        if (e.getColumn().binding === 'country') {
          // if group row
          if (group) {
            const count = group.getAggregate('Cnt', 'sales')
            e.cell.textContent = `국가 : ${group.items[0].country} (총 ${count} 건)`
          }
        }
      }
    })
  },
})
```

아래 코드는 위의 그리드에 적용된 전체 코드이다.
```html
<template>
  <WjFlexGrid ref="grid" :initialized="grid.initialize" :itemsSource="cv" style="max-height: 300px">
    <WjFlexGridColumn header="Country" binding="country" :width="200" />
    <WjFlexGridColumn header="Sales" binding="sales" :width="200" format="n2" aggregate="Sum" />
    <WjFlexGridColumn header="Expenses" binding="expenses" :width="200" format="n2" aggregate="Sum" />
    <WjFlexGridColumn header="Total" binding="total" :width="200" format="n2" align="right" />
  </WjFlexGrid>
</template>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { wijmoGrid, wijmo } from '#ustra/nuxt-wijmo'

const grid = useWijmoFlexGrid({
  onAfterInitialized(control) {
    control.columnFooters.rows.push(new wijmoGrid.GroupRow())

    control.formatItem.addHandler((s, e) => {
      if (e.panel === s.cells) {
        const group = e.getRow() instanceof wijmoGrid.GroupRow ? e.getRow().dataItem : null

        // total 컬럼의 group 및 일반 필드 값 설정
        if (e.getColumn().binding === 'total') {
          // if group row
          if (group) {
            const total = group.getAggregate('Sum', 'sales') + group.getAggregate('Sum', 'expenses')
            e.cell.textContent = wijmo.Globalize.format(total, e.getColumn().format)
          } else {
            const total = e.getRow().dataItem.sales + e.getRow().dataItem.expenses
            e.cell.textContent = wijmo.Globalize.format(total, e.getColumn().format)
          }
        }

        // country 컬럼의 Group Text 설정
        if (e.getColumn().binding === 'country') {
          // if group row
          if (group) {
            const count = group.getAggregate('Cnt', 'sales')
            e.cell.textContent = `국가 : ${group.items[0].country} (총 ${count} 건)`
          }
        }
      }
    })

    control.loadedRows.addHandler(() => {
      // 총 합계 설정
      control.columnFooters.setCellData(0, 0, $ustra.utils.formatting.currency(grid.collectionView.sourceCollection.length) + ' 건')

      const total = cv.value.sourceCollection.map(r => r.sales + r.expenses).reduce((a, b) => a + b, 0)
      control.columnFooters.setCellData(0, 3, wijmo.Globalize.format(total, 'n2'))

      nextTick(() => {
        for (let i = 0; i < 4; i++) {
          control.columnFooters.getCellElement(0, i).style.justifyContent = 'flex-end'
        }
      })
    })

    generateData(100)
  },
})

const cv = ref<wijmo.CollectionView>(null)

const generateData = (cnt: Number) => {
  const countries = 'US,Germany,UK,Japan,Italy,Greece,Korea'.split(',')
  const data = []

  for (let i = 0; i < cnt; i++) {
    data.push({
      id: i,
      country: countries[$ustra.utils.random.max(countries.length) - 1],
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      data1: Math.random() * 1000,
      data2: Math.random() * 1000,
      data3: Math.random() * 1000,
      data4: Math.random() * 1000,
    })
  }

  // CollectionView를 생성하고, groupDescriptions 옵션을 추가
  cv.value = new wijmo.CollectionView(data, {
    groupDescriptions: [new wijmo.PropertyGroupDescription('country')],
  })
}
</script>
<style>
.wj-cell.wj-group {
  background-color: #ccef00;
}
</style>
```
