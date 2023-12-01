<template>
  <div class="my-[80px] mx-[20px] p-[24px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="text-center text-2xl font-bold">통합회원 ONE ID</h2>
    <div class="w-[200px] h-[146px] my-[40px] mx-auto">
      <img src="@/assets/images/sign/one-id.png" alt="통합회원 ONE ID 아이콘" />
    </div>
    <p class="text-sm text-center">
      ONE ID는 다양한 서비스를 하나의 아이디로 통합할 수 있는 통합 아이디입니다.<br />
      정관장몰, 케어나우 서비스를 하나로 이용하실 수 있습니다.<br />
      ONE ID로 사용해도 이전에 이용하신 서비스 이력 정보를 확인하실 수 있습니다.
    </p>
    <Button class="block w-[160px] mx-auto mt-[40px]" label="ONE ID 만들기" size="large" />
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
