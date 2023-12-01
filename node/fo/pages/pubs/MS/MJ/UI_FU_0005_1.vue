<template>
  <!-- 통합회원에는 is-integration class add -->
  <div class="sign is-integration">
    <div class="flex items-center h-[200px] bg-[#F9FAFC]">
      <Steps class="w-[340px] mx-auto" v-model:activeStep="active" :model="items" />
    </div>

    <div class="w-[550px] mx-auto pt-[80px] pb-[105px]">
      <p class="mb-[16px] text-xl text-center">
        원하시는 <strong>아이디</strong>를 선택해주세요.
      </p>
      <ul class="mb-[30px] p-[16px] rounded-[8px] bg-[#F9FAFC]">
        <li class="text-[#888]"><span class="font-bold">&middot;</span> ID 계정중 하나를 선택하시면, 나머지 한 개의 계정은 삭제됩니다.</li>
        <li class="text-[#888]"><span class="font-bold">&middot;</span> 새로운 아이디 생성을 하시면 기존에 있는 계정은 삭제됩니다.</li>
      </ul>
      <form>
        <!-- title -->
        <div class="flex items-end justify-between pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">가입된 아이디 선택</h2>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="pt-[20px] mb-[60px]">
          <li class="flex items-center mb-[16px]">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="carenowId">케어나우</label>
            <div class="flex flex-1">
              <RadioButton class="p-radiobutton-box-lg flex-none mr-[12px]" v-model="integrationId" inputId="integration1" name="integration" value="케어나우 아이디" />
              <InputText disabled v-model="integration1" id="integration1" class="flex-1" type="text" size="large" placeholder="케어나우 아이디" />
            </div>
          </li>
          <li class="flex items-center">
            <label class="flex-none w-[150px] text-[14px] text-[#222]" for="carenowId">정관장몰</label>
            <div class="flex flex-1">
              <RadioButton class="p-radiobutton-box-lg flex-none mr-[12px]" v-model="integrationId" inputId="integration2" name="integration" value="정관장몰 아이디" />
              <InputText disabled v-model="integration2" id="integration2" class="flex-1" type="text" size="large" placeholder="정관장몰 아이디" />
            </div>
          </li>
        </ul>
        <!-- //contents -->

        <!-- title -->
        <div class="flex items-end justify-between pb-[6px] border-b-2 border-[#666]">
          <h2 class="text-xl font-bold">ONE ID 직접 입력</h2>
        </div>
        <!-- //title -->

        <!-- contents -->
        <ul class="pt-[20px] mb-[60px]">
          <li class="flex items-start mb-[24px]">
            <label class="flex-none w-[150px] leading-[50px] text-[14px] text-[#222]" for="userId">아이디</label>
            <div class="flex flex-col w-full">
              <div class="flex gap-2">
                <InputText v-model="userId" id="userId" class="flex-1" type="text" size="large" placeholder="아이디" />
                <button type="button" class="h-[50px] px-[30px] rounded-[4px] font-bold text-[15px] text-[#758EBC] bg-[#ECF0F8]">중복 확인</button>
              </div>
              <!-- positive -->
              <!-- <p class="mt-[5px] text-[13px] text-[#5361E7]">비밀번호가 일치 합니다</p> -->
              <!-- error -->
              <p class="mt-[5px] text-[13px] text-[#F43131]">이미 사용 중인 아이디입니다. 다시 입력해주세요.</p>

              <p class="flex-none mt-[8px] text-[13px] text-[#888] leading-[1.2]">
                6~20자 이하의 영문, 숫자 조합(허용 특수문자’_’, 띄어쓰기 사용 불가)
              </p>
            </div>
          </li>
          <li class="flex items-start mb-[24px]">
            <label class="flex-none w-[150px] leading-[50px] text-[14px] text-[#222]" for="userPassword1">비밀번호</label>
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
          <li class="flex items-start">
            <label class="flex-none w-[150px] leading-[50px] text-[14px] text-[#222]" for="userPassword2">비밀번호 확인</label>
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
        
        <div class="flex gap-2">
          <Button class="flex-1" label="취소" size="large" outlined />
          <Button class="flex-1" label="다음" size="large" />
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
    label: 'ID선택',
  },
  {
    label: '전환완료',
  },
]);

// input
const integration1 = ref('test1234');
const integration2 = ref('test007');
const userId = ref('');
const userPassword1 = ref('');
const userPassword2 = ref('');

// radio
const integrationId = ref('');
</script>

<style lang="scss" scoped></style>
