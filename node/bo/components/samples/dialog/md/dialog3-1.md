confirm 창은 useConfirm 메소드를 사용한다. 메소드의 원형은 다음과 같다.

```typescript
function useConfirm(message: string, title?: string, caption: string = '확인안내', confirmButtonName = '확인') : Promise<boolean>
```

설정할 수 있는 인자 값은 다음과 같다.
- message : small 메시지
- title : big 메시지
- caption : 창의 제목
- confirmButtonName : 확인 버튼 명


