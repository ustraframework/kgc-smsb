<template>
  <div class="flex flex-col items-center my-auto p-[20px]">
    <i>
      <svg width="52" height="52" viewBox="0 0 52 52" fill="none" xmlns="http://www.w3.org/2000/svg">
        <g clip-path="url(#clip0_1080_7357)">
          <circle cx="26" cy="26" r="26" fill="#D20F27" />
          <path
            d="M16.5 26.125L23.0231 32.6481C23.2177 32.8427 23.533 32.8435 23.7285 32.6498L36.5 20"
            stroke="white"
            stroke-width="3.5"
            stroke-linecap="round"
          />
        </g>
        <defs>
          <clipPath id="clip0_1080_7357">
            <rect width="52" height="52" fill="white" />
          </clipPath>
        </defs>
      </svg>
    </i>
    <p class="mt-[20px] text-2xl"><strong>탈퇴가 완료</strong>되었습니다.</p>
    <p class="mt-[16px] text-center text-sm">그동안 정관장 멤버스 포인트 서비스를 이용해 주셔서 감사 드립니다. 더 나은 서비스로 찾아 뵙겠습니다.</p>
    <Button @click="$router.push('/')" class="w-[160px] mt-[40px]" label="홈으로 가기" size="large" />
  </div>
</template>

<script setup></script>

<style lang="scss" scoped></style>
