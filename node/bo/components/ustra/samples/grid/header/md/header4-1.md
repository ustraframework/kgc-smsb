그리드의 컴포넌트의 formatItem 이벤트를 사용하여 header HTML Element가 생성된 시점에 호출되는 handler를 등록할 수 있으며, header column 등의 element에 직접 접근하여 Element 속성을 변경할 수 있다.
- formatItem : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html#formatitem

아래의 예제는 useWijmoFlexGrid 메소드를 사용하여 초기화 시에 formatItem 이벤트 핸들러를 추가하고, Colum Header일 때 컬럼의 정렬을 center로 설정하는 예제이다.
