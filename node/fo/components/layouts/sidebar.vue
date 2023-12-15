<template>
  <div class="min-w-[150px] mr-[40px]">
    <h1 class="text-2xl text-black font-bold">마이페이지</h1>
    <ul class="flex flex-col mt-[15px]">
      <li class="main_item">
        <router-link to="/">포인트 조회</router-link>
      </li>
      <li class="main_item">
        <router-link to="/">쿠폰 조회</router-link>
      </li>
      <li class="main_item">
        <router-link to="/">구매내역 조회</router-link>
      </li>
      <li class="main_item">
        <router-link to="/">포인트 선물</router-link>
      </li>
      <li class="main_item">
        <a href="#none">내정보 수정</a>

        <ul class="sub_list">
          <li class="sub_item">
            <router-link to="/">회원정보 변경</router-link>
          </li>
          <li class="sub_item">
            <router-link to="/">비밀번호 변경</router-link>
          </li>
          <li class="sub_item">
            <router-link to="/">기념일 관리</router-link>
          </li>
          <li class="sub_item">
            <router-link to="/">단골매장 관리</router-link>
          </li>
          <li class="sub_item">
            <router-link to="/">회원 탈퇴</router-link>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>
.main_item {
  &:not(:first-child) {
    margin-top: 5px;
  }
  

  > a {
    display: inline-block;
    padding: 8px 0 9px;
    font-size: 18px;
    color: #000;
  }
}

.sub_list {
  margin-top: 5px;
}

.sub_item {
  &:not(:first-child) {
    margin-top: 5px;
  }

  > a {
    display: inline-block;
    padding: 6px 0 7px;
    font-size: 15px;
    color: var(--j-gray400);
  }
}
</style>