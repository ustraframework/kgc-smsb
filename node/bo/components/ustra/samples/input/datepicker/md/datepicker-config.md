
아래와 같은 방법을 활용하여 전체 UDatepicker 컴포넌트에 동일한 모드값을 설정할 수 있다. 

- 설정 가능 모드
  1. showMonthLabel : '월' 표시 활성화 여부
  2. weekStart: 시작 요일 지정 0-6까지 지정 가능, 0은 일요일, 6은 토요일이다.


1) nuxt.config
```typescript
export default defineNuxtConfig({
  ustra: {
    nuxt: {
      components: {
        UDatepicker: {
          showMonthLabel: false,
          weekStart: 1
        }
      }
    }
  }
})
```

1) plugin
```typescript
$ustra.components.setComponentsOptions('UDatepicker', { showMonthLabel: false })
$ustra.components.setComponentsOptions('UDatepicker', { weekStart: 1 })
```
