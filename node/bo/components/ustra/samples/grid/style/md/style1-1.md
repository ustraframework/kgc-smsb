Row의 Style은 Row Element가 생성된 이후 수행되는 loadedRows 이벤트 상에서 Row 객체의 cssClass 속성을 변경하여 적용할 수 있다.

- loadedRows : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html#loadedrows
- Rows : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.row.html
- cssClass : https://www.grapecity.com/wijmo/api/classes/wijmo_grid.row.html#cssclass

아래의 예제는 사원수가 70보다 크면, high-emp-company 클래스를 추가하고 30보다 작을 경우 low-emp-company 클래스를 추가하는 예제이다.
