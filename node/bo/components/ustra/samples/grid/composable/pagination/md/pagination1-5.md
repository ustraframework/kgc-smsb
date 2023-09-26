아래와 같은 방법을 활용하여 전체 UPaginationBar 컴포넌트에 동일한 모드값을 설정할 수 있다. 

1) nuxt.config
```typescript
export default defineNuxtConfig({
  ustra: {
    nuxt: {
      components: {
        UPaginationBar: {
          showStartEndButtons: true
        }
      }
    }
  }
})
```

2) plugin
```typescript
$ustra.components.setComponentsOptions('UPaginationBar', { showStartEndButtons: true })
```
