'버튼'영역에 버튼을 추가 할 경우, "UFieldRow"컴포넌트의 ratio 속성으로 주었던 170px 영역을 170의 배수로 지정합니다.
ex: ratio=[1, 1, 1, '340px']

```html
<UBox class="columns" direction="row">
  <UItem class="card is-sub is-search" ratio="1">
    <UFieldSet class="is-search">
      <UFieldRow :ratio="[1, 1, 1, '340px']">
        <UField label="검색영역"><UTextBox></UTextBox></UField>
        <UField blank></UField>
        <UField blank></UField>
        <UField blank>
          <div class="search-btn">
            <UButton text="초기화"/>
            <UButton text="조회" type="is-search" />
          </div>
        </UField>
      </UFieldRow>
    </UFieldSet>
  </UItem>
</UBox>
```