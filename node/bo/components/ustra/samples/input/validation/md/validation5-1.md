Validation 결과를 boolean 또는 string이 아닌 object 형태로 반환할 경우, validation 처리를 세부적으로 제어할 수 있다. 설정할 수 있는 정보는 다음과 같다.

| 속성 | 유형 | 설명 |
| --- | --- | --- |
| isValid | boolean | 검증 결과를 true/false로 설정 |
| message | string | 실패 시, 노출할 메시지 |
| onValidated | (result:boolean) => void | Validation 완료 시, result 인자 값에 결과와 함께 호출되는 Callback function. Validation 완료 시, 추가적인 설정을 진행할 수 있다. |
| onInit | () => void | Validation 초기화 시 호출되는 Callback function |
| els | HTMLElement[] | Validation 메시지가 표시될 HTML Element 목록 |


