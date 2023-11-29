오류 alert 창은 useErrorAlert 메소드를 사용한다. 메소드의 원형은 다음과 같다.

```typescript
function useErrorAlert(message: string, title: string = '오류가 발생하였습니다.', caption: string = '오류 발생 안내') : Promise<void>
```

설정할 수 있는 인자 값은 다음과 같다.
- message : small 메시지
- title : big 메시지
- caption : 창의 제목


