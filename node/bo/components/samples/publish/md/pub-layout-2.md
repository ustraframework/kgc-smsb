제목이 포함된 컨텐츠 영역의 템플릿은 다음과 같다
```html
<UBox class="columns" direction="row">
  <!-- 좌측 영역 -->
  <UItem class="card is-sub" ratio="4">
    <UBox class="table-title-wrap" direction="row">
      <UItem itemDirection="row" :ratio="1">
        <h2 class="table-title">
          <span>Sub title</span>
          <span class="data-count">총<span>24</span>건</span>
        </h2>
      </UItem>
    </UBox>

    <WjFlexGrid :itemsSource="customers">
      <WjFlexGridColumn header="ID" binding="id" width="*" />
      <WjFlexGridColumn header="이름" binding="name" width="*" />
      <WjFlexGridColumn header="주소" binding="address" width="*" />
    </WjFlexGrid>
  </UItem>
</UBox>
```
