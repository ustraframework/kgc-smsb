```typescript
function errorCase3() {
  return useOnError(
    (text: string) => {
      throw new Error('정보를 상세하게 입력해주세요.')
    },
    {
      message: err => `에러 발생 (${err.message})`,
    },
  )('text')
}
```
