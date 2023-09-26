<template>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc1" />

      <UButton @click="addRow" text="로우 추가"></UButton>
      <UButton @click="removeRow" text="로우 삭제"></UButton>
      <UButton @click="createData" text="초기화"></UButton>

      <UButton @click="() => (displayData = grid.collectionView.itemsEdited)" text="수정 데이터 조회"></UButton>
      <UButton @click="() => (displayData = grid.collectionView.itemsAdded)" text="추가 데이터 조회"></UButton>
      <UButton @click="() => (displayData = grid.collectionView.itemsRemoved)" text="삭제 데이터 조회"></UButton>

      <br />

      <WjFlexGrid :itemsSource="data" style="max-height: 300px" :allowDelete="true" :allowAddNew="true" :initialized="grid.initialize" class="mt-5">
        <WjFlexGridColumn header="Seq" binding="seq" width="*" />
        <WjFlexGridColumn header="Country" binding="country" width="*" />
        <WjFlexGridColumn header="Sales" binding="sales" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn header="Expenses" binding="expenses" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn header="Data1" binding="data1" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn header="Data2" binding="data2" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn header="Data3" binding="data3" width="*" format="n2" aggregate="Sum" />
        <WjFlexGridColumn header="Data4" binding="data4" width="*" format="n2" aggregate="Sum" />
      </WjFlexGrid>

      <VBanner v-if="displayData" :border="true" :rounded="true" theme="dark" class="mt-2">
        <pre>{{ JSON.stringify(displayData, null, 4) }}</pre>
      </VBanner>

      <UMarkdownViewer :content="doc2" />
    </template>
  </VCard>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { WjFlexGrid, WjFlexGridColumn, UMarkdownViewer, UButton } from '#ustra/nuxt-wijmo/components'
import { useWijmoFlexGrid } from '#ustra/nuxt-wijmo/composables'

// @ts-ignore
import doc1 from './md/tracking1-1.md'

// @ts-ignore
import doc2 from './md/tracking1-2.md'

const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized() {
    grid.collectionView.trackChanges = true

    // 초기화 시에 itemSource가 변경되는 경우는 trackChagnes를 지속적으로 변경해야 함.
    grid.rawControl.itemsSourceChanged.addHandler(() => {
      if (grid.collectionView) {
        grid.collectionView.trackChanges = true
      }
    })
  },
})

const data = ref([])
const displayData = ref(null)

const createData = () => {
  data.value = []

  for (let i = 0; i < 10; i++) {
    data.value.push({
      id: i,
      seq: i + 1,
      country: 'country_' + i,
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      data1: Math.random() * 1000,
      data2: Math.random() * 1000,
      data3: Math.random() * 1000,
      data4: Math.random() * 1000,
    })
  }
  displayData.value = null
}
createData()

const addRow = () => {
  grid.collectionView.addNew(
    {
      id: grid.rawControl.rows.length,
      seq: grid.rawControl.rows.length + 1,
      country: 'country_' + (grid.rawControl.rows.length + 1),
      sales: Math.random() * 10000,
      expenses: Math.random() * 5000,
      data1: Math.random() * 1000,
      data2: Math.random() * 1000,
      data3: Math.random() * 1000,
      data4: Math.random() * 1000,
    },
    true,
  )
}

/**
 * 로우 삭제 버튼 클릭시 선택된 로우 삭제
 */
const removeRow = () => {
  grid.collectionView.remove(grid.collectionView.currentItem)
}
</script>
