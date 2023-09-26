CheckBox Selection을 제어하기 위해서는 useWijmoFlexGrid 메소드에서 반환하는 checkSelection 객체 내의 메소드를 사용하여 제어할 수 있다. 다음과 같은 메소드를 제공한다.
- checkRows : 지정된 row 번호 목록을 선택한다.
  - rows : number[] => 선택할 row 번호 목록
  - clear(optional, default false) => 지정된 rows 외의 항목은 check 해제
- checkAll : 모든 항목을 선택한다.
- uncheckAll : 모든 항목을 비선택한다.
  
