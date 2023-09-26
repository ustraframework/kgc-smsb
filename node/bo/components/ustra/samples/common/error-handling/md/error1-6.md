```typescript
function errorCase5() {
  return useOnError(
    (text: string) => {
      throw new Error('정보를 상세하게 입력해주세요.')
    },
    {
      notifyType: 'redirect',
      path: '/',
    },
  )('text')
}
```
