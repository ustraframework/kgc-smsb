mode 설정을 'Check'로 설정하면 체크 박스 형태로 그리드를 선택할 수 있다. 
이 때는 다음과 같은 값을 추가적으로 수신 받아 사용할 수 있다.
- checkSelection.rows : 체크된 Row 목록 (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.row.html)
- checkSelection.rowsData : 체크된 Row의 데이터 목록
- checkSelection.selector : Selector 객체 (https://www.grapecity.com/wijmo/api/classes/wijmo_grid_selector.selector.html)


SelectionMode는 enum으로 정의되어 있으므로 옵션 설정 시 다음과 같이 SelectionMode 객체를 import 하여 사용한다.

```typescript
const grid = useWijmoFlexGrid<Country>({
  selection: {
    mode: 'Check',
  },
})

// 체크 Row 목록
grid.checkSelection.rows

// 체크 Row 데이터 목록
grid.checkSelection.rowsData

// 체크 Selector 객체
grid.checkSelection.selector
```

Check된 Row 또는 데이터를 기반하여 조작 가능한 메소드를 추가 제공한다.
- checkSelection.removeRows : 선택된 Row 목륵을 제거한다.

삭제 버튼은 다음과 같이 구현할 수 있다.
```html
<UButton text="체크 Row 삭제" @click="grid.checkSelection.removeRows" :disabled="grid.checkSelection.rows.value.length < 1"></UButton>
```
