<template>
  <VCard>
    <template #text>
      Validation은 크게 이벤트를 이용한 방법과 collectionView를 사용하는 방식으로 나뉘어진다.

      <h3 class="mt-5">Event</h3>
      <div class="mt-1">
        cellEditEnding 이벤트를 활용하고, cancel, stayInEditMode 옵션을 활용하여 맞지않은 값을 입력하였을때 정지 후 알림 처리를 하는 방식이다.
        <br />
        아래 예제를 보면 Sale와 Expenses 항목의 데이터가 숫자가 아니거나 0보다 적을 경우 메시지를 노출하고 입력을 취소 처리한다.
        <br /><br />
        <u
          >단, 이벤트 방식은 데이터를 코드 상으로 변경할 경우는 잘못된 값이 입력될 수 있으므로 저장 전 한번 더 검증을 수행하거나 아래의 collection
          View를 이용하는 방법을 사용토록 한다.</u
        >

        <WjFlexGrid :itemsSource="data" allowDragging="Rows" :initialized="grid.initialize" class="mt-2">
          <WjFlexGridColumn header="Country" binding="country" width="2*" :isReadOnly="true" />
          <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" />
          <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" />
        </WjFlexGrid>

        <UMarkdownViewer :content="doc1" />
      </div>
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { useWijmo } from '#ustra/nuxt-wijmo/composables'
import { reactive } from '#ustra/nuxt'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import doc1 from './md/doc1.md'

const data = reactive([])
const countries = 'US,Germany,UK,Japan,Italy,Greece'.split(',')
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    sales: Math.random() * 10000,
    expenses: Math.random() * 5000,
  })
}

const wijmo = useWijmo()
const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized() {
    grid.rawControl.cellEditEnding.addHandler((s, e) => {
      let col = s.columns[e.col]
      if (col.binding == 'sales' || col.binding == 'expenses') {
        let value = wijmo.changeType(s.activeEditor.value, wijmo.DataType.Number, col.format)
        if (!wijmo.isNumber(value) || value < 0) {
          e.cancel = true
          e.stayInEditMode = true
          toast('잘못된 데이터가 입력되었습니다.')
        }
      }
    })
  },
})
</script>
