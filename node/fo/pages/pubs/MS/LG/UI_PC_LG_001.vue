<template>
  <div class="w-[624px] m-auto py-[60px] mb-[60px] rounded-[16px] border border-[#ECF0F8]">
    <h2 class="mb-[12px] text-center text-3xl font-bold">로그인</h2>
    <p class="mb-[40px] text-center text-base"><strong>정관장 멤버스 통합 아이디</strong>로 다양한 서비스를 이용해보세요.</p>
    <form class="flex flex-col w-[320px] mx-auto">
      <InputText class="w-full" v-model="userId" type="text" size="large" placeholder="아이디" />
      <p class="mt-[5px] text-[13px] text-[#F43131]">Error message</p>
      <Password
        class="w-full mt-[8px]"
        inputClass="p-inputtext-lg w-full"
        v-model="userPassword"
        :feedback="false"
        toggleMask
        placeholder="비밀번호"
      />
      <p class="mt-[5px] text-[13px] text-[#F43131]">Error message</p>
      <div class="flex items-center mt-[16px]">
        <Checkbox class="p-checkbox-box-lg" v-model="save" inputId="idSave" name="save" value="아이디 저장" />
        <label for="idSave"> 아이디 저장 </label>
      </div>
      <Button class="w-full mt-[24px]" label="로그인" size="large" />
      <div class="flex justify-center items-center mt-[20px] px-[20px] text-[15px]">
        <router-link to="/">아이디 찾기</router-link>
        <span class="mx-[12px] h-[16px] border-l border-[#E7E7E7]"></span>
        <router-link to="/">비밀번호 재설정</router-link>
        <span class="mx-[12px] h-[16px] border-l border-[#E7E7E7]"></span>
        <router-link to="/">회원가입</router-link>
      </div>
      <div class="pt-[40px]">
        <div
          class="relative h-[23px] mb-[20px] text-center after:absolute after:z-1 after:top-1/2 after:content-[''] after:block after:w-full after:h-[1px] after:bg-[#E0E0E0]"
        >
          <h3 class="relative inline-flex align-top z-10 px-[8px] text-[15px] bg-[white] text-[#666]">간편 로그인</h3>
        </div>

        <div class="flex justify-center gap-5">
          <button class="sns-btn is-kakao" type="button" @click="visible1 = true">카카오 로그인</button>
          <button class="sns-btn is-naver" type="button" @click="visible2 = true">네이버 로그인</button>
          <button class="sns-btn is-apple" type="button">애플 로그인</button>
        </div>
      </div>
    </form>

    <Dialog v-model:visible="visible1" modal header="간편로그인" :style="{ width: '500px' }">
      <div class="p-[40px] text-center">
        <h1 class="text-3xl text-black font-bold mb-[12px]">SNS 계정 연결</h1>
        <p class="mb-[40px]">
          <strong>정관장 멤버스에 가입된 회원정보가 있습니다.</strong> <br />기존에 가입된 계정으로 로그인 하면 SNS 계정과 연동하여 간편하게 로그인할
          수 있습니다.
        </p>
        <form class="flex flex-col w-[320px] mx-auto text-left">
          <InputText class="w-full" v-model="userId1" type="text" size="large" placeholder="아이디" />
          <p class="mt-[5px] text-[13px] text-[#F43131]">아이디를 입력해주세요</p>
          <Password
            class="w-full mt-[8px]"
            inputClass="p-inputtext-lg w-full"
            v-model="userPassword2"
            :feedback="false"
            toggleMask
            placeholder="비밀번호"
          />
          <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호를 입력해주세요</p>
          <Button class="w-full mt-[24px]" label="계정 연결" size="large" />
          <div class="flex justify-center items-center mt-[20px] px-[20px] text-[15px]">
            <router-link to="/">아이디 찾기</router-link>
            <span class="mx-[12px] h-[16px] border-l border-[#E7E7E7]"></span>
            <router-link to="/">비밀번호 재설정</router-link>
            <span class="mx-[12px] h-[16px] border-l border-[#E7E7E7]"></span>
            <router-link to="/">회원가입</router-link>
          </div>
        </form>
      </div>
    </Dialog>

    <Dialog v-model:visible="visible2" modal header="간편로그인" :style="{ width: '500px' }">
      <div class="p-[40px] text-center">
        <h1 class="text-3xl text-black font-bold mb-[12px]">SNS 계정 연결</h1>
        <p class="mb-[40px]">
          <strong>정관장 멤버스에 가입된 회원정보가 있습니다.</strong> <br />기존에 가입된 계정으로 로그인 하면 SNS 계정과 연동하여 간편하게 로그인할
          수 있습니다.
        </p>
        <form class="flex flex-col w-[320px] mx-auto text-left">
          <div class="flex items-center">
            <RadioButton v-model="ingredient" inputId="ingredient11" name="rice" value="Radio1" />
            <label for="ingredient11">Radio1</label>
          </div>
          <Password
            class="w-full mt-[20px]"
            inputClass="p-inputtext-lg w-full"
            v-model="userPassword2"
            :feedback="false"
            toggleMask
            placeholder="비밀번호"
          />
          <p class="mt-[5px] text-[13px] text-[#F43131]">비밀번호를 입력해주세요</p>
          <Button class="w-full mt-[24px]" label="계정 연결" size="large" />
          <div class="flex justify-center items-center mt-[20px] px-[20px] text-[15px]">
            <router-link to="/">비밀번호 재설정</router-link>
            <span class="mx-[12px] h-[16px] border-l border-[#E7E7E7]"></span>
            <router-link to="/">회원가입</router-link>
          </div>
        </form>
      </div>
    </Dialog>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// dialog
const visible1 = ref(false);
const visible2 = ref(false);

// input
const userId = ref('');
const userPassword = ref('');
const userId1 = ref('');
const userPassword2 = ref('');

// checkbox
const save = ref('');

// radio
const ingredient = ref('');
</script>

<style lang="scss" scoped></style>
