```html
<UFieldSet>
  <UFieldRow>
    <UField direction="col" itemDirection="row">
      <template #label>
        <div style="margin-right: 5px">컴포넌트</div>
        <div style="margin-right: 5px">
          <UButton icon="arr-up" />
        </div>
        <div style="margin-right: 5px">
          <UCheckGroupBox :items-source="[{ text: 'Item1' }]" v-model="checked"> </UCheckGroupBox>
        </div>
      </template>
      <UTextBox width="100%"></UTextBox>
    </UField>
    <UField blank>
      <UButtonBox>
        <UButton text="수정" />
        <UButton text="삭제" />
      </UButtonBox>
    </UField>
  </UFieldRow>
  <UFieldRow>
    <UField label="필드 + Slot" itemDirection="row">
      <template #label>
        <i style="margin-right: 5px">텍스트 스타일</i>
        <strong style="margin-right: 5px">bold</strong>
        <span style="color: red"> color </span>
      </template>
      <UTextBox width="100%"></UTextBox>
    </UField>
    <UField blank>
      <UButtonBox right>
        <UButton text="수정" />
        <UButton text="삭제" />
      </UButtonBox>
    </UField>
  </UFieldRow>
</UFieldSet>
```
