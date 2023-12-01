<template>
  <div class="my-auto mx-[20px] border border-[#ECF0F8] rounded-2xl text-center overflow-hidden">
    <div class="py-[40px] px-[20px]">
      <h1 class="text-2xl font-bold mb-[12px]">아이디 찾기</h1>
      <p class="text-sm mb-[30px]">입력하신 정보와 일치하는 아이디입니다. <br />개인정보를 위해 <strong>전체 아이디는 본인인증 후</strong>에 찾으실 수 있습니다.</p>

      <div class="inline-block min-w-[215px] py-[33px] px-[20px] rounded-[8px] border border-[#C8D1E2] font-bold text-lg text-center">
        abce12*****
      </div>
    </div>

    <div class="border-t border-[#ECF0F8] py-[20px] px-[14px] bg-[#F9FAFC]">
      <p class="text-sm mb-[12px]">* 본인 명의로 등록된 휴대폰 번호를 이용해 본인인증</p>
      <Button class="is-phone" label="휴대폰 본인인증 하기">
        <template #icon>
          <svg class="mr-[4px]" width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M13.3334 2.66667C13.3334 1.2 12.1334 0 10.6667 0H5.33341C3.86675 0 2.66675 1.2 2.66675 2.66667V13.3333C2.66675 14.8 3.86675 16 5.33341 16H10.6667C12.1334 16 13.3334 14.8 13.3334 13.3333V2.66667ZM8.66675 14.6667H7.33342C6.93341 14.6667 6.66675 14.4 6.66675 14C6.66675 13.6 6.93341 13.3333 7.33342 13.3333H8.66675C9.06675 13.3333 9.33342 13.6 9.33342 14C9.33342 14.4 9.06675 14.6667 8.66675 14.6667ZM12.0001 11.3333C12.0001 11.7333 11.7334 12 11.3334 12H4.66675C4.26675 12 4.00008 11.7333 4.00008 11.3333V3.33333C4.00008 2.93333 4.26675 2.66667 4.66675 2.66667H11.3334C11.7334 2.66667 12.0001 2.93333 12.0001 3.33333V11.3333Z"
              fill="#464646"
            />
          </svg>
        </template>
      </Button>
    </div>
  </div>
  <div class="flex p-[20px] gap-2">
    <Button class="flex-1" label="비밀번호 재설정" size="large" />
    <Button class="flex-1" label="로그인" size="large" outlined />
  </div>
</template>

<script setup></script>

<style lang="scss" scoped></style>
