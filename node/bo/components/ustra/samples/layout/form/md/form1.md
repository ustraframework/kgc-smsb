```html
<UFieldSet label="기본설정">
  <UFieldRow>
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드4(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow>
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet label="중요 검색항목 표시 (required 옵션 추가)">
  <UFieldRow>
    <UField required label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField required label="필드2(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드4(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow>
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet label="Ratio 설정 (ratio 옵션 활용)">
  <UFieldRow>
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드4(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[1, 3]">
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[4]">
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet label="Ratio 설정 (ratio 옵션 활용 + 고정 px)">
  <UFieldRow :ratio="['300px', 1]">
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[1, '500px']">
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="['300px', 1, 2]">
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet label="라벨 좌우 설정 (left, right 옵션 추가)">
  <UFieldRow>
    <UField left label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField left label="필드2(row)"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(row)"><WjComboBox></WjComboBox> </UField>
    <UField right label="필드4(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[1, 3]">
    <UField right label="필드1(row)"><WjComboBox></WjComboBox></UField>
    <UField left label="필드2(row)"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="[4]">
    <UField label="필드1(row)"><WjComboBox></WjComboBox></UField>
  </UFieldRow>
</UFieldSet>
```
