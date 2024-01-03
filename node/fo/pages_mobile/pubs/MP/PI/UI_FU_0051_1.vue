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

    <div class="w-full mt-[24px]">
      <TabView class="default_tab" v-model:activeIndex="activeTab">
        <!-- 통합 포인트 -->
        <TabPanel header="통합 포인트">
          <div class="text-[15px]">통합 소멸 예정 포인트 내역입니다. (특별 포인트 제외)</div>

          <div class="w-full flex flex-col rounded-xl border border-[#E7E7E7] mt-[20px] px-[20px]">
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
        </TabPanel>
        <TabPanel header="특별 포인트">
          <div class="text-[15px]">특별 포인트 소멸 예정 포인트 내역입니다.</div>

          <div class="w-full flex flex-col rounded-xl border border-[#E7E7E7] mt-[20px] px-[20px]">
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
        </TabPanel>
      </TabView>
    </div>
  </div>
</template>

<script setup lang="ts">
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
  { title: '포인트 소멸', date: '2023-11-30', type: '활동 적립', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '구매 사용', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '영수증 적립', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '특별 포인트', pointType: 'minus', point: '-1,000' },
  { title: '포인트 소멸', date: '2023-11-30', type: '유효기간 만료로 소멸', pointType: 'minus', point: '-1,000' },
];

const activeTab = ref(0);
</script>

<style scoped></style>
