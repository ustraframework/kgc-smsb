<template>
  <div class="w-[650px] my-auto py-[60px] rounded-[16px] border border-[#ECF0F8]">
    <p class="mb-[40px] text-center text-base">회원님의 개인정보 보호를 위해 비밀번호를 입력해주시기 바랍니다.</p>
    <form class="flex flex-col w-[320px] mx-auto">
      <Password inputClass="w-full p-inputtext-lg" v-model="usePassword" :feedback="false" toggleMask placeholder="비밀번호 입력" />
      <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호가 올바르지 않습니다.</p>
      <p class="flex-none mt-[8px] text-[13px] text-[#888] leading-[1.2]">
        5회 이상 로그인 실패 시 비밀번호 찾기에서 재설정 후 로그인 가능합니다.
      </p>
      
      <div class="flex mt-[24px] gap-2">
        <Button class="flex-1" label="취소" size="large" outlined />
        <Button class="flex-1" label="확인" size="large" />
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';

definePageMeta({
  layout: 'side',
});

// input
const usePassword = ref('');
</script>

<style lang="scss" scoped></style>
