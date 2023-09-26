```typescript
function errorCase1() {
  return useOnError((text: string) => {
    throw new Error('에러 발생')
  })('text')
}
```
