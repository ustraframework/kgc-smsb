데이터를 바인딩하는 기능에 대해 설명한다. <br />
WjFlexGrid 컴포넌트를 사용하여 그리드 객체를 정의하고, WjFlexGridColumn 컴포넌트를 사용하여 각 컬럼을 정의할 수 있다. 높이를 지정할 때는 style을
사용하여 지정한다. WjFlexGridColumn을 통해 설정할 수 있는 항목은 다음과 같다.

- header : 컬럼의 헤더 노출 명
- binding : 바인딩할 Object의 키 명
- width : 넓이 (넓이는 숫자 또는 문자형태로 설정할 수 있으며 "*" 문자를 사용하여 배율을 지정할 수 있다.) - https://www.grapecity.com/wijmo/api/classes/wijmo_grid.column.html#width


관련 상세 API는 다음 링크를 참조한다.
- FlexGrid API : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html
- Column API : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.column.html


그리드에 데이터를 바인딩하는 방법은 2가지로 나눌 수 있는데 데이터를 바로 itemsSource에 설정하는 방법과 Collection View를 사용하는 방법이 있다.
Wijmo Grid는 itemsSource에 배열이 유입될 경우, 내부적으로 CollectionView 객체를 만들므로 결국에는 CollectionView 형태로 데이터를 관리한다. CollectionView는 Collection 유형의 데이터 목록을 관리하는 객체로 데이터의 바인딩 뿐만 아닌 조작과 이벤트 등 여러 기능을 제공한다.
- CollectionView API : https://www.grapecity.com/wijmo/api/classes/wijmo.collectionview.html


다음 예제는 배열을 바로 itemsSource에 바인딩하는 예제이다.
