column 영역의 본문 타이틀을 지정해야 하는 경우,
1. ```<UItem class="card is-sub">``` 하위에 UBox를 추가하여 card-header 클래스를 입력합니다.
2. h1태그를 하위에 추가한 후에```<UBox class="card-header">```  하위에 입력할 타이틀을 추가합니다.

```html
<UBox class="columns" direction="row">
  <UItem class="card is-sub is-search" ratio="1" >
    <UBox class="card-header">
      <h1 class="page-title">
        <span>본문 제목</span>
      </h1>
    </UBox>
  </UItem>
</UBox>
```
