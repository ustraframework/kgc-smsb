UDaumPostPopup 컴포넌트를 사용하여 Daum 주소 창과 연계한 주소지 검색 기능을 사용할 수 있다. 
UDaumPostPopup 컴포넌트는 auto import를 통해 제공되며, 수동으로 import할 경우 다음 코드와 같이 한다.
```typescript
import UDaumPostPopup from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'
```

또한 Daum 주소창 연동을 위한 다음과 같은 객체를 제공한다.
- DaumPostResult : 주소창 연동 결과 값 interface
- DaumPostScreenOptions : 주소창 연동 옵션 interface
- openDaumPostScreen : Daum 주소창 Embeded를 처리하는 API
```typescript
import { DaumPostResult, DaumPostScreenOptions, openDaumPostScreen } from '#ustra/nuxt/externals/daum/post'
```
