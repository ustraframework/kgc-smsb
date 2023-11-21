일반 alert 창은 useAlert 메소드를 사용한다. 메소드의 원형은 다음과 같다.

```typescript
function useAlert(message: string, title?: string, caption: string = '안내') : Promise<void>
```

설정할 수 있는 인자 값은 다음과 같다.
- message : small 메시지
- title : big 메시지
- caption : 창의 제목


