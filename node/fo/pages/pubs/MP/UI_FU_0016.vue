<template>
  <div class="flex flex-col items-center w-[856px]">
    <div class="main__info">
      <div class="main__info-user">
        <div class="main__info-user-top">
          <Avatar :image="ico_family" size="large" />
          <span class="leading-[27px]">
            <strong class="text-[20px] leading-[30px]">홍길동</strong>
            님 <br /> 반갑습니다
          </span>
        </div>
        <Button label="회원정보변경" size="small" outlined />
      </div>

      <div class="flex flex-col">
        <span class="main__info-title icon_arrow">가용 포인트</span>
        <span class="text-[20px]">
          <strong class="mr-0.5">1,000</strong>P
        </span>
        <Button label="포인트 선물" class="mt-[20px] text-white" size="small" />
      </div>

      <div class="flex flex-col">
        <span class="main__info-title">특별 포인트</span>
        <span class="text-[20px]">
          <strong class="mr-0.5">5,000</strong>P
        </span>
      </div>

      <div class="flex flex-col">
        <span class="main__info-title">
          <span>소멸 예정 포인트</span>
          <span class="text-[12px] font-normal">(전일기준)</span>
        </span>
        <span class="text-[20px]">
          <strong class="mr-0.5">30</strong>P
        </span>
      </div>
    </div>

    <div class="rank__info">
      <Avatar :image="ico_family" size="xlarge" />
      <span class="rank__info-text">
        <strong>홍길동</strong>
        님의 등급은
        <br />
        <strong class="text-[#D20F27]">패밀리</strong>입니다
      </span>

      <div class="rank__info-benefit">
        <span>멤버스 등급혜택</span>
        <span class="percent">+0.5% 적립중</span>
      </div>
    </div>

    <div class="rank__progress flex items-center">
      <Steps
        class="w-[650px]"
        v-model:activeStep="activeProgress"
        :model="progressList"
        :style="{'--rank-percent': `${userInfo.rank_percent}%`}"
      >
        <template #item="{ item, index }">
          <span :style="{ color: item.color }" :class="[index === (progressList.length -1) ? 'items-end' : '', 'font-bold', 'flex', 'flex-col']">
            <img :src="item.icon" class="mb-[6px] w-[32px]" alt="등급 아이콘" />
            {{ item.label }}
          </span>
        </template>
      </Steps>
    </div>

    <div class="rank__date">
      <strong>산정기간 : </strong>
      <span>2022년 1월 1일 ~ 12월 31일</span>
    </div>


    <span
      class="w-[650px] mt-[24px] pb-[40px] text-[15px] icon_arrow border-b border-[#E7E7E7] cursor-pointer"
      @click="showPopup = true"
    >
      등급 혜택 안내
    </span>

    <Popup_0017 v-model="showPopup" />

    <div class="buttons">
      <div class="coupon">
        <span>
          보유 쿠폰 <br />
          <strong>3장</strong>
        </span>
        
      </div>

      <div class="store">
        <span>
          단골매장 <br />
          <strong>정관장 압구정점</strong>
        </span>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref } from "vue";

import ico_family from '@/assets/images/rank/ico_family.svg';
import ico_gold from '@/assets/images/rank/ico_gold.svg';
import ico_royalgold from '@/assets/images/rank/ico_royalgold.svg';
import ico_silver from '@/assets/images/rank/ico_silver.svg';

import ico_family_mini from '@/assets/images/rank/ico_family_mini.svg';
import ico_gold_mini from '@/assets/images/rank/ico_gold_mini.svg';
import ico_royalgold_mini from '@/assets/images/rank/ico_royalgold_mini.svg';
import ico_silver_mini from '@/assets/images/rank/ico_silver_mini.svg';

import Popup_0017 from './UI_FU_0017.vue';

const activeTab = ref(0);

const showPopup = ref(false);

const userInfo = ref({ name: '홍길동', rank: 'family', rank_percent: 20 });

const rankTab = ref([
  { label : '로얄골드', img: ico_royalgold },
  { label : '골드', img: ico_gold },
  { label : '실버', img: ico_silver },
  { label : '패밀리', img: ico_family }
]);

const activeProgress = ref(2);
const progressList = ref([
  {
    label: '로얄골드',
    icon: ico_royalgold_mini,
    color: '#E29323'
  },
  {
    label: '골드',
    icon: ico_gold_mini,
    color: '#CAA851'
  },
  {
    label: '실버',
    icon: ico_silver_mini,
    color: '#84919B'
  },
  {
    label: '패밀리',
    icon: ico_family_mini,
    color: '#D20F27'
  },
]);

definePageMeta({
  layout: 'side'
});

</script>

<style scoped>

.main__info {
  background-color: #F4F6FA;
  border-radius: 12px;
  display: flex;
  gap: 2px;
  width: 100%;

  & ~ * {
    margin-left: 103px;
    margin-right: 103px;
  }

  > * {
    flex: 1;
    padding: 24px 19px 24px 22px;

    &:not(:first-child) {
      border-left: 2px solid var(--j-white);
    }
  }

  button {
    width: fit-content;
  }

  .main__info-user {
    display: flex;
    flex-direction: column;
    gap: 20px;
    min-width: 250px;

    .main__info-user-top {
      display: flex;
      align-items: center;

      span {
        margin-left: 16px;
        font-size: 18px;
        line-height: 27px;
        flex: 1;
      }
    }
  }

  .main__info-title {
    font-size: 15px;
    font-weight: 500;
    margin-bottom: 4px;
  }
}

.rank__info {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 40px;

  .rank__info-text {
    margin-top: 16px;
    line-height: 36px;
    font-size: 24px;
    text-align: center;
  }

  .rank__info-benefit {
    margin-top: 16px;
    font-size: 15px;
    font-weight: 500;

    .percent {
      background-color: #FFF5EF;
      border-radius: 999px;
      padding: 4px 12px;
      color: var(--j-primary01);
      margin-left: 8px;
    }
  }
}

.rank__progress {
  margin-top: 60px;
}

.rank__date {
  margin-top: 16px;
  font-size: 16px;
  background-color: #F4F6FA;
  border: 1px solid #C8D1E2;
  border-radius: 999px;
  padding: 16px 0;
  width: 650px;
  text-align: center;
  position: relative;

  &::before,
  &::after {
    content: '';
    position: absolute;
    top: -6px;
    width: 10px;
    right: 49%;
    height: 10px;
    transform: rotate(45deg);
    border: 1px solid #C8D1E0;
    background-color: #F4F6FA;
    border-bottom: none;
    border-right: none;
  }
}

.buttons {
  display: flex;
  gap: 16px;
  margin-top: 40px;
  width: 650px;

  > * {
    background-color: #F6F6F6;
    border-radius: 4px;
    padding: 20px;
    flex: 1;
    display: flex;
    align-items: center;

    &::after {
      content: '';
      background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M6 2.5L13.8444 9.85409C13.9286 9.93311 13.9286 10.0669 13.8444 10.1459L6 17.5' stroke='black' stroke-width='1.2' stroke-linecap='round'/%3E%3C/svg%3E%0A");
      background-repeat: no-repeat;
      width: 20px;
      height: 20px;
      background-position: right center;
      flex: 1;
    }

    strong {
      font-size: 16px;
      margin-top: 2px;
    }
  }
  
  .coupon {
    position: relative;

    &::before {
      content: '';
      display: inline-block;
      background-image: url("data:image/svg+xml,%3Csvg width='44' height='44' viewBox='0 0 44 44' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_1292_12650)'%3E%3Cpath d='M21.7568 9.82074C19.6829 9.82074 17.8875 11.0125 17.0095 12.746C16.1282 11.0125 14.336 9.82074 12.2621 9.82074H4.81836V35.1792H12.2588C14.3327 35.1792 16.1282 33.9874 17.0062 32.254C17.8875 33.9874 19.6797 35.1792 21.7536 35.1792H39.1769V9.82074H21.7536H21.7568Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M17.0062 32.254C16.1249 33.9874 14.3327 35.1792 12.2588 35.1792H4.81836V9.82074H12.2588C14.3327 9.82074 16.1282 11.0125 17.0062 12.746' fill='%23F46144'/%3E%3Cpath d='M17.0062 32.254C16.1249 33.9874 14.3327 35.1792 12.2588 35.1792H4.81836V9.82074H12.2588C14.3327 9.82074 16.1282 11.0125 17.0062 12.746' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M17.0078 32.254V32.0898' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M16.999 32L17 13' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round' stroke-dasharray='3 3'/%3E%3Cpath d='M17.0078 12.9101V12.746' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M24.8965 26.3576L32.5761 18.6621' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M27.3627 19.4041C27.3627 18.4487 26.5895 17.6772 25.6394 17.6772C24.6892 17.6772 23.916 18.452 23.916 19.4041C23.916 20.3562 24.6892 21.131 25.6394 21.131C26.5895 21.131 27.3627 20.3562 27.3627 19.4041Z' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M31.8347 27.3425C32.7864 27.3425 33.558 26.5694 33.558 25.6156C33.558 24.6619 32.7864 23.8887 31.8347 23.8887C30.8829 23.8887 30.1113 24.6619 30.1113 25.6156C30.1113 26.5694 30.8829 27.3425 31.8347 27.3425Z' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_1292_12650'%3E%3Crect width='36' height='27' fill='white' transform='translate(4 9)'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
      background-repeat: no-repeat;
      width: 40px;
      height: 40px;
      margin-right: 16px;
    }
  }

  .store {
    position: relative;
    &::before {
      content: '';
      display: inline-block;
      background-image: url("data:image/svg+xml,%3Csvg width='44' height='44' viewBox='0 0 44 44' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M36 18V36H8V18' fill='white'/%3E%3Cpath d='M36 18V36H8V18' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M10 20C7.79032 20 6 18.3186 6 16.2434L7.77168 10.161C8.14468 8.88051 9.31826 8 10.652 8H14V16.2434C14 18.3186 12.2097 20 10 20Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M18 20C15.7903 20 14 18.3186 14 16.2434V8H22V16.2434C22 18.3186 20.2097 20 18 20Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M26 20C23.7903 20 22 18.3186 22 16.2434V8H30V16.2434C30 18.3186 28.2097 20 26 20Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M34 20C31.7903 20 30 18.3186 30 16.2434V8H33.348C34.6817 8 35.8553 8.88051 36.2283 10.161L38 16.2434C38 18.3186 36.2097 20 34 20Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M22 23C24.7605 23 27 25.1682 27 27.8409V36H17V27.8409C17 25.1682 19.2395 23 22 23Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
      background-repeat: no-repeat;
      width: 40px;
      height: 40px;
      margin-right: 16px;
    }
  }
}

::v-deep(.p-steps) {
  .p-steps-list {
    &::before {
      height: 5px;
      margin-top: -17px;
      border-color: #E7E7E7;
    }

    &::after {
      content: '';
      width: var(--rank-percent);
      height: 5px;
      top: 50%;
      right: 0;
      position: absolute;
      margin-top: -17px;
      border-top: 7px solid #D20F27;
      border-radius: 999px;
    }

    .p-steps-item {
      z-index: 2;
    }
  }
}

/* 공통 아이콘 */
.icon_arrow::after {
  content: '';
  width: 16px;
  height: 6px;
  display: inline-block;
  width: 10px;
  height: 10px;
  background-image: url("data:image/svg+xml,%3Csvg width='7' height='11' viewBox='0 0 7 11' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M1 10.5L6 5.5L1 0.499999' stroke='black'/%3E%3C/svg%3E%0A");
  background-repeat: no-repeat;
  background-position: right center;
}
</style>