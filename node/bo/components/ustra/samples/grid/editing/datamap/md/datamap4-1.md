### onCellEdited

useWijmoFlexGrid API에서 제공하는 editing.onCellEdited 핸들러를 등록하면 Row Editing 시에도 Cell 단위로 변화를 감지할 수 있다.
onCellEdited의 유형은 다음과 같다.
```typescript
/**
 * cell값 변경 시 발생되는 이벤트
 * - e: 변경된 Cell 이벤트 정보 (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.cellrangeeventargs.html)
 * - beforeValue : 변경 전 값
 * - afterValue : 변경 후 값
 */
onCellEdited?: (e: wijmoGrid.CellRangeEventArgs, beforeValue: any, afterValue: any) => void
```

DataMap의 경우, 항목을 선택한 후 Row를 이동해야만 변경 사항이 적용되므로 선택과 동시에 Commit을 수행하려면 다음 코드와 같이 editing.restartEdit() 메소드를 호출하여 선택과 동시에 변경된 항목으로 추적할 수 있다.

```typescript
const grid = useWijmoFlexGrid({
  isReadOnly: false,
  onAfterInitialized() {
    grid.collectionView.trackChanges = true
  },
  editing: {
    onCellEdited(e, beforeValue, afterValue) {
      console.log('updated...', beforeValue, afterValue)

      grid.editing.restartEdit()
    },
  },
})
```
