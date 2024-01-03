<template>
  <div class="flex flex-col items-center m-[20px]">
    <!-- <h1 class="text-[30px] font-medium mb-[30px]">포인트 선물</h1> -->

    <div class="w-full flex flex-col items-center gap-[4px] bg-[#F4F6FA] p-[20px] rounded-[12px]">
      <span class="text-[15px] font-medium"> 선물 가능한 포인트 </span>
      <span class="text-[30px] text-[#D20F27]"> <strong class="mr-0.5">1,000</strong>P </span>
    </div>

    <div class="w-full mt-[40px]">
      <div class="flex justify-between items-center pb-[6px] border-b-[2px] border-[#666666]">
        <h2 class="text-[20px] font-bold">받는 사람 선택</h2>
      </div>
    </div>

    <div class="flex flex-col gap-[8px] w-full mt-[20px]">
      <InputText v-model="name" size="large" placeholder="이름" class="w-full" />
      <InputText v-model="phoneNumber" size="large" placeholder="휴대폰번호(-없이 입력해주세요)" class="w-full" />
      <Button label="조회하기" severity="secondary" @click="onClickSearch()" class="search_btn" />
    </div>

    <!-- 조회하기 클릭 시 보여지는 영역 -->
    <template v-if="isShowBottom">
      <div class="name__box">
        <span>
          선물 받을 분 :
          <strong>
            {{ name }}
          </strong>
        </span>
      </div>

      <div class="w-full mt-[60px]">
        <div class="flex justify-between items-center pb-[6px] border-b-[2px] border-[#666666]">
          <h2 class="text-[20px] font-bold">선물 할 포인트</h2>
        </div>
      </div>

      <div class="flex gap-[8px] w-full mt-[20px]">
        <InputText v-model="point" size="large" placeholder="1P 이상 선물 가능" class="flex-1" />
      </div>

      <Button label="선물하기" size="large" class="gift_btn" @click="onClickGift()" />
    </template>

    <!-- 유의사항 -->
    <div class="w-full mt-[40px] p-[16px] rounded-[8px] bg-[#F9FAFC]">
      <h3 class="flex items-center mb-[8px] text-[#888] font-medium">
        <img src="@/assets/images/svg/ico_info.svg" class="mr-1" alt="정보" />
        유의사항
      </h3>
      <ul class="warning__list">
        <li class="text-black">
          <span class="dot"></span>
          정관장 멤버스 본인인증을 완료한 회원에게만 선물하기가 가능합니다. (본인인증을 하지 않은 회원은 불가합니다)
        </li>
        <li>
          <span class="dot"></span>
          선물 받은 포인트의 유효기간은 6개월입니다.
        </li>
        <li>
          <span class="dot"></span>
          선물하기 완료 후 취소처리는 불가합니다.
        </li>
        <li>
          <span class="dot"></span>
          1일 1회 선물하기 및 선물받기 가능합니다.
        </li>
        <li>
          <span class="dot"></span>
          선물 받은 포인트는 연장이 불가하며, 재선물이 되지 않습니다.
        </li>
      </ul>
    </div>
  </div>

  <!-- 선물 완료 팝업 -->
  <Dialog v-model:visible="isShowPopup" modal :style="{ width: '500px' }">
    <div class="dialog-content-inner max-h-[456px]">
      <p class="text-center text-[14px] text-black">
        {{ `${name}님에게 ${point || 0}P 선물 완료` }}
      </p>
    </div>
    <template #footer>
      <div class="flex justify-center pt-[24px] pb-[30px] px-[30px] gap-[10px]">
        <Button label="확인" @click="isShowPopup = false" />
      </div>
    </template>
  </Dialog>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'sub',
});

const isShowBottom = ref(false);
const isShowPopup = ref(false);

const name = ref('');
const phoneNumber = ref('');
const point = ref('');

const onClickSearch = () => {
  if (name.value) isShowBottom.value = true;
  else isShowBottom.value = false;
};

const onClickGift = () => {
  isShowPopup.value = true;
};
</script>

<style scoped>
.search_btn {
  padding: 12px 30px;

  ::v-deep(.p-button-label) {
    font-size: 15px;
    font-weight: 700;
  }
}

.name__box {
  padding: 34px 42.5px;
  margin-top: 40px;
  border-radius: 8px;
  border: 1px solid #c8d1e2;
  font-size: 16px;
}

.gift_btn {
  color: var(--j-white);
  margin-top: 24px;
  width: 100%;
}
</style>
