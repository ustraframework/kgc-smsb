<template>
  <div>사용자 조회 팝업</div>
      <UserSearchInputBox v-model="user" v-model:objectValue="objectValue" />

      <!-- <br />
      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        user : {{ user }}
      </v-chip>

      <v-chip class="ma-2" color="pink" label text-color="white">
        <v-icon start icon="mdi-label"></v-icon>
        objectValue : {{ objectValue }}
      </v-chip>

      <br />
      <UButton text="user = 'admin'" @click="() => (user = 'admin')" />
      <UButton text="user = {code:'admin', name:'관리자'}" @click="() => (user = { code: 'admin', name: '관리자' })" />
      <UButton text="user = null" @click="() => (user = null)" /> -->
  <div>공통코드 조회 팝업</div>
</template>

<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UButton } from '#ustra/nuxt-wijmo/components'
// import { UUserInputBox } from '#ustra/nuxt-wijmo/management/components'
// import {UUserInputBox} from './index'
// import UUserInputBox from '~/components/samples/searchPopup/u-user-input-box.vue'
import UserSearchInputBox from '~/components/samples/search-popup/user-input-box.vue'



const user = ref(null)
const objectValue = ref(null)

const definePageMeta = (arg: any) => {};
definePageMeta({
  auth: {
    required: false,
  },
  layout: false,
});
</script>
