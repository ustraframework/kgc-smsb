플러그인에서 제공되는 $ustra.utils.formatting 유틸리티 기능을 사용하여 여러 유형의 데이터를 문자 형태로 치환한다.
- $ustra.utils.formatting.currency : 숫자를 통화 문자열 형태로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#currency)
- $ustra.utils.formatting.date : 문자 또는 Date를 지정된 일자 포맷 문자열로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#date)
- $ustra.utils.formatting.datetime : 문자 또는 Date를 지정된 일시 포맷 문자열로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#datetime)
- $ustra.utils.formatting.time : 문자 또는 Date를 지정된 시간 포맷 문자열로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#time)
- $ustra.utils.formatting.cardNo : 문자를 카드 번호 포맷 형태로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#cardNo)
- $ustra.utils.formatting.corpRegNo : 문자를 사업자 번호 포맷 형태로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#corpRegNo)
- $ustra.utils.formatting.fileSize : 숫자를 파일 사이즈 포맷 형태로 변경 (http://guide.ustraframework.kro.kr/docs/node/3.0/core/classes/utils_formatting.Formatting.html#fileSize)

```html
<WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource">
  <WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource">
    <WjFlexGridColumn
      header="숫자 포맷팅"
      binding="toCurrency"
      :cellTemplate="ctx => $ustra.utils.formatting.currency(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="숫자 포맷팅(소수점)"
      binding="toCurrency"
      :cellTemplate="ctx => $ustra.utils.formatting.currency(ctx.value, 2)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일자)"
      binding="dateValue"
      :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일자)"
      binding="dateTextValue"
      :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일시)"
      binding="dateValue"
      :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="Date 포맷팅(일시)"
      binding="dateTimeTextValue"
      :cellTemplate="ctx => $ustra.utils.formatting.datetime(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="시간포맷팅(HH:mm)"
      binding="timeTextValue"
      :cellTemplate="ctx => $ustra.utils.formatting.time(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn
      header="시간포맷팅(HH:mm:ss)"
      binding="timeTextValue2"
      :cellTemplate="ctx => $ustra.utils.formatting.time(ctx.value)"
    ></WjFlexGridColumn>

    <WjFlexGridColumn header="카드 번호" binding="cardNoText" :cellTemplate="ctx => $ustra.utils.formatting.cardNo(ctx.value)"></WjFlexGridColumn>
    <WjFlexGridColumn
      header="사업자 번호"
      binding="corpRegNoText"
      :cellTemplate="ctx => $ustra.utils.formatting.corpRegNo(ctx.value)"
    ></WjFlexGridColumn>
    <WjFlexGridColumn
      header="파일사이즈"
      binding="fileSize"
      :cellTemplate="ctx => $ustra.utils.formatting.fileSize(ctx.value)"
    ></WjFlexGridColumn>
  </WjFlexGrid>
</WjFlexGrid>
<script lang="ts" setup>
const itemsSource = ref([
  {
    toCurrency: 90121,
    dateValue: new Date(),
    dateTextValue: '20221123',
    dateTimeTextValue: '20221123105921',
    timeTextValue: '2130',
    timeTextValue2: '213012',
    cardNoText: '4879214569578136',
    corpRegNoText: '69815487985',
    fileSize: 189636181,
  },
])
</script>
```
