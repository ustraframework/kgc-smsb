WjAccordion 컴포넌트는 wj-accordion 클래스를 가진 container를 가지고 있으며 헤더는 wj-header, 내용은 wj-content 클래스가 각 Element에 할당된다.

주요 클래스 목록은 다음과 같다.
- .wj-accordion > .wj-header : 헤더의 기본 클래스
- .wj-accordion > .wj-content : Content 영역의 기본 클래스
- .wj-accordion > .wj-header.wj-state-disabled:not(.wj-popup) : Disabled 상태의 Header
- .wj-accordion > .wj-header.wj-state-active : 활성화 상태의 Header
- .wj-accordion > .wj-header:focus : 헤더의 포커스 상태

아래의 예제는 custom-accordion class 속성을 WjAccordion 컴포넌트에 추가하여 스타일을 커스토마이징하는 예제이다.

```html
<template>
  <WjAccordion class="custom-accordion">
    <WjAccordionPane>
      <div>Header1</div>
      <div>
        Header1 <br />
        Content
      </div>
    </WjAccordionPane>
    <WjAccordionPane :isDisabled="true">
      <div>Header2</div>
      <div>
        Header2 <br />
        Content
      </div>
    </WjAccordionPane>
    <WjAccordionPane>
      <div>Header3</div>
      <div>
        Header3 <br />
        Content
      </div>
    </WjAccordionPane>
  </WjAccordion>
</template>
<script lang="ts" setup>
import { WjAccordion, WjAccordionPane } from '#ustra/nuxt-wijmo/components'
</script>
<style lang="scss" scoped>
.custom-accordion {
  // 헤더 기본
  &.wj-accordion > .wj-header {
    border-radius: 5px;
    margin: 5px 0;
    font-size: unset;
  }

  // Disabled 상태의 Header
  &.wj-accordion > .wj-header.wj-state-disabled:not(.wj-popup) {
    opacity: 0.4;
  }

  // 활성화 상태의 Header
  &.wj-accordion > .wj-header.wj-state-active {
    background-color: #e19730;
  }

  // 헤더의 포커스 상태
  &.wj-accordion > .wj-header:focus {
    outline: 2px solid #e7931e;
    outline-offset: -2px;
  }

  // Content 영역의 기본 클래스
  &.wj-accordion > .wj-content {
    padding: 10px;
    border: 1px dashed #ccc;
  }
}
</style>
```
