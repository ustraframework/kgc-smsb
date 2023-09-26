> UIpAddressTextBox 태그를 사용하며, 다음 속성을 지원한다.
> - required: (boolean) 필수 체크 여부
> - width: (number) 필드 넓이
> - allowAsterisk(boolean) : 와일드 카드 문자 입력을 활성화한다. (기본 값 : false)
```html
<template>
  <div>
    <UIpAddressTextBox v-model="ipValue" :width="200" />
  </div>
  <div>
    <v-chip class="ma-2" color="pink" label text-color="white">
      <v-icon start icon="mdi-label"></v-icon>
      ipValue : {{ ipValue }}
    </v-chip>
  </div>
  <div>
    <VBtn @click="chk1">현재 값 조회</VBtn>
  </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'

let ipValue = ref<string>('127.0.0.1')

const chk1 = () => {
  alert(ipValue.value)
}
</script>
```
