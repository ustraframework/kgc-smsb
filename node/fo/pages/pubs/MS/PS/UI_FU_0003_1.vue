<template>
  <div class="w-[624px] m-auto py-[60px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="mb-[12px] text-center text-3xl font-bold">비밀번호 재설정</h2>
    <p class="mb-[40px] text-center text-base">비밀번호 재설정 하시려면 아이디를 입력 후 본인인증 해주세요.</p>
    <form class="flex flex-col w-[320px] mx-auto">
      <InputText class="w-full" v-model="userID" type="text" size="large" placeholder="아이디를 입력해주세요" />

      <Button class="w-full mt-[24px]" label="인증하기" size="large" />
      <div class="flex flex-col mt-[20px]">
        <p class="text-center mb-1">아이디가 기억나지 않는다면?</p>
        <Button @click="$router.push('/pubs/MS/IS/UI_FU_0002')" label="아이디 찾기 바로가기" text />
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// input
const userID = ref('');
</script>

<style lang="scss" scoped></style>
