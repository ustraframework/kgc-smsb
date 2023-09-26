DataMap 객체는 그리드에서 선택 데이터를 쉽게 선택할 수 있게 만들어주는 기능을 제공한다.
- 참고 : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.datamap.html

WjFlexGridColumn의 dataMap 속성은 생성된 DataMap이나 string 배열을 설정할 수 있으며, dataMap에 속성이 설정되고 isReadOnly 속성이 false 일 경우는 DataMap에 설정된 항목 내에서 선택이 가능하다.

직접 DataMap 인스턴스를 생성하여 사용할 수 있으며, Object 배열일 경우는 value 속성 명과 text 속성 명을 세팅하여 Map의 키 값을 설정하여 선택 시 활용하는 것이 가능하다.

```typescript
const customers = [
  { id: 0, name: 'Paul Perkins', address: '123 Main St' },
  { id: 1, name: 'Susan Smith', address: '456 Grand Ave' },
  { id: 2, name: 'Joan Jett', address: '789 Broad St' },
  { id: 3, name: 'Don Davis', address: '321 Shattuck Ave' },
]
const customerMap = new (useWijmoGrid().DataMap)(customers, 'id', 'name')
```
