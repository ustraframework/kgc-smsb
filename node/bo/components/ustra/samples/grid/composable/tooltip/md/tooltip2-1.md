modifyTooltipText 속성을 사용하여 표시되는 tooltip 문자열을 수정할 수 있다. modifyTooltipText 속성의 원형은 다음과 같다.

```typescript
{
  /**
   * tool 텍스트 변경 핸들러
   *  - grid : FlexGrid 객체
   *  - e : FormatItemEventArgs 객체 (http://demo.grapecity.co.kr/wijmo/api/classes/wijmo_grid.formatitemeventargs.html)
   *  - text : Grid Cell Text
   */
  modifyTooltipText?: (grid: FlexGrid, e: FormatItemEventArgs, text: any) => string
}
```

다음과 같은 총 3개의 인자 값을 전달한다.
- grid : FlexGrid Instance 객체
- e : FormatItemEventArgs (http://demo.grapecity.co.kr/wijmo/api/classes/wijmo_grid.formatitemeventargs.html 참고)
- text : 해당 Cell에 표시활 text 객체
