기본 검색영역의 '조회'버튼 영역 170px의 고정값 부여 및 한라인에 최대 3개의 Element 배치. 
이 2가지 규칙을 준수한 후,
UField의 Input, ComboBox 배치와 "UFieldRow" 컴포넌트의 'ratio' 속성을 활용하여 각 'field'영역의 간격은 임의로 지정 하실 수 있습니다.
```html
<UBox class="columns" direction="row">
  <UItem class="card is-sub is-search" ratio="1" >
    <UFieldSet class="is-search">
      <UFieldRow :ratio="[1, 2, 1, '170px']">
        <UField label="항목구분" required>
          <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
        </UField>
        <UField label="변경일자" required>
          <UDatePeriodBox v-model:start="start" v-model:end="end" />
        </UField>
        <UField blank></UField>
        <UField blank>
          <div class="search-btn">
            <UButton text="조회" type="is-search" />
          </div>
        </UField>
      </UFieldRow>
      <UFieldRow :ratio="[1, 2, 1, '170px']">
        <UField label="회원유형" required>
          <WjComboBox :itemsSource="items" selectedValuePath="value" displayMemberPath="text" />
        </UField>
        <UField label="회원번호/명">
          <UBox>
            <UTextBox type="icon"/>
            <UTextBox/>
          </UBox>
        </UField>
        <UField blank></UField>
        <UField blank></UField>
      </UFieldRow>
    </UFieldSet>
  </UItem>
</UBox>
```
