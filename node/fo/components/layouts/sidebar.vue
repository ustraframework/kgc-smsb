<template>
  <div class="pr-[80px]">
    <h1 class="text-[24px] text-[#000] font-bold">마이페이지</h1>
    <ul class="flex flex-col mt-[23px]">
      <li class="main_list">포인트조회</li>
      <li class="main_list">쿠폰조회</li>
      <li class="main_list">구매내역 조회</li>
      <li class="main_list">포인트 선물</li>
      <li class="main_list" style="margin-bottom: 20px;">내정보 수정</li>

      <li class="sub_list">회원정보 변경</li>
      <li class="sub_list">비밀번호 변경</li>
      <li class="sub_list">기념일 관리</li>
      <li class="sub_list">단골매장 관리</li>
      <li class="sub_list">회원탈퇴</li>
    </ul>
  </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.main_list {
  font-size: 18px;
  margin-bottom: 23px;
  color: #000;
}

.sub_list {
  font-size: 15px;
  margin-bottom: 18px;
  color: var(--j-gray400);
}
</style>