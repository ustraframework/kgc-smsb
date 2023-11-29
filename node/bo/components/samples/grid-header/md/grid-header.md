### 유니코드 이모지 적용

아래 예제를 참고하여 BO, PO 프로젝트에 활용되는 그리드에서 수정 가능한 그리드 열에 useEditableHeader() Composable API를 활용하여 이모지를 헤더 스타일을 적용한다.

```html
<WjFlexGridColumn :header="useEditableHeader('Header')" :isReadOnly="false">
</WjFlexGridColumn>
```
