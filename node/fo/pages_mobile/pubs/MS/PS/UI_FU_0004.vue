<template>
  <div class="my-auto py-[60px]">
    <div class="flex flex-col items-center">
      <i>
        <svg width="52" height="52" viewBox="0 0 52 52" fill="none" xmlns="http://www.w3.org/2000/svg">
          <g clip-path="url(#clip0_1080_7357)">
            <circle cx="26" cy="26" r="26" fill="#D20F27" />
            <path
              d="M16.5 26.125L23.0231 32.6481C23.2177 32.8427 23.533 32.8435 23.7285 32.6498L36.5 20"
              stroke="white"
              stroke-width="3.5"
              stroke-linecap="round"
            />
          </g>
          <defs>
            <clipPath id="clip0_1080_7357">
              <rect width="52" height="52" fill="white" />
            </clipPath>
          </defs>
        </svg>
      </i>
      <p class="mt-[24px] text-[38px]">회원님, <strong>비밀번호를 변경</strong>해주세요.</p>
      <p class="mt-[16px] text-center text-lg">
        회원님은 <em class="text-[#D20F27]">90일</em> 이상 같은 비밀번호를 사용하고 계십니다. <br />
        개인정보 보호를 위해 비밀번호를 주기적으로 변경해 주세요.
      </p>
      <div class="flex gap-2 w-[548px] mt-[60px]">
        <Button class="flex-1" label="다음에 변경(90일 연장)" size="large" outlined />
        <Button class="flex-1" label="지금 변경하기" size="large" />
      </div>
      
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
