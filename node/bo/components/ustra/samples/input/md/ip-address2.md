> UIpAddressTextBox 태그를 사용하며, 다음 속성을 지원한다.
> - required: (boolean) 필수 체크 여부
> - width: (number) 필드 넓이 (최소값 230)
> - height: (number) 필드 높이
> - allowAsterisk(boolean) : 와일드 카드 문자 입력을 활성화한다. (기본 값 : false)

> 목록 선택시 선택한 IP 값이 텍스트박스에 입력된다.
> \+ 버튼을 통해 텍스트박스에 입력된 IP 값을 목록에 추가한다
> \- 버튼을 통해 텍스트박스에 입력된 IP 값을 목록에서 제거한다.

```html
<template>
  <div>
    <UIpAddressListBox v-model="ipListValue" :width="230" :height="100"></UIpAddressListBox>
  </div>
  <div>
    <v-chip class="ma-2" color="pink" label text-color="white">
      <v-icon start icon="mdi-label"></v-icon>
      ipListValue : {{ ipListValue }}
    </v-chip>
  </div>
  <div>
    <VBtn @click="chkListValue">현재 값 조회</VBtn>
    <VBtn @click="setListValue">초기값 반영</VBtn>
  </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'

let ipListValue = ref(['127.0.0.1', '127.0.0.2', '127.0.0.3'])

const chkListValue = () => {
  alert(ipListValue.value)
}
const setListValue = () => {
  ipListValue.value = ['127.0.0.1', '127.0.0.2', '127.0.0.3']
}
</script>
```
