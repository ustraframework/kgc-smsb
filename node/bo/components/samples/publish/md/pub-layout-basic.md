기본 컨텐츠 레이아웃 영역은 최상위 "UBox"의 class 'columns'와 
하위 "UItem" class 'card is-sub'로 구성되어 있습니다.
작성하여야 할 컨텐츠는 UItem card 컴포넌트 안에서 작성하여야 합니다.
```html
<UBox class="columns" direction="row">
  <UItem class="card is-sub" ratio="1">
      Contents
      or
      <UBox>
        Contents
      </UBox>
  </UItem>
</UBox>
```
