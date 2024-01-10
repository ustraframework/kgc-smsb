<template>
  <div class="py-[30px] px-[80px]">
    <!-- ########################################################## -->
    <h2 class="text-[16px] font-bold mb-[10px]">가입한 회원(통합ONE ID 미전환 시)</h2>
    <Button label="팝업 열기" @click="modalVisible = true" class="mr-[10px]" outlined />
    <!-- 가입한 회원(통합ONE ID 미전환 시)-->
    <Dialog class="alert" v-model:visible="modalVisible" modal header="" :style="{ width: '360px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2>이미 가입한 회원입니다.</h2>
        <h2 class="font-bold">통합ID 전환 하시겠습니까?</h2>
      </div>
      <template #footer>
        <div class="alert-footer-inner">
          <Button label="취소" @click="modalVisible = false" class="mr-[10px]" outlined />
          <Button label="확인" @click="modalVisible = false" />
        </div>
      </template>
    </Dialog>

    <!-- ########################################################## -->
    <h2 class="text-[16px] font-bold mt-[20px] mb-[10px]">가입한 회원(통합ONE ID 미전환 시)</h2>
    <Button label="팝업 열기" @click="modalVisible2 = true" class="mr-[10px]" outlined />
    <!-- 가입한 회원(통합ONE ID 전환 시)-->
    <Dialog class="alert" v-model:visible="modalVisible2" modal header="" :style="{ width: '360px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2>이미 가입한 회원입니다.</h2>
        <h2 class="font-bold">로그인 하시겠습니까?</h2>
      </div>
      <template #footer>
        <div class="alert-footer-inner">
          <Button label="확인" @click="modalVisible2 = false" />
        </div>
      </template>
    </Dialog>

    <!-- ########################################################## -->
    <h2 class="text-[16px] font-bold mt-[20px] mb-[10px]">탈퇴 신청한 회원(90일 후 재가입 가능)</h2>
    <Button label="팝업 열기" @click="modalVisible3 = true" class="mr-[10px]" outlined />
    <!-- 탈퇴 신청한 회원(90일 후 재가입 가능)-->
    <Dialog class="alert" v-model:visible="modalVisible3" modal header="" :style="{ width: '380px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2>해당 아이디는 현재 회원탈퇴 처리된 회원입니다.</h2>
      </div>
      <template #footer>
        <div class="alert-footer-inner">
          <Button label="확인" @click="modalVisible3 = false" />
        </div>
      </template>
    </Dialog>

    <!-- ########################################################## -->
    <h2 class="text-[16px] font-bold mt-[20px] mb-[10px]">UI_FU_0007 - 안내 팝업 (정관장 멤버스 회원 아닐시 회원가입 진행 Alert)</h2>
    <Button label="팝업 열기" @click="modalVisible4 = true" class="mr-[10px]" outlined />
    <!-- 회원가입 진행 팝업 -->
    <Dialog class="alert" v-model:visible="modalVisible4" modal header="" :style="{ width: '360px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2>고객님은 정관장 멤버스 회원이 아닙니다.</h2>
        <h2 class="font-bold">회원가입을 진행하시겠습니까?</h2>
      </div>
      <template #footer>
        <div class="alert-footer-inner">
          <Button label="취소" @click="modalVisible4 = false" class="mr-[10px]" outlined />
          <Button label="확인" @click="modalVisible4 = false" />
        </div>
      </template>
    </Dialog>

    <!-- ########################################################## -->
    <h2 class="text-[16px] font-bold mt-[20px] mb-[10px]">UI_FU_0007 - 동의 내역 안내 팝업</h2>
    <Button label="팝업 열기" @click="modalVisible5 = true" class="mr-[10px]" outlined />
    <!-- 동의 내역 안내 팝업 -->
    <Dialog class="alert" v-model:visible="modalVisible5" modal header="" :style="{ width: '400px' }">
      <div class="alert-content-inner mt-[5px] mb-[12px]">
        <h2 class="font-bold">정관장 멤버스 광고정보 수신동의 정보가</h2>
        <h2 class="font-bold">정상적으로 변경되었습니다.</h2>
        <div class="flex justify-items-start mt-[18px]">
          <ul>
            <li class="flex items-center mb-[5px]">
              <span class="w-[60px] text-left">변경일자</span>
              <div class="border-r border-[#E7E7E7] py-[1px] h-[16px] mx-[8px]"></div>
              <span>2024년 01월 10일</span>
            </li>
            <li class="flex items-center mb-[5px]">
              <span class="w-[60px] text-left">동의</span>
              <div class="border-r border-[#E7E7E7] py-[1px] h-[16px] mx-[8px]"></div>
              <span></span>
            </li>
            <li class="flex items-center">
              <span class="w-[60px] text-left">비동의</span>
              <div class="border-r border-[#E7E7E7] py-[1px] h-[16px] mx-[8px]"></div>
              <span>이메일, 문자, 전화, 우편</span>
            </li>
          </ul>
        </div>

        <div class="mt-[18px] text-left">
          <p class="text-[13px] text-[#888888] mb-[5px]">
            광고정보 수신거부에 관계없이 회원 및 서비스 정책 변경, 법적 의무사항 등 고객 고지 내용은 정상 발송 됩니다.
          </p>
          <p class="text-[13px] text-[#888888]">광고정보 수집거부 전 예약 발송된 광고 메시지가 있는 경우 약 1~2일 동안 발송될 수 있습니다.</p>
        </div>
      </div>
      <template #footer>
        <div class="alert-footer-inner">
          <Button label="확인" @click="modalVisible5 = false" />
        </div>
      </template>
    </Dialog>
  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'none',
});

const modalVisible = ref(false);
const modalVisible2 = ref(false);
const modalVisible3 = ref(false);
const modalVisible4 = ref(false);
const modalVisible5 = ref(false);
</script>

<style scoped></style>
