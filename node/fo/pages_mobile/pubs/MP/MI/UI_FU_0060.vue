<template>
  <div class="flex flex-col items-center m-[20px]">
    <!-- <h1 class="text-[30px] font-medium mb-[30px]">단골매장 관리</h1> -->
    <div class="w-full bg-[#F4F6FA] p-[24px] rounded-[12px]">
      <div class="flex justify-between items-center mb-[20px]">
        <h2 class="text-[18px] font-bold">정관장몰</h2>
        <Button label="매장 변경" outlined @click="showPopup = true" style="font-size: 14px" />
      </div>

      <ul class="market_list">
        <li class="mb-[12px]">
          <img src="@/assets/images/svg/ico_map.svg" />
          <span>서울특별시 강남구 영동대로 416(대치동)케이티엔지타워</span>
        </li>
        <li class="mb-[12px]">
          <img src="@/assets/images/svg/ico_call.svg" />
          <span>02-2189-3900</span>
        </li>
        <li>
          <img src="@/assets/images/svg/ico_time.svg" />
          <span>09:00 ~ 18:00</span>
        </li>
      </ul>
    </div>
  </div>

  <Popup61 v-model="showPopup" />
</template>

<script setup lang="ts">
import Popup61 from './UI_FU_0061.vue';

definePageMeta({
  layout: 'sub',
  title: '단골매장 관리',
  footer: 'none'
});

const showPopup = ref(false);
</script>

<style scoped>
.market_list {
  li {
    display: flex;
    align-items: center;

    img {
      width: 20px;
      height: 20px;
      margin-right: 8px;
      align-self: flex-start;
      margin-top: 2px;
    }

    span {
      color: #000;
      font-size: 16px;
    }
  }
}
</style>
