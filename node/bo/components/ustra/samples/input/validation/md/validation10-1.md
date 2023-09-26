onValidationChanged 속성을 Validaiton을 수행하는 컴포넌트에 세팅하면 Validaiton 정보가 변경되었을 때, 커스톰 로직을 처리할 수 있는 핸들러를 구현할 수 있다. onValidationChanged 핸들러의 원형은 다음과 같다.
```typescript
/**
 * isValid : 유효성 확인 성공 여부
 * message : 실패 시의 메시지
 */
(isValid:boolean, message: string) => void
```

Vuetify 컴포넌트에서는 input 컴포넌트에 errorMessages 속성이 존재하므로 특정 값을 매핑하여 오류 메시지를 표시하는 기능을 사용할 수 있다.
```html
<VTextField
  v-model="inputData.value1"
  :errorMessages="inputData.validationMessage1"
  :onValidationChanged="(isValid, message) => (inputData.validationMessage1 = message)"
  :validation="{ rules: ['required'] }"
/>
```
