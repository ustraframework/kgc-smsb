```html 
<UFieldSet label="검색영역">
  <UFieldRow>
    <UField direction="col" required label="프로세스 아이디"><WjComboBox></WjComboBox></UField>
    <UField direction="col" required label="요청 아이디"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow>
    <UField direction="col" required label="인터페이스 아이디"><WjComboBox></WjComboBox> </UField>
    <UField direction="col" label="URL"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow>
    <UField label="채널 코드"><WjComboBox></WjComboBox> </UField>
    <UField label="성공 여부"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow>
    <UField label="응답 코드 값"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[1, 1, 1]">
    <UField label="기간"><UDatePeriodBox /> </UField>
    <UField blank></UField>
    <UField blank>
      <UButtonBox right>
        <UButton text="수정" />
        <UButton text="삭제" />
      </UButtonBox>
    </UField>
  </UFieldRow>
</UFieldSet>
```
