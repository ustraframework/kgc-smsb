<template>
  <!-- 통합회원에는 is-integration class add -->
  <div class="sign is-integration">
    <div class="flex items-center h-[200px] bg-[#F9FAFC]">
      <Steps class="w-[340px] mx-auto" v-model:activeStep="active" :model="items" />
    </div>
    <div class="w-[550px] mx-auto pt-[80px] pb-[65px]">
      <p class="text-xl text-center mb-[30px] tracking-[-0.3px]">정관장 멤버스 통합ONE ID를 위한 <strong>서비스 약관동의</strong>를 선택해주세요.</p>

      <div>
        <div :class="{ '!border-[#D20F27]': agreeAl1 }" class="flex items-center px-[24px] py-[16px] mb-[16px] border rounded-lg border-[#E7E7E7]">
          <Checkbox :binary="true" class="p-checkbox-box-lg" v-model="agreeAll1" inputId="agreeAll1" name="pizza" value="agreeAll" />
          <label :class="{ 'font-bold': agreeAll1 }" class="!text-base !ml-[12px]" for="agreeAll1"> 전체 약관동의 </label>
        </div>
        <ul class="mb-[24px]">
          <li class="flex items-center justify-between px-[24px] h-[50px]">
            <div>
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree1" name="agree" value="agree1" />
              <label class="!text-[16px] !ml-[12px]" for="agree1"> [필수] 통합 회원약관 </label>
            </div>
            <Button label="내용보기" text @click="agree1 = true" />
          </li>
          <li class="flex items-center justify-between px-[24px] h-[50px]">
            <div>
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree3" name="agree" value="agree3" />
              <label class="!text-[16px] !ml-[12px]" for="agree3"> [필수] 개인정보 수집 및 이용 </label>
            </div>
            <Button label="내용보기" text />
          </li>
          <li class="flex items-center justify-between px-[24px] h-[50px]">
            <div>
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree4" name="agree" value="agree4" />
              <label class="!text-[16px] !ml-[12px]" for="agree4"> [선택] 광고성 정보 수신 </label>
            </div>
            <Button label="내용보기" text />
          </li>
        </ul>

        <div :class="{ '!border-[#D20F27]': agreeAll2 }" class="flex items-center px-[24px] py-[16px] mb-[16px] border rounded-lg border-[#E7E7E7]">
          <Checkbox :binary="true" class="p-checkbox-box-lg" v-model="agreeAll2" inputId="agreeAll2" name="pizza" value="agreeAll" />
          <label :class="{ 'font-bold': agreeAll2 }" class="!text-base !ml-[12px]" for="agreeAll2"> 전체 약관동의 </label>
        </div>
        <ul class="pb-[16px] mb-[60px] border-b border-[#E7E7E7]">
          <li class="flex items-center justify-between px-[24px] h-[50px]">
            <div>
              <Checkbox class="non-rounded p-checkbox-box-lg" v-model="agree" inputId="agree2" name="agree" value="agree2" />
              <label class="!text-[16px] !ml-[12px]" for="agree2"> [필수] 케어나우 회원약관 </label>
            </div>
            <Button label="내용보기" text />
          </li>
        </ul>

        <div class="flex gap-2">
          <Button @click="$router.push('/')" class="flex-1" label="취소" size="large" outlined />
          <Button class="flex-1" label="다음" size="large" />
        </div>
      </div>
    </div>

    <!-- 약관 팝업 -->
    <Dialog v-model:visible="agree1" modal header="약관" :style="{ width: '500px' }">
      <div class="dialog-content-inner max-h-[456px]">
        <h2 class="mb-1 font-bold text-[15px] text-black">타이틀</h2>
        <p class="text-sm text-[#666]">약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>
      </div>
      <template #footer>
        <div class="border-t border-[#E7E7E7] pt-[24px] pb-[30px] px-[30px]">
          <Button class="block mx-auto" label="확인" @click="agree1 = false" />
        </div>
      </template>
    </Dialog>
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
    label: 'ID선택',
  },
  {
    label: '전환완료',
  },
]);

// checkbox
const agreeAll1 = ref(false);
const agreeAll2 = ref(false);
const agree = ref();

// 약관 팝업 visible
const agree1 = ref(false);
</script>

<style lang="scss" scoped></style>
