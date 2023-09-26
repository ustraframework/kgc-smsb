WjAutoComplete 컴포넌트를 사용하여 Combo Box 형태의 선택 박스를 사용할 수 있다. AutoComplete는 검색 기능을 제공하므로 이를 활용하여 등록된 아이템을 검색하여 선택하는 기능을 제공한다.
- Demo : https://www.grapecity.com/wijmo/demos/Input/AutoComplete/Overview/vue
- AutoComplete Class : https://www.grapecity.com/wijmo/api/classes/wijmo_input.autocomplete.html

상세한 속성은 위의 AutoComplete Class 링크를 통해 확인할 수 있다. 주로 사용되는 Props는 다음과 같다.
| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| caseSensitiveSearch | boolean | 대소문자를 구분하여 검색한다. | false |
| beginsWithSearch  | boolean | 시작 문자가 일치하는 영역만 검색한다. | false |
| isAnimated | boolean ｜ 애니메이션 효과를 추가한다. | false |
| delay | number ｜ 검색 키 입력 시, 검색 수행 delay를 ms 단위로 설정한다. | 500 |
| maxItems  | number | 검색 시 표시할 최대 아이템 수를 설정한다. | 6 |

프레임워크에서 추가 제공하는 Props은 아래를 참고한다.
| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| autoSelectFirstItem | boolean | 설정된 modelValue 값이 없을 경우, 첫번째 Item을 자동 선택한다. | true |



컴포넌트의 import는 다음과 같이 참조한다.
```typescript
import { WjAutoComplete } from '#ustra/nuxt-wijmo/components'
```
