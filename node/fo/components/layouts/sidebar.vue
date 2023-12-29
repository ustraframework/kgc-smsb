<template>
  <div class="min-w-[150px] mr-[40px]">
    <h1 class="text-2xl text-black font-bold">{{ pageTitle }}</h1>
    <ul class="flex flex-col mt-[15px]" v-for="pageInfo in pageList" :key="pageInfo.id">
      <li class="main_item">
        <router-link :to="pageInfo.url" v-if="pageInfo.url !== '#none'">{{ pageInfo.title }}</router-link>
        <!-- sub 메뉴 있을 시-->
        <a href="#none" v-else>{{ pageInfo.title }}</a> 
        <ul class="sub_list" v-if="pageInfo.sub && pageInfo.sub.length > 0">
          <li class="sub_item" v-for="subInfo in pageInfo.sub" :key="subInfo.id">
            <router-link :to="subInfo.url">{{ subInfo.title }}</router-link>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script setup>
const route = useRoute();

const pageName = ref(route.name);
const myPageList = [
  {id:1 , url: '/pubs/MP/PI/UI_FU_0019', title: '포인트 조회'},
  {id:2 , url: '/pubs/MP/CI/UI_FU_0018', title: '쿠폰 조회'},
  {id:3 , url: '/pubs/MP/PI_2/UI_FU_0021', title: '구매내역 조회'},
  {id:4 , url: '/pubs/MP/PG/UI_FU_0020', title: '포인트 선물'},
  {id:5 , url: '#none', title: '내정보 수정', sub: [
    {id:'5-1' , url: '/', title: '회원정보 변경'},
    {id:'5-2' , url: '/', title: '비밀번호 변경'},
    {id:'5-3' , url: '/pubs/MP/MI/UI_FU_0024', title: '기념일 관리'},
    {id:'5-4' , url: '/pubs/MP/MI/UI_FU_0026', title: '단골매장 관리'},
    {id:'5-5' , url: '/', title: '회원 탈퇴'},
  ]},
];

const customerList = [
  {id: 1 , url: '/pubs/CS/FQ/UI_FU_0015' , title: '자주하는 질문'},
  {id: 2 , url: '/pubs/CS/NT/UI_FU_0013' , title: '공지사항'},
]

const pageTitle = computed(() => {
  return pageName.value === 'customer' ? '고객센터' : '마이페이지';
})
const pageList = computed(() => {
  return pageName.value === 'customer' ? customerList : myPageList;
})

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