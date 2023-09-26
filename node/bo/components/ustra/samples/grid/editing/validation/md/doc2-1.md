CollectionView의 getError 속성을 활용하여 유효성을 검사하는 방식이다.
- getError : https://www.grapecity.com/wijmo/api/classes/wijmo.collectionview.html#geterror

getError 속성은 특정 아이템의 값의 정상 여부를 확인할 수 있는 callback function을 지정할 수 있다. callback 메소드의 인자 값은 다음과 같다.
- item : row data 객체
- prop : 데이터의 binding 값
- parsing : 데이터 변환 과정에서 발생한 오류인지 여부

getError 속성을 통한 검증은 사용자가 직접 데이터를 입력했을 때는 검증에 실패하여도 데이터가 반영되지 않고 입력 컴포넌트에서 포커스가 유지되지만 임의로 데이터를 변경했을 때는 잘못된 입력 값이 들어갈 수 있다.
이 때는 editing.checkValidate 메소드를 사용하여 그리드의 모든 입력 값이 유효한지 확인할 수 있다.
