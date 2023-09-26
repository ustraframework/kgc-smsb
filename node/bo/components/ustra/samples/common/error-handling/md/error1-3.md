```typescript
function errorCase2() {
  return useOnError(
    (text: string) => {
      throw new Error('에러 발생')
    },
    {
      message: '에러가 발생하였습니다.',
    },
  )('text')
}
```
