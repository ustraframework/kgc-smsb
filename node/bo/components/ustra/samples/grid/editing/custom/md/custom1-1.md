WjFlexGridCellTemplate을 사용한 Custom Editor 기반의 입력 방법에 대해 안내한다.
WjFlexGridCellTemplate 컴포넌트는 cellType 속성을 지원하며 CellEdit를 설정하면 에디터 입력 시 설정한 Editor가 노출된다.

주의해야 할 점은 v-model로 형태의 양방향 바인딩을 하거나 이벤트 등을 통하여 에디터의 데이터 겂을 임의로 반영하는 코드가 작성되어야 한다.
