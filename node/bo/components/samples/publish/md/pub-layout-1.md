기본 검색영역의 템플릿은 다음과 같다
```html
<UBox class="columns" direction="row">
  <UItem class="card is-sub is-search" ratio="1">
    <UFieldSet class="is-search">
      <UFieldRow :ratio="[1, 1, 1, '170px']">
        <UField label="검색영역"><UTextBox></UTextBox></UField>
        <UField blank></UField>
        <UField blank></UField>
        <UField blank>
          <div class="search-btn">
            <UButton text="조회" type="is-search" />
          </div>
        </UField>
      </UFieldRow>
    </UFieldSet>
  </UItem>
</UBox>
```
