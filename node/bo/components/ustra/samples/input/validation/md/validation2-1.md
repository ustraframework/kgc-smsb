컴포넌트의 validation prop 설정을 통해 Rule을 설정할 수 있다.
rule은 Object 유형에 rules array를 추가한다.
```html
<!-- 필수 체크 Rule 설정 -->
<WjInputMask :validation="{ rules: ['required'] }" />

<!-- 필수 및 이메일 Rule 설정 -->
<WjInputMask :validation="{ rules: ['required', 'email'] }" />


<!-- 메시지 설정 -->
<WjInputMask :validation="{ rules: [
  { type: 'required', message: '필수 입력 값 입니다.' }, 
  { type: 'email', message: '정확한 이메일을 입력하십시오.'}
]}" />

<!-- Custom Rule 설정 -->
<WjInputMask :validation="{ rules: [
  (value, component) => {
    if (value !== '10') {
      return '10을 입력하세요.'
    }
    return true
  }
]}" />

<!-- Custom Rule 설정 delay 옵션-->
<WjInputMask :validation="{ rules: [
  {type: 'custom', delay: 200, handler: (value, component) => {
    if (value !== '10') {
      return '10을 입력하세요.'
    }
    return true
  }
  }
  
]}" />

```
