<template>
  <div class="flex flex-col items-center my-[20px]">
    <TabView class="fill_tab industry_custom_tab mb-[46px]" v-model:activeIndex="activeTab">

      <!-- 멤버스 소개 -->
      <TabPanel header="멤버스 소개">
        <div class="tabInner__title flex flex-col">
          <h2>멤버스 소개</h2>
          <p>
            정관장 멤버스는 정관장몰, 케어나우, 사푼사푼의 <br />
            혜택을 누릴 수 있는 정관장 통합 서비스입니다. <br />
            정관장 멤버스 회원이 되면 KGC인삼공사에서  <br />
            진행하는 각종 혜택도 누릴 수 있습니다.
          </p>
        </div>

        <div class="flex flex-col gap-[20px] mt-[24px] w-full">
          <div class="card level">
            <h3>등급별 혜택</h3>
            <p> {{ `멤버스 회원에게 제공하는\n차별화된 혜택` }}</p>
          </div>
          <div class="card point1">
            <h3>포인트 적립</h3>
            <p> {{ `전국 정관장 매장, 정관장몰,\n 케어나우, 사푼사푼 카페` }}</p>
          </div>
          <div class="card point2">
            <h3>포인트 사용</h3>
            <p> {{ `전국 정관장 매장, 정관장몰, \n 케어나우, 사푼사푼 카페` }}</p>
          </div>
        </div>
      </TabPanel>

      <TabPanel header="멤버스 혜택" />
      <TabPanel header="매장찾기" />
      <TabPanel header="포인트 쓰기" />
    </TabView>
  </div>
</template>
<script setup lang="ts">
import { ref } from "vue";

const activeTab = ref(0);

definePageMeta({
  layout: 'sub',
});

</script>

<style scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;

  &.border-b {
    border-color: #ECF0F8;
    padding-bottom: 24px;
    margin: 0 20px;
  }

  h2 {
    font-weight: 700;
    font-size: 30px;
    line-height: 45px;
  }

  p {
    color: var(--j-gray500);
    margin-top: 8px;
    line-height: 22.4px;
    font-size: 14px;
  }
}

/* == 멤버스 소개 == */
.card {
  background-color: var(--j-bluegray300);
  border-radius: 16px;
  padding: 30px 30px;
  position: relative;
  display: flex;
  flex-direction: column;
  height: 280px;
  margin: 0 20px;

  h3 {
    font-weight: 500;
    font-size: 24px;
    line-height: 36px;
  }

  p {
    margin-top: 4px;
    color: var(--j-gray500);
    font-size: 14px;
    white-space: pre-line;
  }
  
  &.level::after {
    content: '';
    height: 158px;
    width: 180px;
    position: absolute;
    bottom: 10px;
    right: 20px;
    background-image: url('@/assets/images/intro/level-benefit-mobile.png');
    background-position: right bottom;
  }

  &.point1::after {
    content: '';
    height: 131px;
    width: 195px;
    position: absolute;
    bottom: 10px;
    right: 20px;
    background-image: url('@/assets/images/intro/point-acml-mobile.png');
    background-position: right bottom;
  }

  &.point2::after {
    content: '';
    height: 150px;
    width: 190px;
    position: absolute;
    bottom: 10px;
    right: 20px;
    background-image: url('@/assets/images/intro/point-use-mobile.png');
    background-position: right bottom;
  }
}
/* ============== */
</style>