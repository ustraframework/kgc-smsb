<template>
  <div class="sign flex flex-col flex-1">
    <div class="flex items-center h-[170px] px-[40px] bg-[#F9FAFC]">
      <Steps class="w-full" v-model:activeStep="active" :model="items" />
    </div>
    <div class="flex-1 pt-[40px] px-[20px] pb-[14px]">
      <p class="text-xl text-center mb-[30px]">정관장 멤버스 회원가입을 위한 <br /><strong>서비스 약관동의</strong>가 필요해요.</p>

      <div>
        <div :class="{ '!border-[#D20F27]': agreeAll }" class="flex items-center px-[24px] py-[15px] mb-[16px] border rounded-lg border-[#E7E7E7]">
          <Checkbox :binary="true" class="p-checkbox-box-lg" v-model="agreeAll" inputId="agreeAll" name="pizza" value="agreeAll" />
          <label :class="{ 'font-bold': agreeAll }" class="!text-base !ml-[12px]" for="agreeAll"> 전체 약관동의 </label>
        </div>
        <ul>
          <li class="flex items-center justify-between px-[16px] h-[50px]">
            <div class="overflow-hidden text-ellipsis whitespace-nowrap">
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree1" name="agree" value="agree1" />
              <label class="!text-[15px] !ml-[8px]" for="agree1"> [필수] 통합 회원약관 </label>
            </div>
            <Button class="flex-none" label="내용보기" text />
          </li>
          <li class="flex items-center justify-between px-[16px] h-[50px]">
            <div class="overflow-hidden text-ellipsis whitespace-nowrap">
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree2" name="agree" value="agree2" />
              <label class="!text-[15px] !ml-[8px]" for="agree2"> [필수] 케어나우 회원약관 </label>
            </div>
            <Button class="flex-none" label="내용보기" text />
          </li>
          <li class="flex items-center justify-between px-[16px] h-[50px]">
            <div class="overflow-hidden text-ellipsis whitespace-nowrap">
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree3" name="agree" value="agree3" />
              <label class="!text-[15px] !ml-[8px]" for="agree3"> [필수] 개인정보 수집 및 이용 </label>
            </div>
            <Button class="flex-none" label="내용보기" text />
          </li>
          <li class="flex items-center justify-between px-[16px] h-[50px]">
            <div class="overflow-hidden text-ellipsis whitespace-nowrap">
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree4" name="agree" value="agree4" />
              <label class="!text-[15px] !ml-[8px]" for="agree4"> [선택] 광고성 정보 수신 </label>
            </div>
            <Button class="flex-none" label="내용보기" text />
          </li>
        </ul>

        <div class="flex items-start mt-[16px] pt-[20px] px-[16px] border-t border-[#E7E7E7]">
          <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeSubmit" name="agree" value="agreeSubmit" />
          <label class="!ml-[12px] !text-sm !text-[#888]" for="agreeSubmit">
            본인은 만 14세 이상으로 개인정보 및 약관동의 내용을 확인하였으며, 위 내용에 동의합니다.
          </label>
        </div>
      </div>
    </div>
    <div class="flex gap-2 mt-auto p-[20px]">
      <Button class="flex-1" label="취소" size="large" outlined />
      <Button class="flex-1" label="다음" size="large" />
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// steps
// active 0, 1, 2 값으로 active 값 구분
const active = ref(0);
const items = ref([
  {
    label: '약관동의',
  },
  {
    label: '정보입력',
  },
  {
    label: '가입완료',
  },
]);

// checkbox
const agreeAll = ref(false);
const agree = ref();
</script>

<style lang="scss" scoped></style>
