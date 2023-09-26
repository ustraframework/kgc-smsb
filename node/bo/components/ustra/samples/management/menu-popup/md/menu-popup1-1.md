#### Props
| 명 | 유형 | v-model | 설명 | default |
| --- | --- | --- | --- | --- |
| modelValue | boolean | O | 팝업 오픈 여부 | false |
| title | string |  | 팝업 제목 | '메뉴 조회' |
| multiple | boolean |  | 다중 선택 여부 | false |
| defaultSysCd | string |  | 기본 시스템 코드 |  |
| canSelectSysCd | boolean |  | 시스템 선택 가능 여부 | true |

#### Event
| 명 | 유형 | 설명 |
| --- | --- | --- |
| selected | (e: 'selected', item: Menu ｜ Menu[]): void | 팝업이 선택되었을 때 발생. multiple 속성에 따라 단일 값 또는 다중 값으로 반환 |

#### Model
```typescript
import { Menu } from '#ustra/nuxt/management'
```
