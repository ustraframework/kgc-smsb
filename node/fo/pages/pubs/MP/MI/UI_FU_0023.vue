<template>
  <div class="w-[650px]">
    <h1 class="text-center font-medium text-3xl">회원정보 변경</h1>
    <form class="mt-[30px]">
      <div class="mb-[40px] p-[24px] rounded-[12px] bg-[#F4F6FA]">
        <div class="flex items-center justify-between">
          <p>내정보가 변경되었으면 수정해주세요.</p>
          <Button label="변경" outlined />
        </div>

        <ul class="py-[20px] text-base">
          <li class="flex gap-[40px]">
            <p class="flex-none w-[74px] text-[#666]">이름</p>
            <p class="text-black">홍*동</p>
          </li>
          <li class="flex gap-[40px] mt-[8px]">
            <p class="flex-none w-[74px] text-[#666]">아이디</p>
            <p class="text-black">ab****</p>
          </li>
          <li class="flex gap-[40px] mt-[8px]">
            <p class="flex-none w-[74px] text-[#666]">성별</p>
            <p class="text-black">여</p>
          </li>
          <li class="flex gap-[40px] mt-[8px]">
            <p class="flex-none w-[74px] text-[#666]">생년월일</p>
            <p class="text-black">2001-10-10</p>
          </li>
          <li class="flex gap-[40px] mt-[8px]">
            <p class="flex-none w-[74px] text-[#666]">휴대폰번호</p>
            <p class="text-black">010-1234-5678</p>
          </li>
        </ul>

        <p class="flex items-center text-[#888] border-t border-[#E7E7E7] pt-[20px]">
          <img src="@/assets/images/svg/ico_info.svg" class="mr-1" alt="정보" />
          기본정보 변경은 본인인증 완료시 최신 정보로 업데이트됩니다.
        </p>
      </div>

      <!-- title -->
      <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
        <h2 class="text-xl font-bold">기본정보</h2>
      </div>
      <!-- //title -->

      <!-- contents -->
      <ul class="pt-[20px] mb-[60px]">
        <li class="flex items-start mb-[24px]">
          <label class="flex-none w-[150px] leading-[50px] text-[14px] text-[#222]" for="birthday">실제 생년월일</label>
          <div class="flex flex-wrap gap-5">
            <Calendar class="flex-1" inputClass="!h-[50px]" inputId="birthday" v-model="birthday" placeholder="2023-01-01" />
            <div class="flex flex-none">
              <div class="flex items-center">
                <RadioButton class="p-radiobutton-box-lg" v-model="birthInfo" inputId="birthInfo1" name="birthInfo" value="양력" />
                <label for="birthInfo1">양력</label>
              </div>
              <div class="flex items-center ml-[20px]">
                <RadioButton class="p-radiobutton-box-lg" v-model="birthInfo" inputId="birthInfo2" name="birthInfo" value="음력" />
                <label for="birthInfo2">음력</label>
              </div>
            </div>
            <ul class="w-full text-[13px] text-[#5361E7]">
              <li>&middot; 생년월일을 입력하시면 생일혜택을 드립니다.</li>
              <li>&middot; 혜택은 1년에 1번만 받으실 수 있습니다.</li>
            </ul>
          </div>
        </li>
        <li class="flex items-start mb-[24px]">
          <label class="flex-none w-[150px] leading-[50px] text-[14px] text-[#222]" for="userEmail">이메일</label>
          <div class="w-full">
            <div class="flex gap-2">
              <InputText v-model="userEmail" id="userEmail" class="w-full" type="text" size="large" placeholder="abc123@gmail.com" />
              <Dropdown inputClass="p-inputtext-lg" v-model="domein" :options="domeins" optionLabel="name" class="w-[160px] flex-none" />
            </div>
            <p class="mt-[5px] text-[13px] text-[#F43131]">이메일을 입력해주세요</p>
          </div>
        </li>
        <li class="flex items-start mb-[24px]">
          <label class="flex-none w-[150px] leading-[50px] text-[14px] text-[#222]" for="userAddress">주소</label>
          <div class="flex flex-col w-full">
            <div class="flex gap-2">
              <InputText v-model="userAddress1" id="userAddress" class="flex-1" type="text" size="large" placeholder="주소를 검색하세요." />
              <button type="button" class="h-[50px] px-[30px] rounded-[4px] font-bold text-[15px] text-[#758EBC] bg-[#ECF0F8]">주소검색</button>
            </div>
            <InputText
              v-model="userAddress2"
              id="detailAddress"
              class="w-full mt-[8px]"
              type="text"
              size="large"
              placeholder="상세주소를 입력하세요."
            />
          </div>
        </li>
        <li class="flex items-center">
          <label class="flex-none w-[150px] text-[14px] text-[#222]" for="gender">SNS 계정 연동</label>
          <div class="flex w-full justify-between">
            <p class="flex items-center text-[15px]">
              <img class="w-[32px] mr-2" src="@/assets/images/svg/kakao-sns.svg" alt="kakao" />
              <!-- <img class="w-[32px] mr-2" src="@/assets/images/svg/naver-sns.svg" alt="naver"> -->
              <!-- <img class="w-[32px] mr-2" src="@/assets/images/svg/apple-sns.svg" alt="apple"> -->
              카카오 2023-09-06 14:42
            </p>
            <button type="button" class="h-[50px] px-[30px] rounded-[4px] font-bold text-[15px] text-[#758EBC] bg-[#ECF0F8]">연결해제</button>
          </div>
        </li>
      </ul>
      <!-- //contents -->

      <!-- title -->
      <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
        <h2 class="text-xl font-bold">마케팅 채널 동의 <span class="text-base font-normal">(선택)</span></h2>
      </div>
      <!-- //title -->

      <!-- contents -->
      <ul class="pt-[20px] mb-[60px]">
        <li>
          <div class="flex items-center justify-between">
            <div class="flex items-center">
              <Checkbox
                class="p-checkbox-box-lg"
                v-model="personAgree"
                inputId="personAgree"
                name="personAgree"
                value="혜택제공 및 분석을 위한 개인정보 수집 및 이용 동의"
              />
              <label for="personAgree"> 혜택제공 및 분석을 위한 개인정보 수집 및 이용 동의 </label>
            </div>
            <Button label="내용보기" text @click="personVisible = true" />
          </div>
        </li>
      </ul>

      <!-- title -->
      <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
        <h2 class="text-xl font-bold">마케팅 정보 수신 동의 <span class="text-base font-normal">(선택)</span></h2>
      </div>
      <!-- //title -->

      <!-- contents -->
      <ul>
        <li class="py-[20px] border-b border-[#E7E7E7]">
          <div class="flex items-center">
            <Checkbox class="p-checkbox-box-lg" v-model="agreeAll" inputId="agreeAll" name="agreeAll" value="전체동의" />
            <label for="agreeAll"> 전체동의 </label>
          </div>
        </li>
        <li class="pt-[20px]">
          <div class="flex flex-wrap items-center mb-[22px] gap-6">
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeEmail" name="agreeEmail" value="이메일" />
              <label for="agreeEmail"> 이메일 </label>
            </div>
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeSms" name="agreeSms" value="문자" />
              <label for="agreeSms"> 문자 </label>
            </div>
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreeTel" name="agreeTel" value="전화" />
              <label for="agreeTel"> 전화 </label>
            </div>
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agree" inputId="agreePost" name="agreePost" value="우편" />
              <label for="agreePost"> 우편 </label>
            </div>
          </div>
          <p class="text-[13px] text-[#5361E7] ml-[8px]">
            <span class="font-bold">&middot;</span> 마케팅 정보 수신에 동의하시면 다양한 혜택을 받아 보실 수 있습니다.
          </p>
        </li>
      </ul>
      <!-- //contents -->

      <div class="flex mt-[60px] gap-2">
        <Button class="flex-1" label="취소" size="large" outlined />
        <Button class="flex-1" label="수정" size="large" />
      </div>
    </form>

    <!-- 약관 팝업 -->
    <Dialog v-model:visible="personVisible" modal header="약관" :style="{ width: '500px' }">
      <div class="dialog-content-inner max-h-[456px]">
        <h2 class="mb-1 font-bold text-[15px] text-black">타이틀</h2>
        <p class="text-sm text-[#666]">약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>

        <h2 class="mt-5 mb-1 font-bold text-[15px] text-black">타이틀타이틀</h2>
        <p class="text-sm text-[#666]">약관내용약관내용약관내용약관내용</p>
      </div>
      <template #footer>
        <div class="border-t border-[#E7E7E7] pt-[24px] pb-[30px] px-[30px]">
          <Button class="block mx-auto" label="확인" @click="personVisible = false" />
        </div>
      </template>
    </Dialog>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { onMounted } from '#ustra/nuxt';
import { defaultOptions } from 'primevue/config';

definePageMeta({
  layout: 'side',
});

// 캘린더
const i18n = {
  dateFormat: 'yy-mm-dd',
  dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  showMonthAfterYear: true,
};

onMounted(() => {
  // Prime Vue Calendar 한국어 변경
  Object.assign(defaultOptions.locale, i18n);
});

// input
const birthday = ref('');
const userEmail = ref('');
const userAddress1 = ref('');
const userAddress2 = ref('');

// radio
const birthInfo = ref('');

// dropdown
const year = ref();
const month = ref();
const day = ref();

const years = ref([
  { name: '2022', code: '2022' },
  { name: '2023', code: '2023' },
]);
const months = ref([
  { name: '01', code: 'january' },
  { name: '02', code: 'february' },
]);
const days = ref([
  { name: '01', code: '01' },
  { name: '02', code: '01' },
]);

const domein = ref('');
const domeins = ref([
  { name: '직접입력', code: '직접입력' },
  { name: '@naver.com', code: 'naver' },
  { name: '@hanmail.net', code: 'daum' },
  { name: '@gmail.com', code: 'google' },
]);

// checkbox
const agreeAll = ref();
const agree = ref();
const personAgree = ref();

// dialog
const personVisible = ref(false);
</script>

<style scoped></style>
