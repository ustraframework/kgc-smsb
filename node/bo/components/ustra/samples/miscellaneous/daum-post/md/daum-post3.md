주소 검색 후, 위/경도를 조회하기 위해서는 Kakao API와 연계가 필요하다. Kakao API 연계를 위해서는 API 키를 발급받아야 한다.
- 카카오 개발자 등록 : https://developers.kakao.com/

다음의 순서로 진행한다.
1) 계정으로 로그인
2) 내 어플리케이션 메뉴에서 어플리케이션 추가
3) 생성된 어플리케이션에서 플랫폼 메뉴로 이동
4) Web 플랫폼 등록
5) 사이트 도메인 등록

앱 키 메뉴로 이동하여 JavaScript 키를 API 키로 사용한다.

위와 같이 발급받은 API 키는 nuxt.config, 플러그인, 컴포넌트 속성으로 설정할 수 있다.

1) nuxt.config
```typescript
export default defineNuxtConfig({
  ustra: {
    nuxt: {
      components: {
        UDaumPostPopup: {
          apiKey: '발급받은 API Key'
        }
      }
    }
  }
})
```

2) plugin
```typescript
$ustra.components.setComponentsOptions('UDaumPostPopup', { apiKey: '발급받은 API Key' })
```

3) 컴포넌트
```html
<UDaumPostPopup v-model="showPopup" :addLatLng="true" apiKey="발급받은 API Key" />
```

addLatLng 속성을 true로 설정하고, apiKey를 세팅하면 주소 조회 후 위경도를 확인하며 결과 값에 다음과 같은 항목에 추가된다.
- lat : 경도 (number)
- lng : 위도 (number)


```html
<template>
  <UButton text="주소창 오픈" @click="showPopup = true" />
  <UDaumPostPopup v-model="showPopup" :addLatLng="true" @selected="result => (postResult = result)" />
  
  <v-chip class="ma-2" color="pink" label text-color="white" v-if="postResult">
    <v-icon start icon="mdi-label"></v-icon>
    위도 : {{ postResult.lat }} 경도 : {{ postResult.lng }}
  </v-chip>
</template>
<script lang="ts" setup>
import { DaumPostResult } from '#ustra/nuxt/externals/daum/post'
import UDaumPostPopup from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'

const showPopup = ref(false)
const postResult = ref<DaumPostResult>(null)
</script>
```
