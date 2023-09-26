onCellDblClick 속성에 핸들러를 설정하면 그리드 Cell 클릭 시의 이벤트를 수신할 수 있다. 핸들러 Spec은 다음과 같다.
```typescript
/**
 * cell click 이벤트
 * - col : click column index
 * - row : click row index
 * - data : click row data
 * - e : MouseEvent
 * - hitTestInfo : HitTestInfo Object (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.hittestinfo.html)
 */
onCellDblClick?: (col: number, row: number, data: Data, e: MouseEvent, hitTestinfo: HitTestInfo) => void | Promise<void>
```

```typescript
const grid = useWijmoFlexGrid<Country>({
  onCellDblClick: function (col, row, data) {
    alert(`col: ${col}\n row: ${row}\n data: ${JSON.stringify(data)}`)
  },
})
```
