### 서버 로직
서버에서 엑셀을 생성할 때는 파일 모듈에서 제공하는 DataToExcelWebResourceConverter를 사용하여 변환한다.
- 참고 : http://guide.ustraframework.kro.kr/ref-doc/02/6r1KCmC8u357dFoFl4go#DataToExcelWebResourceConverter

DataToExcelWebResourceConverter를 사용할 때는 모든 데이터를 한 번에 조회하여 엑셀 생성을 처리하거나 순차적으로 데이터를 조회하여 엑셀 파일을 생성하는 방법을 사용할 수 있다. 변환 해야 하는 데이터 양이 많을 경우는 후행 형태로 처리해야 한다.

위의 ExcelCreationController의 downloadExcel 메소드는 엑셀 파일을 모두 조회한 후 엑셀 파일을 변환하며 downloadExcelWithProvider 메소드는 페이지 별로 데이터를 순차적으로 조회하여 엑셀 변환을 수행한다.

엑셀 변환 시에 서버 상에서는 코드 성 데이터를 조회할 때 Raw한 코드 값을 조회하게 되므로 그리드에서 구현했던 로직과 동일하게 데이터를 conversion하여 매핑해야 한다. ExcelCreationController 소스코드에서 이런 데이터를 매핑하는 로직을 살펴볼 수 있다.

- 대용량 엑셀 생성 : http://guide.ustraframework.kro.kr/ref-doc/02/2XWzrAzF9mJT108rZLbj


### 클라이언트 로직
클라이언트에서는 $ustra.api.downloadFile 메소드를 사용하여 API를 호출한다.
API 호출 시 cellInfo 정보를 그리드와 동일하게 사용하기 위해 grid.export.createExcelCellInfo 메소드를 호출하여 그리드에 세팅되어 있는 정보와 동일하게 Cell 정보를 생성할 수 있다.
그 외 조건은 일반 API를 호출할 때와 동일하게 입력하면 된다.
CellInfoModel 등 엑셀 변환에 대한 정보는 아래 링크를 참조한다.
- 엑셀 생성 : http://guide.ustraframework.kro.kr/ref-doc/02/0TMdOfxVBEFqb8VBzPnt


