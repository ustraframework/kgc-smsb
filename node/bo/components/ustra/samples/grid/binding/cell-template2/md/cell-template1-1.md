useUstraCodeValue 메소드를 사용하여 공통 코드 데이터를 코드 명 형태로 치환할 수 있다.

```html
<WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource">
  <WjFlexGridColumn header="시스템코드" binding="sysCd" :cellTemplate="ctx => useUstraCodeValue('SYS_CD', ctx.value)"></WjFlexGridColumn>
  <WjFlexGridColumn
    header="사용자상태코드"
    binding="usrSttCd"
    :cellTemplate="ctx => useUstraCodeValue('USR_STT_CD', ctx.value)"
  ></WjFlexGridColumn>
</WjFlexGrid>
<script lang="ts" setup>
const itemsSource = ref([
  { sysCd: 'BO', usrSttCd: '01' },
  { sysCd: 'FO', usrSttCd: '04' },
])
</script>
```
