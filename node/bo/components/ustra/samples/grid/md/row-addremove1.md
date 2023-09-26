> grid 컨트롤 collectionView 의 addNew 메소드를 통해 로우를 추가한다.
> grid 컨트롤 collectionView 의 remove 메소드를 통해 로우를 제거한다.

```html
  <UButton @click="addRow" text="로우 추가"></UButton>
  <UButton @click="removeRow" text="로우 삭제"></UButton>

  <UButton @click="getGridData" text="전체 데이터 조회"></UButton>
  <UButton @click="getEditedGridData" text="수정 데이터 조회"></UButton>
  <UButton @click="getAddedGridData" text="추가 데이터 조회"></UButton>
  <UButton @click="getDeletedGridData" text="삭제 데이터 조회"></UButton>
  <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px" :allowDelete="true" :allowAddNew="true" :initialized="grid.initialize">
    <WjFlexGridColumn :header="'Seq'" :binding="'seq'" width="*" />
    <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
    <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Expenses'" :binding="'expenses'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data1'" :binding="'data1'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data2'" :binding="'data2'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data3'" :binding="'data3'" width="*" format="n2" aggregate="Sum" />
    <WjFlexGridColumn :header="'Data4'" :binding="'data4'" width="*" format="n2" aggregate="Sum" />
  </WjFlexGrid>
  수정 목록
  <WjFlexGrid :itemsSource="data.itemsEdited" style="max-height: 300px" :isReadOnly="true"></WjFlexGrid>
  추가 목록
  <WjFlexGrid :itemsSource="data.itemsAdded" style="max-height: 300px" :isReadOnly="true"></WjFlexGrid>
  삭제 목록
  <WjFlexGrid :itemsSource="data.itemsRemoved" style="max-height: 300px" :isReadOnly="true"></WjFlexGrid>


<script lang="ts" setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components'
import { wijmo } from '#ustra/nuxt-wijmo'

/**
 * Grid 객체 ref 처리
 */
const grid = useWijmoFlexGrid()

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


/**
 * 로우 추가 버튼 클릭시 랜덤 데이터 추가
 */
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

/**
 * Grid 전체 데이터 조회
 */
const getGridData = () => {
  console.log('##### getGridData #####\n', grid.rawControl.collectionView.items, data)
}

/**
 * Grid 수정 데이터 조회
 */
const getEditedGridData = () => {
  console.log('##### getEditedGridData #####\n', grid.collectionView.itemsEdited, data.itemsEdited)
}

/**
 * Grid 추가 데이터 조회
 */
const getAddedGridData = () => {
  console.log('##### getAddedGridData #####\n', grid.collectionView.itemsAdded, data.itemsAdded)
}

/**
 * Grid 삭제 데이터 조회
 */
const getDeletedGridData = () => {
  console.log('##### getDeletedGridData #####\n', grid.collectionView.itemsRemoved, data.itemsRemoved)
}
</script>

```
