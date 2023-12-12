Grid 혹은 Form등 컨텐츠의 타이틀을 부여하거나 서브 타이틀을 지정해야 하는 경우,
```<UItem class="card is-sub">``` 하위에 UBox를 추가한 후 'table-title-wrap' 클래스를 추가합니다.
1. 타이틀 내용은 h2 - 'table-title' 하위에 추가합니다.
2. 타이틀 내용에 데이터 조회 건수를 추가할 경우
   -> "span"태그를 추가한 후 'data-count' 클래스를 추가 합니다.
   -> 숫자영역에는 위의 span태그 하위에 span태그를 추가하여 숫자를 입력합니다.
      ex: ```<span class="data-count">총<span>50</span>건</span>```

3. 타이틀 우측에 버튼, Input, Combobox등을 추가할 수 있습니다.
   -> UButtonBox 컴포넌트의 table-buttons 클래스를 추가해야 합니다.
   -> ``` <UButtonBox class="tale-bubttons"> ``` 하위에 Element들을 배치합니다.
   -> **버튼의 배열 순서는 아래와 같습니다**
   **Icon Button(엑셀 다운로드 등 icon이 들어가는 버튼) -> Custom Button(icon/CRUD를 제외한 모든 버튼) -> CRUD Button(추가,수정,삭제,취소 등) -> Confirm Button(저장,완료 등의 최종 키액션 버튼(검정바탕으로 표현할 버튼))**


```html
<UBox class="columns" direction="row">
  <UItem class="card is-sub" ratio="1" >
    <UBox class="table-title-wrap">
      <h2 class="table-title">
        <span>Contents Title</span>
        <span class="data-count">총<span>50</span>건</span>
      </h2>
      
      <UButtonBox class="tale-bubttons">
        <UWjComboBox :itemsSource="pwd" displayMemberPath="text" style="width: 200px !important" />
        <UButton text="엑셀 다운로드" icon="excel" />
        <UButton text="초기화" />
        <UButton text="취소" type="is-outline" />
        <UButton text="저장" type="is-filled" />
      </UButtonBox>
    </UBox>

    <WjFlexGrid :itemsSource="itemsSourceGrid">
      <WjFlexGridColumn header="No" binding="col1" width="*" />
      <WjFlexGridColumn header="회원번호" binding="col1" width="*" />
      <WjFlexGridColumn header="회원명" binding="col1" width="*" />
    </WjFlexGrid>
  </UItem>
</UBox>
```
