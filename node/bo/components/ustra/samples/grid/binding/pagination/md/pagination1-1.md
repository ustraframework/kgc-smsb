usePaginationCollectionView은 페이징 기능 만을 구현하기 위한 메소드이며, useWijmoFlexGrid 메소드를 사용한 페이징 구현은 ["Grid > Composable API > pagination"](/samples/grid-composable-pagination-index) 샘플을 참조한다.


usePaginationCollectionView API를 사용하여 그리드의 페이징 UI를 구현할 수 있다. usePaginationCollectionView 메소드는 다음과 같은 인자 값을 수신한다.
- handler : Function으로 유형은 다음과 같으며, 페이지 번호와 정렬 옵션을 수신하여 조회된 페이징 결과 값을 반환하는 객체를 구현한다.
  ```typescript
  (pageNo: number, orders: any[]) => Promise<{
    data: any[]
    totalRecords: number
  }>
  ```
  Object 유형의 Promise 값으로 각 항목은 다음과 같다.
  - data: 현재 페이지의 데이터 목록
  - totalRecords: 전체 데이터 갯수
- option : Object 유형으로 세부 옵션을 설정할 수 있다.
  - pageSize : 페이지 사이즈 ( 기본 값, 20 )
  - watchCurrentPage : 현재 페이지 watch 여부 / true로 설정될 경우 반환된 currentPageNo 값이 변경될 시 자동으로 설정된 페이지 조회를 수행 ( 기본 값, true )
  - sortOnServer : 서버 사이드 정렬 여부 / true로 설정 시, 정렬 속성이 변경될 경우 반환된 loadPageData function을 호출한다 .( 기본 값, true )

usePaginationCollectionView 메소드를 실행하면 다음과 같은 결과 값을 반환하며, 반환된 결과 값으로 페이징 처리를 수행하는 컴포넌트와 연계 처리를 한다.
- pageSize : (ref) 페이지 사이즈
- totalRecords : (ref) 총 레코드 수
- currentPageNo : (ref) 현재 페이지 번호
- collectionView : Wijmo Grid CollectionView 객체
- loadPageData : 페이지 데이터 조회 Function

페이지 Navigation을 위해 UPaginationBar 컴포넌트를 사용하며 다음과 같은 속성을 제공해야 한다.
- modelValue : 현재 페이지 번호
- pageSize : 페이지 사이즈
- totalRecords : 총 레코드 수
