useOnError 메소드는 실행 메소드에서 exception이 발생했을 때 처리 동작을 정의할 수 있는 메소드이며, 다음과 같은 인자 값을 받는다.


| name | 유형 | 설명 |
| --- | --- | --- |
| fn | Funciton | 실행할 메소드 function |
| option  | object | 에러를 핸들링 처리하는 option (optional) |

option은 다음과 같은 값을 설정할 수 있다.

| name | 유형 | 설명 | 기본값 |
| --- | --- | --- | --- |
| notifyType | 'alert' ｜ 'toast' ｜ 'redirect'  | 오류 발생 시 통지 유형을 정의한다.<br />- alert : 경고 메시지 노출<br />- toast : toast 메시지 노출<br />- redirect : 지정된 경로로 이동 | 'alert' |
| throwError  | boolean | 에러 throw 여부.<br />true 설정 시, 전역 예외 처리 영역으로 에러가 전달된다.  | false |
| message  | ((err: Error) => string) ｜ string | 노출 시, 노출할 에러 메시지를 정의한다.  |  |
| onError  | (err: Error) => void ｜ Promise<void> ｜ string | 에러 발생 시, 후속 처리 핸들러  |  |
| logging  | boolean | 로그를 작성할지 여부를 설정  | true |
| statusCode  | number | Redirect할 경우, Http 상태 코드를 정의한다.  | 500 |
| path  | string | Redirect 시 이동할 경로  |  |

