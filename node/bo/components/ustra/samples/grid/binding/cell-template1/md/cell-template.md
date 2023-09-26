CellTemplate을 사용하여 커스톰 유형의 데이터 또는 컴포넌트를 표시할 수 있다. 
- WjFlexGridCellTemplate API : https://www.grapecity.com/wijmo/api/classes/wijmo_angular_grid.wjflexgridcelltemplate.html

WjFlexGridCellTemplate 컴포넌트의 cellType 속성은 CellTemplateType enum으로 정의되어 있으며 각 컬럼의 cell 유형에 따른 템플릿을 지정할 수 있는 필수적으로 숙지해야 할 속성이다.
- BottomLeft : Grid의 컬럼 Footer, Row Header 영역)
- Cell : 컬럼의 데이터 노출 Cell
- CellEdit : 에디팅 모드의 데이터 Cell
- ColumnFooter : 컬럼의 하단 집계 영역
- Group : Grouping Row 영역
- GroupHeader : Grouping을 세팅할 수 있는 Header 영역
- RowHeader : Row Header (가장 왼쪽에 위치) Cell
- RowHeaderEdit : Row Header가 에디팅 모드 일 때의 Cell
- TopLeft : Top Left 영역의 Cell

위의 유형 중 TopLeft, BottomLeft, RowHeader, RowHeaderEdit 유형은 그리드 별로 하나만 존재하거나 Row 단위로 존재하므로 WjFlexGrid 컴포넌트 하위에 위치하며 다른 항목은 WjFlexGridColumn 컴포넌트 하위에 위치해야 한다.
