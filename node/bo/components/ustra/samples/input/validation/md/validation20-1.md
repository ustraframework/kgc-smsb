Wijmo를 사용하지 않는 Vuetify 프로젝트에서는 다음과 같이 컴포넌트를 참조한다.

```typescript
import { UValidationGroup } from '#ustra/nuxt-vuetify/components'
// or 
import { UValidationGroup } from '#components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
```
