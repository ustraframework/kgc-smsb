Popup은 Wijmo의 UPopup 컴포넌트를 기반으로 작성했습니다.
1. Popup의 width, height 값은 ```<UPopup width="" height=""/>``` 컴포넌트의 속성값으로 조정합니다.
   -> 팝업의 타이틀도 ```<UPopup title=""/>``` UPopup의 타이틀 속성으로 추가합니다.
2. ```<UPopup/>```하위에 "UBox" 컴포넌트를 추가한 후 direction 속성을 col로 부여합니다.
3. ```<UBox direction="col">``` 하위에 pop-contents클래스의 "UBox"를 추가합니다.
4. ```<<UItem class="pop-contents">```하위에 컨텐츠를 추가합니다.
5. Popup에도 검색 영역을 추가할 수 있습니다.
   -> Popup의 검색영역 한 라인에 최대 'Field' 갯수는 2개입니다.
   -> ```<UBox class="pop-search">```클래스 pop-search를 입력합니다.
   -> 이후에는 기본 검색영역과 동일하게 마크업을 진행하시면 됩니다.

6. Footer 버튼이 필요한 경우 ```<UBox direction="col">``` 최하단에 ```<UItem class="pop-btn">```를 추가합니다.
   -> ```<UItem class="pop-btn">```하위에 ```<UButtonBox>```를 추가후 UButtonBox 하위에 버튼들을 배치합니다.

```html
<UPopup v-model="showPopup" :width="1100" :height="600" title="팝업 예제">
  <UBox direction="col">
    <UItem :ratio="1" class="pop-contents">
      <UBox class="pop-search" style="margin-bottom: 10px;">
        <UFieldSet class="is-search">
          <UFieldRow :ratio="[1, 1, '170px']">
            <UField label="지사" >
              <UWjComboBox :itemsSource="items" displayMemberPath="text" />
            </UField>
            <UField label="매장코드/명">
              <UTextBox type="icon"></UTextBox>
            </UField>
            <UField blank>
              <div class="search-btn">
                <UButton text="조회" type="is-search"/>
              </div>
            </UField>
          </UFieldRow>
          <UFieldRow :ratio="[1, 1, '170px']">
            <UField label="고객번호/명" required>
              <UTextBox />
            </UField>
            <UField label="핸드폰번호">
              <UTextBox />
            </UField>
          </UFieldRow>
        </UFieldSet>
      </UBox>

      <UBox class="table-title-wrap">
        <h2 class="table-title">
          <span class="data-count">총<span>9</span>건</span>
        </h2>
      </UBox>

      <WjFlexGrid :itemsSource="itemsSourceGrid">
        <WjFlexGridColumn header="No" binding="col1" width="*" />
        <WjFlexGridColumn header="고객번호" binding="col1" width="*" />
      </WjFlexGrid>
    </UItem>
    <UItem class="pop-btn">
      <UButtonBox right top>
        <UButton text="닫기" type="is-outline"/>
        <UButton text="적용" type="is-filled"/>
      </UButtonBox>
    </UItem>
  </UBox>
</UPopup>
```
