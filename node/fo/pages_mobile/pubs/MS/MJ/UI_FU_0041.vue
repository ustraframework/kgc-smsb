<template>
  <div class="sign">
    <div class="flex items-center h-[170px] px-[40px] bg-[#F9FAFC]">
      <Steps class="w-full" v-model:activeStep="active" :model="items" />
    </div>

    <div class="pt-[40px] px-[20px] pb-[20px]">
      <form>
        <!-- title -->
        <div class="flex items-end justify-between pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">기본정보</h2>
          <p class="text-[13px] text-[#666]"><span class="text-[#F46144]">*</span> 표시는 필수입력</p>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="pt-[20px] mb-[40px]">
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="signName">이름</label>
            <InputText disabled v-model="signName" id="signName" class="w-full" type="text" size="large" placeholder="이름을 입력해주세요." />
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="gender">성별</label>
            <InputText disabled v-model="gender" id="gender" class="w-full" type="text" size="large" />
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="birth">생년월일</label>
            <InputText disabled v-model="birth" id="birth" class="w-full" type="text" size="large" />
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="realBirth">실제 생년월일</label>
            <div class="flex flex-col w-full">
              <div class="flex gap-2">
                <Dropdown disabled class="flex-1" inputClass="p-inputtext-lg" v-model="year" :options="years" optionLabel="name" placeholder="년" />
                <Dropdown disabled class="flex-1" inputClass="p-inputtext-lg" v-model="month" :options="months" optionLabel="name" placeholder="월" />
                <Dropdown disabled class="flex-1" inputClass="p-inputtext-lg" v-model="day" :options="days" optionLabel="name" placeholder="일" />
              </div>
              <div class="flex flex-col pt-[20px]">
                <div class="flex mb-[16px]">
                  <div class="flex items-center">
                    <RadioButton class="p-radiobutton-box-lg" v-model="birthInfo" inputId="birthInfo1" name="birthInfo" value="양력" />
                    <label for="birthInfo1">양력</label>
                  </div>
                  <div class="flex items-center ml-[20px]">
                    <RadioButton class="p-radiobutton-box-lg" v-model="birthInfo" inputId="birthInfo2" name="birthInfo" value="음력" />
                    <label for="birthInfo2">음력</label>
                  </div>
                </div>
                <p class="text-[13px] text-[#5361E7]"><span class="font-bold">&middot;</span> 생일정보 입력하시면 혜택을 드립니다</p>
              </div>
            </div>
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="phone">휴대폰 번호</label>
            <InputText disabled v-model="phone" id="phone" class="w-full" type="text" size="large" />
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm">내/외국인 <span class="text-[#F46144]">*</span></label>
            <div class="flex">
              <div class="flex items-center">
                <RadioButton class="p-radiobutton-box-lg" v-model="native" inputId="native1" name="native" value="양력" />
                <label for="native1">내국인</label>
              </div>
              <div class="flex items-center ml-[20px]">
                <RadioButton class="p-radiobutton-box-lg" v-model="native" inputId="native2" name="native" value="음력" />
                <label for="native2">외국인</label>
              </div>
            </div>
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="userId">아이디 <span class="text-[#F46144]">*</span></label>
            <div class="flex flex-col">
              <div class="flex gap-2">
                <InputText v-model="userId" id="userId" class="flex-1" type="text" size="large" placeholder="아이디" />
                <button type="button" class="h-[50px] px-[30px] rounded-[4px] font-bold text-[15px] text-[#758EBC] bg-[#ECF0F8]">중복 확인</button>
              </div>
              <!-- positive -->
              <!-- <p class="mt-[5px] text-[13px] text-[#5361E7]">비밀번호가 일치 합니다</p> -->
              <!-- error -->
              <p class="mt-[5px] text-[13px] text-[#F43131]">이미 사용 중인 아이디입니다. 다시 입력해주세요.</p>

              <p class="flex-none mt-[8px] text-[13px] text-[#888] leading-[1.2]">
                6~20자 이하의 영문, 숫자 조합<br />(허용 특수문자’_’, 띄어쓰기 사용 불가)
              </p>
            </div>
          </li>
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="userPassword1">비밀번호 <span class="text-[#F46144]">*</span></label>
            <div class="flex flex-col w-full">
              <Password
                inputId="userPassword1"
                inputClass="p-inputtext-lg w-full"
                v-model="userPassword1"
                :feedback="false"
                toggleMask
                placeholder="비밀번호"
              />
              <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호를 입력해주세요</p>
              <p class="mt-[8px] text-[13px] text-[#888] leading-[1.2]">
                영문 대/소문자, 숫자, 특수문자 8자 이상 3가지 이상 조합 <br />(허용 특수문자 !@#$%^&*( ) )
              </p>
            </div>
          </li>
          <li class="flex flex-col">
            <label class="py-[9px] text-sm" for="userPassword2">비밀번호 확인<span class="text-[#F46144]">*</span></label>
            <div class="flex flex-col w-full">
              <Password
                class="w-full"
                inputId="userPassword2"
                inputClass="p-inputtext-lg w-full"
                v-model="userPassword2"
                :feedback="false"
                toggleMask
                placeholder="비밀번호 확인"
              />
              <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호 확인을 입력해주세요</p>
            </div>
          </li>
        </ul>
        <!-- //contents -->

        <!-- title -->
        <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">추가정보</h2>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="pt-[20px] mb-[40px]">
          <li class="flex flex-col mb-[20px]">
            <label class="py-[9px] text-sm" for="userEmail">이메일</label>
            <div>
              <div class="flex w-full gap-2">
                <InputText v-model="userEmail" id="userEmail" class="w-full" type="text" size="large" placeholder="이메일" />
                <Dropdown inputClass="p-inputtext-lg" v-model="domein" :options="domeins" optionLabel="name" class="w-[160px] flex-none" />
              </div>
              <p class="mt-[5px] text-[13px] text-[#F43131]">이메일을 입력해주세요</p>
            </div>
          </li>
          <li class="flex flex-col">
            <label class="py-[9px] text-sm" for="userAddress">주소</label>
            <div class="flex flex-col w-full">
              <div class="flex gap-2">
                <InputText v-model="userAddress" id="userAddress" class="flex-1" type="text" size="large" placeholder="주소를 검색하세요." />
                <button type="button" class="h-[50px] px-[30px] rounded-[4px] font-bold text-[15px] text-[#758EBC] bg-[#ECF0F8]">주소검색</button>
              </div>
              <InputText
                v-model="userEmail"
                id="detailAddress"
                class="w-full mt-[8px]"
                type="text"
                size="large"
                placeholder="상세주소를 입력하세요."
              />
            </div>
          </li>
        </ul>
        <!-- //contents -->

        <!-- title -->
        <div class="flex items-end pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">마케팅 정보 수신 동의 <span class="text-base font-normal">(선택)</span></h2>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="mb-[60px]">
          <li class="pt-[20px] pb-[15px] border-b border-[#E7E7E7]">
            <div class="flex items-center">
              <Checkbox class="p-checkbox-box-lg" v-model="agreeAll" inputId="agreeAll" name="agreeAll" value="전체동의" />
              <label for="agreeAll"> 전체동의 </label>
            </div>
          </li>
          <li class="pt-[15px]">
            <div class="flex flex-wrap items-center mb-[20px] gap-6">
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
            <p class="text-[13px] text-[#5361E7]"><span class="font-bold">&middot;</span> 생일정보 입력하시면 혜택을 드립니다</p>
          </li>
        </ul>
        <!-- //contents -->
        <div class="flex gap-2">
          <Button class="flex-1" label="취소" size="large" outlined />
          <Button class="flex-1" label="완료" size="large" />
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// steps
// active 0, 1, 2 값으로 active 값 구분
const active = ref(1);
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

// input
const signName = ref('홍길동');
const gender = ref('남자');
const birth = ref('2000-10-10');
const phone = ref('010-1234-5678');
const userId = ref('');
const userPassword1 = ref('');
const userPassword2 = ref('');
const userEmail = ref('');
const userAddress = ref('');

// radio
const birthInfo = ref('');
const native = ref('');

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
</script>

<style lang="scss" scoped></style>
