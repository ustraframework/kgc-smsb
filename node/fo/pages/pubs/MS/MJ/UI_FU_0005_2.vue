<template>
  <!-- 통합회원에는 is-integration class add -->
  <div class="sign is-integration">
    <div class="flex items-center h-[200px] bg-[#F9FAFC]">
      <Steps class="w-[340px] mx-auto" v-model:activeStep="active" :model="items" />
    </div>

    <div class="w-[800px] mx-auto pt-[120px] pb-[138px]">
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
        <p class="mt-[24px] text-[38px]"><strong>통합회원 전환이 완료</strong>되었습니다.</p>
        <p class="mt-[16px] text-center text-lg">
          기본정보 외에 기존에 입력되어 있던 추가정보는 기존정보를 기준으로 입력됩니다. <br />
          이미 입력되어 있는 정보가 있을 경우에는 기 입력되어 있는 정보를 유지됩니다. <br /><br />
          정관장 멤버스에서 제공하는 다양한 정보와 서비스를 이용하실 수 있습니다.
        </p>
        <Button class="w-[270px] mt-[60px]" label="로그인" size="large" />
      </div>
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
    label: 'ID선택',
  },
  {
    label: '전환완료',
  },
]);
</script>

<style lang="scss" scoped></style>
