> onMounted 시점에 dragstart 와 drop 이벤트 리스너를 등록하여 drop 이벤트에서 변경내용을 반영한다.
> - dragstart : drag 시작 시점의 row 정보 추출
> - drop : drop 대상의 row 정보를 추출하고 필요한 경우 row 데이터를 수정한며, 해당 가이드에서는 seq 항목을 row 순서로 변경하는 부분이 구현되어 있다.

```html
  <UButton @click="getGridData" text="전체 데이터 조회"></UButton>
  <UButton @click="getEditedGridData" text="수정 데이터 조회"></UButton>
  <UButton @click="getAddedGridData" text="추가 데이터 조회"></UButton>
  <UButton @click="getDeletedGridData" text="삭제 데이터 조회"></UButton>

  <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px" allowDragging="Rows" :allowDelete="true">
    <WjFlexGridColumn :header="'Seq'" :binding="'seq'" width="*" />
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data1'" :binding="'data1'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data2'" :binding="'data2'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data3'" :binding="'data3'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data4'" :binding="'data4'" width="*" format="n2" aggregate="Sum" />
  </WjFlexGrid>

  수정목록
  <WjFlexGrid :itemsSource="data.itemsEdited" style="max-height: 300px" :isReadOnly="true"></WjFlexGrid>
  추가목록
  <WjFlexGrid :itemsSource="data.itemsAdded" style="max-height: 300px" :isReadOnly="true"></WjFlexGrid>
  삭제목록
  <WjFlexGrid :itemsSource="data.itemsRemoved" style="max-height: 300px" :isReadOnly="true"></WjFlexGrid>

<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '@grapecity/wijmo.vue2.grid'
import * as wijmo from '@grapecity/wijmo'
import { ref, onMounted } from 'vue'
import { max, min, toInteger } from 'lodash'

//#region Grid 초기 설정
/**
 * Grid 객체 ref 처리
 * <script> 내에서는 grid.value.control 로 접근
 * <template> 내에서는 grid.control 로 접근
 */
const grid = ref()

/**
 * 마운트시 Drag&Drop 이벤트 구성
 */
onMounted(() => {
  /**
   * Drag 시작 이벤트 리스너 등록
   */
  grid.value.control.addEventListener(grid.value.control.hostElement, 'dragstart', e => {
    // Drag 시작한 Grid의 row 번호 보관
    e.dataTransfer.setData('dragIndex', grid.value.control.hitTest(e).row)
  })

  /**
   * Drop 이벤트 리스너 등록
   */
  grid.value.control.addEventListener(grid.value.control.hostElement, 'drop', e => {
    // Drag 시작한 Grid Index, Drop 대상의 Grid Row Index 추출
    const dragIndex = toInteger(e.dataTransfer.getData('dragIndex'))
    const dropIndex = grid.value.control.hitTest(e).row
    const indexArr = [dragIndex, dropIndex]

    // Drag & Drop 을 통해 변경된 Grid 데이터 순서를 collectionView에 변경 적용
    // 이후 변경된 collectionView.items 조회를 위해 beginUpdate, endUpdate 사이에 구성
    grid.value.control.collectionView.beginUpdate()
    const arr = grid.value.control.collectionView.sourceCollection
    const item = arr[dragIndex]
    arr.splice(dragIndex, 1)
    arr.splice(dropIndex, 0, item)
    grid.value.control.collectionView.endUpdate()

    // Drag 시작 Grid Row Index 와 Drop 대상 Grid Row Index 내의 모든 데이터의 seq 항목 수정
    grid.value.control.collectionView.items.forEach((item, index) => {
      if (index >= min(indexArr) && index <= max(indexArr)) {
        grid.value.control.collectionView.editItem(item)
        item.seq = index + 1
        grid.value.control.collectionView.commitEdit()
      }
    })
  })
})

/**
 * 샘플용 Grid Data 생성
 * @param cnt Grid Row 카운트
 */
const _getData = (cnt: Number) => {
  // create some random data
  const data = []

  for (let i = 0; i < cnt; i++) {
    data.push({
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

  // Grid 데이터 변경내용 추적을 위해 wijmo 객체에 추적 옵션 적용하여 반환
  return new wijmo.CollectionView(data, {
    trackChanges: true,
  })
}
/**
 * grid itemsSource 에 매핑하는 data 값
 */
const data = _getData(5)
//#endregion

/**
 * Grid 전체 데이터 조회
 */
const getGridData = () => {
  console.log('##### getGridData #####\n', grid.value.control.collectionView.items, data)
}

/**
 * Grid 수정 데이터 조회
 */
const getEditedGridData = () => {
  console.log('##### getEditedGridData #####\n', grid.value.control.collectionView.itemsEdited, data.itemsEdited)
}

/**
 * Grid 추가 데이터 조회
 */
const getAddedGridData = () => {
  console.log('##### getAddedGridData #####\n', grid.value.control.collectionView.itemsAdded, data.itemsAdded)
}

/**
 * Grid 삭제 데이터 조회
 */
const getDeletedGridData = () => {
  console.log('##### getDeletedGridData #####\n', grid.value.control.collectionView.itemsRemoved, data.itemsRemoved)
}
</script>



```
