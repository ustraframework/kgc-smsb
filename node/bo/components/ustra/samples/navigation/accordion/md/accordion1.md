WjAccordion 컴포넌트는 Accordion 형태의 레이아웃을 제공하는 컴포넌트이다. WjAccordion 하위에는 WjAccordionPane 컴포넌트가 위치할 수 있으며 Accordion을 구성하는 각 Panel을 구성할 수 있다. 컴포넌트는 다음과 같이 참조한다.

```typescript
import { WjAccordion, WjAccordionPane } from '#ustra/nuxt-wijmo/components'
```

WjAccordion과 WjAccordionPane은 Wijmo에서 제공하는 Accordion, AccordionPane 클래스를 Wrapping한 컴포넌트로 상세한 API 명세는 다음 링크에서 확인할 수 있다.
- Accordion : https://www.grapecity.com/wijmo/api/classes/wijmo_nav.accordion.html
- AccordionPanel : https://www.grapecity.com/wijmo/api/classes/wijmo_nav.accordionpane.html

WjAccordion 컴포넌트에서 제공하는 주요 속성은 다음과 같다.
| name | 유형 | 설명 | default |
| --- | --- | --- | --- |
| allowCollapseAll | boolean | 모든 Panel이 Collapse 상태로 변경 가능한지 여부를 설정한다. | false |
| allowExpandMany | boolean | Panel을 복수로 오픈할지 수 있는지 여부를 설정한다. | false |
| autoSwitch | boolean | 키보드를 사용하여 활성화 index를 변경할 경우 자동으로 활성화된 Panel을 세팅할지 여부를 설정한다. | true |
| isAnimated | boolean | Panel의 상태가 변경되었을 때, 애니메이션 처리를 수행하지 여부를 설정한다. | true |
| isDisabled | boolean | Control의 비활성화 여부를 설정한다. | false |
| isTouching (Readonly) | boolean | Control의 현재 Touch 이벤트 처리 여부를 가져온다. |  |
| isUpdating (Readonly) | boolean | Control의 현재 업데이트 처리 여부를 가져온다. |  |
| panes (Readonly) | ObservableArray<AccordionPane> | 설정된 Panel 목록을 조회한다. |  |
| selectedIndex | number | 활성화된 Panel의 인덱스를 가져오거나 설정한다. |  |
| selectedPane | AccordionPane | 활성화된 Panel 객체를 가져오거나 설정한다. |  |
| showIcons | boolean | Panel 헤더의 Arrow 아이콘 표시여부를 설정한다. | true |

WjAccordion과 WjAccordionPane 컴포넌트는 WjAccordion 하위에 필요한 WjAccordionPane 컴포넌트를 복수로 설정하여 세팅한다.
```html
<UButton text="첫번째 항목 선택" @click="selectedIndex = 0" />
<UButton text="두번째 항목 선택" @click="selectedIndex = 1" />
<UButton text="세번째 항목 선택" @click="selectedIndex = 2" />
<WjAccordion :selectedIndex="selectedIndex" :autoSwitch="true" class="mt-5">
  <WjAccordionPane v-for="item in items" :key="item.id">
    <div>{{ item.id }}</div>
    <template v-if="item.id === 'Header1'">
      <div>
        Header1 <br />
        Content
      </div>
    </template>
    <template v-if="item.id === 'Header2'">
      <div>
        Header2 <br />
        Content
      </div>
    </template>
    <template v-if="item.id === 'Header3'">
      <div>
        Header3 <br />
        Content
      </div>
    </template>
  </WjAccordionPane>
</WjAccordion>

<script lang="ts" setup>
import { WjAccordion, WjAccordionPane } from '#ustra/nuxt-wijmo/components'

const selectedIndex = ref(0)
const items = reactive([{ id: 'Header1' }, { id: 'Header2' }, { id: 'Header3' }])
</script>
```

위의 코드에서 보듯이 WjAccordionPane 하위에는 2개의 Element가 필요하며 첫번째는 Accordion의 제목, 두번째는 Expand 되었을 때의 표시 내용을 의미한다.
