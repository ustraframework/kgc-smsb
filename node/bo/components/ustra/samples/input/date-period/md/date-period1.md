> 연동 포맷은 v-model을 통해 설정한다. 
> - 기본적으로 시작일 종료일을 배열로 구성하여 셋팅하며 값이 없을 경우, [null, null] 형태로 바인딩한다.
> - 시작일과 종료일을 각각 설정 할 수도 있다. 값이 없을 경우, null 형태로 바인딩한다.
```html
<!-- 배열 바인딩 -->
<UDatePeriodBox v-model="dateArr1" />
<div>
  <v-chip>
    dateArr1 : {{ dateArr1 }}
  </v-chip>
</div>
<VBtn @click="dateArr1 = ['20220507', '20221009']">배열 일자 반영</VBtn>
<VBtn @click="dateArr1 = [null, null]">배열 null 반영</VBtn>

<!-- 시작일, 종료일 각각 바인딩 -->
<UDatePeriodBox v-model:start="start" v-model:end="end" />
<div>
  <v-chip>
    start : {{ start }}
  </v-chip>
  <v-chip>
    end : {{ end }}
  </v-chip>
</div>
<VBtn @click="start = '20220507'">시작 일자 반영</VBtn>
<VBtn @click="start = null">시작 일자 null 반영</VBtn>
<VBtn @click="end = '20221009'">종료 일자 반영</VBtn>
<VBtn @click="end = null">종료 일자 null 반영</VBtn>
```
