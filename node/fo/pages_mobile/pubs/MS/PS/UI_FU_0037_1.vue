<template>
  <div class="my-[34px] mx-[20px] pt-[40px] px-[20px] pb-[20px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="mb-[12px] text-center text-2xl font-bold">비밀번호 변경</h2>
    <p class="mb-[24px] text-center text-sm break-keep">고객님의 소중한 개인정보를 안전하게 보호하기 위하여 새로운 비밀번호를 변경해주세요.</p>
    <form>
      <div class="flex flex-col">
        <label class="py-[9px] text-[#222]" for="userPassword0">현재 비밀번호</label>
        <Password
          inputId="userPassword0"
          inputClass="p-inputtext-lg w-full"
          v-model="userPassword0"
          :feedback="false"
          placeholder="현재 비밀번호를 입력해주세요"
        />
        <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호가 일치하지 않습니다</p>
      </div>

      <div class="flex flex-col mt-[20px]">
        <label class="py-[9px] text-[#222]" for="userPassword1">새 비밀번호</label>
        <Password
          inputId="userPassword1"
          inputClass="p-inputtext-lg w-full"
          v-model="userPassword1"
          :feedback="false"
          toggleMask
          placeholder="비밀번호를 입력해주세요"
        />

        <!-- error -->
        <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호가 일치하지 않습니다</p>
      </div>

      <div class="flex flex-col mt-[20px]">
        <label class="py-[9px] text-[#222]" for="userPassword2">새 비밀번호 확인</label>
        <Password
          inputId="userPassword2"
          inputClass="p-inputtext-lg w-full"
          v-model="userPassword2"
          :feedback="false"
          toggleMask
          placeholder="변경하실 비밀번호를 다시 입력해 주세요"
        />

        <!-- positive -->
        <p class="mt-[5px] text-[13px] text-[#5361E7]">비밀번호가 일치 합니다</p>
        <!-- error -->
        <!-- <p class="mt-[5px] text-[13px] text-[#F43131]">Error Message</p> -->
      </div>

      <div class="flex gap-2 mt-[24px]">
        <Button class="flex-1" label="취소" size="large" outlined />
        <Button class="flex-1" label="확인" size="large" />
      </div>
    </form>

    <div class="mt-[40px] p-[16px] rounded-[8px] bg-[#F9FAFC]">
      <h3 class="flex items-center mb-[8px] text-[#888] font-medium">
        <img src="@/assets/images/svg/ico_info.svg" class="mr-1" alt="정보" />
        유의사항
      </h3>
      <ul class="warning__list">
        <li><span class="dot"></span> 8자 이상 영문 대/소문자, 숫자, 특수문자 3가지 이상 조합하여 사용해주기 바랍니다.</li>
        <li><span class="dot"></span> 사용 가능한 특수문자 !@#$%^&*( ) )</li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// input
const userPassword0 = ref('');
const userPassword1 = ref('');
const userPassword2 = ref('');
</script>

<style lang="scss" scoped></style>
