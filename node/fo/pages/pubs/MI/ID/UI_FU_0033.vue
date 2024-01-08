<template>
  <div class="flex flex-col w-[856px] mt-[80px]">
    <div class="bread-wrap">
      <span>홈</span>
      <img src="@/assets/images/svg/ico_bread_arrow.svg" class="my-[4px]" />
      <Dropdown v-model="item" :options="items" optionLabel="name" />
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const item = ref('a');

const items = ref([
  { name: '이용약관', code: 'a' },
  { name: '개인정보처리방침', code: 'b' },
]);
</script>

<style scoped>
.bread-wrap {
  width: 100%;
  display: flex;
  align-items: center;
  font-size: 15px;
  color: #000;

  .p-dropdown {
    border: 0;
  }
}
</style>
