<template>
  <div class="w-[624px] mx-auto my-[126px] py-[60px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="mb-[12px] text-center text-3xl font-bold">아이디 찾기</h2>
    <p class="mb-[40px] text-center text-base">가입 시 등록된 휴대폰번호를 통해 아이디를 찾으실 수 있습니다.</p>
    <form class="flex flex-col w-[320px] mx-auto">
      <InputText class="w-full" v-model="userName" type="text" size="large" placeholder="이름" />
      <div class="flex gap-2 mt-[8px]">
        <Dropdown
          inputClass="p-inputtext-lg"
          v-model="firstNumber"
          :options="lastNumbers"
          optionLabel="name"
          placeholder="010"
          class="w-[100px] flex-none"
        />
        <InputText class="flex-1" v-model="userPhone" type="text" size="large" placeholder="숫자만 입력" />
      </div>
      
      <Button class="w-full mt-[24px]" label="확인" size="large" />
      <div class="flex flex-col mt-[20px]">
        <p class="text-center mb-1">비밀번호가 기억나지 않는다면?</p>
        <Button @click="$router.push('/')" label="비밀번호 재설정 바로가기" text />
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// input
const userName = ref('');
const userPhone = ref('');

// dropdown
const firstNumber = ref();
const lastNumbers = ref([
  { name: '010', code: 'skt' },
  { name: '019', code: 'lg' },
]);
</script>

<style lang="scss" scoped></style>
