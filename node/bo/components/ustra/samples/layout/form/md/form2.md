```html
<UFieldSet label="기본설정">
  <UFieldRow>
    <UField label="필드1(col)" direction="col"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(col)" direction="col"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(col)" direction="col"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow>
    <UField label="필드1(col)" direction="col"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(col)" direction="col"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
</UFieldSet>
<UFieldSet label="Ratio 설정">
  <UFieldRow :ratio="[1, 1, 2]">
    <UField label="필드1(col)" direction="col"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(col)" direction="col"><WjComboBox></WjComboBox> </UField>
    <UField label="필드3(col)" direction="col"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
  <UFieldRow :ratio="['300px', 2]">
    <UField label="필드1(col)" direction="col"><WjComboBox></WjComboBox></UField>
    <UField label="필드2(col)" direction="col"><WjComboBox></WjComboBox> </UField>
  </UFieldRow>
</UFieldSet>
```
