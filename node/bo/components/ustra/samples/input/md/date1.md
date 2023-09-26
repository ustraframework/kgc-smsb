연동 포맷은 v-model을 통해 설정한다. 값이 없을 경우, null 형태로 바인딩한다.
```html
<UDateBox v-model="inputValue1" />
<div>
  <v-chip>
    <v-icon></v-icon>
    inputValue1 : {{ inputValue1 }}
  </v-chip>
</div>
<VBtn @click="inputValue1 = '20220507'">일자 반영</VBtn>
<VBtn @click="inputValue1 = null">null 반영</VBtn>
```
