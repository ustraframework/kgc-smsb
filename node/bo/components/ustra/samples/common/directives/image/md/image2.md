이미지 경로의 경우, nuxt.config와 플러그 인에서 기본 설정을 세팅할 수 있다.

```typescript

// 플러그인
export default defineNuxtPlugin(nuxtApp => {
  nuxtApp.$ustra.env.appProps.nuxt.directives.image.defaultNotFoundImagePath = '/ustra-sample-resources/img/not-found.jpg'
})


// nuxt config
export default defineNuxtConfig({
  ustra: {
    nuxt: {
      directives: {
        image: {
          defaultNotFoundImagePath: '/ustra-sample-resources/img/not-found.jpg'
        }
      }
    }
  }
})
```
