기본 검색영역의 템플릿은 다음과 같습니다.
한라인에 최대 Field의 갯수는 3개입니다. --> :ratio="[1, 1, 1, '170px']
마지막 Field 영역은 '조회'버튼 영역을 위하여 170px의 고정값을 주어야 합니다.
1. "UBox"의 'columns' 클래스는 필수로 입력하여야 합니다.
2. "UItem"의 '클레스에 card', 'is-sub', 'is-search' 순으로 입력합니다.
3. UFieldSet 컴포넌트에 'is-search' 클래스를 입력합니다.
4. "조회" 버튼의 경우 "UField"의 blank 속성을 추가한 후 div로 영역을 다시잡고 'search-btn' 클래스를 입력하여야 합니다.
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
