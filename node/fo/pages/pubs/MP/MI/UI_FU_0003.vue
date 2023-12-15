<template>
  <div class="w-[650px] mx-auto py-[60px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="mb-[12px] text-center text-3xl font-bold">비밀번호 변경</h2>
    <p class="mb-[40px] text-center text-base">새로운 비밀번호를 입력해주세요.</p>
    <form class="w-[320px] mx-auto">
      <div class="flex flex-col">
        <label class="py-[9px] text-[#222]" for="userPassword1">새 비밀번호</label>
        <Password inputId="userPassword1" inputClass="p-inputtext-lg w-full" v-model="userPassword1" :feedback="false" toggleMask placeholder="비밀번호를 입력해주세요" />
        <p class="mt-[5px] text-[13px] text-[#F43131]">Error Message</p>
      </div>
      
      <div class="flex flex-col mt-[16px]">
        <label class="py-[9px] text-[#222]" for="userPassword2">새 비밀번호 확인</label>
        <Password inputId="userPassword2" inputClass="p-inputtext-lg w-full" v-model="userPassword2" :feedback="false" toggleMask placeholder="변경하실 비밀번호를 다시 입력해 주세요" />
        <p class="mt-[5px] text-[13px] text-[#F43131]">Error Message</p>
      </div>
      
      <div class="flex mt-[24px] gap-2">
        <Button class="flex-1" label="취소" size="large" outlined />
        <Button class="flex-1" label="확인" size="large" />
      </div>
    </form>
    
    <div class="mt-[40px] mx-[42px] py-[16px] px-[20px] rounded-[8px] bg-[#F9FAFC]">
      <h3 class="flex items-center mb-[8px] text-[#888] font-medium">
        <i class="mr-[3px]">
          <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
            <rect x="0.5" y="0.5" width="15" height="15" rx="7.5" fill="white"/>
            <rect x="0.5" y="0.5" width="15" height="15" rx="7.5" stroke="#BDBDBD"/>
            <rect x="7.25" y="7" width="1.5" height="5" rx="0.75" fill="#BDBDBD"/>
            <rect x="7" y="4" width="2" height="2" rx="1" fill="#BDBDBD"/>
          </svg>
        </i>
        유의사항
      </h3>
      <ul class="pl-[10px] text-[#888]">
        <li>&middot; 8자 이상 영문 대/소문자, 숫자, 특수문자 3가지 이상 조합하여 사용해주기 바랍니다.</li>
        <li>&middot; 허용 가능한 특수문자 !@#$%^&*( ) )</li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

definePageMeta({
  layout: 'side',
});

// input
const userPassword1 = ref('');
const userPassword2 = ref('');
</script>

<style lang="scss" scoped></style>
