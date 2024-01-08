<template>
  <div class="flex flex-col items-center w-[650px]">
    <h1 class="text-[30px] font-medium mb-[30px]">소멸 포인트 조회</h1>

    <div class="w-[650px] bg-[#F4F6FA] p-[24px] rounded-[12px]">
      <div class="flex flex-col justify-center items-center mb-[20px] border-b border-[#E7E7E7] pb-4">
        <span class="text-[18px]"> 당월 소멸 예정 포인트 </span>
        <span class="text-[30px] text-[#D20F27] mt-2"> <strong class="mr-0.5">1,000</strong>P </span>
      </div>

      <div class="flex justify-between items-center mb-4">
        <div class="flex items-center">
          <span class="text-[15px] font-medium mr-4">12월 소멸 예정 포인트</span>
          <span class="text-[20px]"> <strong class="mr-0.5">500</strong>P </span>
        </div>
        <div class="flex items-center">
          <span class="text-[15px] font-medium mr-4"> 1월 소멸 예정 포인트 </span>
          <span class="text-[20px]"> <strong class="mr-0.5">1,000</strong>P </span>
        </div>
      </div>

      <div class="flex items-center">
        <img src="@/assets/images/svg/ico_info.svg" class="mr-1" alt="정보" />
        <span class="text-[12px] text-[#888888]"> 향후 <strong>3개월</strong> 이내 소멸 예정인 포인트 합계 내역만 조회됩니다. </span>
      </div>
    </div>

    <div class="w-full mt-[40px]">
      <TabView class="default_tab" v-model:activeIndex="activeTab">
        <!-- 통합 포인트 -->
        <TabPanel header="통합 포인트">
          <div class="text-[15px]">통합 소멸 예정 포인트 내역입니다. (특별 포인트 제외)</div>

          <div class="w-full flex flex-col rounded-[12px] border border-[#E7E7E7] mt-5 px-8 py-2">
            <div v-for="(item, i) in list1" :key="i" class="flex justify-between py-6" :class="[i !== 0 ? ' border-t border-[#E7E7E7]' : '']">
              <div class="flex flex-col">
                <span class="text-[18px] font-bold">{{ item.title }}</span>
                <span class="text-[14px] text-[#666] mt-2.5">{{ `유효기간 만료일: ${item.date}` }}</span>
              </div>
              <div class="flex flex-col text-right justify-center" :class="[item.pointType === 'plus' ? 'text-[#D20F27]' : '']">
                <span class="text-[18px]">
                  <strong class="mr-0.5">{{ item.point }}</strong
                  >P
                </span>
              </div>
            </div>
          </div>
        </TabPanel>

        <!-- 특별 포인트 -->
        <TabPanel header="특별 포인트">
          <div class="text-[15px]">특별 포인트 소멸 예정 포인트 내역입니다.</div>

          <div class="w-full flex flex-col rounded-[12px] border border-[#E7E7E7] mt-5 px-8 py-2">
            <div v-for="(item, i) in list2" :key="i" class="flex justify-between py-6" :class="[i !== 0 ? ' border-t border-[#E7E7E7]' : '']">
              <div class="flex flex-col">
                <span class="text-[18px] font-bold">{{ item.title }}</span>
                <span class="text-[14px] text-[#666] mt-2.5">{{ `유효기간 만료일: ${item.date}` }}</span>
              </div>
              <div class="flex flex-col text-right justify-center" :class="[item.pointType === 'plus' ? 'text-[#D20F27]' : '']">
                <span class="text-[18px]">
                  <strong class="mr-0.5">{{ item.point }}</strong
                  >P
                </span>
              </div>
            </div>
          </div>
        </TabPanel>
      </TabView>
    </div>

    <!-- <Button class="more_btn">
      <span class="mr-0.5">더보기</span>
      <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M10.2278 4.71875C10.2278 4.25276 9.85006 3.875 9.38407 3.875C8.91808 3.875 8.54032 4.25276 8.54032 4.71875V9.04032H4.21875C3.75276 9.04032 3.375 9.41808 3.375 9.88407C3.375 10.3501 3.75276 10.7278 4.21875 10.7278H8.54032V15.0492C8.54032 15.5152 8.91808 15.8929 9.38407 15.8929C9.85006 15.8929 10.2278 15.5152 10.2278 15.0492V10.7278H14.5492C15.0152 10.7278 15.3929 10.3501 15.3929 9.88407C15.3929 9.41808 15.0152 9.04032 14.5492 9.04032H10.2278V4.71875Z" fill="#758EBC"/>
      </svg>
    </Button> -->
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

definePageMeta({
  layout: 'side',
});

const activeTab = ref(0);
</script>

<style scoped>
.more_btn {
  margin-top: 20px;
  margin-bottom: 80px;
  font-size: 15px;
  text-align: center;
  width: 100%;
  background-color: #ecf0f8;
  color: #758ebc;
  line-height: 22.5px;
  padding: 15px 0;
  justify-content: center;
}
</style>
