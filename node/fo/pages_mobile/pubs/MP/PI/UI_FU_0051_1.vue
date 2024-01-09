<template>
  <div class="flex flex-col items-center m-[20px]">
    <div class="w-full bg-[#F4F6FA] p-[24px] rounded-xl">
      <div class="flex flex-col justify-center items-center mb-[20px] border-b border-[#E7E7E7] pb-[20px]">
        <span class="text-[15px]"> 당월 소멸 예정 포인트 </span>
        <span class="text-[30px] text-[#D20F27] mt-[4px]"> <strong class="mr-0.5">1,000</strong>P </span>
      </div>

      <div class="flex flex-col mb-[20px]">
        <div class="flex justify-between items-center text-[15px] mb-[16px]">
          <span>12월 소멸 예정 포인트</span>
          <span> <strong class="mr-0.5">5,000</strong>P </span>
        </div>
        <div class="flex justify-between items-center cursor-pointer text-[15px]" @click="$router.push('/pubs/MP/PI/UI_FU_0051_1')">
          <span> 1월 소멸 예정 포인트 </span>
          <span> <strong class="mr-0.5">50</strong>P </span>
        </div>
      </div>

      <div class="flex items-start">
        <img src="@/assets/images/svg/ico_info.svg" class="mr-1 mt-[1px]" alt="정보" />
        <span class="text-[12px] text-[#888888]">향후 3개월 이내 소멸 예정인 포인트 합계 내역만 조회됩니다.</span>
      </div>
    </div>

    <div class="w-full mt-[24px] mb-[54px]">
      <TabView class="default_tab" v-model:activeIndex="activeTab">
        <!-- 통합 포인트 -->
        <TabPanel header="통합 포인트">
          <div class="text-[15px]">통합 소멸 예정 포인트 내역입니다. (특별 포인트 제외)</div>

          <!-- 데이터 있을 경우 -->
          <div v-if="list1?.length > 0" class="w-full flex flex-col rounded-xl border border-[#E7E7E7] mt-[20px] px-[20px]">
            <div v-for="(item, i) in list1" :key="i" class="flex justify-between py-[20px]" :class="[i !== 0 ? ' border-t border-[#E7E7E7]' : '']">
              <div class="flex flex-col">
                <span class="text-[16px] font-bold">{{ item.title }}</span>
                <span class="text-[13px] text-[#666] mt-[10px]">{{ `유효기간 만료일: ${item.date}` }}</span>
              </div>
              <div class="flex flex-col text-right justify-center" :class="[item.pointType === 'plus' ? 'text-[#D20F27]' : '']">
                <span class="text-[16px]">
                  <strong class="mr-0.5">{{ item.point }}</strong
                  >P
                </span>
              </div>
            </div>
          </div>
          
          <!-- 데이터 없을 경우 -->
          <div v-else class="empty">
            <i ></i>
            <span>소멸 예정 포인트 내역이 없습니다.</span>
          </div>
        </TabPanel>
        <TabPanel header="특별 포인트">
          <div class="text-[15px]">특별 포인트 소멸 예정 포인트 내역입니다.</div>

          <!-- 데이터 있을 경우 -->
          <div v-if="list2?.length > 0" class="w-full flex flex-col rounded-xl border border-[#E7E7E7] mt-[20px] px-[20px]">
            <div v-for="(item, i) in list2" :key="i" class="flex justify-between py-[20px]" :class="[i !== 0 ? ' border-t border-[#E7E7E7]' : '']">
              <div class="flex flex-col">
                <span class="text-[16px] font-bold">{{ item.title }}</span>
                <span class="text-[13px] text-[#666] mt-[10px]">{{ `유효기간 만료일: ${item.date}` }}</span>
              </div>
              <div class="flex flex-col text-right justify-center" :class="[item.pointType === 'plus' ? 'text-[#D20F27]' : '']">
                <span class="text-[16px]">
                  <strong class="mr-0.5">{{ item.point }}</strong
                  >P
                </span>
              </div>
            </div>
          </div>

          <!-- 데이터 없을 경우 -->
          <div v-else class="empty">
            <i ></i>
            <span>소멸 예정 포인트 내역이 없습니다.</span>
          </div>
        </TabPanel>
      </TabView>
    </div>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'sub',
  title: '소멸 예정 포인트'
});

interface ListType {
  title: string;
  date: string;
  type: string;
  pointType: string;
  point: string;
}

const list1: ListType[] = [
  { title: '포인트 소멸', date: '2023-11-30', type: '활동 적립', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '구매 사용', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '영수증 적립', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '특별 포인트', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '유효기간 만료로 소멸', pointType: 'minus', point: '-1,000' },
];

const list2: ListType[] = [
  // { title: '포인트 소멸', date: '2023-11-30', type: '활동 적립', pointType: 'minus', point: '-1,000' },
  // { title: '포인트 소멸', date: '2023-11-30', type: '구매 사용', pointType: 'minus', point: '-1,000' },
  // { title: '포인트 소멸', date: '2023-11-30', type: '영수증 적립', pointType: 'minus', point: '-1,000' },
  // { title: '포인트 소멸', date: '2023-11-30', type: '특별 포인트', pointType: 'minus', point: '-1,000' },
  // { title: '포인트 소멸', date: '2023-11-30', type: '유효기간 만료로 소멸', pointType: 'minus', point: '-1,000' },
];

const activeTab = ref(0);
</script>

<style scoped>
.empty {
  margin-top: 80px;
  display: flex;
  flex-direction: column;
  align-items: center;
  color: #888888;
  font-weight: 500;
  font-size: 16px;

  i {
    width: 40px;
    height: 40px;
    background-image: url("data:image/svg+xml,%3Csvg width='40' height='40' viewBox='0 0 40 40' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_1292_13378)'%3E%3Ccircle cx='20' cy='20' r='20' fill='%23C8D1E2'/%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M20 11C19.1716 11 18.5 11.6716 18.5 12.5V22.5C18.5 23.3284 19.1716 24 20 24C20.8284 24 21.5 23.3284 21.5 22.5V12.5C21.5 11.6716 20.8284 11 20 11ZM20 26C18.8954 26 18 26.8954 18 28C18 29.1046 18.8954 30 20 30C21.1046 30 22 29.1046 22 28C22 26.8954 21.1046 26 20 26Z' fill='white'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_1292_13378'%3E%3Crect width='40' height='40' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
    background-repeat: no-repeat;
    margin-bottom: 20px;
  }
}
</style>
