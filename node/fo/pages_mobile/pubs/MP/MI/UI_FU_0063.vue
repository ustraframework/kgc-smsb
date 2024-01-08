<template>
  <form class="m-[20px]">
    <div class="mb-[40px] p-[20px] rounded-[12px] bg-[#F4F6FA]">
      <p class="mb-[20px] text-black">
        회원 탈퇴 신청 전 유의사항을 확인하세요. <br />탈퇴하시면 현재 보유하고 계신 멤버십 포인트는
        <em class="text-[#D20F27]">즉시 자동 소멸</em>합니다. <br /><em class="text-[#D20F27]">90일</em>간 다시 가입할 수 없습니다.
      </p>

      <p class="flex items-center text-[#888] border-t border-[#E7E7E7] pt-[20px]">
        <img src="@/assets/images/svg/ico_info.svg" class="mr-1" alt="정보" />
        유의사항
      </p>
      <ul class="warning__list">
        <li>
          <span class="dot"></span> 한국인삼공사 통합회원 탈퇴 시 온라인/오프라인에서 적립되었던 포인트/쿠폰 등은 즉시 삭제 처리되며 환급되지
          않습니다.(재가입시 복원 불가)
        </li>
        <li>
          <span class="dot"></span> 회원탈퇴 후 90일간 재가입이 불가능 하며, 금일 탈퇴할 경우 <span class="text-black">2024년 03월 01일</span> 부터
          재가입이 가능합니다.
        </li>
        <li><span class="dot"></span> 진행중인 구매내역이 있을 경우 회원 탈퇴가 불가능하며, 구매 확정 후 탈퇴 하실 수 있습니다.</li>
        <li>
          <span class="dot"></span> 소비자보호에 관한 법률 제6조(거래기록의 보전 등) 및 동법 시행령 제6조에 의거, 계약 또는 청약철회 등에 관한 기록은
          5년, 대금결제 및 재화 등의 공급에 기록은 5년, 소비자의 불만 또는 분쟁처리에 관한 기록은 3년 동안 보관됩니다. 동 개인정보는 법률에 의한
          경우가 아니고 서는 보유 되어지는 이외의 다른 목적으로는 이용되지 않습니다.
        </li>
        <li><span class="dot"></span> 연결된 SNS 계정은 탈퇴 즉시 자동 연결 해제 됩니다.</li>
      </ul>
    </div>

    <!-- title -->
    <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
      <h2 class="text-xl font-bold">탈퇴사유</h2>
    </div>
    <!-- //title -->

    <!-- contents -->
    <ul class="pt-[20px] mb-[40px]">
      <li class="flex items-start mb-[8px] py-[16px] px-[24px] border border-[#E7E7E7] rounded-[8px]">
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="reason" inputId="reason1" name="reason1" value="이용 횟수 적음" />
          <label class="!text-base" for="reason1">이용 횟수 적음</label>
        </div>
      </li>
      <li class="flex items-start mb-[8px] py-[16px] px-[24px] border border-[#E7E7E7] rounded-[8px]">
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="reason" inputId="reason2" name="reason2" value="서비스를 이용하기 어려움" />
          <label class="!text-base" for="reason2">서비스를 이용하기 어려움</label>
        </div>
      </li>
      <li class="flex items-start mb-[8px] py-[16px] px-[24px] border border-[#E7E7E7] rounded-[8px]">
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="reason" inputId="reason3" name="reason3" value="서비스 불만족" />
          <label class="!text-base" for="reason3">서비스 불만족</label>
        </div>
      </li>
      <li class="flex items-start mb-[8px] py-[16px] px-[24px] border border-[#E7E7E7] rounded-[8px]">
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="reason" inputId="reason4" name="reason4" value="상품 금액의 불만족" />
          <label class="!text-base" for="reason4">상품 금액의 불만족</label>
        </div>
      </li>
      <li class="flex items-start mb-[8px] py-[16px] px-[24px] border border-[#E7E7E7] rounded-[8px]">
        <div class="flex items-center">
          <RadioButton class="p-radiobutton-box-lg" v-model="reason" inputId="reason5" name="reason5" value="직접 입력" />
          <label class="!text-base" for="reason5">직접 입력</label>
        </div>
      </li>
      <li>
        <InputText class="w-full" v-model="value1" type="text" size="large" placeholder="내용을 입력해주세요" />
      </li>
    </ul>
    <!-- //contents -->

    <!-- title -->
    <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
      <h2 class="text-xl font-bold">통합 ID 탈퇴</h2>
    </div>
    <!-- //title -->

    <!-- contents -->
    <ul class="pt-[20px] mb-[40px]">
      <li>
        <div class="flex items-center">
          <Checkbox class="p-checkbox-box-lg" v-model="member" inputId="member" name="member" value="정관장 멤버스 탈퇴" />
          <label for="member"> 정관장 멤버스 탈퇴 </label>
        </div>
      </li>
    </ul>

    <!-- title -->
    <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
      <h2 class="text-xl font-bold">채널 탈퇴</h2>
    </div>
    <!-- //title -->

    <!-- contents -->
    <ul>
      <li class="pt-[20px]">
        <div class="flex flex-col gap-6">
          <div class="flex items-center">
            <Checkbox class="p-checkbox-box-lg" v-model="service1" inputId="service1" name="service1" value="정관장몰 서비스 탈퇴" />
            <label for="service1"> 정관장몰 서비스 탈퇴 </label>
          </div>
          <div class="flex items-center">
            <Checkbox class="p-checkbox-box-lg" v-model="service2" inputId="service2" name="service2" value="케어나우 서비스 탈퇴" />
            <label for="service2"> 케어나우 서비스 탈퇴 </label>
          </div>
        </div>
      </li>
    </ul>
    <!-- //contents -->

    <div class="flex mt-[48px] gap-2">
      <Button class="flex-1" label="취소" size="large" outlined />
      <Button class="flex-1" label="탈퇴하기" size="large" />
    </div>
  </form>
</template>

<script setup lang="ts">
import { ref } from 'vue';

definePageMeta({
  layout: 'sub',
});

// radio
const reason = ref('');

// input
const value1 = ref('');

// checkbox
const member = ref();
const service1 = ref();
const service2 = ref();
</script>

<style scoped></style>
