```html 
<UFieldSet label="검색영역">
  <UFieldRow>
    <UField label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
    <UField label="요청 아이디"><WjComboBox></WjComboBox> </UField>
    <UField label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
    <UField label="URL"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[2, 1]">
    <UField label="기간"><UDatePeriodBox /> </UField>
    <UField blank>
      <UButtonBox right>
        <UButton text="수정" />
        <UButton text="삭제" />
      </UButtonBox>
    </UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet label="검색영역">
  <UFieldRow disabled>
    <UField label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
    <UField label="요청 아이디"><WjComboBox></WjComboBox> </UField>
    <UField label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
    <UField label="URL"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[2, 1]">
    <UField label="기간"><UDatePeriodBox /> </UField>
    <UField blank>
      <UButtonBox right>
        <UButton text="수정" />
        <UButton text="삭제" />
      </UButtonBox>
    </UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet disabled label="검색영역">
  <UFieldRow>
    <UField label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
    <UField label="요청 아이디"><WjComboBox></WjComboBox> </UField>
    <UField label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
    <UField label="URL"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[2, 1]">
    <UField label="기간"><UDatePeriodBox /> </UField>
    <UField blank>
      <UButtonBox right>
        <UButton text="수정" />
        <UButton text="삭제" />
      </UButtonBox>
    </UField>
  </UFieldRow>
</UFieldSet>
```
