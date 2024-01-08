<template>
  <div class="flex flex-col items-center my-[80px] mx-auto">
    <TabView class="fill_tab industry_custom_tab" v-model:activeIndex="activeTab">
      <TabPanel header="멤버스 소개" />

      <!-- 멤버스 혜택 -->
      <TabPanel header="멤버스 혜택">
        <div class="tabInner__title w-[650px] border-b">
          <h2>멤버스 혜택</h2>
          <p>정관장 멤버스 회원만이 누릴 수 있는 혜택! 언제, 어디서나 일상 속에서 혜택을 플러스해보세요.</p>
        </div>

        <div class="rank">
          <h3 class="rank__title">구매 금액별 정관장 멤버스 혜택</h3>
          <p class="rank__desc">실적에 따라 달라지는 다양한 혜택을 확인하세요.</p>

          <TabView class="default_tab" v-model:activeIndex="activeRankTab">
            <TabPanel v-for="(tab, i) in rankTab" :index="i">
              <template #header>
                <div class="flex flex-col items-center gap-[4px]">
                  <Avatar  :image="activeRankTab === i ? tab.img_select : tab.img_unselect" size="xlarge" />
                  <span :style="{ color: activeRankTab === i ? tab.color : '' }">{{ tab.label }}</span>
                </div>
              </template>
              <div class="card_list">
                <div class="card level">
                  <span>
                    {{ `${rankLIst[tab.value].label} 멤버 등급조건` }}
                    <br />
                    <strong>
                      {{ `전년도 ${rankLIst[tab.value].pay}만원 이상 구매` }}
                    </strong>
                  </span>
                </div>
                <div class="card point">
                  <span>
                    포인트 적립률
                    <br />
                    <strong>
                      {{ `${rankLIst[tab.value].point}%` }}
                    </strong>
                  </span>
                </div>
                <div class="card service">
                  <span>
                    서비스 혜택
                    <br />
                    <strong>
                      {{ rankLIst[tab.value].service }}
                    </strong>
                  </span>
                </div>
              </div>
            </TabPanel>
          </TabView>

          <!-- 등급 산정 안내 -->
          <div class="warning__box">
            <ul class="warning__list">
              <li>
                <span class="dot"></span>
                등급 선정일 : 매년 1월 1일
              </li>
              <li>
                <span class="dot"></span>
                등급 선정 방법 : 전년 1월 1일 ~ 12월 31일 구매내역
              </li>
              <li>
                <span class="dot"></span>
                현재 등급 선정 기준이며, 이는 매년 변경될 수 있습니다.
              </li>
              <li>
                <span class="dot"></span>
                서비스 혜택의 경우, 회사 사정에 따라 변경될 수 있습니다.
              </li>
            </ul>
          </div>
          
        </div>
      </TabPanel>

      <TabPanel header="매장찾기" />
      <TabPanel header="포인트 쓰기" />
    </TabView>
  </div>
</template>
<script setup lang="ts">
import { ref } from "vue";

import ico_family from '@/assets/images/rank/ico_family.svg';
import ico_gold from '@/assets/images/rank/ico_gold.svg';
import ico_gray_family from '@/assets/images/rank/ico_gray_family.svg';
import ico_gray_gold from '@/assets/images/rank/ico_gray_gold.svg';
import ico_gray_royalgold from '@/assets/images/rank/ico_gray_royalgold.svg';
import ico_gray_silver from '@/assets/images/rank/ico_gray_silver.svg';
import ico_royalgold from '@/assets/images/rank/ico_royalgold.svg';
import ico_silver from '@/assets/images/rank/ico_silver.svg';


const activeTab = ref(1);
const activeRankTab = ref(0);

const rankTab = ref([
  { label : '로얄골드', value: 'royal', color: '#E29323', img_select: ico_royalgold, img_unselect: ico_gray_royalgold  },
  { label : '골드', value: 'gold', color: '#CAA851', img_select: ico_gold, img_unselect: ico_gray_gold },
  { label : '실버', value: 'silver', color: '#84919B', img_select: ico_silver, img_unselect: ico_gray_silver },
  { label : '패밀리', value: 'family', color: '#860D14', img_select: ico_family, img_unselect: ico_gray_family }
])

const rankLIst = {
  royal: { label: 'ROYAL GOLD', pay: 350, point: '2.0', service: '생일축하 Gift 제공, 시즌구매 혜택 제공' },
  gold: { label: 'GOLD', pay: 300, point: '1.5', service: '골드 등급별 생일 혜택' },
  silver: { label: 'SILER', pay: 200, point: '1.0', service: '실버 등급별 생일 혜택' },
  family: { label: 'FAMILY', pay: 100, point: '0.5', service: '패밀리 등급별 생일 혜택' }
}

</script>

<style scoped>
/* 소개페이지 공통 css */
.tabInner__title {
  text-align: center;
  display: flex;
  flex-direction: column;

  &.border-b {
    border-color: #ECF0F8;
    padding: 0 16.5px 40px;
    margin: auto;
  }

  h2 {
    font-weight: 700;
    font-size: 40px;
    line-height: 60px;
  }

  p {
    color: var(--j-gray500);
    margin-top: 8px;
    line-height: 24px;
  }
}

/* == 멤버스 혜택 == */
.rank {
  margin: 40px auto 0;
  width: 650px;

  .rank__title {
    font-size: 20px;
    font-weight: 700;
    line-height: 30px;
  }

  .rank__desc {
    font-size: 15px;
    line-height: 22.5px;
    color: var(--j-gray500);
  }

  ::v-deep(.p-tabview.default_tab) {
    margin-top: 40px;

    .p-tabview-nav-container {
      width: 650px;

      .p-tabview-header {
        padding: 0 0 12px;
        color: var(--j-gray300);

        &.p-highlight {
          border-bottom: 3px solid var(--j-primary01) ;
    
          .p-tabview-nav-link {
            color: #E29323;
            font-weight: 700;
          }
        }
      }
    }
  }
}

.card_list {
  display: flex;
  flex-direction: column;
  gap: 8px;

  .card {
    background-color: var(--j-gray100);
    border-radius: 4px;
    padding: 20px;
    position: relative;
    width: 100%;
    display: flex;

    &::before {
      content: '';
      width: 44px;
      height: 44px;
      display: inline-block;
      margin-right: 16px;
    }

    &.level::before {
      background-image: url("data:image/svg+xml,%3Csvg width='44' height='44' viewBox='0 0 44 44' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M19.5374 15.3277L25.1459 7.86904C24.1637 7.15818 23.637 6 21.9288 6C19.4626 6 19.4626 8.40999 17 8.40999C14.5374 8.40999 14.5338 6 12.0712 6C10.3594 6 9.8363 7.16165 8.85053 7.86904L14.4591 15.3277C9.05338 16.4616 5 21.1463 5 26.7534V32.9741C5 35.1968 6.85053 37 9.13167 37H24.8683C27.1495 37 29 35.1968 29 32.9741V26.7534C29 21.1463 24.9466 16.4616 19.5409 15.3277H19.5374Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M11.1074 23.8799L14.1874 33.2077L16.8138 25.2411L19.4435 33.2077L22.5234 23.8799' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M12.64 28.6128H9.76562' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M23.8646 28.6128H20.9902' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M32.0788 33.5076H25.0686C24.0556 33.5076 23.2344 34.3288 23.2344 35.3418C23.2344 36.3548 24.0556 37.1761 25.0686 37.1761H32.0788C33.0918 37.1761 33.913 36.3548 33.913 35.3418C33.913 34.3288 33.0918 33.5076 32.0788 33.5076Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M36.3502 29.8389H29.3401C28.3271 29.8389 27.5059 30.6601 27.5059 31.6731C27.5059 32.6861 28.3271 33.5074 29.3401 33.5074H36.3502C37.3633 33.5074 38.1845 32.6861 38.1845 31.6731C38.1845 30.6601 37.3633 29.8389 36.3502 29.8389Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M33.0397 26.1704H26.0296C25.0165 26.1704 24.1953 26.9916 24.1953 28.0047C24.1953 29.0177 25.0165 29.8389 26.0296 29.8389H33.0397C34.0527 29.8389 34.8739 29.0177 34.8739 28.0047C34.8739 26.9916 34.0527 26.1704 33.0397 26.1704Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M34.5358 22.502H27.5257C26.5126 22.502 25.6914 23.3232 25.6914 24.3362C25.6914 25.3492 26.5126 26.1705 27.5257 26.1705H34.5358C35.5488 26.1705 36.37 25.3492 36.37 24.3362C36.37 23.3232 35.5488 22.502 34.5358 22.502Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M33.0397 18.8335H26.0296C25.0165 18.8335 24.1953 19.6547 24.1953 20.6677C24.1953 21.6808 25.0165 22.502 26.0296 22.502H33.0397C34.0527 22.502 34.8739 21.6808 34.8739 20.6677C34.8739 19.6547 34.0527 18.8335 33.0397 18.8335Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M20.8444 13H13.8342C12.8212 13 12 13.8212 12 14.8342C12 15.8473 12.8212 16.6685 13.8342 16.6685H20.8444C21.8574 16.6685 22.6786 15.8473 22.6786 14.8342C22.6786 13.8212 21.8574 13 20.8444 13Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
    }

    &.point::before {
      background-image: url("data:image/svg+xml,%3Csvg width='44' height='44' viewBox='0 0 44 44' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_1292_13054)'%3E%3Cpath d='M35.739 22.926C35.4359 22.3459 35.4359 21.6541 35.739 21.074L37.0552 18.5544C37.5739 17.5614 37.176 16.3361 36.1728 15.8374L33.5511 14.534C32.9727 14.2465 32.5687 13.6972 32.4666 13.0594L32.0108 10.2132C31.8367 9.1254 30.8156 8.3833 29.7272 8.55338L26.7446 9.01944C26.1199 9.11706 25.4858 8.91352 25.0347 8.47053L22.9012 6.37578C22.1232 5.61192 20.8768 5.61192 20.0988 6.37578L17.9653 8.47053C17.5142 8.91352 16.8801 9.11706 16.2554 9.01944L13.2728 8.55338C12.1844 8.3833 11.1633 9.1254 10.9892 10.2132L10.5334 13.0594C10.4313 13.6972 10.0273 14.2465 9.44888 14.534L6.82715 15.8374C5.82402 16.3361 5.42609 17.5614 5.94478 18.5543L7.261 21.074C7.56407 21.6541 7.56407 22.3459 7.261 22.926L5.94478 25.4457C5.42608 26.4386 5.82402 27.6639 6.82715 28.1626L9.44888 29.466C10.0273 29.7535 10.4313 30.3028 10.5334 30.9406L10.9892 33.7868C11.1633 34.8746 12.1844 35.6167 13.2728 35.4466L16.2554 34.9806C16.8801 34.8829 17.5142 35.0865 17.9653 35.5295L20.0988 37.6242C20.8768 38.3881 22.1232 38.3881 22.9012 37.6242L25.0347 35.5295C25.4858 35.0865 26.1199 34.8829 26.7446 34.9806L29.7272 35.4466C30.8156 35.6167 31.8367 34.8746 32.0108 33.7868L32.4666 30.9406C32.5687 30.3028 32.9727 29.7535 33.5511 29.466L36.1728 28.1626C37.176 27.6639 37.5739 26.4386 37.0552 25.4457L35.739 22.926Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M21.5 32C15.9771 32 11.5 27.5229 11.5 22C11.5 16.4771 15.9771 12 21.5 12C27.0229 12 31.5 16.4771 31.5 22C31.5 27.5229 27.0229 32 21.5 32Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M17 26L26 18' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M20 19C20 17.8964 19.1036 17 18 17C16.8964 17 16 17.8964 16 19C16 20.1036 16.8964 21 18 21C19.1036 21 20 20.1036 20 19Z' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M27 25C27 23.8964 26.1036 23 25 23C23.8964 23 23 23.8964 23 25C23 26.1036 23.8964 27 25 27C26.1036 27 27 26.1036 27 25Z' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_1292_13054'%3E%3Crect width='33' height='34' fill='white' transform='translate(5 5)'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A");
    }

    &.service::before {
      background-image: url("data:image/svg+xml,%3Csvg width='44' height='44' viewBox='0 0 44 44' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M22.5146 11.4384L18.516 9.23871C16.7513 8.26643 14.5346 8.66045 13.2247 10.177L11.9609 11.6425' fill='%23F46144'/%3E%3Cpath d='M22.5146 11.4384L18.516 9.23871C16.7513 8.26643 14.5346 8.66045 13.2247 10.177L11.9609 11.6425' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M21.4824 11.4384L25.4811 9.23871C27.2458 8.26643 29.4625 8.66045 30.7723 10.177L32.0361 11.6425' fill='%23F46144'/%3E%3Cpath d='M21.4824 11.4384L25.4811 9.23871C27.2458 8.26643 29.4625 8.66045 30.7723 10.177L32.0361 11.6425' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M24.3448 11.4384C24.3448 10.1628 23.294 9.12817 21.9986 9.12817C20.7031 9.12817 19.6523 10.1628 19.6523 11.4384' fill='%23F46144'/%3E%3Cpath d='M24.3448 11.4384C24.3448 10.1628 23.294 9.12817 21.9986 9.12817C20.7031 9.12817 19.6523 10.1628 19.6523 11.4384' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M35 18H9V36H35V18Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M37.2793 11.8467H6.71875V18.5705H37.2793V11.8467Z' fill='white' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3Cpath d='M25 12H19V36H25V12Z' fill='%23F46144' stroke='%23222222' stroke-width='1.5' stroke-linecap='round' stroke-linejoin='round'/%3E%3C/svg%3E%0A");
    }
  }
}

.warning__box {
  margin-top: 40px;
  border-radius: 12px;
  background-color: var(--j-bluegray200);
  padding: 24px;
}
/* ============== */
</style>