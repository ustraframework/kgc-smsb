<template>
  <div class="flex flex-col items-center">
    <!-- === 상단 바코드 영역 === -->
    <div class="main__info">
      <div class="main__info-user">
        <Avatar :image="ico_family" />
        <span class="leading-[27px]">
          <strong class="text-[20px] leading-[30px]">홍길동</strong>
          님 반갑습니다
        </span>
      </div>

      <div class="barcode__box">

        <!-- 가용보인트 및 바코드 영역 -->
        <div class="flex justify-between items-center pb-[16px] border-b-[1.5px] border-[#e8e8e833]">
          <div class="flex flex-col text-[#F46144]">
            <span class="text-[15px] font-medium icon_arrow flex items-center primary">가용 포인트</span>
            <span class="text-[24px]">
              <strong class="mr-0.5">1,000</strong>P
            </span>
          </div>

          <div class="barcode" />
        </div>

        <!-- 선물하기 영역 -->
        <div class="mt-[16px] flex justify-between items-center">
          <span class="text-white">친구에게 선물해보세요.</span>
          <Button label="포인트 선물" severity="secondary" size="small" />
        </div>
      </div>

      <div class="flex flex-col justify-center gap-[16px]">
        <div class="flex justify-between items-center">
          <span class="text-[15px]">특별 포인트</span>
          <span class="text-[15px]">
            <strong class="mr-0.5">5,000</strong>P
          </span>
        </div>

        <div class="flex justify-between items-center">
          <span class="text-[15px]">
            <span>소멸 예정 포인트</span>
            <span class="text-[12px] font-normal">(전일기준)</span>
          </span>
          <span class="text-[15px]">
            <strong class="mr-0.5">30</strong>P
          </span>
        </div>
      </div>
    </div>
    <!-- ==================== -->

    <!-- === 하단영역 === -->
    <div class="main__bottom">
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

      <div class="mt-[40px] flex items-center w-full">
        <Steps
          class="w-full"
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
        class="flex items-center mt-[24px] pb-[40px] text-[15px] icon_arrow border-b border-[#E7E7E7] cursor-pointer"
        @click="showPopup = true"
      >
        등급 혜택 안내
      </span>

      <Popup_0050 v-model="showPopup" />

      <div class="buttons">
        <div class="coupon icon_arrow large">
          <span>
            보유 쿠폰 <br />
            <strong>3장</strong>
          </span>
        </div>

        <div class="store icon_arrow large">
          <span>
            단골매장 <br />
            <strong>정관장 압구정점</strong>
          </span>
        </div>
      </div>
    </div>
    <!-- ============== -->
  </div>

  <!-- == Footer Menu List == -->
  <div class="menu__list">
    <div class="menu icon_arrow large">회원정보 변경</div>
    <div class="menu icon_arrow large">비밀번호 변경</div>
    <div class="menu icon_arrow large">기념일 관리</div>
    <div class="menu icon_arrow large">단골매장 관리</div>
    <div class="menu icon_arrow large">회원탈퇴</div>
  </div>
  <!-- ====================== -->
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

import Popup_0050 from './UI_FU_0050.vue';

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


</script>

<style scoped>

.main__info {
  width: 100%;
  padding: 20px;
  display: flex;
  flex-direction: column;
  gap: 20px;
  background-color: #F4F6FA;

  button {
    width: fit-content;
  }

  .main__info-user {
    display: flex;

    span {
      margin-left: 12px;
      font-size: 18px;
      line-height: 27px;
      flex: 1;
    }
  }

  .barcode__box {
    background-color: var(--j-primary03);
    border-radius: 12px;
    padding: 24px;

    .barcode {
      width: 100px;
      height: 30px;
      background-image: url("data:image/svg+xml,%3Csvg width='100' height='31' viewBox='0 0 100 31' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M46.24 30.0388H44V0.52306H46.24V30.0388Z' fill='white'/%3E%3Cpath d='M49.04 30.0388H48.2V0.52306H49.04V30.0388Z' fill='white'/%3E%3Cpath d='M49.6 30.0388H50.44V0.52306H49.6V30.0388Z' fill='white'/%3E%3Cpath d='M51.28 30.0388H51V0.52306H51.28V30.0388Z' fill='white'/%3E%3Cpath d='M52.4 30.0388H52.68V0.52306H52.4V30.0388Z' fill='white'/%3E%3Cpath d='M55.2 30.0388H53.8V0.52306H55.2V30.0388Z' fill='white'/%3E%3Cpath d='M55.76 30.0388H56.88V0.52306H55.76V30.0388Z' fill='white'/%3E%3Cpath d='M58 30.0388H57.72V0.52306H58V30.0388Z' fill='white'/%3E%3Cpath d='M31.24 30.254H29V0.738279H31.24V30.254Z' fill='white'/%3E%3Cpath d='M34.04 30.254H33.2V0.738279H34.04V30.254Z' fill='white'/%3E%3Cpath d='M34.6 30.254H35.44V0.738279H34.6V30.254Z' fill='white'/%3E%3Cpath d='M36.28 30.254H36V0.738279H36.28V30.254Z' fill='white'/%3E%3Cpath d='M37.4 30.254H37.68V0.738279H37.4V30.254Z' fill='white'/%3E%3Cpath d='M40.2 30.254H38.8V0.738279H40.2V30.254Z' fill='white'/%3E%3Cpath d='M40.76 30.254H41.88V0.738279H40.76V30.254Z' fill='white'/%3E%3Cpath d='M43 30.254H42.72V0.738279H43V30.254Z' fill='white'/%3E%3Cpath d='M15.24 30.0234H13V0.507687H15.24V30.0234Z' fill='white'/%3E%3Cpath d='M18.04 30.0234H17.2V0.507687H18.04V30.0234Z' fill='white'/%3E%3Cpath d='M18.6 30.0234H19.44V0.507687H18.6V30.0234Z' fill='white'/%3E%3Cpath d='M20.28 30.0234H20V0.507687H20.28V30.0234Z' fill='white'/%3E%3Cpath d='M21.4 30.0234H21.68V0.507687H21.4V30.0234Z' fill='white'/%3E%3Cpath d='M24.2 30.0234H22.8V0.507687H24.2V30.0234Z' fill='white'/%3E%3Cpath d='M24.76 30.0234H25.88V0.507687H24.76V30.0234Z' fill='white'/%3E%3Cpath d='M27 30.0234H26.72V0.507687H27V30.0234Z' fill='white'/%3E%3Cpath d='M0.857143 30.1311H0V0.615297H0.857143V30.1311Z' fill='white'/%3E%3Cpath d='M1.42857 30.1311H2.28571V0.615297H1.42857V30.1311Z' fill='white'/%3E%3Cpath d='M3.14286 30.1311H2.85714V0.615297H3.14286V30.1311Z' fill='white'/%3E%3Cpath d='M4.28571 30.1311H4.57143V0.615297H4.28571V30.1311Z' fill='white'/%3E%3Cpath d='M7.14286 30.1311H5.71429V0.615297H7.14286V30.1311Z' fill='white'/%3E%3Cpath d='M7.71429 30.1311H8.85714V0.615297H7.71429V30.1311Z' fill='white'/%3E%3Cpath d='M10 30.1311H9.71429V0.615297H10V30.1311Z' fill='white'/%3E%3Cpath d='M69.76 30.0696H72V0.553804H69.76V30.0696Z' fill='white'/%3E%3Cpath d='M66.96 30.0696H67.8V0.553804H66.96V30.0696Z' fill='white'/%3E%3Cpath d='M66.4 30.0696H65.56V0.553804H66.4V30.0696Z' fill='white'/%3E%3Cpath d='M64.72 30.0696H65V0.553804H64.72V30.0696Z' fill='white'/%3E%3Cpath d='M63.6 30.0696H63.32V0.553804H63.6V30.0696Z' fill='white'/%3E%3Cpath d='M60.8 30.0696H62.2V0.553804H60.8V30.0696Z' fill='white'/%3E%3Cpath d='M60.24 30.0696H59.12V0.553804H60.24V30.0696Z' fill='white'/%3E%3Cpath d='M58 30.0696H58.28V0.553804H58V30.0696Z' fill='white'/%3E%3Cpath d='M86.4545 30.0158H87V0.5H86.4545V30.0158Z' fill='white'/%3E%3Cpath d='M83.7273 30.0158H84.5455V0.5H83.7273V30.0158Z' fill='white'/%3E%3Cpath d='M83.1818 30.0158H82.3636V0.5H83.1818V30.0158Z' fill='white'/%3E%3Cpath d='M81.5455 30.0158H81.8182V0.5H81.5455V30.0158Z' fill='white'/%3E%3Cpath d='M80.4545 30.0158H80.1818V0.5H80.4545V30.0158Z' fill='white'/%3E%3Cpath d='M77.7273 30.0158H79.0909V0.5H77.7273V30.0158Z' fill='white'/%3E%3Cpath d='M77.1818 30.0158H76.0909V0.5H77.1818V30.0158Z' fill='white'/%3E%3Cpath d='M75 30.0158H75.2727V0.5H75V30.0158Z' fill='white'/%3E%3Cpath d='M88.5455 30.5H88V0.984243H88.5455V30.5Z' fill='white'/%3E%3Cpath d='M91.2727 30.5H90.4545V0.984243H91.2727V30.5Z' fill='white'/%3E%3Cpath d='M91.8182 30.5H92.6364V0.984243H91.8182V30.5Z' fill='white'/%3E%3Cpath d='M93.4545 30.5H93.1818V0.984243H93.4545V30.5Z' fill='white'/%3E%3Cpath d='M94.5455 30.5H94.8182V0.984243H94.5455V30.5Z' fill='white'/%3E%3Cpath d='M97.2727 30.5H95.9091V0.984243H97.2727V30.5Z' fill='white'/%3E%3Cpath d='M97.8182 30.5H98.9091V0.984243H97.8182V30.5Z' fill='white'/%3E%3Cpath d='M100 30.5H99.7273V0.984243H100V30.5Z' fill='white'/%3E%3C/svg%3E%0A");
    }
  }
}

.main__bottom {
  width: 100%;
  padding: 20px 20px 40px;
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

.rank__date {
  margin-top: 16px;
  font-size: 16px;
  background-color: #F4F6FA;
  border: 1px solid #C8D1E2;
  border-radius: 999px;
  padding: 16px 0;
  width: 100%;
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
  width: 100%;
  flex-direction: column;

  > * {
    background-color: #F6F6F6;
    border-radius: 4px;
    padding: 20px;
    flex: 1;
    display: flex;
    align-items: center;

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
      margin-top: -17px;
      border-color: #E7E7E7;
      border-top: 5px solid var(--j-gray200);
    }

    &::after {
      content: '';
      width: var(--rank-percent);
      height: 5px;
      top: 50%;
      right: 0;
      position: absolute;
      margin-top: -17px;
      border-top: 5px solid #D20F27;
      border-radius: 999px;
    }

    .p-steps-item {
      z-index: 2;
    }
  }
}

.menu__list {
  padding: 0 20px 10px 20px;
  margin-bottom: 45px;
  font-size: 16px;
  border-top: 10px solid #F4F6FA;
  border-bottom: 10px solid #F4F6FA;

  .menu {
    cursor: pointer;
    padding: 16px 0;
    display: flex;
    align-items: center;
    justify-content: space-between;

    &:not(:last-child) {
      border-bottom: 1px solid var(--j-gray100);
    }
  }
}

/* 공통 아이콘 */
.icon_arrow {
  &::after {
    content: '';
    display: inline-block;
    width: 16px;
    height: 16px;
    background-image: url("data:image/svg+xml,%3Csvg width='7' height='11' viewBox='0 0 7 11' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M1 10.5L6 5.5L1 0.499999' stroke='black'/%3E%3C/svg%3E%0A");
    background-repeat: no-repeat;
    background-position: center;
  }

  &.primary::after {
    background-image: url("data:image/svg+xml,%3Csvg width='16' height='17' viewBox='0 0 16 17' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M5 14.5L10 9.5L5 4.5' stroke='%23F46144'/%3E%3C/svg%3E%0A");
  }

  &.large::after {
    width: 20px;
    height: 20px;
    background-image: url("data:image/svg+xml,%3Csvg width='20' height='20' viewBox='0 0 20 20' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M6 2.5L13.8444 9.85409C13.9286 9.93311 13.9286 10.0669 13.8444 10.1459L6 17.5' stroke='black' stroke-width='1.2' stroke-linecap='round'/%3E%3C/svg%3E%0A");
    background-position: right center;
    flex: 1;
  }
}
</style>