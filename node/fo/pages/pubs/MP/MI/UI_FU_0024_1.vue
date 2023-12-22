<template>
  <div class="flex flex-col items-center w-[650px]">
    <h1 class="text-[30px] font-medium mb-[30px]">기념일 관리</h1>
    <div class="w-full bg-[#F4F6FA] p-[24px] rounded-[12px]">
      <div class="flex justify-between items-center">
        <span class="text-[15px]">나의 기념일을 등록해보세요. 최대 7개까지 가능합니다.</span>
        <Button label="기념일 등록"/>
      </div>
    </div>

    <div class="w-full mt-[40px]">
      <h3 class="text-[#000] text-[15px] font-medium">총 4건</h3>
      <div class="grid grid-cols-2 gap-[16px] mt-[20px]">
        <div class="card" v-for="item in cardList" :key="item.id">
          <div class="flex items-center justify-between mb-[20px]">
            <div class="title-box">
              <span>{{ item.title }}</span>
            </div>
            <div class="flex gap-[20px]">
              <img src="@/assets/images/svg/ico_edit.svg">
              <img src="@/assets/images/svg/ico_delete.svg">
            </div>
          </div>
          <div class="card-desc">
            <span>{{ item.gender }}</span>
            <span>{{ item.date }}</span>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup lang="ts">
definePageMeta({
  layout: 'side',
})

const cardList = reactive([
  {id: 1, title: '결혼기념일' , gender : '남자', date: '[양력] 2000-11-30'},
  {id: 2, title: '부모 생일' , gender : '여자', date: '[양력] 2010-04-20'},
  {id: 3, title: '배우자 생일' , gender : '남자', date: '[양력] 1986-02-25'},
  {id: 4, title: '자녀 생일' , gender : '남자', date: '[양력] 2019-05-16'},
])

</script>

<style scoped>
.card {
  padding: 20px;
  border: 1px solid var(--j-gray200);
  border-radius: 8px;

  .title-box{
    padding: 6px 8px;
    background-color: #FFF5EF;

    span {
      color: #F46144;
      font-weight: 500;
    }
  }
  
  .card-desc{
    display: flex;
    align-items: center;
    justify-content: space-between;

    span {
      font-size: 16px;
      color: #000;
    }
  }
}
</style>