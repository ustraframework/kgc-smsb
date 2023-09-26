API를 통해 실시간으로 데이터를 조회하여 아이템을 검색하는 경우는 itemsSource 속성 대신 itemsSourceFunction 속성을 사용한다.
itemsSourceFunction은 Function 유형의 값을 세팅할 수 있으며 메소드의 원형은 다음과 같다.
```typescript
const itemsSourceFunction = (query: string, max: number, callback: Function => void
```
- query : 검색 문자열
- max : 최대 결과 수
- callback : 조회가 완료되었을 경우, Callback Function

itemsSourceFunction은 다음과 같이 구현할 수 있다.
```typescript
function searchItems(query: string, max: number, callback: Function) {
  $ustra.api
    .call<{ userId: number; id: number; title: string; body: string }[]>({
      url: 'https://jsonplaceholder.typicode.com/posts',
      showLoadingBar: false,
    })
    .then(result => {
      callback(!query ? result.data : result.data.filter(data => data.title.includes(query)).slice(0, max))
    })
}
```
