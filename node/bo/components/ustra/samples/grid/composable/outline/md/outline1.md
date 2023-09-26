useWijmoFlexGrid 메소드는 Wijmo Flex Grid 객체를 쉽게 사용할 수 있는 Composable API 메소드이다.
auto import되어 있는 메소드이며, 기본 사용법은 다음과 같이 사용한다.

```typescript
const grid = useWijmoFlexGrid()
```
위와 같이 선언된 변수는 initialize 메소드를 객체로 감싸 반환하며, 해당 메소드를 사용하여 Grid 객체의 intialized 메소드 핸들러로 등록해야 한다.

```html
<template>
  <!-- 반드시 아래와 같이 initialized 속성을 매핑해야 한다. -->
  <WjFlexGrid :initialized="grid.initialize" />
</template>
<script lang="ts" setup>
import { WjFlexGrid } from '#ustra/nuxt-wijmo/components'

const grid = useWijmoFlexGrid()
</script>
```

#### Option
useWijmoFlexGrid 메소드는 첫번째 인자로 object 유형의 옵션 설정이 가능하다.

```typescript
// option 설정
const grid = useWijmoFlexGrid({
  // 초기화 이후 실행할 로직 수행
  onAfterInitialized(control) {
    $ustra.logger.info('grid init...')
  }
})
```

옵션은 각 사용 기능과 지원 이벤트에 따라 추가 기능에 대한 설정을 통해 미리 정의된 기능을 사용할 수 있다. 각 지원 옵션에 대한 상세 SPEC은 아래 링크를 확인한다.
(http://guide.ustraframework.kro.kr/docs/node/3.0/nuxt-wijmo/interfaces/composables_grid.WijmoFlexGridOption.html)





#### Return
메소드는 옵션 설정에 따라 각 영역의 데이터 또는 객체를 반환한다. 예를 들어 Wijmo Flex Grid 객체는 다음과 같이 접근하여 사용할 수 있다.
```typescript
const grid = useWijmoFlexGrid({})
// wijmo control 객체
grid.control.value
```

다음은 기본적으로 노출되는 속성 목록이다.
- control : Flex Grid 객체 : Ref로 매핑됨. (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html)
- rawControl : Flex Grid Raw 객체 (https://www.grapecity.com/wijmo/api/classes/wijmo_grid.flexgrid.html)
- collectionView : Flex Grid collectionView 객체 (https://www.grapecity.com/wijmo/api/classes/wijmo.collectionview.html#addnew)
- option : 메소드 호출 시 설정한 option. 반응형 객체이므로 값 변경 시, 일부 기능을 옵션 설정이 실시간으로 변경된다.

그 외의 반환 값은 각 샘플 항목을 참고토록 한다.


#### 기본 값 설정
useWijmoFlexGridDefaultOption 메소드를 사용하여, useWijmoFlexGrid 에서 사용되는 기본 옵션 값을 변경할 수 있다. 전역 기본 설정 값을 바꾸게 되므로 플러그인 또는 app.vue 컴포넌트에서 호출하여 사용한다.
```typescript
export default defineNuxtPlugin(nuxtApp => {
  useWijmoFlexGridDefaultOption({
    emptyText: 'No Data',
  })
})
```
