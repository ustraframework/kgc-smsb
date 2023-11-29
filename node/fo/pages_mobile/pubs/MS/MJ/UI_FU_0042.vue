<template>
  <div class="sign flex flex-col flex-1">
    <div class="flex items-center h-[170px] px-[40px] bg-[#F9FAFC]">
      <Steps class="w-full" v-model:activeStep="active" :model="items" />
    </div>

    <div class="flex flex-col flex-1 pt-[60px] px-[20px] pb-[15px]">
      <div class="flex flex-col items-center mb-[148px]">
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
        <p class="mt-[20px] text-2xl"><strong>회원가입을 완료</strong>하였습니다.</p>
        <p class="mt-[12px] text-center text-sm">
          로그인 후 정관장 멤버스에서 제공하는 다양한 정보와 <br />
          서비스를 이용하실 수 있습니다.
        </p>
        <Button class="w-[160px] mt-[40px]" label="로그인" size="large" />
      </div>

      <a class="mt-auto" href="#" target="_blank">
        <img src="@/assets/images/banner/whats-new-mo.png" alt="what's NEW 정관장 구매 시 신제품 증정" />
      </a>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// steps
// active 0, 1, 2 값으로 active 값 구분
const active = ref(2);
const items = ref([
  {
    label: '약관동의',
  },
  {
    label: '정보입력',
  },
  {
    label: '가입완료',
  },
]);
</script>

<style lang="scss" scoped></style>
