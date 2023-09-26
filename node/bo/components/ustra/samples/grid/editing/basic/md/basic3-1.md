그리드 컴포넌트에서 제공하는 에디팅 관련 대표적인 이벤트는 다음과 같다.
- beginningEdit : 에디팅을 하기 전에 발생하는 이벤트로 특정 조건에 의해 에디팅을 취소처리 할 수 있다. (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html#beginningedit)
- cellEditEnding : 에디팅을 완료하고 데이터에 저장되기 전에 발생되는 이벤트로 입력 값의 검증을 확인하여 입력을 취소하거나 에디팅 모드를 유지하는 등의 액션을 처리할 수 있다. (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html#celleditending)
- cellEditEnded : 에디팅이 완료되어 데이터가 변경된 시점에 호출되는 이벤트로 데이터 변경 후, 후속 처리를 수행한다.

아래 예제를 보면 다음과 위 3개의 이벤트를 사용하여 입력 데이터의 제어와 동기화 등을 처리하고 있다.
- beginningEdit : editable 항목이 체크되지 않을 경우, 편집을 취소 처리
- cellEditEnding : 입력된 값이 없을 경우, 편집 모드 유지 처리
- cellEditEnded : 동일한 country를 가진 row 데이터를 조회하여 변경된 값으로 동기화하고, 그리드를 refresh
