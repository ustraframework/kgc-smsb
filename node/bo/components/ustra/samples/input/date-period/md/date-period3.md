> - mode에 따른 displayFormat 기본 값
> -- 'date' mode : 'yyyy-MM-dd'
> -- 'datetime' mode : 'yyyy-MM-dd HH:mm:ss'
> -- 'year' mode : 'yyyy'
> -- 'yearmonth' mode : 'yyyy-MM'
> - mode에 따른 valueFormat 기본 값
> -- 'date' mode : 'yyyyMMdd'
> -- 'datetime' mode : 'yyyyMMddHHmmss'
> -- 'year' mode : 'yyyy'
> -- 'yearmonth' mode : 'yyyyMM'

[주의] valueFormat에 따라 데이터가 바인딩 되어야한다.예를 들어 valueFormat="yyyyMM"인 경우, "20220901"을 바인딩 할 수 없다.

```html
<!-- displayFormat, valueFormat 적용 -->
<UDatePeriodBox v-model="dateArr6" mode="datetime" displayFormat="yyyy-MM" valueFormat="yyyyMMddHHmm" />
<v-chip>
  <v-icon></v-icon>
  dateArr6 : {{ dateArr6 }}
</v-chip>
```
