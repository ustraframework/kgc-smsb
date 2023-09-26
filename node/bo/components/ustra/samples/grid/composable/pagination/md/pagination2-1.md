## Pagination 모드
### Infinite 모드

pagination.mode 속성을 'infinite'로 설정하면 스크롤 하단으로 이동할 경우, 다음 페이지 데이터를 조회하는 infinite scroll 형태의 
페이징 처리를 할 수 있다.

이 때 sortOnServer 옵션에 따라 기본적으로 정렬이 변경되면 첫페이지부터 정렬을 다시 하도록 설정된다.
sortOnServer 설정을 false로 할 경우, 조회된 데이터 영역 내에서 정렬이 처리된다.
