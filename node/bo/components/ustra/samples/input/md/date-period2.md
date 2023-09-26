> 위 샘플에서 지정 된 mode의 종류는 순서대로 다음과 같다.
> - date : 일자
> - datetime : 일자 및 시분
> - year : 년도
> - yearmonth : 연월

```html
<!-- date mode -->
<UDatePeriodBox v-model="dateArr2" mode="date" />
<div>
  <v-chip>
    <v-icon></v-icon>
    dateArr2 : {{ dateArr2 }}
  </v-chip>
</div>

<!-- datetime mode -->
<UDatePeriodBox v-model="dateArr3" mode="datetime" />
<div>
  <v-chip>
    <v-icon></v-icon>
    dateArr3 : {{ dateArr3 }}
  </v-chip>
</div>

<!-- year mode -->
<UDatePeriodBox v-model="dateArr4" mode="year" />
<div>
  <v-chip>
    <v-icon></v-icon>
    dateArr4 :{{ dateArr4 }}
  </v-chip>
</div>

<!-- yearmonth mode -->
<UDatePeriodBox v-model="dateArr5" mode="yearmonth" />
<div>
  <v-chip>
    <v-icon></v-icon>
    dateArr5 : {{ dateArr5 }}
  </v-chip>
</div>
```
