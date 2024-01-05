<template>
  <div class="flex flex-col items-center m-[20px]">
    <!-- <h1 class="text-[30px] font-medium mb-[30px]">단골매장 관리</h1> -->
    <div class="w-full bg-[#F4F6FA] p-[20px] rounded-[12px]">
      <div class="flex justify-between items-center mb-[20px]">
        <h2 class="text-[18px] font-bold">정관장몰</h2>
        <Button label="변경" outlined style="font-size: 14px" />
      </div>

      <ul class="market_list">
        <li class="mb-[12px]">
          <img src="@/assets/images/svg/ico_map.svg" />
          <span>서울특별시 강남구 영동대로 416 (대치동)케이티엔지타워</span>
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

    <div class="w-full mt-[40px]">
      <div class="flex justify-between items-end pb-[6px] border-b-[2px] border-[#666666]">
        <h2 class="text-[20px] font-bold">매장검색</h2>
        <Button label="현위치" outlined class="location_btn">
          <template #icon>
            <svg class="mr-[4px]" width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
              <g clip-path="url(#clip0_1550_2289)">
                <path
                  d="M13.6 8C13.6 11.0928 11.0928 13.6 8 13.6M13.6 8C13.6 4.90721 11.0928 2.4 8 2.4M13.6 8H15M8 13.6C4.90721 13.6 2.4 11.0928 2.4 8M8 13.6V15M2.4 8C2.4 4.90721 4.90721 2.4 8 2.4M2.4 8H1M8 2.4V1M10.1 8C10.1 9.1598 9.1598 10.1 8 10.1C6.8402 10.1 5.9 9.1598 5.9 8C5.9 6.8402 6.8402 5.9 8 5.9C9.1598 5.9 10.1 6.8402 10.1 8Z"
                  stroke="#464646"
                  stroke-width="1.5"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </g>
              <defs>
                <clipPath id="clip0_1550_2289">
                  <rect width="16" height="16" fill="white" />
                </clipPath>
              </defs>
            </svg>
          </template>
        </Button>
      </div>

      <div class="w-full flex flex-wrap gap-[8px] mt-[20px]">
        <Dropdown inputClass="p-inputtext-lg" class="flex-1" placeholder="시/도 선택" />
        <Dropdown inputClass="p-inputtext-lg" class="flex-1" placeholder="구/군 선택" />
        <span class="p-input-icon-right w-full">
          <button class="pi pi-search indent-[-999em]">검색</button>
          <InputText v-model="value" size="large" placeholder="강남" class="w-full" />
        </span>
      </div>
    </div>

    <div class="w-full mt-[40px]">
      <h3 class="text-black text-[15px] font-medium">총 <span class="text-[#D20F27]">4</span>개 매장</h3>

      <div class="mt-[20px] p-[20px] border-[1px] border-[#E7E7E7] rounded-[12px]">
        <!-- card -->
        <div class="market-card" v-for="id in 5" :key="id">
          <div class="flex justify-between items-center mb-[16px]">
            <span class="text-[16px] font-bold">정관장몰</span>
            <Button label="매장 선택" severity="secondary" style="font-size: 14px" />
          </div>
          <ul class="market_list is-card">
            <li class="mb-[12px]">
              <img src="@/assets/images/svg/ico_map.svg" />
              <span>서울특별시 강남구 영동대로 416 (대치동)케이티엔지타워</span>
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
        <!-- /card -->
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'sub',
  title: '단골매장 관리',
  footer: 'none'
});
</script>

<style lang="scss" scoped>
.market_list {
  li {
    display: flex;
    align-items: flex-start;

    img {
      width: 20px;
      height: 20px;
      margin-right: 8px;
      margin-top: 1px;
    }

    span {
      color: #000;
      font-size: 16px;
    }
  }

  &.is-card {
    span {
      font-size: 15px;
      color: var(--j-gray500);
    }
  }
}

.location_btn {
  font-size: 14px;
  padding: 10px 16px;
  border-color: #ededed;
}

.market-card {
  &:not(:last-child) {
    margin-bottom: 20px;
    border-bottom: 1px solid #e7e7e7;

    .is-card {
      padding-bottom: 20px;
    }
  }
}
</style>
