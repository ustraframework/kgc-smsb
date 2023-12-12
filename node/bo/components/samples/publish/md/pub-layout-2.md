column 영역의 본문 타이틀을 지정해야 하는 경우,
UItem-card 하위에 UBox를 추가하여 card-header 클래스를 입력한 후 h1태그에 'page-title'클래스 하위에
입력할 타이틀을 추가해주면 됩니다.



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
