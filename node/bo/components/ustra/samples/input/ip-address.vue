<template>
  <div>
    <v-card>
      <template #title> Input - IP주소 </template>
      <template #subtitle> IP 주소 입력시 사용하는 컴포넌트 </template>
      <template #text> </template>
    </v-card>
    <v-card>
      <template #title> 단일 입력 </template>
      <template #subtitle> UIpAddressTextBox를 사용하여 IP 입력 처리를 할 수 있다. </template>
      <template #text>
        <div>
          <UIpAddressTextBox v-model="ipValue" :width="200" />
        </div>
        <div>
          <v-chip class="ma-2" color="pink" label text-color="white">
            <v-icon start icon="mdi-label"></v-icon>
            ipValue : {{ ipValue }}
          </v-chip>
        </div>
        <div><VBtn @click="chk1">현재 값 조회</VBtn></div>
        <br />
        <UMarkdownViewer>{{ ipAddress1 }}</UMarkdownViewer>
      </template>
    </v-card>
    <v-card>
      <template #title> 목록 입력 </template>
      <template #subtitle> UIpAddressListBox를 사용하여 IP 목록의 입력 처리를 할 수 있다. </template>
      <template #text>
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
        <br />
        <UMarkdownViewer>{{ ipAddress2 }}</UMarkdownViewer>
      </template>
    </v-card>
  </div>
</template>
<script lang="ts" setup>
import { UMarkdownViewer } from '#ustra/nuxt/components'
import { ref } from 'vue'

// @ts-ignore
import ipAddress1 from './md/ip-address1.md'

// @ts-ignore
import ipAddress2 from './md/ip-address2.md'

let ipValue = ref<string>('127.0.0.1')
let ipListValue = ref(['127.0.0.1', '127.0.0.2', '127.0.0.3'])

const chk1 = () => {
  alert(ipValue.value)
}

const chkListValue = () => {
  alert(ipListValue.value)
}
const setListValue = () => {
  ipListValue.value = ['127.0.0.1', '127.0.0.2', '127.0.0.3']
}
</script>
