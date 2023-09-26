useWijmoFlexGrid API를 사용하여 그리드의 페이징 UI를 구현할 수 있다. (usePaginationCollectionView 메소드 또한 동일한 기능을 구현할 수 있지만 useWijmoFlexGrid API는 몇가지 추가 기능을 더 제공한다.)
useWijmoFlexGrid의 pagination 속성에 페이징 관련 옵션을 추가할 수 있다.
- handler : PaginationHandler 인터페이스 유형은 원형은 다음과 같으며, 현재 페이지 번호, 페이지 사이즈, 정렬 옵션을 수신하여 조회된 페이징 결과 값을 반환하는 객체를 구현한다.
```typescript
export type PaginationHandler<Data> = (
/**
 * 현재 페이지 번호
  */
currentPage: number,

/**
 * 페이지 사이즈
  */
pageSize: number,

/**
 * 정렬 옵션
  */
orders: paginationModels.Order[],
) => Promise<{
  /**
  * 데이터 목록
  */
  data: Data[]

  /**
  * 총 건수
  */
  totalRecords: number
}>
```
  결과 값은 Object 유형의 Promise 값으로 리턴해야 하며 일반적으로 API 호출 후 결과 값을 다음과 같은 유형으로 반환한다.
  - data: 현재 페이지의 데이터 목록
  - totalRecords: 전체 데이터 갯수

그 외의 추가 옵션은 다음과 같다.
  - mode : 페이징 모드를 세팅한다. (normal, infinite)
  - pageSize : 페이지 사이즈 ( 기본 값, 20 )
  - watchCurrentPage : 현재 페이지 watch 여부 / true로 설정될 경우 반환된 currentPageNo 값이 변경될 시 자동으로 설정된 페이지 조회를 수행 ( 기본 값, true )
  - sortOnServer : 서버 사이드 정렬 여부 / true로 설정 시, 정렬 속성이 변경될 경우 반환된 loadPageData function을 호출한다 .( 기본 값, true )

useWijmoFlexGrid 메소드를 실행하면 다음과 같은 결과 값을 반환하며, 반환된 결과 값으로 페이징 처리를 수행하는 컴포넌트와 연계 처리를 한다.
- pagination.pageSize : (ref) 페이지 사이즈
- pagination.totalRecords : (ref) 총 레코드 수
- pagination.currentPageNo : (ref) 현재 페이지 번호
- pagination.collectionView : Wijmo Grid CollectionView 객체
- pagination.loadPageData : 페이지 데이터 조회 Function

페이지 Navigation을 위해 UPaginationBar 컴포넌트를 사용하며 다음과 같은 속성을 제공해야 한다.
- modelValue : 현재 페이지 번호
- pageSize : 페이지 사이즈
- totalRecords : 총 레코드 수
